<%@page import="com.techlabs.contacts.ContactDto"%>
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
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<jsp:include page="header.jsp" />

</head>
<body>

	<div class="container">
		<h2 align="center">Contact List</h2>
		<p>
		<center>
			<form>
				<div class="input-field">
					<input id="search" name="search_name" type="search" required>
					<label class="label-icon" for="search"><i
						class="material-icons">search</i></label> <i class="material-icons">close</i>
				</div>
			</form>

			<table class="striped">
				<tr id="row">
					<th></th>
					<th>Name</th>
					<th>Phone No</th>
					<th>Email</th>
					<th></th>
				</tr>
				<%
					ArrayList<ContactDto> contacts = (ArrayList<ContactDto>) request
									.getAttribute("contacts");
							if (contacts.isEmpty()) {
								out.print("<p>No contacts to display(Please add contacts)</p>");
							} else
								for (ContactDto contact : contacts) {
				%>
				<tr scale-transition scale-out>
					<td><i class="material-icons">contact_phone</i></td>
					<td><%=contact.getName()%></td>
					<td><%=contact.getPhoneNo()%></td>
					<td><%=contact.getEmailId()%></td>
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
	<script>
		$("#search").on("keyup", function() {
			var value = $(this).val();
			$("table tr").each(function(index) {
				if (index != 0) {

					$row = $(this);

					var id = $row.find("td:nth-child(2)").text();

					if (id.indexOf(value) != 0) {
						$(this).hide();
					} else {
						$(this).show();
					}
				}
			});
		});
	</script>
</body>
</html>