<%@page import="com.techlabs.contacts.Contact"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contacts list</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<jsp:include page="header.jsp" />

</head>
<body>
	
	<div class="container">
		<h2 align="center">Contact List</h2>
		<p>
		<center>

			<table class="striped">
				<tr>
					<th></th>
					<th>Name</th>
					<th>Phone No</th>
					<th>Email</th>
					<th></th>
				</tr>
				<%
					ArrayList<Contact> contacts = (ArrayList<Contact>) request
							.getAttribute("contacts");
					if(contacts.isEmpty()){
						out.print("<p>No contacts to display(Please add contacts)</p>");
					}
					else
					for (Contact contact : contacts) {
				%>
				<tr>
					<td><i class="material-icons">contact_phone</i></td>
					<td><%=contact.getName()%></td>
					<td><%=contact.getPhone()%></td>
					<td><%=contact.getEmail()%></td>
					<td><form method="get" action="UpdateContactController">
							<input type="hidden" name="id" value="<%=contact.getId()%>"
								style="display: none">
							<button class="btn waves-effect waves-light" type="submit">
						</form> <i class="material-icons">edit</i></td>
				</tr>
				<%
					}
				%>
			</table>
			<br> <br>
			<form action="AddContactController" method="get">
				<button class="btn waves-effect waves-light" type="submit">
					add Contact <i class="material-icons right">person_add</i>
				</button>
			</form>
		</center>
	</div>
</body>
</html>