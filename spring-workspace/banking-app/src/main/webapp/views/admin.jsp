<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin</title>
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
		<center>
			<h1>Lock/Unlock account</h1>
			<table class="striped">
				<tr id="row">
					<th>Name</th>
					<th>Status</th>
					<th></th>
				</tr>
				<s:iterator value="userList">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="status" /></td>
						<s:if test="status">
							<td><a
								href="<s:url action="updateStatus">
					<s:param name="userId"><s:property value="user_id" /></s:param>
				</s:url>">
									<button class="btn waves-effect waves-light">
										Deactivate
									</button>
							</a></td>
						</s:if>
						<s:else>
							<td><a
								href="<s:url action="updateStatus">
					<s:param name="userId"><s:property value="user_id" /></s:param>
				</s:url>">
									<button class="btn waves-effect waves-light">
										Activate
									</button>
							</a></td>
						</s:else>
					</tr>
				</s:iterator>
			</table>
		</center>
	</div>
</body>
</html>