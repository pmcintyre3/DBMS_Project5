package dbms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dbms.dao.CategoriesDAO;
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
			HttpSession session = request.getSession();
			int productID = Integer.parseInt(request.getParameter("productID"));
			int userID=Integer.parseInt(session.getAttribute("userID").toString());
			boolean productDiscountFlag=false;
			
			
			// Get that specific product
			Product productObject = ProductDao.getProduct(productID, 0);
			
			/**
			 * Check if discount is allowed on that product 
			 * for that particular User.
			 * 
			 * - If the check retrieves any records, it implies, no discount is allowed on that product
			 * - If the check retrieves no records, it implies, discount is allowed on that product
			 */
			if(ProductDao.checkIfProductDiscounted(productID, userID)>0){
				productObject.setProductDiscountedPrice(0);
			}else{
				productObject=this.getDiscoutOnProduct(productObject,userID);
				productDiscountFlag=true;
			}
			
			/**
			 * After determining the availability of dicsount,
			 * retrieve User's point so that he can redeem.
			 */
			int userPoints=UserDAO.getUserPoints(userID);
			
			
			/**
			 * Set the required variables for response.
			 */
			request.setAttribute("productDetails", productObject);
			request.setAttribute("userPoints", userPoints);
			request.setAttribute("productDiscountFlag",productDiscountFlag);
			
			RequestDispatcher rd = request.getRequestDispatcher("productDetails.jsp");
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
			boolean productDiscountFlag=false;
			response.setContentType("text/html");
			HttpSession session = request.getSession();
			int userID=Integer.parseInt(session.getAttribute("userID").toString());
						
			// Get request parameters for productID
			JSONObject jObj=new JSONObject(request.getParameter("product"));
			int productID = jObj.getInt("productID");
			boolean redeemPoints=jObj.getBoolean("redeemPoints");
			PrintWriter out;
		
			//Retrieve that product's details
			Product productObject = ProductDao.getProduct(productID, 0);
			
			/**
			 * Check if discount is allowed on that product 
			 * for that particular User.
			 * 
			 * - If the check retrieves any records, it implies, no discount is allowed on that product
			 * - If the check retrieves no records, it implies, discount is allowed on that product
			 */
			if(ProductDao.checkIfProductDiscounted(productID, userID)>0){
				productObject.setProductDiscountedPrice(0);
			}else{
				productObject=this.getDiscoutOnProduct(productObject,userID);
				productDiscountFlag=true;
			}
			
			/**
			 * Determine how much should the User pay
			 *  - User must pay either the full amount of the product
			 *    or the amount after discount.
			 */
			int currentUserPoints=UserDAO.getUserPoints(userID);
			double productPrice=productObject.getProductPrice();
			double finalAmountToPay=productPrice;
			
			if(productDiscountFlag){
				double productDiscountPrice=productObject.getProductDiscountedPrice();
				System.out.println("productDiscountPrice: "+productDiscountPrice);
				if(productPrice>productDiscountPrice)
					finalAmountToPay=productDiscountPrice;
			}
			
			/**
			 * Based on whether the User wants to redeem his points,
			 * update his points.
			 * 
			 */
//			if(redeemPoints){
//				double temp=finalAmountToPay;
//				if(userPoints<=finalAmountToPay){
//					finalAmountToPay-=(double)userPoints;
//					userPoints=0;
//				}else{
//					finalAmountToPay=0;
//					userPoints-=temp;
//				}
//				
//			}
			
			currentUserPoints+=productObject.getProductPoints();
			Date date = new Date();
			java.util.Date utilDate = new java.util.Date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
		    /**
		     * Place the order. 
		     * If the order was successfully placed, add points 
		     * for the User.
		     */
		    if(OrderDAO.putOrder(userID, productID,finalAmountToPay,sqlDate)){
		    	if(UserDAO.setUserPoints(userID, currentUserPoints,null)){
		    		result=true;
		    	}
		    }
		    
		    /**
		     * Update the User's membership status based on his 
		     * current points.
		     * 
		     */
		    Date existingPointsRenewalDate=UserDAO.getPointsRenewalDate(userID);
		    long diff = sqlDate.getTime() - existingPointsRenewalDate.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		    if(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)>=2){
		    	System.out.println("Change the date!!!!! and reset the points to 0");
		    	int categoryId=this.findCorrespondingCategoryID(currentUserPoints);
		    	if(UserDAO.setUserCategory(userID,categoryId)==1){
		    		UserDAO.setUserPoints(userID, 0,sqlDate);
		    	}
		    }
			
		    if(result){
			    out = response.getWriter();  
		        out.print(
		        			" Order placed! You've successfully bought this item and received "
		        			+ productObject.getProductPoints()
		        			+" additional points!!"
		        			
		        		);
		    }

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Function to get the discounted on the selected product
	 * 
	 */
	public Product getDiscoutOnProduct(Product productObject,int userID){
		try{
			Map<String, String> userCategory=UserDAO.getUserCategory(userID);
			double productPrice=productObject.getProductPrice();
			double x=productPrice*(Double.parseDouble(userCategory.get("categoryDiscount"))/100);
			double y=productPrice-x;
			productObject.setProductDiscountedPrice(y);
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return productObject;
		
	}
	/**
	 * Function to get the discounted on the selected product
	 * 
	 */
	public int findCorrespondingCategoryID(int currentUserPoints){
		int result=0;
		try{
			Map<Integer,Integer> categoriesList = CategoriesDAO.getMinOfCategories();
			int n1=0;int n2=0;
			for(int i=0;i<categoriesList.size();i++){
				n1=categoriesList.get(i);
				n2=(i==categoriesList.size()-1)?Integer.MAX_VALUE:categoriesList.get(i+1);
				if( (n1<=currentUserPoints) && (currentUserPoints<n2)){
					System.out.println("Printing selected category: "+i);
					return i;
				}
					
			}
			
		}catch(Exception e){
		
			e.printStackTrace();
		}
		return result;
		
	}

}
