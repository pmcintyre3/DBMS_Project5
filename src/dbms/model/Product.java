package dbms.model;

public class Product {

	private int productID;
	private String productName;
	private String productDescription;
	private String productImage;
	private int productPrice;
	private int productPoints;
	private int productCategoryID;
	
	public Product(int productID,String productName, String productDescription, String productImage, int productPrice, int productPoints, int productCategoryID){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategoryID=productCategoryID;
		
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
	
	public void setProductImg(String productImage){
		this.productImage=productImage;
	}
	
	public int getProductPrice() {
		return productPrice;
	}
 
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductPoints() {
		return productPoints;
	}
 
	public void setProductPoints(int productPoints) {
		this.productPoints = productPoints;
	}

	public int getProductCatID() {
		return productCategoryID;
	}
 
	public void setProductCatID(int productCatID) {
		this.productCategoryID = productCatID;
	}


}
