<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <link rel="stylesheet"
 href="resources/css/bootstrapmin.css">
  <script src="resources/js/bootstrapmin.js"></script>
  <script src="resources/js/jquerymin.js"></script> -->
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.loggedin}">
<img src="<c:url value='/resources/image/logo.png'/>" width="70" height="85" align="right"/>
<font color="CRIMSON" face="Curlz MT" size="20" ><center><b>C-KART</b>
<br>
<h4><b>Mission,Vision,Values</b></h4>
</center></font>
<hr size="30px" width="100%"></hr>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main">C-Kart</a>
    </div>
    <ul class="nav navbar-nav">
  
      <li class="active"><a href="main">Home</a></li>
          <li><a href="aboutus">About Us</a></li>
          <li><a href="contactme">Contact us</a></li>
          <c:if test="${sessionScope.srole=='ROLE_ADMIN'}">
           <li><a href="Category">Category</a></li>
          <li><a href="product">Product</a></li>
          <li><a href="supplier">Supplier</a></li>
          </c:if>
          <c:if test="${sessionScope.srole=='ROLE_USER'}">
          <li><a href="showproduct">product page</a></li>
        
          </c:if>
          </ul>
           <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="newregistration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
      <li><a href="logout1"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
      <li><a href="redirect:/main"><span class="glyphicon glyphicon-arrow-left"></span> Back </a></li>
    </ul>
          </div>
          </nav>   
   </c:if>       

<c:if test="${!sessionScope.loggedin}">
<img src="resources/image/logo.png" width="70" height="85" align="right">
<font color="CRIMSON" face="Curlz MT" size="20" ><center><b>C-KART</b></center></font>
<hr size="30px" width="100%"></hr>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main">C-Kart</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main">Home</a></li>
          <li><a href="aboutus">About Us</a></li>
          <li><a href="contactme">Contact us</a></li>
          </ul>
           <ul class="nav navbar-nav navbar-right">
      <li><a href="newregistration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="index"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      <li><a href="main"><span class="glyphicon glyphicon-arrow-left"></span> Back </a></li>
      
    </ul>
          </div>
          </nav>
         
    </c:if>      
    
</body>
</html>