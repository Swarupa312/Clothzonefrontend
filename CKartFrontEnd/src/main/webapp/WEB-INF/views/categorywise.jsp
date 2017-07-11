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
<c:forEach items="${prodlist}" var="product">
<a href="<c:url value="/description/${product.prodid}"/>" class="Thumbnail">
<img src="<c:url value='/resources/Prodimage/${product.prodid}.jpg'/>" height="400" width="400" class="thumbnail" />
</a>
<table>
<tr><td>product name</td><td>Product Price</td></tr>
<tr><td>${product.prodname}</td>
<td>${product.prodprc}</td></tr>
</table>
</c:forEach>
</body>
</html>