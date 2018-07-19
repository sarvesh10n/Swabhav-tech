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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="headerAnimation">
		<nav>
		<div class="nav-wrapper"  >
			<a href="displayPassbook" class="brand-logo"><i
				class="fa fa-university" aria-hidden="true"></i>Banking app</a>

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
				<li><a href="login"> Login <i
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