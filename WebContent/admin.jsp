<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="d" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
	<d:set var="base" value="${fn:substring(url, 0, fn:length(url) - fn:length(req.requestURI))}${req.contextPath}/" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Adidas Reward Program</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="bootstrap/css/justified-nav.css" rel="stylesheet">

<!--- jQuery libraries from Google Developers --->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<!--     <script src="../../assets/js/ie-emulation-modes-warning.js"></script> -->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<script type="text/javascript">
	$(document).ready(function() {
		
		$('li').click(function(){
			$('li').removeClass('active');
			$(this).addClass('active');	
			
			var id = $(this).attr('id');
			//console.log(id);
			if(id == 'overview'){
				$('#overviewData').siblings('.container-fluid').hide();
				$('#overviewData').show();
			}
			else if(id == 'userView'){
				$('#userData').show();
				$('#userData').siblings('.container-fluid').hide();
			}
			else if(id == 'categoryView'){
				$('#catData').siblings('.container-fluid').hide();
				$('#catData').show();	
			}
			else if(id == 'productView'){
				$('#prodData').siblings('.container-fluid').hide();
				$('#prodData').show();	
			}
			else if(id == 'pointView'){
				$('#pointData').siblings('.container-fluid').hide();
				$('#pointData').show();	
			}
		})
		
	});
</script>
	
</head>

<body>

