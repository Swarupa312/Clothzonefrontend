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

<style>
.navbar-inverse{
background-color: #ADD8E6;
margin:10px 0;
}

.navbar-inverse .navbar-nav > li > a {
    color: 	#191970;
}

.navbar-inverse .navbar-nav > li > a:hover {
    background-color: 	#000000;
}

.navbar-inverse .navbar-header > a {
    color: 	#191970;
}

.navbar-inverse .navbar-header > a:hover {
     background-color: 	#000000;
}

input[type=text] {
    width: 130px;
    box-sizing: border-box;
    border: 2px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    
    background-position: 10px 10px; 
    
    padding: 12px 20px 12px 40px;

}

</style>


</head>
<body>
<c:if test="${sessionScope.loggedin}">

<font color="DARKSLATEBLUE" face="Curlz MT" size="8" ><b>ClothZone</b>
<br>
<h4><b>Mission,Vision,Values</b></h4>
</font>
 <center><input type="text" name="search" placeholder="Search.."></center>
<hr size="30px" width="100%"></hr>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}/main">C-Kart</a>
    </div>
    <ul class="nav navbar-nav">
  
      <li class="active"><a href="main">Home</a></li>
          <li><a href="${pageContext.request.contextPath}/aboutus">About Us</a></li>
          <li><a href="${pageContext.request.contextPath}/contactme">Contact us</a></li>
          <c:if test="${sessionScope.srole=='ROLE_ADMIN'}">
           <li><a href="Category">Category</a></li>
          <li><a href="product">Product</a></li>
          <li><a href="supplier">Supplier</a></li>
          </c:if>
          <c:if test="${sessionScope.srole=='ROLE_USER'}">
          
         
          
       <%-- <%@ page import="java.util.List" %>  
		<%@ page import ="com.OnlineKartZone.CKartonline.Dao.CategoryDao"%>
		<%@ page import=" com.OnlineKartZone.CKartonline.Model.Category"%>
		<%@ page import="org.springframework.beans.factory.annotation.Autowired"%>
     	<%@ page import=" org.springframework.ui.Model"%>
      <%! 
      class categorywiseshop
      {
      
      	@Autowired
  		CategoryDao categoryDao;
      	public void shop(Model m)
      	{
        List<Category> list=categoryDao.getCategoryDetails();
        m.addAttribute("catdetail",list);
      	}
      }
        %> --%>
        
        
      
  <li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Shop by Category
  <span class="caret"></span></a>
  <ul class="dropdown-menu">
   
<c:forEach items="${catdetail}" var="category">
<li>
<a href="categorywise/${category.catid}">${category.catname}
</a></li>
</c:forEach>

  </ul>
</li>

 <li><a href="<c:url value="/showproduct"/>">product page</a></li>
 <li><a href="<c:url value="/cart"/>">Cart</a></li>
          </c:if>
          </ul>
           <ul class="nav navbar-nav navbar-right">
      <!-- <li><a href="newregistration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li> -->
      <li><a href="${pageContext.request.contextPath}/logout1"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
      <li><a href="<c:url value="/main"/>"><span class="glyphicon glyphicon-arrow-left"></span> Back </a></li>
    </ul>
          </div>
          </nav>   
   </c:if>       








<c:if test="${!sessionScope.loggedin}">

<font color="DARKSLATEBLUE" face="Curlz MT" size="8" ><b>ClothZone</b>
<h4><b>Mission,Vision,Values</b></h4>
</font>
<center><input type="text" name="search" placeholder="Search.."></center>
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