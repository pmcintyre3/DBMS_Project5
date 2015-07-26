package dbms.model;

public class Categories {
	
	private int categoryID;
	private String categoryName;
	private int categoryDiscount;
	private int minPointsRequired;
	
	
	public Categories(int categoryID,String categoryName, int categoryDiscount)
	{	
		this.categoryID=categoryID;
		this.categoryName=categoryName;
		this.categoryDiscount=categoryDiscount;
		
	}

	public Categories(int categoryID, String categoryName, int categoryDiscount, int minPointsRequired){
		this.categoryID=categoryID;
		this.categoryName=categoryName;
		this.categoryDiscount=categoryDiscount;
		this.minPointsRequired=minPointsRequired;
	}
	
	public int getCategoryID() {
		return categoryID;
	}
 
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
 
	public String getCategoryName() {
		return categoryName;
	}
 
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public int getCategoryDiscount() {
		return categoryDiscount;
	}
	
	public void setCategoryDiscount(int categoryDiscount) {
		this.categoryDiscount = categoryDiscount;
	}

	public int getMinPointsRequired(){ return minPointsRequired; }

	public void setMinPointsRequired(int minPointsRequired){ this.minPointsRequired = minPointsRequired; }


}
