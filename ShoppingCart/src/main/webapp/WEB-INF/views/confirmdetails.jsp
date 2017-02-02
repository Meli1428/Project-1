<%@include file="header.jsp"%>

<!-- <style>
body {
	background-image: url("resources/images/aaa.jpg");
}
</style> -->

<div class="content"style="text-align:center;">
	<fieldset>
		<legend>Confirm Details</legend>
		
		<a href="${flowExecutionUrl}&_eventId_index">Home</a><br/><br/>
		
		<form:form modelAttribute="us">
			<form:label path="username">User Name:</form:label>${us.username}
					<br/>
			<br/>
			<form:label path="password">Password :</form:label>${us.password}
					<br/>


			<form:label path="emailid">Email:</form:label>${us.emailid}
					<br/>
			<br/>
			<form:label path="phno">Mobile #:</form:label>${us.phno}
					<br/>
			<br/>
			<input name="_eventId_edit"type="submit"value="Edit"/>
			<input name="_eventId_submit"type="submit"value="Confirm Details"/>
			<br/>
		</form:form>
	</fieldset>
</div>

<%@include file="footer.jsp"%>
