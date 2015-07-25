package dbms.model;

public class Product {

	private int productID;
	private String productName;
	private String productDescription;
	private String productImage;
	private double productPrice;
	private int productPoints;
	private int productCategoryID;
	private String productCategoryName;
	private double productDiscountedPrice;
	private int productCategoryDiscount;
	
	
	public Product(int productID,String productName, String productDescription, String productImage, double productPrice, int productPoints, int productCategoryID){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategoryID=productCategoryID;
		
	}
	
	public Product(int productID,String productName, String productDescription, String productImage, double productPrice, int productPoints, int productCategoryID, String productCategoryName){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategoryID=productCategoryID;
		this.productCategoryName=productCategoryName;
		
	}

	
	public Product(int productID,String productName, String productDescription, String productImage, double productPrice, int productPoints, int productCategoryID, String productCategoryName,int productCategoryDiscount){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategoryID=productCategoryID;
		this.productCategoryName=productCategoryName;
		this.productCategoryDiscount=productCategoryDiscount;
		
		
	}

	public Product(int productID,String productName, String productDescription, String productImage, double productPrice, int productPoints, int productCategoryID, String productCategoryName,double productDiscountedPrice,int productCategoryDiscount){
		this.productID = productID;
		this.productName=productName;
		this.productDescription = productDescription;
		this.productImage=productImage;
		this.productPrice=productPrice;
		this.productPoints=productPoints;
		this.productCategoryID=productCategoryID;
		this.productCategoryName=productCategoryName;
		this.productDiscountedPrice=productDiscountedPrice;
		this.productCategoryDiscount=productCategoryDiscount;
		
	}

	public int getProductCategoryDiscount(){
		return productCategoryDiscount;
	}
 
	public void setProductCategoryDiscount(int productCategoryDiscount) {
		this.productCategoryDiscount = productCategoryDiscount;
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
 
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductPoints() {
		return productPoints;
	}
 
	public void setProductPoints(int productPoints) {
		this.productPoints = productPoints;
	}

	public int getProductCategoryID() {
		return productCategoryID;
	}
 
	public void setProductCategoryID(int productCatID) {
		this.productCategoryID = productCatID;
	}
	public String getProductCategoryName() {
		return productCategoryName;
	}
 
	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
	public double getProductDiscountedPrice() {
		return productDiscountedPrice;
	}
 
	public void setProductDiscountedPrice(double productDiscountedPrice) {
		this.productDiscountedPrice = productDiscountedPrice;
	}




}
