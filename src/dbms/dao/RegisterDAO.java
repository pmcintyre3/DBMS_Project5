package dbms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

import dbms.model.User;

/**
 * Created by Phillip on 7/25/2015.
 */
public class RegisterDAO {

    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "dbmsProject5";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "root";


    //public static List<User> registerUser() {
    public static int registerUser(String name, String pass) {
        Connection conn = null;
        PreparedStatement pst = null;
        int rs = -1;

        try {
        	String sha1password = DigestUtils.sha1Hex(pass);
            rs = -1;
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
            pst = conn
                    .prepareStatement("INSERT INTO users (userName, userPassword, isAdmin, createdOn) VALUES (?,?,?,?,?);");
            pst.setString(1, name);
            
            pst.setString(2, sha1password);
            pst.setInt(3, 0);
          //  pst.setInt(4, 0);
            pst.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

            rs = pst.executeUpdate();
            pst.clearParameters();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //System.out.println("rs: " + rs);
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
//            if (rs != null) {
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
        return rs;
        //return userList;
    }
}
