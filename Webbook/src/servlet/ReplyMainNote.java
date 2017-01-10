package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.WebbookService;
import serviceImpl.WebbookServiceImpl;

/**
 * Servlet implementation class ReplyMainNote
 */
@WebServlet({"/ReplyMainNote", "/Replymainnote", "/replymainnote"})
public class ReplyMainNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyMainNote() {
        super();
        // TODO Auto-generated constructor stub
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
		String idstr = request.getParameter("id");
		int id = Integer.valueOf(idstr);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("username")==null)
		{
			//System.out.println("22222222222");
            
        	
        	session.setAttribute("mainid", idstr);
			response.sendRedirect("/Webbook/LoginServlet");
		}else{
		
		String floorcontent = request.getParameter("floorcontent");
		System.out.println(id+floorcontent);
		WebbookService wb = new WebbookServiceImpl();
		
		String username = (String) session.getAttribute("username");
		wb.insertReplyNotes(id, floorcontent, username);
		
		response.sendRedirect("/Webbook/details?id="+id);
		}
//		PrintWriter pw;
//		try {
//			pw = response.getWriter();
//			pw.write("<script language='javascript'>alert('Reply success !!!!!')</script>");
//			pw.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
