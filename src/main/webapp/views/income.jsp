<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Income Page</title>
</head>
<body>
	<h1>Add Income</h1>
	
	<form action="getTransactions" method="post">
		
		Enter income: 	<select name="operation" value="${type}">
							<option value="salary">Salary</option>
							<option value="extra">Extra</option>
						</select> 
		Enter amount: 	<input type="text" name="amount" value="${amount}">
		Enter date: 	<input type="date" name="date_tx" value="${date_tx}">
		
						<input type="hidden" name="type" value="income">
						<input type="hidden" name="id">
						<input type="hidden" name="action" value="SAVE">
		
		<input type="submit">
	</form>
	
	<form action="/">
		<input type="submit" value="Back Home">
	</form>
	
</body>
</html>