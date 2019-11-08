<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>home page</h1>
	
	<form action="getTransactions" method="post">
		<input type="hidden" name="action" value="LIST">
		<input type="submit" value="Go To Transactions">
	</form>
	
	<form action="add">
		<input type="hidden" name="type" value="expense">
		<input type="hidden" name="action" value="SAVE">
		<input type="submit" value="Add Expense">
	</form>
	
	<form action="add">
		<input type="hidden" name="type" value="income">
		<input type="hidden" name="action" value="SAVE">
		<input type="submit" value="Add Income">
	</form>
	
	<table border="1">
		<tr>
			<th>Operation</th>
			<th>Amount</th>
			
		</tr>
	<c:forEach items="${listGroupByOperation}" var="transaction">	
	<tr>	
			<td>${transaction.getOperation()}</td>
			<td>${transaction.getAmount()}</td>
	</tr>
	</c:forEach>
	</table>
	
	
	
</body>
</html>