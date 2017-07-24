

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
    input[type=textarea]
    {
    
    width:70%;
    }


</style>

</head>

<body background="<c:url value='/resources/image/bg1.jpg'/>">

<script type="text/javascript">
function checkPass()
{
	var x=document.getElementById("pass1").value;
	var y=document.getElementById("pass2").value;
	if(x!=y)
	{
		alert("both passwords should be same");
		document.getElementById("pass2").focus();
		document.getElementById("submit").disabled=false;
	}

	
}
</script>

<div class="container">
<form:form action="AddUser" modelAttribute="user" method="post">

<font color="MIDNIGHTBLUE">
<p align="center">
				<div class="row">
				<div class="form-group col-md-8">
               <label><b><font face="Garamond" size="4px">Customer name</font></b></label><br>
               
				<form:input path="cname"/>
				<form:errors path="cname" cssStyle="color:red"></form:errors><br>
				</div>
				
				<div class="form-group col-md-8">
				<label><b><font face="Garamond" size="4px">Customer address</font></b></label><br>
				<form:textarea path="uaddr" rows="4" />
				<form:errors path="uaddr" cssStyle="color:red"></form:errors><br>
				</div>
				<div class="form-group col-md-8">
				<label><b><font face="Garamond" size="4px">User name</font></b></label><br>
				<form:input path="uname" />
				<form:errors path="uname" cssStyle="color:red"></form:errors><br>
				</div>
				<div class="form-group col-md-8">
				<label><b><font face="Garamond" size="4px">Email address</font></b></label><br>
				 <form:input path="uemail"  />
				<form:errors path="uemail" cssStyle="color:red"></form:errors><br>
				</div>
				<div class="form-group col-md-8">
				<label><font face="Garamond" size="4px"><b> password</b></font></label><br>
				<form:password path="upass" id="pass1"/>
				<form:errors path="upass" cssStyle="color:red"></form:errors><br>
				</div>
				<div class="form-group col-md-8">
			<label><b><font face="Garamond" size="4px">Confirm password</font></b></label><br>
				<input type="password" id="pass2" name="confirm_pass" onblur="checkPass()"><br>
				</div>
				<div class="form-group col-md-8">
					<label><b><font face="Garamond" size="4px">Mobile number</font></b></label><br>
				<form:input path="umobile" />
				<form:errors path="umobile" cssStyle="color:red"></form:errors><br>
				</div>
				<form:hidden path="enabled" value="true" />
				<form:hidden path="urole" value="ROLE_USER" />
				
				<div class="form-group col-md-8">
			<button type="submit" id="submit" class="btn btn-success btn-lg">Sign Up</button>
			<button type="submit"  class="btn btn-danger btn-lg">Cancel</button>
			</div>
		</div>
			</p>
			</font>
			</div>
			</form:form>
   </div>
   </div>
</body>

</html>