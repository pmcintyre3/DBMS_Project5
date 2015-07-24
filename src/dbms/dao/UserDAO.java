package dbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbms.model.User;

public class UserDAO {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "dbmsProject5";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";

	public static List<User> getAllUsers() {
		boolean status = false;
		int id=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select userID,userName,userCategoryID,isAdmin from users;");
				rs = pst.executeQuery();
				while(rs.next()){
					userList.add(new User(rs.getString("userID"),
                            					rs.getString("userName"),
                            					rs.getInt("userCategoryID"),
                            					rs.getBoolean("isAdmin")
                            					                            					
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
		
		return userList;  
	}
	
	public static User getUser(String userName) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select userID,userName,userCategoryID,isAdmin from users where userName=?");
				System.out.println("baher");
				pst.setString(1, userName);
				rs = pst.executeQuery();
				while(rs.next()){
					                       					
					System.out.println("aat");
					user = new User(rs.getString("userID"),
		        					rs.getString("userName"),
		        					rs.getInt("userCategoryID"),
		        					rs.getBoolean("isAdmin")
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
		
		return user;  
	}
	
	public static int getUserPoints(int userID){
		boolean result=false;
		int points=0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select points from points where userID=?");
				pst.setInt(1, userID);
				rs = pst.executeQuery();
				while(rs.next()){
					                       					
					points=rs.getInt("points");	
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
		

		
		return points;
	}

	
	public static boolean setUserPoints(int userID,int points){
		boolean result=false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("update points set points = ? where userID=?");
				pst.setInt(1, points);
				pst.setInt(2, userID);
				if(pst.executeUpdate()>0)
					result=true;
				
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
		

		
		return result;
	}
}
