package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dbms.dao.LoginDao;
import dbms.dao.OrderDAO;
import dbms.dao.ProductDao;
import dbms.dao.UserDAO;
import dbms.model.Product;
import dbms.model.User;


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
			
			boolean result = false;
			response.setContentType("text/html");
			HttpSession session = request.getSession();
						
			// Get request parameters for productID
			JSONObject jObj=new JSONObject(request.getParameter("product"));
			int productID = jObj.getInt("productID");
			PrintWriter out;
			
			//Retrieve that product's details
			Product productObject=ProductDao.getProduct(productID, 0);
			System.out.println("ProductObj: "+productObject.getProductPoints());
			
			/**
			 * Check if the user has an discount on that product.
			 * 	-- If yes, apply that amount
			 * 	-- If no, keep the original amount
			 * - Finally, increase User's points  
			 * 
			 */
			int userID=Integer.parseInt(session.getAttribute("userID").toString());
			Date date = new Date();
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
		    /**
		     * Place the order. 
		     * If the order was successfully placed, add points 
		     * for the User.
		     */
		    if(OrderDAO.putOrder(productID,userID,productObject.getProductPrice(),sqlDate)){
		    	int currentPoints=UserDAO.getUserPoints(userID);
		    	currentPoints+=productObject.getProductPoints();
		    	if(UserDAO.setUserPoints(userID, currentPoints)){
		    		result=true;
		    	}
		    }
			
		    if(result){
			    out = response.getWriter();  
		        out.print(
		        			" Order placed! You've successfully bought this item and received "
		        			+productObject.getProductPoints()
		        			+" points!!"
		        			
		        		);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
