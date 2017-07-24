<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
<body background="<c:url value='/resources/image/bg1.jpg'/>">
<script type="text/javascript">
function givemsg()
{
	var m=document.getElementById("setflag").value;
	if(!m)
		{
		 alert("You can not delete!!");
		}
}

</script>

<c:if test="${flag}">
	<form action="${pageContext.request.contextPath}/UpdateCategory" method="post">
   
</c:if>
<c:if test="${!flag}">
<form action="AddCategory" method="post">
</c:if>
<font color="MIDNIGHTBLUE">
<h2><center>Category manager</center></h2></font>
	<table align="center" cellspacing="5">
		<tr>
			<c:if test="${flag}">
			<input type="hidden" name="catid" value="${category.catid}"/>
			</c:if>
		</tr>
		<tr>
			<td><font color="MIDNIGHTBLUE">Category Name</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="catname" value="${category.catname}" required /></td>
			</c:if>
			<c:if test="${!flag}">
				<td><input type="text" name="catname" required /></td>
			</c:if>
		</tr>
		<br>
		<tr>
			<td><font color="MIDNIGHTBLUE">Category Description</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="catdesc" value="${category.catdesc}" required/></td>
			</c:if>
			<c:if test="${!flag}">
			<td><input type="text" name="catdesc" required/></td>
			</c:if>
		</tr><br><br>
		<tr>
		</table><br>
		<br>
		<font color="INDIGO">
			<center><input type="submit" class="btn btn-primary" value="Submit" background="black" /></center></font>
		
		
	<br><br><br>

</form>
<font color="MIDNIGHTBLUE">
<div class="container">



<table class="table table-bordered">
<thead>
	<tr bgcolor="POWDERBLUE">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${catdetail}" var="category">
		<tr>
			<td>${category.catid}</td>
			<td>${category.catname}</td>
			<td>${category.catdesc}</td>
			<td><a href="<c:url value="deleteCategory/${category.catid}"/>" onclick="givemsg()"><span class="glyphicon glyphicon-trash"></span></a>
			&nbsp;&nbsp;	<a href="<c:url value="updateCategory/${category.catid}"/>"><span class="glyphicon glyphicon-edit"></span></a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<c:set var="flag1" value="${flag1}"/>
<input type="hidden" id="setflag" value='<c:out value="${flag1}"/>' >
</div>

</div>
<!-- Completed Displaying Table -->
</font>
</body>
</html>