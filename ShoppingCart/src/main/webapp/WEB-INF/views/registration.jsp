<%@ include file="header.jsp" %>
<title>Register User</title>
<style>
body {
	background-image: url("resources/images/12.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
tr
{
font-size:20pt;
color:red;
}
}
</style>
</head>

<center>
	<h1>Registration</h1>
	<p>
		ALREADY REGISTERED? <a href="login">Sign In</a>
	</p>

	<form:form commandName="us">

		<table>
			<tr>
				<td><i>User Name</i></td>
				<td><form:input type="text" path="username"/></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('username')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td><i>Enter Password</i></td>
				<td><form:input type="password" path="password"/></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>

			<tr>
				<td><i>Enter Confirmed Password</i></td>
				<td><form:input type="password" path="confirmpassword"/></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('confirmpassword')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>
			<tr>
				<td><i>Email Id</i></td>
				<td><form:input type="email" path="emailid"/></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>



			<tr>
				<td><i>Mobile no:</i></td>
				<td><form:input type="text" path="phno"/></td>
			</tr>
			<!-- to display validation messages -->
			<c:forEach
				items="${flowRequestContext.messageContext.getMessagesBySource('phno')}"
				var="err">
				<div>
					<span>${err.text}</span>
				</div>
			</c:forEach>



			<tr>
				<td><input type="CHECKBOX"NAME="OFFER"CHECKED>I agree
					to receive information about exciting offers</td>
			</tr>
		</table>

		<br/>
		<br/>


		<div class="center">
			<input type="submit"name="_eventId_submit"value="submit">
		</div>

	</form:form>
	

</center>
<br/>

<%@include file="footer.jsp"%>

<%-- <body>

	<h2>Please fill the details</h2>
${message }
<centre>
	<form:form commandName="user" method="post" action="addus">
		<table>
		
			<tr style="color: White; font-size: 10pt">
				<td><i>User Name:<i></i></td>
				<td><input type="text" name="name" path="username"></td>
			</tr>
		
		<tr style="color: White; font-size: 10pt">
				<td><i>Email ID:<i></i></td>
				<td><input type="email ID" name="email" path="emailid"></td>
			</tr>
			
		
			
			<tr style="color: White; font-size: 10pt">
				<td><i>Password:<i></i></td>
				<td><input type="text" name="password" path="password"></td>
			</tr>
			
			<tr style="color: White; font-size: 10pt">
				<td><i>Confirm Password:</i></td>
				<td><input type="text" name="password" path="confirmpassword"></td>
			</tr>
			
			<tr style="color: White; font-size: 10pt">
				<td><i>Mobile No:</i></td>
				<td><input type="text" name="mobile" path="phno"></td>
			</tr>
				
			
			<tr style="color: Red; font-size: 10pt">
				<td><input type="submit" value="Register">
				<td><input type="reset" value="Reset">
			</tr>
			
		</table>

	</form:form>
	</centre>
	</body>

<%@ include file="footer.jsp" %> --%>
