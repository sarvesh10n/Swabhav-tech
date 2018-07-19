<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<center>
			<h2>Login</h2>
			<form action="loginValidate" method="post">
				<div class="input-field">
					<input id="userName" type="text" class="validate" name="userName"
						required="" aria-required="true"> <label for="userName">UserName</label>
				</div>
				<div class="input-field">
					<input id="password" type="password" class="validate"
						name="password" required="" aria-required="true"> <label
						for="password">password</label>
				</div>

				<button class="btn waves-effect waves-light" type="submit">
					Login <i class="material-icons right">lock</i>
				</button>
				<br> <a href="register">new user? register</a>
			</form>

			<s:if test="fieldErrors.get('loginError').size() > 0">
				<div style="color: red">
					<s:property value="fieldErrors.get('loginError').get(0)" />
				</div>
				attemptError
	</s:if>
			<s:if test="fieldErrors.get('attemptError').size() > 0">
				<div style="color: red">
					<s:property value="fieldErrors.get('attemptError').get(0)" />
				</div>
	</s:if>
	</div>
	</center>
	</div>
</body>
</html>