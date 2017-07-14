<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">
<style>
input[type=text] {
    width: 40%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

  </style>
  
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body background="<c:url value='/resources/image/new9.jpg'/>">
<font color="LIGHTSALMON">
<div class="container">
<div class="row">

<div class="col-md-4">

<label><b><font face="Garamond">Your name</font></b></label><br>
<input type="text" name="name" required><br>

<label><b><font face="Garamond">Email</font></b></label><br>
<input type="text" name="eid" required><br>

<label><b><font face="Garamond">phone no</font></b></label><br>
<input type="text" name="phno" required><br>
</div>
<div class="col-md-4">
<label><b><font face="Garamond">Your message</font></b></label><br>
<textarea class="form control" rows="8" name="msg"></textarea>
</div>
<div class="col-md-4">

Address<br>15/45,Baner,Pune(India)<br>
Phone number<br>9874521575<br>
Email address<br>
ckartinfo3@gmail.org




</div>
</div>
<center>
<div class="gallery">
<a href="#"><img src="resources/image/fb.png" height="40px" width="40px"></a><a href="#"><img src="resources/image/ld.png" height="40px" width="40px"></a>

</div>

</center>
</div>

</font>
</body>
</html>