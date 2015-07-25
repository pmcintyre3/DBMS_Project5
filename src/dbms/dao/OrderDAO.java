package dbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import dbms.model.Order;
import dbms.model.Product;
import dbms.model.UserOrder;

public class OrderDAO {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "dbmsProject5";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";


	public static List<UserOrder> getAllOrdersOfUser(int userID){
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<UserOrder> userOrderList = new ArrayList<UserOrder>();
		
		try{
			
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			String selectTableSQL = "select orders.orderID,products.productID as productID, products.productName as productName, products.productDescription as productDescription, "
									+"products.productImage as productImage,products.productPrice as productPrice,products.productCategoryID as productCategoryID, products.productPoints as productPoints, "
									+"categories.categoryName as categoryName,orders.orderedOn as orderedOn, orderDetails.productSoldAt as discountedPrice " 
									+"from users, products,orders,orderDetails,categories where " 
									+" users.userID=orders.userID AND orders.orderID=orderDetails.orderNumber "
									+"AND products.productID=orderDetails.productID AND categories.categoryID=products.productCategoryID AND users.userID=?";
					
									
			pst = conn.prepareStatement(selectTableSQL);
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while(rs.next()){
				userOrderList.add(new UserOrder(
						//int productID,String productName, String productDescription, String productImage, int productPrice, int productPoints, int productCatID, String productCategoryName,Date orderedOn
									rs.getInt("orderID"),
                        			rs.getInt("productID"),
                        			rs.getString("productName"),
                        			rs.getString("productDescription"),
                        			rs.getString("productImage"),
                        			rs.getDouble("productPrice"),
                        			rs.getInt("productPoints"),
                        			rs.getInt("productCategoryID"),
                        			rs.getString("categoryName"),
                        			rs.getDate("orderedOn"),
                        			rs.getDouble("discountedPrice")
                        			
                        	));
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userOrderList;
		
	}

	
	public static boolean putOrder(int userID,int productID,double totalOrderPrice,Date orderedOn){
		boolean result=false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int maxOrderID=-1;
		int maxOrder=0;
		
		
		try{
			
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
			
			
			
			// Determine the orderID
			String selectTableSQL = "select MAX(orderID) from orders";
			pst = conn.prepareStatement(selectTableSQL);
			rs = pst.executeQuery();
			while(rs.next()){
				maxOrder=rs.getInt(1);
				if(maxOrder==0){
					maxOrderID=1;
				}else{
					maxOrderID=maxOrder+1;
				}
			}

			
			/**
			 * Insert into orders table the userID and orderID.
			 * orderID is required inorder to update the totalOrderPrice 
			 * But, in our case since only 1 product can be bought at a time,
			 * we can straightaway insert the totalOrderPrice.
			 */
			
			String insertTableSQL = "insert into orders (orderID,userID,totalOrderPrice,orderedOn)"
									+" values (?,?,?,?)";
			pst = conn.prepareStatement(insertTableSQL);
			pst.setInt(1, maxOrderID);
			pst.setInt(2, userID);
			pst.setDouble(3, totalOrderPrice);
			pst.setDate(4, orderedOn);
		
			if(pst.executeUpdate()>0){
				/**
				 * After insert into orders tables, 
				 * make entries into orderDetails table too.
				 * 
				 */
				insertTableSQL = "insert into orderDetails (orderNumber, productID, productSoldAt,createdOn)"
						+" values (?,?,?,?)";
				pst = conn.prepareStatement(insertTableSQL);
				pst.setInt(1, maxOrderID);
				pst.setInt(2, productID);
				pst.setDouble(3, totalOrderPrice);
				pst.setDate(4, orderedOn);
				if(pst.executeUpdate()>0)
					result=true;

			}	
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
		
	}
//	public static List<User> getAllUsers() {
//		boolean status = false;
//		int id=-1;
//		Connection conn = null;
//		PreparedStatement pst = null;
//		ResultSet rs = null;
//		List<User> userList = new ArrayList<User>();
//		
//		try {
//				Class.forName(driver).newInstance();
//				conn = DriverManager
//						.getConnection(url + dbName, userName, password);
//				pst = conn.prepareStatement("select id,user,catId,admin from users;");
//				rs = pst.executeQuery();
//				while(rs.next()){
//					userList.add(new User(rs.getString("id"),
//                            					rs.getString("user"),
//                            					rs.getInt("catId"),
//                            					rs.getBoolean("admin")
//                            					                            					
//                            		));
//				}
//			} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			
//			if (conn != null) {
//				try {
//					conn.close();
//				
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pst != null) {
//				try {
//					pst.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return userList;  
//	}
//	
//	public static User getUser(String userName) {
//		Connection conn = null;
//		PreparedStatement pst = null;
//		ResultSet rs = null;
//		User user = null;
//		
//		try {
//				Class.forName(driver).newInstance();
//				conn = DriverManager
//						.getConnection(url + dbName, userName, password);
//				pst = conn.prepareStatement("select id,user,catId,admin from users where user=?;");
//				pst.setString(1, userName);
//				rs = pst.executeQuery();
//				while(rs.next()){
//					                       					
//
//					user = new User(rs.getString("id"),
//		        					rs.getString("user"),
//		        					rs.getInt("catId"),
//		        					rs.getBoolean("admin")
//        					);
//				}
//			} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			
//			if (conn != null) {
//				try {
//					conn.close();
//				
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (pst != null) {
//				try {
//					pst.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			if (rs != null) {
//				try {
//					rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		
//		return user;  
//	}
}
