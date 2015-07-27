package dbms.model;

import java.sql.Date;

public class User {
	

	private int userID;
	private String userName;
	private int userCategoryID;
	private boolean isAdmin;

	
	public User(int userID,String userName,int userCategoryID,boolean isAdmin){
		
		this.userID=userID;
		this.userName=userName;
		this.userCategoryID=userCategoryID;
		this.isAdmin=isAdmin;
   }
	
	public int getUserID() {
		return userID;
	}
 
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
 	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserCategoryID() {
		return userCategoryID;
	}
 
	public void setUserCategoryID(int userCategoryID) {
		this.userCategoryID = userCategoryID;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
 
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
