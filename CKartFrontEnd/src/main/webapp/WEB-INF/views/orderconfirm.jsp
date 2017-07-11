<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body background="resources/image/new9.jpg">

<form action="<c:url value="/bill"/>" method="get">
<div class="container">

<div class="table-responsive">

<table class="table">
<thead>
	<tr bgcolor="KHAKI">
		<td>Product name</td>
		<td>Product Quantity</td>
		<td>Subtotal</td>
		<td>Image</td>
	</tr>
	</thead>
<tbody>
	<c:forEach items="${cartitems}" var="cart">
		<tr bgcolor="LEMONCHIFFON">
			<td>${cart.prodname}</td>
			<td>${cart.prodqty}</td>
		 <td>${cart.prodprc*cart.prodqty}</td> 
			<td><img src="<c:url value='/resources/Prodimage/${cart.prodid}.jpg'/>" height="50" width="50"></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			
			</div>
			
			<br><br>
		<font color="LIGHTSALMON" size="5">
<label><font face="Garamond"><b>Payment Mode</b></font></label><br>
<label class="radio-inline"><input type="radio" name="paymode" value="Creditcard"><span class="glyphicon glyphicon-credit-card"> Credit card</span></label>
<label class="radio-inline"><input type="radio" name="paymode" value="NetBanking"><span class="glyphicon glyphicon-piggy-bank"> NetBanking</span></label>
<label class="radio-inline"><input type="radio" name="paymode" value="CashOnDelivery"><span class="glyphicon glyphicon-usd">CashOnDelivery</span></label><br><br>
<label><font face="Garamond"><b>Shipment address</b></font></label><br>
<textarea class="form-control" rows="4" name="shipmentaddress"></textarea>
</font>
	
	<br><br>
	<div class="table-responsive">
			<font size="5px">
			<table class="table">
			<tr bgcolor="KHAKI"><c:set var="grandtotal"  value="${subtotal}"/> 
			<td>TOTAL PRICE RS:</td><td><input type="text" name="grandtotal" value="<c:out value="${grandtotal}"/>"/>
			</tr>
			</table>
			</font>
			</div>
		<center>	<input type="submit" class="btn btn-primary" value="PAY"></center>
</div>
</form>
</body>
</html>