<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Page</title>
</head>
<body>
	<h1>Add Expense</h1>
	
	<form action="getTransactions" method="post">
		Enter expense: <select name="operation">
							<option value="${expense.getOperation()}">${expense.getOperation()}</option>
							<option value="food">Food</option>
							<option value="rent">Rent</option>
							<option value="phone">Phone</option>
							<option value="commute">Commute</option>
						</select> 
		Enter amount: <input type="text" name="amount" value="${expense.getAmount()}"> 
		Enter date:<input type="date" name="date_tx" value="${expense.getDate_tx()}"> 
		<input type="hidden" name="type" value="expense"> 
		<input type="hidden" name="id" value="${expense.getId()}"> 
		<input type="hidden" name="action" value="SAVE">
		<input type="submit">
	</form>

	<form action="/">
		<input type="submit" value="Back Home">
	</form>

</body>
</html>