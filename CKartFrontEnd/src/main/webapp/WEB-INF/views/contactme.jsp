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
<body background="<c:url value='/resources/image/bg1.jpg'/>">
<font color="MIDNIGHTBLUE" size="5px">
<div class="container">
<div class="row">

<div class="col-md-4">

<label><b><font face="Garamond">Your name -</font></b></label><br>
<input type="text" name="name" required><br>

<label><b><font face="Garamond">Email -</font></b></label><br>
<input type="text" name="eid" required><br>

<label><b><font face="Garamond">phone no -</font></b></label><br>
<input type="text" name="phno" required><br>
</div>
<div class="col-md-4">&nbsp;&nbsp;&nbsp;&nbsp;
<label><b><font face="Garamond">Your message -</font></b></label><br>
&nbsp;&nbsp;&nbsp;&nbsp;
<textarea class="form control" rows="8" name="msg"></textarea>
</div>
<div class="col-md-4">
Contact us and we'll get back to you within 24 hours<br><br><br>
Address<br>15/45,Baner,Pune(India)<br>
<span  class="glyphicon glyphicon-earphone"></span>  9874521575<br>
Email address<br>
ckartinfo3@gmail.org




</div>
</div>





<center>
<div class="gallery">
<a href="http://facebook.com/"><i class="fa fa-facebook-official"></i></a>
   <a href="http://twitter.com/"><i class="fa fa-twitter"></i></a>
  <a href="http://linkedin.com/"><i class="fa fa-linkedin"></i></a>
  <a href="http://instagram.com/"><i class="fa fa-instagram"></i></a>
</div>

</center>
</div>

</font>
</body>

</html>