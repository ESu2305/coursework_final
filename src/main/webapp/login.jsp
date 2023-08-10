<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Name: <input type="text" name="name"> 
		<br>
		<br>
		Password: <input type="password" name="password"> 
		<br>
		<br> 
		<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/userEdit.jsp"
					class="btn btn-success">Forgot Password</a>
			</div>
			<br>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a href="<%=request.getContextPath()%>/index.jsp"
					class="btn btn-success">Register</a>
			</div>
			<br>
		<input type="submit" value="Call Servlet">
	</form>
</body>
</html>