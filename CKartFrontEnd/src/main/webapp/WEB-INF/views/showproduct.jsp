<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body>

<body background="resources/image/new9.jpg">

<div id="container">
<div class="row">
<!-- <div class="col-sm-6 col-md-3"> -->
<div class="thumbnail">
<c:forEach items="${prodlist}" var="product">
<a href="description/${product.prodid}" class="thumbnail" class="col-lg-3">
<img src="<c:url value="/resources/Prodimage/${product.prodid}.jpg"/>" />
</a>
<div class="caption"><font color="LIGHTSALMON">
<h2>${product.prodname}</h2>
<h4>${product.prodprc}</h4>
</div>
</div>
</font>
</c:forEach>

</div>
</div>
</html>