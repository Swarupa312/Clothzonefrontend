<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body background="<c:url value='/resources/image/bg1.jpg'/>">
<center>
<font color="MIDNIGHTBLUE">

<h2>description</h2>
<br><br>

<img src="<c:url value='/resources/Prodimage/${prodinfo.prodid}.jpg'/>" height="300" width="300" />

<div class="container">

<table border="1" cellspacing="5">

<tr><td>product name  </td><td>${prodinfo.prodname}</td></tr>
<tr><td>product description  </td><td>     ${prodinfo.proddesc}</td></tr>
<tr><td>product price</td><td> ${prodinfo.prodprc}</td></tr>
<%-- <tr><td>product supplier</td><td>${prodinfo.supid}</td></tr> --%>
<tr><td>product category</td><td> ${prodinfo.catid}</td></tr>

<tr><td>
<form action="<c:url value="/addcart/${prodinfo.prodid}"/>"method="get">
Enter quantity</td><td><input type="text" name="prodqty" class="form-control"/></td></tr>
<tr><td colspan="2" align="center">
<input type="submit" class="btn btn-primary"  value="Add To cart"></td></tr>
</form>

</table>

</div>
</font>

</center>
</body>

</html>