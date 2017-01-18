<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Supplier Page</title>
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
	<h1>Add a Supplier</h1>


	<form:form action="/admin/addsupp" commandName="supplier">
		<table>
			<tr>
				<td><form:label path="sup_id">
						<spring:message text="ID" />
					</form:label></td>
				<c:choose>
					<c:when test="${!empty supplier.sup_id}">
						<td><form:input path="sup_id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<%-- <c:otherwise>
						<td><form:input path="id" patttern =".{6,7}" required="true" title="id should contains 6 to 7 characters" /></td>
					</c:otherwise> --%>
				</c:choose>
			<tr>
			<form:input path="sup_id" hidden="true"  />
				<td><form:label path="supname">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="supname" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="supaddress">
						<spring:message text="Address" />
					</form:label></td>
				<td><form:input path="supaddress" required="true" /></td>
			</tr>
			
			<tr>
				<td><form:label path="supdescription">
						<spring:message text="description" />
					</form:label></td>
				<td><form:input path="supdescription" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty supplier.supname}">
						<input type="submit"
							value="<spring:message text="Edit Supplier"/>" />
					</c:if> <c:if test="${empty supplier.supname}">
						<input type="submit" value="<spring:message text="Add Supplier"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Supplier List</h3>
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th width="80">Supplier ID</th>
				<th width="120">Supplier Name</th>
				<th width="120">Supplier Address</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.sup_id}</td>
					<td>${supplier.supname}</td>
					<td>${supplier.supaddress}</td>
					<td><a href="<c:url value='supplier/edit/${supplier.sup_id}' />">Edit</a></td>
					<td><a href="<c:url value='supplier/remove/${supplier.sup_id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>