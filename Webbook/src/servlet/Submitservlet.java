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
 * Servlet implementation class Submitservlet
 */
@WebServlet(description = "提交主题帖", urlPatterns = { "/submitNote" })
public class Submitservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submitservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("++++++++++++");
		WebbookService wb = new WebbookServiceImpl();
		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		String mainNoteType = request.getParameter("type");
		String mainNoteTitle = request.getParameter("title");
		String mainNoteContent = request.getParameter("content");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		
		//mainNoteType = "question";//暂时指定，日后从页面获取！！！！！！！！！！
		
		wb.insertMainNotes(mainNoteType, mainNoteTitle, mainNoteContent, username);
		
		System.out.println("---------------");
		//response.sendRedirect("/Webbook/Selectmainnote");//防止重复提交表单。这是返回旧的servlet，现在用新的分页的
		response.sendRedirect("/Webbook/Listofnote");
		//request.getRequestDispatcher("/Selectmainnote").forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
