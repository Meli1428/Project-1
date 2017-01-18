<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Welcome to Home page</title>

<h2 style="color:blue;">Welcome to Shopping Cart</h2>

<style>
 .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 70%;
      margin: auto;
  }
 
</style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"></a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="registration"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
      <li><a href="#">About Us</a></li>
      <li><a href="#">Page 3</a></li>
    </ul>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
    <li data-target="#myCarousel" data-slide-to="3"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="resources/images/art-painting-sad-tears-Favim.com-1999220.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="resources/images/black-and-white-portraits-of-faces-painted-black-and-white-7.jpg" alt="Chania">
    </div>

    <div class="item">
      <img src="resources/images/images.jpg" alt="Flower">
    </div>

    <div class="item">
      <img src="resources/images/index.jpg" alt="Flower">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

<!-- if the user logged in, these links should not be displayed

 How I know whether usr is logged or not----.successMsg -->

<c:if test="${empty successMsg}"> <!-- if the id and pwd is left empty -->




</c:if>

<!-- we need to use JSP Tag library -->
<hr>
${successMsg}
<c:if test="${showLogin}">

<jsp:include page="login.jsp"></jsp:include> 
</c:if>

<c:if test="${not empty errorMsg}"> <!-- if the id or the pwd is wrong then -->
${errorMsg}
<jsp:include page="login.jsp"></jsp:include> 
</c:if>


<c:if test="${showRegistration}">

<jsp:include page="registration.jsp"></jsp:include>
</c:if>


</body>
</html>