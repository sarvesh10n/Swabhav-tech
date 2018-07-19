<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<center>
			<table class="striped">
				<tr id="row">
					<th>Roll No</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Address</th>
					<th></th>
					<th></th>
				</tr>
				<s:iterator value="studentList">
					<tr>
						<td><s:property value="rollNo" /></td>
						<td><s:property value="firstName" /></td>
						<td><s:property value="lastName" /></td>
						<td><s:property value="address" /></td>
						<td><a
							href="<s:url action="updateStudentPage">
					<s:param name="rollNo"><s:property value="rollNo" /></s:param>
				</s:url>">
								<button class="btn waves-effect waves-light">
									<i class="material-icons">edit</i>
								</button>
						</a></td>
						<td><a
							href="<s:url action="deleteStudent">
					<s:param name="rollNo"><s:property value="rollNo" /></s:param>
				</s:url>">
								<button class="btn waves-effect waves-light">
									<i class="material-icons">delete</i>
								</button>
						</a></td>
					</tr>
				</s:iterator>
			</table>
			<br> <br> <a href="<s:url action="addStudentPage"></s:url>"><button
					class="btn waves-effect waves-light">
					add Student <i class="material-icons right">person_add</i>
				</button></a>
		</center>
	</div>
</body>
</html>