<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		$('#orderSuccess').hide();
		$('a.buyProduct').show();
		$('.buyProduct').show();
		$(function() {
			$('[data-toggle="tooltip"]').tooltip()
		});
		
		$("#productDetails").on('click', 'a.buyProduct', function() {
		   
		//$('.buyProduct').click(function(){
			
			var elementID=this.id; 
			var productID=elementID.split('_')[1];
			$.ajax({
                type: "post",
                url: "http://localhost:8080/DBMS_Project5/ProductServlet", //this is my servlet
                data: { productID : JSON.stringify(productID) },
                success: function(result){   
                		$('#successText').text(result);
                		$('#orderSuccess').slideDown();
                		$('#'+elementID).hide();
                        
                }
            });
		});
		
	});
</script>


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
						if (session.getAttribute("user") == null) {
							response.sendRedirect("login.html");
						} else
							user = (String) session.getAttribute("user");
						String userName = null;
						String sessionID = null;
						Cookie[] cookies = request.getCookies();
						if (cookies != null) {
							for (Cookie cookie : cookies) {
								if (cookie.getName().equals("user"))
									userName = cookie.getValue();
								if (cookie.getName().equals("JSESSIONID"))
									sessionID = cookie.getValue();
							}
						}
					%>
					<a href="#" class="dropdown-toggle" data-toggle="dropdown"
						role="button" aria-expanded="false"
						style="text-transform: capitalize;"><b><%=userName%></b>
						&nbsp; <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">My Orders</a></li>
						<li class="divider"></li>
						<li>
							<form action="LogoutServlet" method="post">
								<a id="logoutFormLink" href="#" value="Logout"
									onclick="$(this).closest('form').submit();">&nbsp; Logout </a>
							</form>

						</li>

					</ul>

				</div>
			</div>
			<nav>
				<ul class="nav nav-justified" style="color: #2c3e50;">
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>

		</div>

		<div class="row" id="productDetails">
			<br />
			<div class="bs-component col-md-12" id="orderSuccess">

				<div class="alert alert-dismissible alert-success">
					<button type="button" class="close" data-dismiss="alert">×</button>
					<div id="successText"></div>
				</div>
			</div>

			<div class="col-md-5" style="text-align: center;">
				<br>

				<div class="thumbnail" style="">
					<img class='img-responsive' src='${productDetails.productImg}'
						alt=''>
				</div>
			</div>

			<div class="col-md-7">
				<div class='caption'>

					<h3>${productDetails.productName}<br />
					</h3>
					<p>${productDetails.productDescription}</p>

					<p>
						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="top" title=""
							data-original-title="Size #6">6</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="top" title=""
							data-original-title="Size #7">7</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="top" title=""
							data-original-title="Size #8">8</button>

						<button type="button" class="btn btn-default"
							data-toggle="tooltip" data-placement="top" title=""
							data-original-title="Size #9">9</button>

					</p>

					<p>
						<a class="btn btn-primary buyProduct" href="#" role="button"
							id='buyProduct_${productDetails.productID}'>Buy Now</a>
					</p>
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


</body>
</html>