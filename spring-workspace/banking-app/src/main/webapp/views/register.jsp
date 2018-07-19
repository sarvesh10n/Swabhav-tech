<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src='https://www.google.com/recaptcha/api.js'></script>
<jsp:include page="header.jsp" />
</head>
<body>
	<div class="container">
		<center>
			<h2>Register</h2>
			<s:form action="registerUser" method="post" id="myform"
				onsubmit="return (checkPassword()&&checkAmount())">
				<div class="input-field">
					<s:textfield id="name" type="text" class="validate" name="name"
						required="" aria-required="true" />
					<label for="name">Name</label>
				</div>

				<div class="input-field">
					<s:textfield id="password" type="password" class="validate"
						name="password" required="" />
					<label for="password">Password</label>
				</div>
				<div class="input-field">
					<s:textfield id="rePassword" type="password" class="validate"
						name="rePassword" required="" />
					<label for="rePassword">Re-Type Password</label>
				</div>
				<div class="input-field">
					<s:textfield id="amount" type="number" class="validate"
						name="amount" required="" value="1000" />
					<label for="amount">Initial Deposit</label>
				</div>
				<div class="g-recaptcha"
					data-sitekey="6Ld3OGIUAAAAALigOC5n4kV4D3IU-JiRgy7wdofH"></div>
				<br>

				<button class="btn waves-effect waves-light" type="submit"
					id="submit">
					Register <i class="material-icons right">person_add</i>
				</button>
				<div id="validUser" style="display: none; color: red;">
					Username already in use</div>
			</s:form>
			<br>
			<s:if test="fieldErrors.get('registerError').size() > 0">
				<div style="color: red">
					<s:property value="fieldErrors.get('registerError').get(0)" />
				</div>
			</s:if>
		</center>
		<script type="text/javascript">
			function checkPassword() {
				var pass = document.getElementById("password");
				var rePass = document.getElementById("rePassword");
				if (pass.value == rePass.value)
					return true;
				alert("Password does not match");
				return false;
			}
			function checkAmount() {
				var amount = document.getElementById("amount").value;
				if (amount >= 1000)
					return true;
				alert("Initial amount must be greater than 1000");
				return false;
			}

			$(document).ready(function() {

				$('#name').on('input', function(e) {
					var form = $('#name').serialize();
					$.getJSON('checkName', form, function(data) {
						console.log(data.availability);
						if (data.availability) {
							$('#validUser').show();
							$('#submit').prop('disabled', true);
						} else {
							$('#validUser').hide();
							$('#submit').prop('disabled', false);
						}
					});
				});
			});
		</script>

	</div>
</body>
</html>