package dbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dbms.model.Product;

public class ProductDao {
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbName = "test";
	static String driver = "com.mysql.jdbc.Driver";
	static String userName = "root";
	static String password = "root";

	public static List<Product> getAllProducts(int categoryID) {
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
				pst = conn.prepareStatement("select id,productName, productDescription,productImg from product;");
				rs = pst.executeQuery();
				while(rs.next()){
					productList.add(new Product(rs.getInt("id"),
                            					rs.getString("productName"),
                            					rs.getString("productDescription"),
                            					rs.getString("productImg")
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
}
