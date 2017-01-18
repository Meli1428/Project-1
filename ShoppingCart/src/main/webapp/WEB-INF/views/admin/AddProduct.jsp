<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Product Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<h1>Adding Products</h1>


	<form:form action="addprod" commandName="product" enctype="multipart/form-data">
		<table>
			<tr>
				<td><form:label path="prod_id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty product.prod_id}">
						<td><form:input path="prod_id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="prod_id" patttern =".{6,7}" required="true" title="id should contains 6 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
			<form:input path="prod_id" hidden="true"  />
				<td><form:label path="prod_name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="prod_name" required="true" /></td>
			</tr>
			
			
			<tr>
				<td><form:label path="prod_price">
						<spring:message text="Price" />
					</form:label></td>
				<td><form:input path="prod_price" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="quantity">
						<spring:message text="Quantity" />
					</form:label></td>
				<td><form:input path="quantity" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
				<%-- <td><form:input path="supplier.supname" required="true" /></td> --%>
				 <td><form:select path="supplier.supname" items="${supplierList}" itemValue="name" itemLabel="name" /></td>
			</tr>
			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<%-- <td><form:input path="category.catname" required="true" /></td> --%>
				<td><form:select path="category.catname" items="${categoryList}" itemValue="catname" itemLabel="catname" /></td>
			</tr>
			
			<tr>
				<td>Product Image</td>
						<td><form:input type="file" path="img"/>
			</tr>
			
			<tr>
				<td colspan="2"><c:if test="${!empty product.prod_name}">
						<input type="submit"
							value="<spring:message text="Edit Product"/>" />
					</c:if> <c:if test="${empty product.prod_name}">
						<input type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
			
			
					
			
		</table>
	</form:form>
	<br>
	<h3>Product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">Product ID</th>
				<th width="120">Product Name</th>
				<th width="200">Product Quantity</th>
				<th width="80">Price</th>
				<th width="80">Product Category</th>
				<th width="80">Product Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.prod_id}</td>
					<td>${product.prod_name}</td>
					<td>${product.quantity}</td>
					<td>${product.prod_price}</td>
					<td>${product.category.catname}</td>
					<td>${product.supplier.supname}</td>
					<td><a href="<c:url value='product/edit/${product.prod_id}' />">Edit</a></td>
					<td><a href="<c:url value='product/remove/${product.prod_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>