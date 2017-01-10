package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Note;
import model.PageBean;
import model.Replynote;
import service.WebbookService;
import serviceImpl.WebbookServiceImpl;

/**
 * Servlet implementation class Selectreplynote
 */
@WebServlet({"/Selectreplynote", "/details"})
public class Selectreplynote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Selectreplynote() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 获取当前页面页码数pc
     */
    
    private int getPc(HttpServletRequest request){
    	int pc = 1;
    	String parm = request.getParameter("pc");
    	if(parm!=null&&!parm.trim().isEmpty()){
    		pc = Integer.parseInt(parm);
    	}
    	return pc;
    }
    
    /**
     * 获取url，
     */
    
    private String getUrl(HttpServletRequest request){
    	String url = request.getRequestURI()+"?"+request.getQueryString();
    	int index = url.lastIndexOf("&pc=");
    	if(index!=-1){
    		url = url.substring(0, index);
    	}
    	return url;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String idstr = request.getParameter("id");
		int id = Integer.valueOf(idstr);		
		int pc = getPc(request);
		System.out.println("pc "+pc);
		String url = getUrl(request);
		WebbookService wb = new WebbookServiceImpl();
		PageBean<Replynote> pageBean = wb.findReplyNoteByPage(pc, id);
		Note mainNote = wb.getMainNote(id);
		pageBean.setUrl(url);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pb", pageBean);
		map.put("main", mainNote);
		//request.setAttribute("pb", pageBean);
		request.setAttribute("map", map);
		request.getRequestDispatcher("details.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
