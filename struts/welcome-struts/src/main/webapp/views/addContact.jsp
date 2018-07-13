<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add contact</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<style type="text/css">
		.errorMessage{
		color:red;
		}
		

td, th {
    border: 1px solid #ddd;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2;}

tr:hover {background-color: #ddd;}

th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
	</style>
</head>

<body>
	<div class="container">
		<center>
			<h2>Add contact</h2>
			<s:form action="addSingleStudent" method="post">
				<s:textfield id="Name" type="text" class="validate"
					name="student.name" label="Name"/>
				<s:textfield id="phoneNo" type="number" class="validate"
					name="student.phoneNo" label="phoneNo"/>
				
				<s:textfield id="email" type="email" class="validate"
					name="student.email" label="email" />
				<s:submit value="Add"/>
			</s:form>
		</center>
	</div>
</body>
</html>