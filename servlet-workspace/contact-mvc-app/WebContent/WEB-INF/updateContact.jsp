<%@page import="com.techlabs.contacts.Contact"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Student</title>
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
			<%
				Contact contact = (Contact) request.getAttribute("contact");
				String id = (String) request.getAttribute("id");
			%>
			<h2>Update contact</h2>
			<form method="post" action="UpdateContactController" id="myform">
				<div class="input-field">
					<input id="Name" type="text" class="validate" name="name"
						required="" value="<%=contact.getName()%>" aria-required="true">
					<label for="Name">Name</label> <span class="helper-text"
						data-error="Enter Name"></span>
				</div>
				<div class="input-field">
					<input id="phoneNo" type="number" class="validate" name="phoneNo"
						required="" value="<%=contact.getPhone()%>"> <label
						for="phoneNo">Phone no</label> <span class="helper-text"
						data-error="enter valid Phone number"
						data-success="valid Phone number"></span>
				</div>
				<div class="input-field">
					<input id="email" type="email" class="validate" name="email"
						required="" value="<%=contact.getEmail()%>"> <label
						for="email">E-mail</label> <span class="helper-text"
						data-error="Enter valid Email" data-success="valid Email"></span>
				</div>
				<input type="hidden" value=<%=id%> name="id">
				<button class="btn waves-effect waves-light" type="submit">
					Update Student <i class="material-icons right">control_point</i>
				</button>
			</form>
		</center>
	</div>
</body>
</html>