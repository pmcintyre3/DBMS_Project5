
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

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		//$("#loginError").hide();
	});
</script>

</head>

<body>

	<div class="container">

		<!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
		<div class="masthead">
			<div class="row">
				<div class="col-md-10">
					<a href="index.html"><img src="bootstrap/images/logo.png"
						alt=""></a> <br />
				</div>
				<div class="col-md-2 pull-right"
					style="padding-left: 2px; font-size: 16px; text-align: right;">
					<a href="login.jsp">Sign IN / Register</a>
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


		<div class="row">
			<br />
			<div class="col-md-6" style="border-right: 1px solid #eee;">
				<br />
				<legend>New Customers</legend>
				<p style="text-align: justify;">Lorem ipsum dolor sit amet,
					consectetuer adipiscing elit, sed diam nonummy nibh euismod
					tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi
					enim ad minim veniam, quis nostrud exerci tation ullamcorper
					suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis
					autem vel eum iriure dolor in hendrerit in vulputate velit esse
					molestie consequat, vel illum dolore eu feugiat nulla facilisis at
					vero eros et accumsan.</p>
				<a href="register.html" class="btn btn-primary">Sign UP</a>

			</div>
			<div class="col-md-6">
				<br />
				<form class="form-horizontal" action="LoginServlet" method="post">
					<fieldset>
						<legend>Registered Customers</legend>
						<div class="bs-component" id="loginError">
							<% String login_msg=(String)request.getAttribute("error");
								if(login_msg!=null) out.println("<div class='alert alert-dismissible alert-danger'><button type='button' class='close' data-dismiss='alert'>×</button>"+login_msg+".</div>");
							%>
							
						</div>
						<div class="form-group">
							<label for="inputEmail" class="col-lg-2 control-label">Email<span
								class="text-danger">*</span></label>
							<div class="col-lg-10">
								<input type="text" class="form-control" id="userName"
									name="userName" placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword" class="col-lg-2 control-label">Password<span
								class="text-danger">*</span></label>
							<div class="col-lg-10">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password">

							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-10 col-lg-offset-2">
								<button type="submit" class="btn btn-success pull-right"
									value="Login">Login</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>

		</div>

		<!-- Site footer -->
		<footer class="footer">
			<p>&copy; Company 2015</p>
		</footer>

	</div>
	<!-- /container -->



</body>
</html>
