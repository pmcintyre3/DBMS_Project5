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
import dbms.dao.ProductDao;
import dbms.model.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			int productID = Integer.parseInt(request.getParameter("productID"));
			Product productObject = ProductDao.getProduct(productID, 0);
			System.out.println(productObject.getProductID());
			request.setAttribute("productDetails", productObject);
			RequestDispatcher rd = request
					.getRequestDispatcher("productDetails.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
			HttpSession session = request.getSession();

			// Get request parameters for userID and password
			String userName = request.getParameter("productID");
			PrintWriter out;
	        out = response.getWriter();  
	        out.print(" Order placed! You've successfully bought this item.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
