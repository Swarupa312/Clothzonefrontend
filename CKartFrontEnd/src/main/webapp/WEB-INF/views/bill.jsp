<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="CRIMSON" face="Curlz MT" size="20" ><center><b>C-KART</b></center></font>
<hr color="black">
<div class="container">
<div class="table-responsive">
<table class="table">
<thead>
	<tr>
		<td>Cart itemID</td>
		<td>product id</td>
		<td> product Price</td>
		<td>Quantity</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${cartitems}" var="cartlist">
		<tr>
			<td>${cartlist.cartitemid}</td>
			<td>${cartlist.prodid}</td>
			<td>${cartlist.prodprc}</td>
			<td>${cartlist.prodqty}</td>
			</tr>
			</c:forEach>			
			</tbody>
			</table>
			</div>
	
	<div class="table-responsive">
<table class="table">
<thead>
	<tr>
		<td>bill id</td>
		<td>order id</td>
		<td>cart id</td>
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
			<td>${orderitems.cartid}</td>
			<td>${orderitems.paymode}</td>
			<td>${orderitems.shipmentaddress}</td>
			<td>${orderitems.status}</td>
			<td>${orderitems.grandtotal}</td>
			
			</tr>
			</c:forEach>			
			</tbody>
			</table>
			</div>
	
</div>			
</body>
</html>