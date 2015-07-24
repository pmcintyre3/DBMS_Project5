package dbms.model;

import java.sql.Date;

public class Order {

	private int userID;
	private int productID;
	private Date orderedOn;
	
	public Order(int userID, int productID,Date orderedOn){
		this.userID=userID;
		this.productID=productID;
		this.orderedOn=orderedOn;
		
	}

	public int getUserID() {
		return userID;
	}
 
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getProductID() {
		return productID;
	}
 
	public void setProductID(int productID) {
		this.productID = productID;
	}

	public Date getOrderedOn() {
		return orderedOn;
	}
 
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn=orderedOn;
	}


}
