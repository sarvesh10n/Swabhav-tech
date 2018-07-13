<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<nav>
	<div class="nav-wrapper">
		<a href="#" class="brand-logo"><i class="material-icons">contacts</i>Contacts
			app</a>

		<ul id="nav-mobile" class="right hide-on-med-and-down">

			<%
				if (request.getSession().getAttribute("user") != null) {
			%>
			<li><a href="#"> <%=request.getSession().getAttribute("user")%>
					<i class="material-icons right">person</i></a></li>
			<li><a href="logout"> Logout <i
					class="material-icons right">lock</i></a></li>

			<%
				} else {
			%>
			<li><a href="loginPage"> Login <i
					class="material-icons right">lock</i></a></li>
			<%
				}
			%>
		</ul>
	</div>
	</nav>
</body>
</html>