package dbms.model;

import java.sql.Date;

public class UserOrder {

	private int orderID;
	private int productID;
	private String productName;
	private String productDescription;
	private String productImage;
	private double productPrice;
	private double discountedPrice;
	private int productPoints;
	private int productCategory;
	private String productCategoryName;
	private Date orderedOn;
	
	public UserOrder(int orderID,int productID,String productName, String productDescription, String productImage, double productPrice, int productPoints, int productCatID, String productCategoryName,Date orderedOn,double discountedPrice){
		this.orderID=orderID;
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategory=productCatID;
		this.productCategoryName=productCategoryName;
		this.orderedOn=orderedOn;
		this.discountedPrice=discountedPrice;
	}
 
	public int getOrderID() {
		return orderID;
	}
 
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getProductID() {
		return productID;
	}
 
	public void setProductID(int productID) {
		this.productID = productID;
	}
 
	public String getProductName() {
		return productName;
	}
 
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getProductDescription() {
		return productDescription;
	}
 
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public String getProductImage(){
		return productImage;
	}
	
	public void setProductImage(String productImage){
		this.productImage=productImage;
	}
	
	public double getProductPrice() {
		return productPrice;
	}
 
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}
 
	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public int getProductPoints() {
		return productPoints;
	}
 
	public void setProductPoints(int productPoints) {
		this.productPoints = productPoints;
	}

	public int getProductCatID() {
		return productCategory;
	}
 
	public void setProductCatID(int productCatID) {
		this.productCategory = productCatID;
	}
	
	public String getProductCategoryName() {
		return productCategoryName;
	}
 
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	public Date getOrderedOn() {
		return orderedOn;
	}
 
	public void setOrderedOn(Date orderedOn) {
		this.orderedOn = orderedOn;
	}


}
