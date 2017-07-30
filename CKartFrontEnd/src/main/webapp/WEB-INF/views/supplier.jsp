<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
<body background ="resources\image\bg1.jpg">

<c:if test="${flag}">
	<form action="${pageContext.request.contextPath}/UpdateSupplier" method="post">
   ${pageContext.request.contextPath}
</c:if>
<c:if test="${!flag}">
<form action="AddSupplier" method="post">
</c:if>
<font color="MIDNIGHTBLUE">
<h2><center>Supplier manager</center></h2></font>
	<table align="center" cellspacing="2">
		<tr>
			<c:if test="${flag}">
			<input type="hidden" name="supid" value="${supplier.supid}"/>
			</c:if>
		</tr>
		<tr>
			<td><font color="MIDNIGHTBLUE">Supplier Name</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="sname" value="${supplier.sname}" required/></td>
			</c:if>
			<c:if test="${!flag}">
				<td><input type="text" name="sname" required/></td>
			</c:if>
		</tr>
		<tr>
			<td><font color="MIDNIGHTBLUE">Supplier Address</font></td>
			<c:if test="${flag}">
				<td><input type="text" name="saddr" value="${supplier.saddr}" required /></td>
			</c:if>
			<c:if test="${!flag}">
			<td><input type="text" name="saddr" required/></td>
			</c:if>
		</tr>
		<tr>
		</table>
		<br>
		<font color="INDIGO">
			<center><input type="submit" value="Submit" background="black" /></center></font>
		
		
	

</form>





<table class="table table-bordered">
<thead>
	<tr bgcolor="POWDERBLUE">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Address</td>
		<td>Operation</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${supdetail}" var="supplier">
		<tr>
			<td>${supplier.supid}</td>
			<td>${supplier.sname}</td>
			<td>${supplier.saddr}</td>
			<td><a href="<c:url value="deleteSupplier/${supplier.supid}"/>"><span class="glyphicon glyphicon-trash"></span></a>
				<a href="<c:url value="updateSupplier/${supplier.supid}"/>"><span class="glyphicon glyphicon-edit"></span></a>
			</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>


</body>
</html>