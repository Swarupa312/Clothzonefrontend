<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="resources/image/new9.jpg">
<form action="${pageContext.request.contextPath}/SignInnavbar" method="post">
				<label for="username">Name</label><br>
				<input type="text" name="Uname" placeholder="Enter  User name" required />&nbsp;&nbsp;&nbsp;
			<br>
				<label for="newpassword">New password</label><br>
				<input type="password" name="password"  placeholder="Enter password"  required /><br>
				
				<label for="confirmpassword">confirm password</label><br>
				<input type="password" name="cpassword"  placeholder="Confirm password"  required /><br>
				<input type="submit" class="btn btn-primary" value="Confirm ">
				</form>
</body>
</html>