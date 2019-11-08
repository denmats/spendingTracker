<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions Page</title>
</head>
<body>
	<h1>Transactions page</h1>
	
	<form action="/">
		<input type="submit" value="Back Home">
	</form>
	
	<table border="1">
		<tr>
			<th>Type</th>
			<th>Operation</th>
			<th>Amount</th>
			<th>Date</th>
		</tr>
	<c:forEach items="${list}" var="transaction">	
	<tr>	
			<td>${transaction.getType()}</td>
			<td>${transaction.getOperation()}</td>
			<td>${transaction.getAmount()}</td>
			<td>
				<a href="${pageContext.request.contextPath}/add?type=${transaction.getType()}&id=${transaction.getId()}">Edit</a>
				|
				<a href="${pageContext.request.contextPath}/delete?id=${transaction.getId()}">Delete</a>
			</td>
	</tr>
	</c:forEach>
	</table>
	
	
	
</body>
</html>