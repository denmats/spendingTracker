<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Josefin+Sans&display=swap" rel="stylesheet">
<link href="css/style.css" rel="stylesheet"/>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-light navbar-dark fixed-top">
		<div class="container">
			<div>
				<i class="fas fa-piggy-bank fa-2x text-success"></i>
				<span><strong>Spending Tracker</strong></span>
			</div>
			<form action="getTransactions" method="post">
				<input type="hidden" name="action" value="LIST">
				<button type="submit" class="btn btn-outline-success">More Details</button>
			</form>	
		</div>
	</nav>
	<div class="container">
		<div class="d-flex justify-content-end align-items-center topnav">
			<div class="col-md-6 mt-3">
			<h1 class="display-6 mt-5 text-success" >DashBoard</h1>
		
			<div class="progress mt-2 mb-3">
				  <div class="progress-bar bg-success" style="width:${progressBarIncomePercent}%"></div>
				  <div class="progress-bar bg-danger" style="width:${progressBarExpensePercent}%"></div>
			</div>
			<div>
				<h3 class="display-6 d-flex justify-content-between  mb-3" style="font-family: 'Josefin Sans', sans-serif;">Income
					<span class="badge badge-success">
						<fmt:formatNumber type="currency" maxFractionDigits="2" value="${totalIncome}" currencySymbol="&#122;&#322;"/>
					</span>
				</h3>
				<h3 class="display-6 d-flex justify-content-between  mb-3" style="font-family: 'Josefin Sans', sans-serif;">Expense
					<span class="badge badge-danger">
						<fmt:formatNumber type="currency" maxFractionDigits="2" value="${totalExpense}" currencySymbol="&#122;&#322;"/>
					</span>
				</h3>
			</div>
			
			<div class="scrollable mb-2">
			<c:forEach items="${listTest}" var="transaction">	
			<ul class="list-group">	
					<li class="list-group-item d-flex justify-content-between">${transaction.getOperation().toUpperCase()}
						<h4>
							<span class="badge badge-danger">
								<fmt:formatNumber type="currency" maxFractionDigits="2" value="${transaction.getSum()}" currencySymbol="&#122;&#322;"/>
							</span>
						</h4>
					</li>
			</ul>
			</c:forEach>
			</div>
			<h3 class="display-6 d-flex justify-content-between mb-4 mt-2" style="font-family: 'Josefin Sans', sans-serif;">Balance		
					<c:choose>
				        <c:when test = "${balance > '0'}">
				            <td>
				            	<span class="text-success">
				            		<fmt:formatNumber type="currency" maxFractionDigits="2" value="${balance}" currencySymbol="&#122;&#322;"/>
			            		</span>
							</td>
				        </c:when>
				        <c:otherwise>
				            <td>
				            	<span class="text-danger">
				            		<fmt:formatNumber type="currency" maxFractionDigits="2" value="${balance}" currencySymbol="&#122;&#322;"/>
			            		</span>
							</td>
				        </c:otherwise>
				    </c:choose>	
			</h3>
			<div class="d-flex justify-content-between mt-3 mb-3">
				<form action="add">
				<input type="hidden" name="type" value="expense">
				<input type="hidden" name="action" value="SAVE">
				<button type="submit" class="btn btn-outline-danger">Add Expense</button>
			</form>
			
			<form action="add">
				<input type="hidden" name="type" value="income">
				<input type="hidden" name="action" value="SAVE">
				<button type="submit" class="btn btn-outline-success">Add Income</button>
			</form>
			</div>
			</div>
			<div class="col-md-6 mt-5">
				<div id="container" style="height: 400px"></div>
			</div>
		</div>
	</div>
	
	<div class="footer">
  			<small>Copyright &copy;<span id="year"></span>Denys Matsuiev</small> 
	</div>
	
	
	
	<script src="js/highcharts.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/piechart.js"></script>
	<script>$('#year').text(new Date().getFullYear());</script>
</body>
</html>