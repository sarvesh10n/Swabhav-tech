<%@ taglib prefix="s" uri="/struts-tags"%>
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
				<s:iterator value="contactList">
					<tr>
						<td><i class="material-icons">contact_phone</i></td> 
						<td><s:property value="name" /></td>
						<td><s:property value="phoneNo" /></td>
						<td><s:property value="email" /></td>
						<td><a
							href="<s:url action="updateContactPage">
					<s:param name="guid"><s:property value="id" /></s:param>
				</s:url>">
								<button class="btn waves-effect waves-light">
									<i class="material-icons">edit</i>
								</button>
						</a></td>
					</tr>
				</s:iterator>
			</table>
			<br> <br> <a href="<s:url action="addContactPage"></s:url>"><button
					class="btn waves-effect waves-light">
					add Contact <i class="material-icons right">person_add</i>
				</button></a>
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