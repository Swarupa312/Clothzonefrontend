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

<style>

div.gallery {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 30%;
}

div.gallery:hover {
    border: 1px solid #777;
}

div.gallery img {
    width: 100%;
    height: 300px;
}

div.desc {
    padding: 15px;
    text-align: center;
    color:PURPLE;
    font-family:Algerian;
    size:15px;
}
.carousel-inner> .item>img,
.carousel-inner> .item> a> img{
width=:70%;
margin:auto;
}

</style>
<jsp:include page="navbar.jsp"></jsp:include>
</head>
<body background="resources/image/new9.jpg">
 <div class="container">
<div class="gallery">
  <a target="_blank" href="western.jsp">
    <img src="resources/image/download (6).jpg">
  </a>
  <div class="desc">Western</div>
</div>

<div class="gallery">
  <a target="_blank" href="traditional.jsp">
    <img src="resources/image/Latest-Indian-Wedding-Saree-Lehenga-Designs-2015-2016-1140x641.jpg">
  </a>
  <div class="desc">Traditional</div>
</div>

<div class="gallery">
  <a target="_blank" href="other.jsp">
    <img src="resources/image/Craftsvilla.jpg">
  </a>
  <div class="desc">Others</div>

</div>


<br><br><br><br><br>


   
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="resources/image/download (2).jpg" style="width:100%;">
      </div>

      <div class="item">
        <img src="resources/image/images (6).jpg" style="width:100%;">
      </div>
    
      <div class="item">
        <img src="resources/image/images.png" style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>

</div>
</div>

 

 <!-- <div id="mycarousel" class="carousel slide" data-ride="carousel">
 <ol class="carousel-indicators">
 <li data-target="#mycarousel" data-slide-to="0" class="active">
 </li>
 <li data-target="#mycarousel" data-slide-to="1"> 
 </li>
 <li data-target="#mycarousel" data-slide-to="2"> 
 </li>
 <li data-target="#mycarousel" data-slide-to="3"> 
 </li>
 </ol>
 
 <div class="carousel-inner">
     <div class="item active">
     <img src="resources/image/download (2).jpg" > 
     </div>
     
     
      <div class="item">
     <img src="resources/image/images.png"> 
    
     </div>
     
      <div class="item">
     <img src="resources/image/download.png"> 
    
     </div>
     
      <div class="item">
     <img src="resources/image/images (6).jpg"> 
     </div>
    
    
  <a class="left carousel-control" href="#MyCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#MyCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
  </div>
  </div>
  </div> -->
  
 
</body>

</html>