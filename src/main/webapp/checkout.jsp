<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Checkout</title>
</head>
<body>
    <h1>Checkout</h1>
    <form action="confirmPayment.jsp" method="post">
        <label for="paymentType">Payment Type:</label>
        <select name="paymentType" id="paymentType">
            <option value="Cash">Cash</option>
            <option value="PayPal">PayPal</option>
            <option value="Credit Card">Credit Card</option>
        </select>
        <br><br>
        <input type="submit" value="Confirm Payment">
    </form>
</body>
</html>