<!-- <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost/rewardsite"
     user="root"  password=""/> -->

	<div class="container">

		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<div class="row">
				<div class="col-md-10">
					<a href="AdminServlet"><img src="bootstrap/images/logo.png" alt=""></a> <br />
				</div>
			</div>	
			<nav class="navbar navbar-default">
			<%
				//allow access only if session exists
				String user = null;
				if(session.getAttribute("user") == null){
					response.sendRedirect("login.html");
				} else user = (String) session.getAttribute("user");
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
			  <div class="container-fluid">
				
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				  <a class="navbar-brand" href="admin.jsp" disabled>Adidas Rewards</a>
				</div>

				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				  <ul class="nav navbar-nav">
					<li class="active" id='overview'><a href="#">Overview<span class="sr-only">(current)</span></a></li>
					<li id='userView'><a href="#">User Options</a></li>
					<li id='categoryView'><a href="#">Category Options</a></li>
					<li id='productView'><a href="#">Product Options</a></li>
					<li id='pointView'><a href="#">Points Options</a></li>
					
				
					<!--
					<li class="dropdown">
					  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">User Options<span class="caret"></span></a>
					  <ul class="dropdown-menu" role="menu">
						<li><a href="#">Display Users</a></li>
						<li class="divider"></li>
						<li><a href="#">Change User Category</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					  </ul>
					</li>
					-->
				  </ul>
				  <ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%= user %> <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
						<li>
							<form action="LogoutServlet" method="post">
								<a id="logoutFormLink" href="#" value="Logout"
									onclick="$(this).closest('form').submit();"
									style="text-decoration: none; text-align: center;"><span
									class="glyphicon glyphicon-log-out" aria-hidden="true"></span> &nbsp;&nbsp;
									Logout </a>
							</form>
						</li>
					  </ul>
					</li>
				  </ul>
				</div>
			  </div>
			</nav>
		
		</div>
		
		<div class='container-fluid' id='overviewData'>
			<h3>Overview related things</h3>
			<p>Probably just list orders and/or graphs here.</p>
			<hr />
			<p> Lorem ipsum dolor sit amet, consectetur adipiscing elit. In at ipsum neque. Cras tristique sem enim, 
			et scelerisque urna ultrices eu. Curabitur ornare purus in est pharetra, eu semper ex ultricies. Aenean 
			accumsan leo est, non ultricies ipsum sodales sed. Fusce neque dolor, imperdiet sit amet erat in, tempus 
			vehicula arcu. Integer sagittis mauris et orci varius, semper fringilla augue vehicula. Quisque efficitur 
			erat posuere justo rutrum, sit amet mollis neque tempor. Ut suscipit accumsan sollicitudin. Nulla convallis 
			lacus id quam commodo cursus. Vivamus pellentesque rhoncus pretium. Sed efficitur finibus arcu. Duis sed mi 
			feugiat, accumsan ligula vitae, efficitur nunc. Mauris vitae odio in lectus dictum sodales.
			</p>
			
		</div>
		
		<div class='container-fluid' id='userData' style='display: none;'>
			<h3>Users</h3> <!-- Show users -->
			<hr />
			<table class="table table-striped table-hover">
				<thead>
					<tr class='clickable-row' data-toggle="modal" data-target='#userModal'>
						<th>ID</th>
						<th>Username</th>
						<th>User Category ID</th>
						<th>Admin</th>
						<!-- <th>Date Created</th> -->
					</tr>
				</thead>
				<tbody>
				<!--
					<tr class='clickable-row' data-toggle="modal" data-target='#userModal'>
						<td>1</td>
						<td>test</td>
						<td>0</td>
						<td>0</td>
						<td>Jan 1, 2015</td>
					</tr>
				</tbody>
				<tbody>
					<tr class='clickable-row' data-toggle="modal" data-target='#userModal'>
						<td>2</td>
						<td>Allan</td>
						<td>2</td>
						<td>0</td>
						<td>June 17, 2015</td>
					</tr>
					-->
					<c:forEach items="${userList}" var="article">
						<tr class='clickable-row' data-toggle="modal" data-target='#userModal'>
							<td>${article.userID}</td>
							<td>${article.userName}</td>
							<td>${article.userCatID}</td>
							<td>${article.isAdmin}</td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>
		
		<div class='container-fluid' id='catData' style='display: none;'>
			<h3>Categories</h3> <!-- Show users -->
			<hr />
			<table class="table table-striped table-hover">
				<thead>
					<tr class='clickable-row' data-toggle="modal" data-target='#catModal'>
						<th>ID</th>
						<th>Category Name</th>
						<th>Category Discount</th>
						<th>minPointsRequired</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categoryList}" var="article">
						<tr class='clickable-row' data-toggle="modal" data-target='#catModal'>
							<td>${article.categoryID}</td>
							<td>${article.categoryName}</td>
							<td>${article.categoryDiscount}%</td>
							<td>${article.minPointsRequired} points</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class='container-fluid' id='prodData' style='display: none;'>
			<h3>Products</h3> <!-- Show users -->
			<hr />
			<table class="table table-striped table-hover">
				<thead>
					<tr class='clickable-row' data-toggle="modal" data-target='#prodModal'>
						<th>ID</th>
						<th>Price</th>
						<th>Image URL</th>
						<th>Product Name</th>
						<th>Description</th>
						<th>Points</th>
						<th>Category ID</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${productsList}" var="article">
						<tr class='clickable-row' data-toggle="modal" data-target='#prodModal'>
							<td>${article.productID}</td>
							<td>\$${article.productPrice}</td>
							<td>${article.productImage}</td>
							<td>${article.productName}</td>
							<td>${article.productDescription}</td>
							<td>${article.productPoints}</td>
							<td>${article.productCategoryID}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tbody>
					<tr class='clickable-row' data-toggle="modal" data-target='#prodModal'>
						<td>2</td>
						<td>$60</td>
						<td>bootstrap/images/asics.jpg</td>
						<td>Asics</td>
						<td>Fusce neque dolor, imperdiet</td>
						<td>17</td>
						<td>2</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class='container-fluid' id='pointData' style='display: none;'>
			<h3>Products</h3> <!-- Show users -->
			<hr />
			<table class="table table-striped table-hover">
				<thead>
					<tr class='clickable-row' data-toggle="modal" data-target='#pointModal'>
						<th>ID</th>
						<th>Points</th>
						<th>Points Renewal Date</th>
					</tr>
				</thead>
				<tbody>
					<tr class='clickable-row' data-toggle="modal" data-target='#pointModal'>
						<td>1</td>
						<td>25</td>
						<td>2015-01-23 12:00:00</td>
					</tr>
				</tbody>
				<tbody>
					<tr class='clickable-row' data-toggle="modal" data-target='#pointModal'>
						<td>2</td>
						<td>109</td>
						<td>2015-07-15 07:30:00</td>
					</tr>
				</tbody>
			</table>
		</div>
		
		<div class="modal fade" id="userModal" tabindex="-1"
						role="dialog" aria-labelledby="basicModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
									<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="mLabel">Edit User Data</h4>
					</div>
					<div class="modal-body">
					
						<label for='#insertID'>User ID</label>
						<input type='text' id='insertID' class="form-control" placeholder='User ID' disabled>
						<br />
						<label for='#insertUsername'>Username</label>
						<input type='text' id='insertUsername' class="form-control" placeholder='username'>
						<br />
						<label for='#insertCatID'>Cat ID</label>
						<input type='text' id='insertCatID' class="form-control" placeholder='CatID'>
						<br />
						<label for='#insertisAdmin'>Admin Status</label>
						<input type='text' id='insertIsAdmin' class="form-control" placeholder='Admin Status'>
						<br />
						<label for='#insertRegisterDate'>Date Registered</label>
						<input type='text' id='insertRegisterDate' class="form-control" placeholder='Date Registered'>
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary buyProduct"
										id='buyProduct_${productDetails.productID}'>Ok</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="catModal" tabindex="-1"
						role="dialog" aria-labelledby="basicModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
									<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="mLabel">Edit Categories</h4>
					</div>
					<div class="modal-body">
					
						<label for='#insertID'>Category ID</label>
						<input type='text' id='insertID' class="form-control" placeholder='Category ID' disabled>
						<br />
						<label for='#insertCatName'>Category Name</label>
						<input type='text' id='insertCatName' class="form-control" placeholder='Category Name'>
						<br />
						<label for='#insertCatDiscount'>Category Discount</label>
						<input type='text' id='insertCatDiscount' class="form-control" placeholder='Category Discount'>
						<br />
						<label for='#insertMinPtsReq'>Minimum Points Required</label>
						<input type='text' id='insertMinPtsReq' class="form-control" placeholder='Minimum Points Required'>
						<br />
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary buyProduct"
										id='buyProduct_${productDetails.productID}'>Ok</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="prodModal" tabindex="-1"
						role="dialog" aria-labelledby="basicModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
									<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="mLabel">Edit Product Data</h4>
					</div>
					<div class="modal-body">
					
						<label for='#insertID'>Product ID</label>
						<input type='text' id='prodID' class="form-control" placeholder='Product ID' disabled>
						<br />
						<label for='#insertPrice'>Price</label>
						<input type='text' id='insertPrice' class="form-control" placeholder='Price'>
						<br />
						<label for='#insertProdName'>Product Name</label>
						<input type='text' id='insertProdName' class="form-control" placeholder='Product Name'>
						<br />
						<label for='#insertDescription'>Description</label>
						<textarea id='insertDescription' class="form-control" placeholder='Description'></textarea>
						<br />
						<label for='#insertPoints'>Points Awarded</label>
						<input type='text' id='insertPoints' class="form-control" placeholder='Points Awarded'>
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary buyProduct"
										id='buyProduct_${productDetails.productID}'>Ok</button>
					</div>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="pointModal" tabindex="-1"
						role="dialog" aria-labelledby="basicModal">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
										aria-label="Close">
									<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="mLabel">Edit Points Data</h4>
					</div>
					<div class="modal-body">
					
						<label for='#insertID'>Point ID</label>
						<input type='text' id='insertID' class="form-control" placeholder='Points ID' disabled>
						<br />
						<label for='#insertNumPoints'>Number of Points</label>
						<input type='text' id='insertNumPoints' class="form-control" placeholder='numPoints'>
						<br />
						<label for='#insertPtRenewDt'>Cat ID</label>
						<input type='text' id='insertPtRenewDt' class="form-control" placeholder='Points Renewal Date (YYYY-MM-DD HH-MM-SS)'>
							
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
										data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary buyProduct"
										id='buyProduct_${productDetails.productID}'>Ok</button>
					</div>
				</div>
			</div>
		</div>
		
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
