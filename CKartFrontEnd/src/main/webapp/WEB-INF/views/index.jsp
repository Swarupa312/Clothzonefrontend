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
<style>
 input[type=text], input[type=password] {
    width: 40%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
    
    }
    
.cancelbtn {
color: white;
    padding: 15px 50px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
   background-color: #f44336;
    width:20%;
     
} 
div.gallery img {
    width: 70%;
    height: 400px;
  
}
.signupbtn {
color: white;
    padding: 15px 50px;
    margin: 30px 0;
    border: none;
    cursor: pointer;
background-color: #4CAF50;
    float: center;
    width: 20%;
}
</style>

<body background ="resources\image\login.jpg">

<form action="perform_login" method="post">

<div class="row">
<div class="col-md-6">
<div class="gallery">
  <img src="resources\image\Lock.png">
</div>
</div>
<div class="col-md-6">
<div class="container">
           
  <br><br>
				<label for="name">Name</label><br>
				<input type="text" name="username" placeholder="Enter name" required />&nbsp;&nbsp;&nbsp;
			<br>
				<label for="password">password</label><br>
				<input type="password" name="password"  placeholder="Enter password"  required /><br>
				
				
			
				<input type="submit" class="signupbtn"  value="login">
				<input type="button" class="cancelbtn" value="Cancel">&nbsp;&nbsp;&nbsp;
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /><br>
				<h4><b><u><a href="newregistration">New to C-Kart? Sign up</a></u></b></h4>
				<h6><a href="forgotpass">forgot password?</a></h6>
	
		</div>
		</div>
		</div>


	</form>
</body>
</html>