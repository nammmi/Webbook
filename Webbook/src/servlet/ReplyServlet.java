package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Replynote;
import service.WebbookService;
import serviceImpl.WebbookServiceImpl;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet({"/ReplyServlet", "/Replyservlet", "/replyservlet"})
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String mainidstr = request.getParameter("mainid");
		int mainid = Integer.valueOf(mainidstr);
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null)
		{
        	session.setAttribute("mainid", mainidstr);
			response.sendRedirect("/Webbook/LoginServlet");
		}else{
		WebbookService wb = new WebbookServiceImpl();
		Replynote replyNote = new Replynote();
		replyNote = wb.findReplyNote(id);
		//String floorid = Integer.toString(replyNote.getFloorid());
		//String username = replyNote.getUsername();
		//String floorContent = replyNote.getFloorcontent();
		//String content = "<blockquote><b>引用${map.replyNote.floorid}楼${map.replyNote.username}发表的:</b>${map.replyNote.floorcontent}</blockquote>";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Replynote", replyNote);
		//map.put("content", content);
		map.put("mainid", mainid);
		//map.put("floorid", floorid);
		//map.put("username", username);
		//map.put("floorContent", floorContent);
		request.setAttribute("map", map);
		request.getRequestDispatcher("answer.jsp").forward(request, response);//filter在这里也起作用了。
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
