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

import dbms.dao.RegisterDAO;

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
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            //HttpSession session = request.getSession();

            // Get request parameters for userID and password
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");

            result = RegisterDAO.registerUser(userName, password);

            if (result > 0) {

//                // Set session parameters
//                session = request.getSession(true);
//                session.setAttribute("user", userName);
//                session.setAttribute("userID", result);
//
//                // Setting session to expiry in 30 mins
//                session.setMaxInactiveInterval(30 * 60);
//                Cookie cookieUserName = new Cookie("user", userName);
//                cookieUserName.setMaxAge(30 * 60);
//                response.addCookie(cookieUserName);

//                // Send the successful response
//                //response.sendRedirect("loginSuccess.jsp");
//                //
//
//                // Get all discounted products
//                request.setAttribute("discountedProductList",this.getAllDiscoutedProducts(result));
//
//                //Get non-discounted products
//                request.setAttribute("nonDiscountedProductList",this.getAllNonDiscoutedProducts(result));
//
//                //Get the user membership
//                Map<String, String> userCategory=UserDAO.getUserCategory(result);
//                request.setAttribute("userCategoryID",Integer.parseInt(userCategory.get("categoryID")));

                request.setAttribute("loginSuccess","Registration Success! Log in with your new account!");
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);

            } else {
                request.setAttribute("error","Invalid Username or Password. Result = " + result);
                RequestDispatcher rd = request
                        .getRequestDispatcher("/register.jsp");
                rd.include(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
