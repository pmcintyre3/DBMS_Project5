<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="base"
	value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Reward Points</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/justified-nav.css" rel="stylesheet">


<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
#logoutFormLink {
	display: block;
	padding: 3px 20px;
	clear: both;
	font-weight: normal;
	line-height: 1.42857143;
	color: rgb(123, 138, 139);
	white-space: nowrap;
}
</style>
</head>

<body>

	<div class="container">

		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<div class="row">
				<div class="col-md-9">
					<a href="index.html"><img src="bootstrap/images/logo.png"
						alt=""></a> <br />
				</div>
				<div class="col-md-3 pull-right"
					style="padding-left: 2px; font-size: 16px; text-align: right;">
					<%
						//allow access only if session exists
						String user = null;
						if(session.getAttribute("user") == null){
							response.sendRedirect("login.html");
						}else user = (String) session.getAttribute("user");
						String userName = null;
						String sessionID = null;
						Cookie[] cookies = request.getCookies();
						if(cookies !=null){
						for(Cookie cookie : cookies){
							if(cookie.getName().equals("user")) userName = cookie.getValue();
							if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
						}
						}
					%>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false"
						><b><%= user %></b> &nbsp;
						<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a
							href="http://localhost:8080/DBMS_Project5/OrderServlet"> <span
								class="glyphicon glyphicon-align-justify" aria-hidden="true"></span>&nbsp;&nbsp;My
								Orders
						</a></li>
						<li class="divider"></li>
						<li>
							<form action="LogoutServlet" method="post">
								<a id="logoutFormLink" href="#" value="Logout"
									onclick="$(this).closest('form').submit();"
									style="text-decoration: none;"><span
									class="glyphicon glyphicon-log-out" aria-hidden="true"></span>&nbsp;&nbsp;
									Logout </a>
							</form>

						</li>

					</ul>

				</div>
			</div>
			<nav>
				<ul class="nav nav-justified" style="color: #2c3e50;">
					<li class="active"><a href="http://localhost:8080/DBMS_Project5/LoginServlet">Home</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>

		</div>

		<c:choose>
		<c:when test="${fn:length(discountedProductList) gt 0}">
				<div class="row discountedProductList">
					<c:forEach items="${discountedProductList}" var="article">
		
						<div class='col-md-4'>
							<br />
							<div class='thumbnail'>
								<img class='img-responsive' src='${article.productImage}' alt=''>
								<div class='caption'>
									<c:choose>
									  <c:when test="${userCategoryID==1}">
									    <span class="label label-danger">Bronze Membership</span>
									  </c:when>
									  <c:when test="${userCategoryID==2}">
									  	<span class="label label-default">Silver Membership</span>
									  </c:when>
									  <c:when test="${userCategoryID==3}">
									  	<span class="label label-warning">Gold Membership</span>
									  </c:when>
									</c:choose>
									<div class="co-md-6">
											<p>Discounted Price: $${article.productDiscountedPrice}</p>
									</div>
									<h3>${article.productName}<br />
									</h3>
									<p>${article.productDescription}</p>
									<div class="row">
										<div class="col-md-6">
											<p>
												Product Price:
												<c:choose>
													<c:when
														test="${article.productDiscountedPrice < article.productPrice}">
														<span style="text-decoration: line-through;">$${article.productPrice}</span>
													</c:when>
													<c:otherwise>
														<span>$${article.productPrice}</span>
													</c:otherwise>
												</c:choose>
											</p>
										</div>
										
									</div>
									<p>
										<a class="btn btn-primary"
											href="http://localhost:8080/DBMS_Project5/ProductServlet?productID=${article.productID}"
											role="button">View details &raquo;</a>
									</p>
								</div>
							</div>
						</div>
		
					</c:forEach>
		
				</div>			
	  	</c:when>
	  	</c:choose>
	  	
	  	<c:choose>
		<c:when test="${fn:length(nonDiscountedProductList) gt 0}">
				<div class="row nonDiscountedProductList">
					<c:forEach items="${nonDiscountedProductList}" var="article">
		
						<div class='col-md-4'>
							<br />
							<div class='thumbnail'>
								<img class='img-responsive' src='${article.productImage}' alt=''>
									<h3>${article.productName}<br />
									</h3>
									<p>${article.productDescription}</p>
									<div class="row">
										<div class="col-md-6">
											<p>
												Product Price: <span>$${article.productPrice}</span>
													
											</p>
										</div>
										
									</div>
									<p>
										<a class="btn btn-primary"
											href="http://localhost:8080/DBMS_Project5/ProductServlet?productID=${article.productID}"
											role="button">View details &raquo;</a>
									</p>
								</div>
							</div>
					</c:forEach>
		
				</div>			
			
		</c:when>
		</c:choose>
	  	
							


		<!-- Site footer -->
		<footer class="footer">
			<p>&copy; Company 2015</p>
		</footer>

	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<!--     <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script> -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
