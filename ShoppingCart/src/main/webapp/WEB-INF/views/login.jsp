<%@ include file="header.jsp" %>
<body>
<style>
body {
	background-image: url("resources/images/8.jpg");
	background-repeat: no-repeat;
	background-size: cover;
}
}
</style>
<h3><i>Please login with your credentials</i><br>

	${message}
	<center>
		<form action="perform_login" method="POST">
			<table>
				<tr style="color: green; font-size: 20pt">
					<td><i>Email-id:</i></td>
					<td><input type="email" name="username"
						placeholder="abc@gmail.com" /></td>
				</tr><br>
				<tr style="color: green; font-size: 20pt">
					<td><i>Password:</i></td>
					<td><input type="password" name="password" /><br></td>
				</tr>
				<tr><br>
				<br>
					<td><br><input type="submit" value="Sign-in"
						style="color: blue; font-size: 15pt" /></td>
					<td><br><input type="reset" value="Cancel"
						style="color: red; font-size: 15pt" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>

<%@ include file="footer.jsp" %>

