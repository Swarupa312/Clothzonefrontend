<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body>
<font color="black">
<hr color="black">
<div class="container">
	
<table class="table table-bordered">
<thead>
<tr><td colspan="3"><h4><center>Username = ${sessionScope.username}</center></h4></td></tr>
	<tr>
		
		<td>product name</td>
		<td>Quantity</td>
		<td>product Price</td>
		
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${cartitems}" var="cartlist">
	
		<tr>
			<td>${cartlist.prodname}</td>
			
			<td>${cartlist.prodqty}</td>
			<td>${cartlist.prodprc}</td>
			</tr>
			</c:forEach>			
			</tbody>
			</table>
			</div>
	<br><br>
	<div class="table-responsive">
<table class="table">
<thead>
	<tr>
		<td>bill id</td>
		<td>order id</td>
		<!-- <td>cart id</td> -->
		<td>Payment mode</td>
		<td>Shipment address</td>
		<td>Payment Status</td>
		<td>Final Amount</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${orderlist}" var="orderitems">
		
		<tr>
			<td>${orderitems.billid}</td>
			<td>${orderitems.orderid}</td>
			<%-- <td>${orderitems.cartid}</td> --%>
			<td>${orderitems.paymode}</td>
			<td>${orderitems.shipmentaddress}</td>
			<td>${orderitems.status}</td>
			<td><u><strong><h3>${orderitems.grandtotal}</h3></strong></u></td>
			
			</tr>
			</c:forEach>			
			</tbody>
			</table>
			</div>
	
</div>
<center>
<h3>Your Order will be deliver within 4 days
<br>Thank you!!
</h3>
</center>
</font>			
</body>

</html>