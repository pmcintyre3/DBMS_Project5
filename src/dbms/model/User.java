package dbms.model;


public class User {
	

	private String userID;
	private String userName;
	private int userCatID;
	private boolean isAdmin;
	
	public User(String userID,String userName,int userCatID,boolean isAdmin){
		
		this.userID=userID;
		this.userName=userName;
		this.userCatID=userCatID;
		this.isAdmin=isAdmin;
   }
	
	public String getUserID() {
		return userID;
	}
 
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
 	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserCatID() {
		return userCatID;
	}
 
	public void setUserCatID(int userCatID) {
		this.userCatID = userCatID;
	}
	public boolean getIsAdmin() {
		return isAdmin;
	}
 
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
}
