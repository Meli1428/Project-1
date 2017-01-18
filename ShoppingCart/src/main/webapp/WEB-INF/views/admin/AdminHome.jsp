<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Art Gallery</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>

 <div align="right">
<a href="logout" class="btn btn-success">
          <span class="glyphicon glyphicon-log-out"></span>Logout</a>
</div>  

<div align="center">
<img src="resources/images/pic4.jpg">
</div>
<h4>Welcome Admin, </h4> <br><br>
<a href="admin/AddCategory"><button type="button" class="btn btn-success btn-lg">Category</button></a> 
<a href="admin/AddSupplier"><button type="button" class="btn btn-success btn-lg">Supplier</button></a> 
<a href="admin/AddProduct"><button type="button" class="btn btn-success btn-lg">Product</button></a>  


<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>

<jsp:include page="footer.jsp"/> 
</body>
</html>
