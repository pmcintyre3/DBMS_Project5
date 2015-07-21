package dbms.model;

public class Product {

	private int productID;
	private String productName;
	private String productDescription;
	private String productImg;
 
	public Product(int productID,String productName, String productDescription, String productImg){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImg=productImg;
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
	
	public String getProductImg(){
		return productImg;
	}
	
	public void setProductImg(String productImg){
		this.productImg=productImg;
	}
}
