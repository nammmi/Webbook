package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.UserService;
import serviceImpl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet({ "/LoginServlet", "/Loginservlet", "/loginservlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService us = new UserServiceImpl();
		User user = us.findByUserNameAndPassword(username, password);
		if (user.getUsername() == null) {
			System.out.println(user.getUsername() + "3333333333");
			response.getWriter().write("<script>alert('please input the right user name and password!')</script>");
			response.getWriter().write("<script>location.href='/Webbook/login'</script>");
			// response.sendRedirect("/Webbook/LoginServlet");
		} else {
			HttpSession session = request.getSession();

			session.setAttribute("username", username);
			if (user.getLevel().equals("管理员")) {
				session.setAttribute("power", user.getLevel());

			}

			if (session.getAttribute("mainid") != null) {

				response.sendRedirect("/Webbook/details?id=" + session.getAttribute("mainid"));
			} else {
				// response.getWriter().write("<script>alert('登录成功，您可以正常发帖了！')</script>");
				response.getWriter().write("<script>location.href='/Webbook'</script>");

				// response.sendRedirect("/Webbook/createmainnote");
			}

		}

	}

}
