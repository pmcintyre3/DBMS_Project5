package dbms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbms.model.User;

public class UserDAO {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "dbmsProject5";
	static String driver = "com.mysql.jdbc.Driver";
	static String dbUserName = "root";
	static String password = "root";

	
	
	/***
	 * Function to retrieve all the Users
	 * @return List<User>
	 */
	public static List<User> getAllUsers() {
		boolean status = false;
		int id = -1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> userList = new ArrayList<User>();

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn
					.prepareStatement("select users.userID,userName,points.userCategoryID as userCategoryID,isAdmin "
									+"from users,points "
									+"where users.userID=points.userID");
			rs = pst.executeQuery();
			while (rs.next()) {
				userList.add(new User(rs.getInt("userID"), rs
						.getString("userName"), rs.getInt("userCategoryID"), rs
						.getBoolean("isAdmin")

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

	/**
	 * Function to retrieve a particular User
	 * @param userName
	 * @return
	 */
	public static User getUser(String userName) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn
					.prepareStatement("select users.userID as userID,userName,points.userCategoryID as userCategoryID,isAdmin "
							+ "from users,points "
							+ "where users.userID=points.userID "
							+ "AND userName=?");
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while (rs.next()) {

				user = new User(rs.getInt("userID"),
						rs.getString("userName"), rs.getInt("userCategoryID"),
						rs.getBoolean("isAdmin"));
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

	/**
	 * Function to retrieve a User's points
	 * @param userID
	 * @return
	 */
	public static int getUserPoints(int userID) {
		boolean result = false;
		int points = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn
					.prepareStatement("select points from points where userID=?");
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while (rs.next()) {

				points = rs.getInt("points");
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

	/**
	 *  Function to set a User's points and poinstRenewal date
	 * @param userID
	 * @param points
	 * @param pointsRenewalDate
	 * @return
	 */
	public static boolean setUserPoints(int userID, int points, Date pointsRenewalDate) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, dbUserName, password);
			
			if(pointsRenewalDate==null){
				pst = conn.prepareStatement("update points set points = ? where userID=?");
				pst.setInt(1, points);
				pst.setInt(2, userID);
				
			}else{
				pst = conn.prepareStatement("update points set points = ?, pointsRenewalDate=? where userID=?");
				pst.setInt(1, points);
				pst.setDate(2, pointsRenewalDate);
				pst.setInt(3, userID);
				
			}
			if (pst.executeUpdate() > 0)
				result = true;

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

	/***
	 * Function to retrieve a User's category
	 * @param userID
	 * @return
	 */
	public static Map<String, String> getUserCategory(int userID) {
		boolean result = false;
		int points = 0;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		Map<String, String> membershipMap = new HashMap<String, String>();

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn
					.prepareStatement("select points.userCategoryID as categoryID, categories.categoryName as categoryName,categories.categoryDiscount as categoryDiscount " 
									  +"from users,categories,points " 
									  +"where users.userID=points.userID "
									  +"AND points.userCategoryID=categories.categoryID " 
									  +"AND users.userID=?");
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while (rs.next()) {
				membershipMap.put("categoryID",
						String.valueOf(rs.getInt("categoryID")));
				membershipMap.put("categoryName", rs.getString("categoryName"));
				membershipMap.put("categoryDiscount", rs.getString("categoryDiscount"));
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

		return membershipMap;
	}

	/**
	 * Function to set a User's category
	 * @param userID
	 * @param userCategoryID
	 * @return
	 */
	public static int setUserCategory(int userID,int userCategoryID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn.prepareStatement("update points set userCategoryID=? where userID=?");
			pst.setInt(1, userCategoryID);
			pst.setInt(2, userID);
			
			return pst.executeUpdate();
			
				

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

		return 0;
	}
	
	/***
	 * Function to get the points renewal date for a userID
	 * @param userID
	 * @return
	 */
	public static Date getPointsRenewalDate(int userID) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Date pointsRenewalDate=null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, dbUserName, password);
			pst = conn
					.prepareStatement("select pointsRenewalDate from points where points.userID=?");
			pst.setInt(1, userID);
			rs = pst.executeQuery();
			while (rs.next()) {
				pointsRenewalDate=rs.getDate("pointsRenewalDate");
				
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

		return pointsRenewalDate;
	}
	
	/**
	 * Functions to retrieve the count of Users according to the category
	 * @return
	 */
	public static Map<String,Integer> getUserCountCategoryWise() {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<String,Integer> productList = new HashMap<String,Integer>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, dbUserName, password);
				pst = conn.prepareStatement("select count(users.userID) as count,categories.categoryName as categoryName "
											+"from users, points, categories " 
											+"where users.userID=points.userID "
											+"AND points.userCategoryID=categories.categoryID " 
											+"group by points.userCategoryID");
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

	public static boolean setUserData(String userName, int userCategoryID, int userID) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, dbUserName, password);

			pst = conn.prepareStatement("update users set userName=?, userCategoryID=? where userID=?");
			pst.setString(1, userName);
			pst.setInt(2, userCategoryID);
			pst.setInt(3, userID);

			if (pst.executeUpdate() > 0)
				result = true;

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
