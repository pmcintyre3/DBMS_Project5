package dbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbms.model.Product;

public class ProductDao {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "dbmsProject5";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";
	
	public static List<Product> getAllProducts() {
		boolean status = false;
		int id=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<Product>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select productID,productName, productDescription,productImage,productPrice,productPoints,productCategoryID from products");
				rs = pst.executeQuery();
				while(rs.next()){
					productList.add(new Product(rs.getInt("productID"),
                            					rs.getString("productName"),
                            					rs.getString("productDescription"),
                            					rs.getString("productImage"),
                            					rs.getDouble("productPrice"),
                            					rs.getInt("productPoints"),
                            					rs.getInt("productCategoryID")
                            					
                            		));
				}
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productList;  
	}
	
	public static Product getProduct(int productID,int categoryID) {
		boolean status = false;
		int id=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				//pst = conn.prepareStatement("select productID,productName, productDescription,productImage,productPrice,productPoints,productCategoryID from products where productID=?");
				pst=conn.prepareStatement(" select "
										  +"products.productID as productID, "
										  +"products.productCategoryId as productCategoryID, categories1.categoryName as productCategoryName,categories1.categoryDiscount as productCategoryDiscount, "
										  +"products.productName as productName, products.productDescription as productDescription, products.productImage as productImage, "
										  +"products.productPrice as productPrice,products.productPoints as productPoints "
										  +"from products,categories as categories1 "
										  +"where products.productCategoryID=categories1.categoryID "
										  +"AND products.productID=?");
				pst.setInt(1, productID);
				rs = pst.executeQuery();
				while(rs.next()){
					
					product =new Product(rs.getInt("productID"),
                            					rs.getString("productName"),
                            					rs.getString("productDescription"),
                            					rs.getString("productImage"),
                            					rs.getDouble("productPrice"),
                            					rs.getInt("productPoints"),
                            					rs.getInt("productCategoryID"),
                            					rs.getString("productCategoryName"),
                            					rs.getInt("productCategoryDiscount")
                            					
                            			);
				}
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return product;  
	}
	
	/**
	 * Function to get all the products which are
	 * available at a discount rate to a specific User
	 */
	public static List<Product> getDiscountedProducts(int userID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<Product>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				
				String selectQuery="select "
								   +"products.productID as productID, "
								   +"products.productCategoryId as productCategoryID, categories2.categoryName as productCategoryName,categories2.categoryDiscount as productCategoryDiscount, "
								   +"products.productName as productName, products.productDescription as productDescription, products.productImage as productImage, "
								   +"products.productPrice as productPrice,products.productPoints as productPoints "
								   +"from users,products,categories as categories1, categories as categories2 "
								   +"where products.productCategoryID=categories2.categoryID "
								   +"AND users.userCategoryID=categories1.categoryID "
								   +"AND users.userCategoryID>=products.productCategoryID "
								   +"AND users.userID=? "
								   +"order by products.productID";

				pst = conn.prepareStatement(selectQuery);
				pst.setInt(1, userID);
				rs = pst.executeQuery();
				while(rs.next()){
					
					productList.add(new Product(rs.getInt("productID"),
                            					rs.getString("productName"),
                            					rs.getString("productDescription"),
                            					rs.getString("productImage"),
                            					rs.getDouble("productPrice"),
                            					rs.getInt("productPoints"),
                            					rs.getInt("productCategoryID"),
                            					rs.getString("productCategoryName"),
                            					rs.getInt("productCategoryDiscount")
                            					
                            			));
				}
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productList;  
	}
	
	/**
	 * Function to get all the products which are
	 * available at a discount rate to a specific User
	 */
	public static List<Product> getNonDiscountedProducts(int userID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Product> productList = new ArrayList<Product>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				
				String selectQuery="select " 
								   +"products.productID as productID, products.productName as productName, " 
								   +"products.productDescription as productDescription, products.productImage as productImage, "
								   +"products.productPrice as productPrice,products.productPoints as productPoints, "
								   +"products.productCategoryId as productCategoryID, categories.categoryName as productCategoryName "
								   +"from products,categories "
								   +"where products.productCategoryID=categories.categoryID "
								   +"AND products.productID NOT IN " 
								   +"(select products.productID as productID "
								   +"from users,products,categories as categories1, categories as categories2 " 
								   +"where products.productCategoryID=categories2.categoryID " 
								   +"AND users.userCategoryID=categories1.categoryID " 
								   +"AND users.userCategoryID>=products.productCategoryID " 
								   +"AND users.userID=? "
								   +"order by products.productID)" ;

				pst = conn.prepareStatement(selectQuery);
				pst.setInt(1, userID);
				rs = pst.executeQuery();
				while(rs.next()){
					
					productList.add(new Product(rs.getInt("productID"),
                            					rs.getString("productName"),
                            					rs.getString("productDescription"),
                            					rs.getString("productImage"),
                            					rs.getDouble("productPrice"),
                            					rs.getInt("productPoints"),
                            					rs.getInt("productCategoryID"),
                            					rs.getString("productCategoryName")
                            					//rs.getInt("productCategoryDiscount")
                            					
                            			));
				}
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productList;  
	}
	
	/**
	 * Function to get all the products which are
	 * available at a discount rate to a specific User
	 */
	public static int checkIfProductDiscounted(int productID,int userID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Product productObj = null;
		int returnProductID=0;
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				
				String selectQuery="select " 
								   +"products.productID as productID "
								   +"from products,categories "
								   +"where products.productCategoryID=categories.categoryID "
								   +"AND products.productID=? "
								   +"AND products.productID NOT IN " 
								   +"(select products.productID as productID "
								   +"from users,products,categories as categories1, categories as categories2 " 
								   +"where products.productCategoryID=categories2.categoryID " 
								   +"AND users.userCategoryID=categories1.categoryID " 
								   +"AND users.userCategoryID>=products.productCategoryID " 
								   +"AND users.userID=? "
								   +"order by products.productID)" ;

				pst = conn.prepareStatement(selectQuery);
				pst.setInt(1, productID);
				pst.setInt(2, userID);
				rs = pst.executeQuery();
				while(rs.next()){
					returnProductID=rs.getInt("productID");
					        					
                }
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return returnProductID;  
	}
	
	public static Map<String,Integer> getProductCountCategoryWise() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String,Integer> productList = new HashMap<String,Integer>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select count(products.productID) as count,categories.categoryName as categoryName "
											+"from products, categories "
											+"where products.productCategoryID=categories.categoryID "
											+"group by products.productCategoryID");
				rs = pst.executeQuery();
				while(rs.next()){
					productList.put(rs.getString("categoryName"),rs.getInt("count"));
				}
			} catch (Exception e) {
			System.out.println(e);
		} finally {
			
			if (conn != null) {
				try {
					conn.close();
				
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return productList;  
	}



}

