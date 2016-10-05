<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="il.ac.hit.todolist.model.Item"%>
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
				<li><a href="LogoutController">Logout</a></li>
			</ul>
		</div>
	</div>
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-lg-offset-3 text-center">
				<h1>Todo List</h1>
				<h2>Welcome <span style="color: green; font-weight: bolder;"><%=session.getAttribute("username")%></span></h2>

				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Description</th>
							<th>Delete</th>
							<th>Edit</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<Item> items = (List<Item>) request.getAttribute("items");
							for (Item item : items) {
						%>
						<tr>
							<td><%=item.getId()%></td>
							<td><%=item.getTitle()%></td>
							<td><%=item.getDescription()%></td>
							<td><a href="DeleteController?id=<%=item.getId()%>">Delete</a></td>
							<td><a href="EditController?id=<%=item.getId()%>">Edit</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<br />
				<form role="form" method="post" action="NewItemController">
					<h3>New Item</h3>
					<table class="table table-bordered">
						<tr>
							<td>Title</td>
							<td><input type="text" name="title" class="form-control" /></td>
						</tr>
						<tr>
							<td>Description</td>
							<td><input type="text" name="description"
								class="form-control" /></td>
						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="Add New Item"
								class="form-control btn btn-success" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>