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

import dbms.model.Categories;
import dbms.model.Product;

public class CategoriesDAO {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "dbmsProject5";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";

	public static List<Categories> getAllCategories() {
		boolean status = false;
		int id=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Categories> catList = new ArrayList<Categories>();

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager
					.getConnection(url + dbName, userName, password);
			pst = conn.prepareStatement("select categoryID, categoryName, categoryDiscount, minPointsRequired from categories");
			rs = pst.executeQuery();
			while(rs.next()){
				catList.add(new Categories(
						rs.getInt("categoryID"),
						rs.getString("categoryName"),
						rs.getInt("categoryDiscount"),
						rs.getInt("minPointsRequired")
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

		return catList;
	}

	public static Map<Integer,Integer> getMinOfCategories() {
		boolean status = false;
		int id=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Map<Integer,Integer> categoriesList = new HashMap<Integer,Integer>();
		
		try {
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn.prepareStatement("select categoryID,minPointsRequired from categories");
				rs = pst.executeQuery();
				while(rs.next()){
					categoriesList.put(rs.getInt("categoryID"), rs.getInt("minPointsRequired"));
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
		
		return categoriesList;  
	}

	
}
