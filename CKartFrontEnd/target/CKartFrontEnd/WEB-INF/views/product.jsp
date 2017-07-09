<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="SignInnavbar.jsp"></jsp:include>
</head>
<body background="resources/image/new9.jpg">

          <c:if test="${flag}"><form action="${pageContext.request.contextPath}/UpdateProduct" method="post">
   ${pageContext.request.contextPath}
   </form>
</c:if>
 <form:form action="AddProduct" modelAttribute="product" method="post" enctype="multipart/form-data">

<font color="LIGHTSALMON">
<h2><center>Product Manager</center></h2></font>
<table align="center" cellspacing="4">
<%-- <tr>
				
				<td><font color="LIGHTSALMON">Product ID</font></td>
				<c:if test="${!flag}">
				<td><form:input path="prodid" /></td>
				</c:if>
				<c:if test="${flag}">
			<form:input path="prodid" value="${product.prodid}"/>
			</c:if>
			</tr>
			<tr> --%>
				<td><font color="LIGHTSALMON">Category</font></td>
				<td><c:if test="${!flag}"><form:select path="catid">
						<form:option value="0" label="------Select----" />
						<form:options items="${catlist}" />
					</form:select>
					</c:if>
					<c:if test="${flag}">
					<form:select path="catid" value="${product.catid}"/>
					</c:if>
				</td>
				
			</tr>
			<tr>
				<td><font color="LIGHTSALMON">Product Desc</font></td>
				<td><c:if test="${!flag}"><form:textarea path="proddesc" /></c:if>
				<c:if test="${flag}"><form:input path="proddesc" value="${product.proddesc}"/></c:if>
				</td>
			</tr>		
			<tr>
				<td><font color="LIGHTSALMON">Product Name</font></td>
				<td><c:if test="${!flag}"><form:input path="prodname"/></c:if>
				<c:if test="${flag}"><form:input path="prodname" value="${product.prodname}"/></c:if>
				</td>
			</tr>
			<tr>
				<td><font color="LIGHTSALMON">Price</font></td>
				<td><c:if test="${!flag}"><form:input path="prodprc" /></c:if>
				<c:if test="${flag}"><form:input path="prodprc" value="${product.prodprc}"/></c:if>
				</td>
			</tr>
			<tr>
				<td><font color="LIGHTSALMON">Stock</font></td>
				<td><c:if test="${!flag}"><form:input path="prodqty"/></c:if>
				<c:if test="${flag}"><form:input path="prodqty" value="${product.prodqty}"/></c:if>
				</td>
			</tr>
			<tr>
				<td><font color="LIGHTSALMON">Supplier</font></td>
				<td><c:if test="${!flag}"><form:select path="supid">
						<form:option value="0" label="------Select----" />
						<form:options items="${suplist}" />
					</form:select>
					</c:if>
					<c:if test="${flag}"><form:select path="supid" value="${product.supid}"/></c:if>
				</td>
			</tr>
			<tr><td><font color="LIGHTSALMON">File (only in .jpg format) &nbsp;</font></td>
			<td><c:if test="${!flag}"><form:input type="file" path="pimage" /></c:if>
			<c:if test="${flag}"><form:input type="file" path="pimage" value="${product.imgpath}"/></c:if>
			</td></tr>
			
			</table>
			<br><br>
			<font color="INDIGO"><center><input type="submit" value="AddProduct"/></center></font>
			</form:form>
</div>

<div class="table-responsive">
<table class="table">
<thead>
	<tr bgcolor="KHAKI">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Price</td>
		<td>Quantity</td>
		<td>Category Id</td>
		<td>Supplier Id</td>
		<td>Operation</td>
		<td>Image</td>
	
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${prodlist}" var="product">
		<tr bgcolor="LEMONCHIFFON">
			<td>${product.prodid}</td>
			<td>${product.prodname}</td>
			<td>${product.prodprc}</td>
			<td>${product.prodqty}</td>
			<td>${product.catid}</td>
			<td>${product.supid}</td>
			<td><a href="<c:url value="deleteProduct/${product.prodid}"/>">Delete</a>
			<a href="<c:url value="updateProduct/${product.prodid}"/>">Update</a></td>
			<td><img src="${product.imgpath}" height="30" width="25"></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<!-- Completed Displaying Table -->

</body>
</html>