package dbms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import dbms.model.User;

public class LoginDao {
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String dbName = "dbmsProject5";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root";
	private static String password = "root";

	
	public static int validate(String name, String pass) {
		boolean status = false;
		int userID=-1;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
        		String sha1password = DigestUtils.sha1Hex(pass);
				Class.forName(driver).newInstance();
				conn = DriverManager
						.getConnection(url + dbName, userName, password);
				pst = conn
						.prepareStatement("select userID from users where userName=? and userPassword=?");
				pst.setString(1, name);
				pst.setString(2, sha1password);
	
				rs = pst.executeQuery();
				while(rs.next()){
					userID=rs.getInt("userID");
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
		
		return userID;  
	}
	

}