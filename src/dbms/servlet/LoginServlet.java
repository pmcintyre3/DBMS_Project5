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

import dbms.dao.LoginDao;
import dbms.dao.ProductDao;
import dbms.dao.UserDAO;
import dbms.model.Product;
import dbms.model.User;


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

			if ((result=LoginDao.validate(userName, password))!=-1) {

				
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
				//response.sendRedirect("loginSuccess.jsp");
				//
			
				// Get all discounted products
				request.setAttribute("discountedProductList",this.getAllDiscoutedProducts(result));
				
				//Get non-discounted products
				request.setAttribute("nonDiscountedProductList",this.getAllNonDiscoutedProducts(result));
				
				//Get the user membership
				Map<String, String> userCategory=UserDAO.getUserCategory(result);
				request.setAttribute("userCategoryID",Integer.parseInt(userCategory.get("categoryID")));
				
				RequestDispatcher rd = request.getRequestDispatcher("loginSuccess.jsp");
				rd.forward(request, response);

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
	
	
	/**
	 * Function to get all the discounted products
	 * 
	 */
	public List<Product> getAllDiscoutedProducts(int userID){
		List<Product> discountedProducts=null;
		try{
			
			discountedProducts=ProductDao.getDiscountedProducts(userID);
			Map<String, String> userCategory=UserDAO.getUserCategory(userID);
			for(int i=0;i<discountedProducts.size();i++){
					double productPrice=discountedProducts.get(i).getProductPrice();
					double x=productPrice*(Double.parseDouble(userCategory.get("categoryDiscount"))/100);
					double y=productPrice-x;
					discountedProducts.get(i).setProductDiscountedPrice(y);
				
			}
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return discountedProducts;
		
	}
	/**
	 * Function to get all the non-discounted products
	 * 
	 */
	public List<Product> getAllNonDiscoutedProducts(int userID){
		List<Product> nonDiscountedProducts=null;
		try{
			
			nonDiscountedProducts=ProductDao.getNonDiscountedProducts(userID);
			
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return nonDiscountedProducts;
		
	}
}
