package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Listofnotes;
import model.Note;
import model.PageBean;
import service.WebbookService;
import serviceImpl.WebbookServiceImpl;

/**
 * Servlet implementation class ListofNote
 */
@WebServlet({"/Listofnote", "" })
public class ListofNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListofNote() {
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
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int pc = getPc(request);
		System.out.println("pc "+pc);
		String url = getUrl(request);
		WebbookService wb = new WebbookServiceImpl();
		//PageBean<Note> pageBean = wb.findByPage(pc);
		String str = request.getParameter("like");
		//System.out.println(str+"5555555555555");
		if(str==null||"".equals(str))
		{
			PageBean<Listofnotes> pageBean = wb.findRecentReplyByPage(pc);
			pageBean.setUrl(url);
			request.setAttribute("pb", pageBean);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			PageBean<Note> pageBean = wb.findByFuzzyPage(pc, str);
			pageBean.setUrl(url);
			request.setAttribute("pb", pageBean);
			request.getRequestDispatcher("indexlike.jsp").forward(request, response);
		}
		

		
		/**
		 *保存当前查询内容，传送到页面
		 */
		
		
		
	}

}




















