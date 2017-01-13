<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>

<h1></h1>

	<h2>Please fill the details</h2>

	<form:form commandName="user" method="post" action="addus">
		<table>
		
			<tr>
				<td>User Name:</td>
				<td><input type="text" name="name" path="username"></td>
			</tr>
		
		<tr>
				<td>Email ID:</td>
				<td><input type="email ID" name="email" path="emailid"></td>
			</tr>
			
		
			
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password" path="password"></td>
			</tr>
			
			<tr>
				<td> Confirm Password:</td>
				<td><input type="text" name="password" path="confirmpassword"></td>
			</tr>
			
			<tr>
				<td>Mobile No:</td>
				<td><input type="text" name="mobile" path="phno"></td>
			</tr>
				
			
			<tr>
				<td><input type="submit" value="Register">
				<td><input type="reset" value="Reset">
			</tr>
			
		</table>

	</form:form>

</body>
</html>