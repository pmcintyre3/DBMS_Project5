# Rewards Program
## DBMS_Project 5 - Final Project

## Authors

Jey John Britton  
Phillip McIntyre  
Narita Pandhe  
Ryan Persaud  
Justin Tumale  

## Description

The Rewards Program site is a website that shows a typical business
implementation of a Rewards System. When a user buys an item from
the store, they get a certain amount of points. These points accumulate
until a certain date, where they are placed into a group based on the
amount of points they have at that time. These groups are tiered, and 
higher the group, the higher of a discount you are rewarded with on that
date. The points reset after the assigned date, so points have to be 
accumulated again.

## Project Structure
#### File Tree
```
+---DBMS_Project5
	|   .gitignore
	|   DBMS_Project5.iml
	|   README.md
	|   
	+---Diagrams
	|       3NF.png
	|       architecture.png
	|       BCNF.png
	|       insert_create.png
	|       Project 5 presentation.pdf
	|       Project 5 presentation.pptx
	|       schema.png
	|       UML.png
	|                       
	+---scripts
	|       dbmsProject5.sql
	|       inserts.sql
	|       schema.sql
	|       
	+---src
	|   \---dbms
	|       +---dao
	|       |       CategoriesDAO.java
	|       |       LoginDao.java
	|       |       OrderDAO.java
	|       |       package-info.java
	|       |       PointsDAO.java
	|       |       ProductDao.java
	|       |       RegisterDAO.java
	|       |       UserDAO.java
	|       |       
	|       +---model
	|       |       Categories.java
	|       |       Order.java
	|       |       package-info.java
	|       |       Points.java
	|       |       Product.java
	|       |       User.java
	|       |       UserOrder.java
	|       |       
	|       \---servlet
	|               AdminServlet.java
	|               HomeServlet.java
	|               LoginServlet.java
	|               LogoutServlet.java
	|               OrderServlet.java
	|               package-info.java
	|               ProductServlet.java
	|               RegisterServlet.java
	|               
	\---WebContent
		|   admin.jsp
		|   index.html
		|   index.jsp
		|   login.html
		|   login.jsp
		|   loginSuccess.jsp
		|   orderHistory.jsp
		|   productDetails.jsp
		|   register.html
		|   register.jsp
		|   
		+---bootstrap
		|           
		+---META-INF
		|       MANIFEST.MF
		|       
		\---WEB-INF
			|   web.xml
			|   
			+---classes
			|   \---dbms
			|       +---dao
			|       |       CategoriesDAO.class
			|       |       LoginDao.class
			|       |       OrderDAO.class
			|       |       package-info.class
			|       |       PointsDAO.class
			|       |       ProductDao.class
			|       |       RegisterDAO.class
			|       |       UserDAO.class
			|       |       
			|       +---model
			|       |       Categories.class
			|       |       Order.class
			|       |       package-info.class
			|       |       Points.class
			|       |       Product.class
			|       |       User.class
			|       |       UserOrder.class
			|       |       
			|       \---servlet
			|               AdminServlet.class
			|               HomeServlet.class
			|               LoginServlet.class
			|               LogoutServlet.class
			|               OrderServlet.class
			|               package-info.class
			|               ProductServlet.class
			|               RegisterServlet.class
			|               
			\---lib
					commons-codec-1.9.jar
					java-json.jar
					jstl-1.2.jar
					mysql-connector-java-5.1.34-bin.jar
					servlet-api.jar
```

#### Contents
* diagrams: UML diagrams and the PowerPoint with diagrams
* doc: Reviews and attendance schedules
* scripts: SQL scripts for the database
* src: Contains .java servlets and DAOs
* WebContent: Contains web pages and scripts, as well as compiled .class files

## Execution
To run the website, follow these instructions:  
1. Run the SQL scripts to create the database  
2. Add the WebContent to your Tomcat webapps folder and rename it to "DBMS_Project5"  
3. Ensure the phpmyadmin username and password are both "root"  
4. Go to http://localhost:8080/DBMS_Project5 to run the index page  
5. Any changes to the java code must be compiled and added to the webapps/DBMS_Project5/WEB-INF/classes folder
This may require restarting the Tomcat server.  
