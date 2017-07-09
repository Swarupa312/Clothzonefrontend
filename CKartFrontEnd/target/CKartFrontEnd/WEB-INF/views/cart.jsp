<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="SignInUsernavbar.jsp"></jsp:include>

<html>

<body background="<c:url value='/resources/image/new9.jpg'/>">

<div class="table-responsive">
<table class="table">
<thead>
	<tr bgcolor="DARKKHAKI">
		<td>Cart itemID</td>
		<td>product id</td>
		<td>Cart id</td>
		<td> product Price</td>
		<td>Quantity</td>
		<td>subtotal</td>
		<td>Image</td>
		<td>Operation</td>
	
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${cartlist}" var="cartitems">
		<tr bgcolor="KHAKI">
			<td>${cartitems.cartitemid}</td>
			<td>${cartitems.prodid}</td>
			<td>${cartitems.cartid}</td>
			<td>${cartitems.prodprc}</td>
			<form action="<c:url value="/updatecart/${cartitems.cartitemid}"/>" method="get">
			<td><input type="text" value="${cartitems.prodqty}" name="prodqty" class="form-control button-block"/></td>
			<td>${cartitems.prodprc*cartitems.prodqty}</td>
			<td><img src="<c:url value='/resources/Prodimage/${cartitems.prodid}.jpg'/>" height="30" width="20" /></td>
			<td><a href="<c:url value="/deletecart/${cartitems.cartitemid}"/>"><span class="glyphicon glyphicon-trash"></span></a>
			
			<input type="submit" value="Update"></td></form>
		<%-- 	<a href="<c:url value="/updatecart/${cartitems.cartitemid}"/>"><span class="glyphicon glyphicon-edit"></span></a></td> --%>
			
		</tr>
		<tr></tr>
		<tr></tr>
	</c:forEach>
	</tbody>
	
	
</table>
<p align="left">
<a href="<c:url value="/showproduct"/>"><span class="glyphicon glyphicon-menu-left">Continue</span></a></p>
<p align="right">
<a href="<c:url value="/placeorder"/>"><span class="glyphicon glyphicon-check">Placeorder</span></a></p>
</center>
</div>

</body>

</html>