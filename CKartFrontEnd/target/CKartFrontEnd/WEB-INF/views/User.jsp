<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
 href="resources/css/bootstrapmin.css">
  <script src="resources/js/bootstrapmin.js"></script>
  <script src="resources/js/jquerymin.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="SignInUsernavbar.jsp"></jsp:include>
</head>
<body background="resources/image/new9.jpg">

<div class="container">
<table class="table table-striped">


<tbody><tr>
<c:forEach items="${catdetail}" var="category"><td>
<a href="categorywise/${category.catid}">${category.catname}
</a></td>
</c:forEach>

</tr>
<tr><td>
<img src="resources/image/Latest-Indian-Wedding-Saree-Lehenga-Designs-2015-2016-1140x641.jpg" height="200" width="200">
</td>
<td>
<img src="resources/image/formals.jpg" height="200" width="200"></td>
<td><img src="resources/image/Craftsvilla.jpg" height="200" width="200"></td>
</tr>
</tbody>
</table>
</div>

</body>
</html>