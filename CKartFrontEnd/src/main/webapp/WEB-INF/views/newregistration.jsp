<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navbar.jsp"></jsp:include>


<style>
input[type=text], input[type=password] {
    width: 70%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

.cancelbtn {
color: white;
    padding: 15px 40px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
   background-color: #f44336;
    width:40%;
} 
.signupbtn {
color: white;
    padding: 15px 40px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
background-color: #4CAF50;
    float: center;
    width: 40%;
}
</style>

</head>

<body background ="resources\image\login.jpg">

<script type="text/javascript">
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


</script>

<form action="user" method="POST" onsubmit="return checkPass()">

<div class="container">
<p align="right">
<label><font color="red"> *All fields are Necessary*</font></label><br></p>
<label><b><font face="Garamond">Customer name</b></font></label><br>
<input type="text" name="cname" required><br>
<label><font face="Garamond"><b>Address</b></font></label><br>
<input type="text" name="uaddr" required><br>
<label><font face="Garamond"><b>User Name-*Generate new user name</b></font></label><br>
<input type="text" name="uname" maxlength="5" required><br>

<label><font face="Garamond"><b>Email Id</b></font></label><br>
<input type="text" name="uemail" pattern="^[a-z0-9_]+@[a-z0-9.]+\.[a-z]{2,4}$" required><br>
<label><font face="Garamond"><b> password</b></font></label><br>
<input type="password" id="pass" name="upass"  maxlength="5" required><br>

<label><font face="Garamond"><b>Confirm password</b></font></label><br>
<input type="password" id="cpass" name="confirmpass" maxlength="5" required><br>

<label><font face="Garamond"><b>Mobile no</b></font></label><br>
<input type="text" name="umobile" maxlength="10" pattern="[789]{1}[0-9]{9}" required><br>

</div>
<center>
<h4><input type="checkbox" checked="checked">I Agree<a href="#"><u>Terms and Privacy.</u></a></h3>
<input type="button" class="cancelbtn" value="Cancel">&nbsp;&nbsp;&nbsp;
<input type="submit" class="signupbtn"  value="user" ></center>
				
</form>

   
    
</body>

</html>