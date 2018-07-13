<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/main.css">
<script src='https://www.google.com/recaptcha/api.js'></script>
</head>
<body>
	<div class="container" id="animation">
		<center>
			<h2>Register</h2>
			<form action="RegisterController" method="post"
				onsubmit="return (checkPassword()&&checkAmount())">
				<div class="input-field">
					<input id="userName" type="text" class="validate" name="userName"
						required="" aria-required="true"> <label for="userName">UserName</label>
					<span class="helper-text" data-error="Enter UserName"></span>
				</div>
				<div class="input-field">
					<input id="password" type="password" class="validate"
						name="password" required="" aria-required="true"> <label
						for="password">Password</label> <span class="helper-text"
						data-error="Enter Password"></span>
				</div>
				<div class="input-field">
					<input id="reTypePassword" type="password" class="validate"
						name="password" required="" aria-required="true"> <label
						for="reTypePassword">Re-enter password</label> <span
						class="helper-text" data-error="Re-Enter Password"></span>
				</div>
				<div class="input-field">
					<input id="initialAmount" type="number" class="validate"
						name="initialAmount" required="" aria-required="true"> <label
						for="initialAmount">Enter initial amount <i
						class="fa fa-inr"></i>(Minimum 1000)
					</label> <span class="helper-text" data-error="Enter initial amount"></span>
				</div>
				<div class="g-recaptcha"
					data-sitekey="6Ld3OGIUAAAAALigOC5n4kV4D3IU-JiRgy7wdofH"></div>
					<br>
				<button class="btn waves-effect waves-light" type="submit">
					Register <i class="material-icons right">lock</i>
				</button>
			</form>
		</center>
		<script type="text/javascript">
			function checkPassword() {
				var pass = document.getElementById("password");
				var rePass = document.getElementById("reTypePassword");
				if (pass.value == rePass.value)
					return true;
				alert("Password does not match");
				return false;
			}
			function checkAmount() {
				var amount = document.getElementById("initialAmount").value;
				if (amount >= 1000)
					return true;
				alert("Initial amount must be greater than 1000");
				return false;
			}
		</script>
</body>
</html>