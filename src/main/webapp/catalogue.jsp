<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Super Catalogue</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Catalogue</h1>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Item</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="catalogue" items="${listCat}">
					<tr>
						<td><c:out value="${catalogue.item}" /></td>
						<td><c:out value="${catalogue.name}" /></td>
						<td><c:out value="${catalogue.price}" /></td>
						<td><c:out value="${catalogue.quantity}" /></td>
						<td><img src="${catalogue.image}" alt="Catalogue Image"
							width=25% /></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<div class="container text-left">
			<!-- Add new user button redirects to the register.jsp page -->
			<a href="<%=request.getContextPath()%>/welcome.jsp"
				class="btn btn-success">Back to Welcome Page</a>
		</div>
		<br>
		<footer>*All prices are in SGD.</footer>
	</div>
</body>
</html>