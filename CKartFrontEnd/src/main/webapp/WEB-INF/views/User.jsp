<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet"
 href="resources/css/bootstrapmin.css">
  <script src="resources/js/bootstrapmin.js"></script>
  <script src="resources/js/jquerymin.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body background="resources/image/bg1.jpg">
<font color="MIDNIGHTBLUE"><h3>welcome ${sessionScope.username}</h3></font>

</body>

</html>