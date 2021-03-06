<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>

<style>

input{
  
    padding: 15px 20px;
    margin: 10px 0;
    }
    textarea{
    padding: 15px 20px;
    margin: 10px 0;
    }
    option{
    padding: 15px 20px;
    margin: 10px 0;
    }

</style>


</head>
<body background="<c:url value='/resources/image/bg1.jpg'/>">

<script type="text/javascript">
function givemesaage()
{
	var m=document.getElementById("setflag").value;
	if(!m)
		{
		 alert("You can not delete!!");
		}
}

</script>


          <c:if test="${flag}"><form:form action="${pageContext.request.contextPath}/UpdateProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
 <table align="center" cellspacing="4">
<tr><td>  <form:input path="prodid" value="${product.prodid}" readonly="true"/></td></tr>
   <tr><td><form:select path="catid" required="true">
					<form:option value="0" label="------Select----" />
						<form:options items="${catlist}" />
					</form:select></td></tr>
					 <tr><td><form:input path="proddesc" value="${product.proddesc}" required="true" /></td></tr>
					
					 <tr><td><form:input path="prodname" value="${product.prodname}" required="true"/></td></tr>
				 <tr><td><form:input path="prodprc" value="${product.prodprc}" required="true"/></td></tr>
					 <tr><td><form:input path="prodqty" value="${product.prodqty}" required="true"/></td></tr>
					 <tr><td><form:select path="supid" required="true">
					<form:option value="0" label="------Select----" />
						<form:options items="${suplist}" />
					</form:select></td></tr>
					 <tr><td><form:input  path="imgpath" value="${product.imgpath}" required="true"/>
					<font color="INDIGO"><center><input type="submit" value="UpdateProduct"/></td></tr></center></font>
					</table>
					
   </form:form>
   </c:if>
 
<c:if test="${!flag}">
 <form:form   action="${pageContext.request.contextPath}/AddProduct" modelAttribute="product" method="post" enctype="multipart/form-data">

<font color="MIDNIGHTBLUE">
<h2><center>Product Manager</center></h2></font>
<table align="center" cellspacing="4">
<tr>
				
				<td><font color="MIDNIGHTBLUE">Product ID</font></td>
				<c:if test="${!flag}">
				<td><form:input path="prodid" readonly="true"/></td>
				</c:if>
			</tr>
			<tr>
				<td><font color="MIDNIGHTBLUE">Category</font></td>
				<td><c:if test="${!flag}"><form:select path="catid" required="true">
						<form:option value="0" label="------Select----" />
						<form:options items="${catlist}" />
					</form:select>
					</c:if>
					
				</td>
				
			</tr>
			<tr>
				<td><font color="MIDNIGHTBLUE">Product Desc</font></td>
				<td><c:if test="${!flag}"><form:textarea path="proddesc" required="true" /></c:if>
				
				</td>
			</tr>		
			<tr>
				<td><font color="MIDNIGHTBLUE">Product Name</font></td>
				<td><c:if test="${!flag}"><form:input path="prodname" required="true"/></c:if>
				</td>
			</tr>
			<tr>
				<td><font color="MIDNIGHTBLUE">Price</font></td>
				<td><c:if test="${!flag}"><form:input path="prodprc" pattern="[0-9]*\\d" required="true" /></c:if>
				
				</td>
			</tr>
			<tr>
				<td><font color="MIDNIGHTBLUE">Stock</font></td>
				<td><c:if test="${!flag}"><form:input path="prodqty" pattern="[0-9]*\\d" required="true"/></c:if>
				
				</td>
			</tr>
			<tr>
				<td><font color="MIDNIGHTBLUE">Supplier</font></td>
				<td><c:if test="${!flag}"><form:select path="supid" required="true">
						<form:option value="0" label="------Select----" />
						<form:options items="${suplist}" />
					</form:select>
					</c:if>
					
				</td>
			</tr>
			<tr><td><font color="MIDNIGHTBLUE">File (only in .jpg format) &nbsp;</font></td>
			<td><c:if test="${!flag}"><form:input type="file" path="pimage" required="true"/></c:if>
			${product.imgpath}
			</td></tr>
			
			</table>
			<br><br>
			<font color="INDIGO"><center><input type="submit" value="AddProduct"/></center></font>
			</form:form>
			</c:if>
			
</div>


<table class="table table-bordered">
<thead>

	<tr bgcolor="POWDERBLUE">
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
		<tr>
			<td>${product.prodid}</td>
			<td>${product.prodname}</td>
			<td>${product.prodprc}</td>
			<td>${product.prodqty}</td>
			<td>${product.catid}</td>
			<td>${product.supid}</td>
			<td><a href="<c:url value="deleteProduct/${product.prodid}"/>"><span class="glyphicon glyphicon-trash" onclick="givemesaage()"></span></a>&nbsp;&nbsp;&nbsp;
			<a href="<c:url value="updateProduct/${product.prodid}"/>"><span class="glyphicon glyphicon-edit"></span></a></td>
			<td><img src="<c:url value='${product.imgpath}'/>" height="30" width="25"></td>
		</tr>
	</c:forEach>
	
	</tbody>
</table>
<!-- Completed Displaying Table -->
</div>
<c:set var="flag1" value="${flag1}"/>
<input type="hidden" id="setflag" value='<c:out value="${flag1}"/>' >
</body>
</html>