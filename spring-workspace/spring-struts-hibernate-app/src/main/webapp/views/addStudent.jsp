<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Student</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<center>
			<h2>Add contact</h2>
			<s:form action="addSingleStudent" method="post" id="myform">
				<div class="input-field">
					<s:textfield id="firstName" type="text" class="validate"
						name="firstName" required="" aria-required="true" />
					<label for="firstName">First Name</label>
				</div>
				<div class="input-field">
					<s:textfield id="lastName" type="text" class="validate"
						name="lastName" required="" />
					<label for="lastName">Last Name</label>
				</div>
				<div class="input-field">
					<s:textfield id="address" type="text" class="validate"
						name="address" required="" />
					<label for="address">Address</label>
				</div>
				<button class="btn waves-effect waves-light" type="submit">
					Add Student<i class="material-icons right">person_add</i>
				</button>
			</s:form>
		</center>
	</div>
</body>
</html>