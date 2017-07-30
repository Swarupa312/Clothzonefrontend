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
<font color="MIDNIGHTBLUE" size="5px">
<div class="container">
<div class="row">
<div class="col-md-12">

<h2>description</h2>
<br><br>

<img src="<c:url value='/resources/Prodimage/${prodinfo.prodid}.jpg'/>" height="300" width="300" />

<br><br>
<ul>

<li>product name:= ${prodinfo.prodname}</li>
<li>description   :=   ${prodinfo.proddesc}</li>
<li> price:=${prodinfo.prodprc}</li>
<li>category:= ${prodinfo.catid}</li>
<li><font color="red" size="6px">${stock}</font></li>
</ul>
</div>
</div>

<form action="<c:url value="/addcart/${prodinfo.prodid}"/>"method="get">
<div class="row">
<div class="col-md-6">
Enter quantity<input type="text" name="prodqty" class="form-control-"/>
</div><br>
<div class="col-md-6">
<input type="submit" class="btn btn-primary btn-lg" class="form-control" value="Add To cart">
</div>

</div>
</form>

</div>
</font>


</body>
 
</html>