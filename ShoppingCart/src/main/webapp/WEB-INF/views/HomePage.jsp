<%@ include file="header.jsp" %>
<title>Welcome to Home page</title>

<h2 style="color: Purple;"><i>Welcome to you're Favourite Art Gallery</i></h2>

<style>
.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

body {
	background-color: yellow;
}
</style>
</head>
<body>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
			<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
			
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="resources/images/2.png"">
			</div>
			<div class="item">
				<img src="resources/images/3.png">
			</div>
			<div class="item">
				<img src="resources/images/4.png">
			</div>
			<div class="item">
				<img src="resources/images/5.png">
			</div>

			<div class="item">
				<img src="resources/images/7.jpg">
			</div>
		</div>
		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- <style>
/* .parallax {
    /* The image used */
    background-image: url("resources/images/Street-Artist-Transformed-Buildings-into-Works-of-Art-3.jpg");
    /* Set a specific height */
    min-height: 500px; 
    /* Create the parallax scrolling effect */
    background-attachment: fixed;
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
} */
 -->

	<div class="cover flexcontainer"
		style="background-image: url("resources/images/bb.jpg") style="width:304px;height:228px;">
		<h1 class="sa-hero-title">The World's Leading Online Art Gallery</h1>
		<h2 class="sa-hero-subtitle">Discover new work by emerging
			artists from around the world</h2>
	</div>
	

	<%-- <div style="background-color: powderblue";
     height: 200px;
    width: 50%;
class="parallax">
        <div class="container" style="padding:15% 0;" >
        <centre>
              <img src="resources/images/bb.jpg" width="1000px" height="800">
        </centre>
        
        <div style="color:yellow"class="carousel-caption">
          <h2 >Every art</h2><br>
          <h3>has a story, has a feeling,is a unique creation.</h3>
        </div>
        </div>
    </div> --%>
	<!-- </style>
 -->
	<!-- if the user logged in, these links should not be displayed
 How I know whether usr is logged or not----.successMsg -->
<c:if test="${empty successMsg}">
		<!-- if the id and pwd is left empty -->
	</c:if>
	<!-- we need to use JSP Tag library -->
	<hr>
	${successMsg}
	<c:if test="${showLogin}">
		<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${not empty errorMsg}">
		<!-- if the id or the pwd is wrong then -->
${errorMsg}
<jsp:include page="login.jsp"></jsp:include>
	</c:if>
	<c:if test="${showRegistration}">
		<jsp:include page="registration.jsp"></jsp:include>
	</c:if>
	
	<%@ include file="footer.jsp" %>
