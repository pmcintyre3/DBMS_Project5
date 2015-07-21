package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbms.dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
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
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int result = -1;
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			HttpSession session = request.getSession();

			// Get request parameters for userID and password
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");

			if ((result = LoginDao.validate(userName, password)) > 0) {

				// Set session parameters
				session = request.getSession(true);
				session.setAttribute("user", userName);
				session.setAttribute("userID", result);

				// Setting session to expiry in 30 mins
				session.setMaxInactiveInterval(30 * 60);
				Cookie cookieUserName = new Cookie("user", userName);
				cookieUserName.setMaxAge(30 * 60);
				response.addCookie(cookieUserName);

				// Send the successful response
				response.sendRedirect("loginSuccess.jsp");

			} else {
				request.setAttribute("error","Invalid Username or Password. Please try again.");
				RequestDispatcher rd = request
						.getRequestDispatcher("/login.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
