package dbms.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbms.model.Points;

/**
 * Created by Phillip on 7/26/2015.
 */
public class PointsDAO {

    static String url = "jdbc:mysql://localhost:3306/";
    static String dbName = "dbmsProject5";
    static String driver = "com.mysql.jdbc.Driver";
    static String userName = "root";
    static String password = "root";

    /**
     * Function to retrieve User's points
     * 
     * @return List<Points>
     */
    public static List<Points> getAllPoints() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Points> pointsList = new ArrayList<Points>();

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
            pst = conn.prepareStatement("select userID, points, pointsRenewalDate from points");
            rs = pst.executeQuery();
            while(rs.next()){
                pointsList.add(new Points(
                        rs.getInt("userID"),
                        rs.getInt("points"),
                        rs.getDate("pointsRenewalDate")
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

        return pointsList;
    }

    public static int registerUserPoints (int uID) {
        Connection conn = null;
        PreparedStatement pst = null;
        int rs = -1;

        try {
            rs = -1;
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);
            pst = conn
                    .prepareStatement("INSERT INTO points (userID, points, userCategoryID, pointsRenewalDate) VALUES (?,?,?);");
            pst.setInt(1, uID);
            pst.setInt(2, 0);
            pst.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

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
