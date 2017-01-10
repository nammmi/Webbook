package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UserService;
import serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet({ "/RegisterServlet", "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("register.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String email = request.getParameter("email");
		if(!password.equals(password2))
		{
			response.getWriter().write("<script>alert('please input the right password!')</script>");
			response.getWriter().write("<script>location.href='/Webbook/register'</script>");
		}
		else{
			UserService ud = new UserServiceImpl();
			if(ud.findByUserName(userName, email))
			{
				response.getWriter().write("<script>alert('Sorry, the user name or email have already been used !')</script>");
				response.getWriter().write("<script>location.href='/Webbook/register'</script>");
			}
			else{
				ud.insertUser(userName, password, email);
				response.getWriter().write("<script>alert('register success! now redirect to login page!')</script>");
				response.getWriter().write("<script>location.href='/Webbook/login'</script>");
			}
			
		}
		
	}

}
