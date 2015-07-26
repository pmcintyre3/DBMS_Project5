package dbms.model;

import java.sql.Date;

/**
 * Created by Phillip on 7/26/2015.
 */
public class Points {

    private int userID;
    private int points;
    private Date pointsRenewalDate;

    public Points (int userID, int points, Date pointsRenewalDate){
        this.userID = userID;
        this.points = points;
        this.pointsRenewalDate = pointsRenewalDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getPointsRenewalDate() {
        return pointsRenewalDate;
    }

    public void setPointsRenewalDate(Date pointsRenewalDate) {
        this.pointsRenewalDate = pointsRenewalDate;
    }
}
