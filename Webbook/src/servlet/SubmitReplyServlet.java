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
 * Servlet implementation class SubmitReplyServlet
 */
@WebServlet({"/SubmitReplyServlet", "/submitReplyServlet"})
public class SubmitReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReplyServlet() {
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
		String content1 = request.getParameter("replycontent1");
		String content2 = request.getParameter("replycontent2");
		String idstr = request.getParameter("id");
		int id = Integer.valueOf(idstr);
		String quotecontent = "<blockquote><b>"+content1+"</b></blockquote><br>"+content2;
		WebbookService wb = new WebbookServiceImpl();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		wb.insertReplyNotes(id, quotecontent, username);
		response.sendRedirect("/Webbook/details?id="+id);
		
	}

}
