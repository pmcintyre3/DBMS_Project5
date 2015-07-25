package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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


@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
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
			
			HttpSession session = request.getSession();
			//Get the current session's User ID
			int userID=Integer.parseInt(session.getAttribute("userID").toString());
			
			request.setAttribute("userOrderList",OrderDAO.getAllOrdersOfUser(userID));
			request.setAttribute("totalUserPoints",UserDAO.getUserPoints(userID));
			
			
			Map<String, String> membershipMap =UserDAO.getUserCategory(userID);
			request.setAttribute("userMembershipString",membershipMap.get("categoryName"));
			RequestDispatcher rd = request.getRequestDispatcher("orderHistory.jsp");
			rd.forward(request, response);
			//Get all the products bought by that User
			
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
			
//			boolean result = false;
//			response.setContentType("text/html");
//			HttpSession session = request.getSession();
//			int userID=Integer.parseInt(session.getAttribute("userID").toString());
//						
//			// Get request parameters for productID
//			JSONObject jObj=new JSONObject(request.getParameter("product"));
//			int productID = jObj.getInt("productID");
//			boolean redeemPoints=jObj.getBoolean("redeemPoints");
//			PrintWriter out;
//		
//			//Retrieve that product's details
//			Product productObject = ProductDao.getProduct(productID, 0);
//			productObject=this.getDiscoutOnProduct(productObject);
//			int userPoints=UserDAO.getUserPoints(userID);
//		
//			
//			/**
//			 * 1. finalAmountoPay = productPrice;
//			 * 2. if productPrice>=discountPrice
//			 * 		finalAmountoPay=discountPrice;
//			 * 3. if chkbox chked {
//			 * 			temp=finalAmountoPay;
//			 * 			if(redeemPoints<=finalAmpuntopay){
//			 * 				finalAmountoPay -= redeemPoints;
//			 * 				redeemPoints=0
//			 * 				
//			 * 			}
//			 * 			else{
//			 * 				finalAmountoPay=0;
//			 * 				redeemPoints-=temp;
//			 * 			}
//			 * 			redeemPoints+=points accodring to the product
//			 * }
//			 * 4. Update redeemPoints
//			 * 
//			 * 
//			 */
//			
//			
//			double productPrice=productObject.getProductPrice();
//			double productDiscountPrice=productObject.getProductDiscountedPrice();
//			System.out.println("productDiscountPrice: "+productDiscountPrice);
//			
//			double finalAmountToPay=productPrice;
//			
//			if(productPrice>productDiscountPrice)
//				finalAmountToPay=productDiscountPrice;
//			
//			System.out.println("Final Amount: "+finalAmountToPay);
//			if(redeemPoints){
//				double temp=finalAmountToPay;
//				if(userPoints<=finalAmountToPay){
//					finalAmountToPay-=(double)userPoints;
//					userPoints=0;
//				}else{
//					finalAmountToPay=0;
//					userPoints-=temp;
//				}
//				userPoints+=productObject.getProductPoints();
//				
//			}
//					
//			
//			Date date = new Date();
//			java.util.Date utilDate = new java.util.Date();
//		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//		    
//		    /**
//		     * Place the order. 
//		     * If the order was successfully placed, add points 
//		     * for the User.
//		     */
//		    if(OrderDAO.putOrder(userID, productID,finalAmountToPay,sqlDate)){
//		    	if(UserDAO.setUserPoints(userID, userPoints)){
//		    		result=true;
//		    	}
//		    }
//			
////		    if(result){
////			    out = response.getWriter();  
////		        out.print(
////		        			" Order placed! You've successfully bought this item and received "
////		        			+productObject.getProductPoints()
////		        			+" points!!"
////		        			
////		        		);
////		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Function to get the discounted on the selected product
	 * 
	 */
	public Product getDiscoutOnProduct(Product productObject){
		try{
			
			double productPrice=productObject.getProductPrice();
			double x=productPrice*((double)(productObject.getProductCategoryDiscount())/100);
			double y=productPrice-x;
			productObject.setProductDiscountedPrice(y);
				
			
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return productObject;
		
	}

	
}
