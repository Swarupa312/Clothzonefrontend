<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
<body background="<c:url value='/resources/image/new9.jpg'/>">


<c:if test="${flag}">
	<form action="${pageContext.request.contextPath}/UpdateCategory" method="post">
   
</c:if>
<c:if test="${!flag}">
<form action="AddCategory" method="post">
</c:if>
<font color="LIGHTSALMON">
<h2><center>Category manager</center></h2></font>
	<table align="center" cellspacing="2">
		<tr>
			<c:if test="${flag}">
			<input type="hidden" name="catid" value="${category.catid}"/>
			</c:if>
		</tr>
		<tr>
			<td><font color="LIGHTSALMON">Category Name</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="catname" value="${category.catname}" required /></td>
			</c:if>
			<c:if test="${!flag}">
				<td><input type="text" name="catname" required /></td>
			</c:if>
		</tr>
		<tr>
			<td><font color="LIGHTSALMON">Category Description</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="catdesc" value="${category.catdesc}" required/></td>
			</c:if>
			<c:if test="${!flag}">
			<td><input type="text" name="catdesc" required/></td>
			</c:if>
		</tr>
		<tr>
		</table>
		<br>
		<font color="INDIGO">
			<center><input type="submit" class="btn btn-primary" value="Submit" background="black" /></center></font>
		
		
	

</form>

<div class="container">

<div class="table-responsive">

<table class="table">
<thead>
	<tr bgcolor="KHAKI">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${catdetail}" var="category">
		<tr bgcolor="LEMONCHIFFON">
			<td>${category.catid}</td>
			<td>${category.catname}</td>
			<td>${category.catdesc}</td>
			<td><a href="<c:url value="deleteCategory/${category.catid}"/>">Delete</a>
				<a href="<c:url value="updateCategory/${category.catid}"/>">Update</a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</div>
<!-- Completed Displaying Table -->

</body>
</html>