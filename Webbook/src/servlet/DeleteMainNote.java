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
 * Servlet implementation class DeleteMainNote
 */
@WebServlet({ "/DeleteMainNote", "/Deletemainnote", "/deletemainnote" })
public class DeleteMainNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMainNote() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("power")==null)
		{
			response.sendRedirect("/Webbook");
		}else{
		String idstr = request.getParameter("id");
		int id = Integer.valueOf(idstr);
		WebbookService wb = new WebbookServiceImpl();
		wb.deleteMainNote(id);
		//response.sendRedirect("/Webbook");
		response.getWriter().write("<script>alert('delete success!')</script>");
		response.getWriter().write("<script>location.href='/Webbook'</script>");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
