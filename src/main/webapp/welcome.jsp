<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<h1>Welcome to Super</h1>
<p>Here at Super we provide the freshest fruits and vegetables. Don't be
fooled by how our products look. Looks are deceiving after all. We can assure
you that our products are fresh and delicious.</p>

<p>Our goal is to reduce food wastage and provide a cheaper alternative for
fruits and vegetables. Please give our products a chance. You won't be 
disappointed.</p>

	<p>Please browse our catalogue if you're interested in buying some
		groceries.</p>
	<div class="container text-left">
		<!-- Add new user button redirects to the register.jsp page -->
		<a href="<%=request.getContextPath()%>/CatalogueServlet/items"
			class="btn btn-success">Catalogue</a>
	</div>
	
	<h2>Best-selling product of the month</h2>
	<p>Apple</p>
	<img src="https://www.shutterstock.com/image-photo/concept-ugly-food-red-apple-260nw-1536991616.jpg">

</body>
</html>