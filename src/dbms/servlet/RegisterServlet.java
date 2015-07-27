package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbms.dao.PointsDAO;
import dbms.model.User;

import dbms.dao.RegisterDAO;
import dbms.dao.UserDAO;

/**
 * Created by Phillip on 7/25/2015.
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        try {
            int result = -1;
            int update = -1;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            HttpSession session = request.getSession();

            // Get request parameters for userID and password
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            if ((result = RegisterDAO.registerUser(userName, password)) > 0) {
                int u = UserDAO.getRecentRegisteredUserID(userName);

                if((update = PointsDAO.registerUserPoints(u)) > 0)
                {

                    request.setAttribute("loginSuccess", "Registration Success! Log in with your new account!");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                }

            } else {
                request.setAttribute("error","Invalid Username or Password.");
                RequestDispatcher rd = request
                        .getRequestDispatcher("/register.jsp");
                rd.include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
