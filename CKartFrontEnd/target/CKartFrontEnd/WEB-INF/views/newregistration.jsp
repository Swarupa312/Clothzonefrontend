

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>

<style type="text/css">

input[type=text],[type=password]{
  width:60%;
    padding: 15px 20px;
    margin: 10px 0;
    }


.signupbtn {
color: white;
    padding: 15px 50px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
background-color: #4CAF50;
    float: center;
    width: 40%;
}

.cancelbtn {
color: white;
    padding: 15px 50px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
   background-color: #f44336;
    width:40%;
     
} 

</style>

</head>

<body background="<c:url value='/resources/image/bg1.jpg'/>">

<!-- <script type="text/javascript">
function checkPass()
{
	var x=document.getElementById("pass").value;
	var y=document.getElementById("cpass").value;
	if(x!=y)
	{
		alert("both passwords should be same");
		return false;
	}

	
}
</script> -->
<div class="container">
<form:form action="AddUser" modelAttribute="user" method="post">
<div class="form-group">
<font color="MIDNIGHTBLUE">
<p align="center">
				

               <label><b><font face="Garamond" size="4px">Customer name</font></b></label><br>
				<%-- <form:input path="cname"/><br>
				<form:errors path="cname" cssStyle="color:red"></form:errors>
				
				<label><b><font face="Garamond" size="4px">Customer address</font></b></label><br>
				<form:input path="uaddr" /><br>
				<form:errors path="uaddr" cssStyle="color:red"></form:errors>
				
				<label><b><font face="Garamond" size="4px">User name</font></b></label><br>
				<form:input path="uname" /><br>
				<form:errors path="uname" cssStyle="color:red"></form:errors>
				
				<label><b><font face="Garamond" size="4px">Email address</font></b></label><br>
				 <form:input path="uemail"  /><br>
				<form:errors path="uemail" cssStyle="color:red"></form:errors> --%>
				
				<label><font face="Garamond" size="4px"><b> password</b></font></label><br>
				<form:password path="upass"/><br>
				<form:errors path="upass" cssStyle="color:red"></form:errors>
				
			<%-- <label><b><font face="Garamond">Confirm password</font></b></label><br>
				<form:input path="confirmpass" id="cpass" />
				 --%>
			<%-- 		<label><b><font face="Garamond" size="4px">Mobile number</font></b></label><br>
				<form:input path="umobile" /><br>
				<form:errors path="umobile" cssStyle="color:red"></form:errors>
				
				<form:hidden path="enabled" value="true" />
				<form:hidden path="urole" value="ROLE_USER" />
 --%>				
				
			<input type="submit" class="signupbtn" value="user"/>
			<input type="button" class="cancelbtn" value="Cancel">&nbsp;&nbsp;&nbsp;
		
			</p>
			</font>
			</div>
			</form:form>
   
   </div>
</body>

</html>