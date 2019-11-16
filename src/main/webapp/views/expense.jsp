<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Expense Page</title>
</head>
<body>
	<h1>Add Expense</h1>

	<form action="getTransactions" method="post">

		Enter expense: <select name="operation" value="${type}">
							<option value="food">Food</option>
							<option value="rent">Rent</option>
							<option value="phone">Phone</option>
							<option value="commute">Commute</option>
						</select> 
		Enter amount: <input type="text" name="amount" value="${amount}"> 
		Enter date:<input type="date" name="date_tx" value="${date_tx}"> 
		<input type="hidden" name="type" value="expense"> 
		<input type="hidden" name="id" > 
		<input type="hidden" name="action" value="SAVE">
		<input type="submit">
	</form>

	<form action="/">
		<input type="submit" value="Back Home">
	</form>

</body>
</html>