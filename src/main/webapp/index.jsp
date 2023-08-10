<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<form action="RegisterServlet" method="post">
		Name: <input type="text" name="userName"> 
		<br>
		<br>
		Password: <input type="password" name="password"> 
		<br>
		<br>
		Email: <input type="text" name="email"> 
		<br>
		<br>
		Language: <select name="language">
			<option>English</option>
			<option>Chinese (Simplified)</option>
			<option>Malay</option>
			<option>Tamil</option>
		</select>
		<input type="submit" value="Call Servlet">
	</form>
</body>
</html>