<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

</head>
<body>
	<div id="headerAnimation">
		<nav>
		<div class="nav-wrapper">
			<a href="LoginController" class="brand-logo"><i
				class="fa fa-university" aria-hidden="true"></i>Banking app</a>

			<ul id="nav-mobile" class="right hide-on-med-and-down">

				<%
					if (request.getSession().getAttribute("username") != null) {
				%>
				<li><a href="#"> <%=request.getSession().getAttribute("username")%>
						<i class="material-icons right">person</i></a></li>
				<li><a href="LogoutController"> Logout <i
						class="material-icons right">lock</i></a></li>

				<%
					} else {
				%>
				<li><a href="LoginController"> Login <i
						class="material-icons right">lock</i></a></li>
				<%
					}
				%>
			</ul>
		</div>
		</nav>
	</div>
</body>
</html>