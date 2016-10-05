<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="lib/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<script src="lib/jquery-3.1.1.js"></script>
<script src="lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<!-- Custom CSS -->
<style>
body {
	padding-top: 70px;
	/* Required padding for .navbar-fixed-top. Remove if using .navbar-static-top. Change if height of navigation changes. */
}
</style>
<title>Login to TODO list</title>
</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Todo List</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<!--li><a href="#">Login</a></li-->
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container --> </nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 text-center">
				<h1>Login To Todo List</h1>
				<form role="form" method="post" action="LoginController">
					Username:<br /> <input type="text" name="username"
						class="form-control"
						value="<%if (request.getCookies().length != 0) {
				out.print(request.getCookies()[0].getValue());
			}%>" /></br>
					Password:<br /> <input type="password" name="password"
						class="form-control" /></br> <input type="submit" value="Login!"
						class="form-control btn btn-success" />
				</form>
			</div>
		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->
</body>
</html>