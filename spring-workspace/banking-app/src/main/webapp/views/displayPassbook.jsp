<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Passbook</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.1/css/all.css"
	integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.js"
	integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
	crossorigin="anonymous"></script>
<jsp:include page="header.jsp" />
</head>
<body>
	<%
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
				.format(new java.util.Date());
		String username = (String) session.getAttribute("user");
		String fileName = username + " " + timeStamp;
	%>
	<div class="container">
		<center>
			<table class="striped" align="center">
				<tr id="row">
					<th>Name</th>
					<th>Amount</th>
					<th>Type</th>
					<th>Date</th>
				</tr>
				<s:iterator value="transactionList">
					<tr>
						<td><s:property value="name" /></td>
						<td><s:property value="amount" /></td>
						<td><s:property value="type" /></td>
						<td><s:property value="date" /></td>
					</tr>
				</s:iterator>
			</table>
			<br> <br> <a
				href="<s:url action="withdrawDepositPage"></s:url>"><button
					class="btn waves-effect waves-light">
					Withdraw/Deposit <i class="fa fa-inr"></i>
				</button></a>

			<button class="btn waves-effect waves-light"
				onclick="exportTableToCSV('<%=fileName%>')">
				Export to csv <i class="fas fa-file-export"></i>
			</button>
		</center>
	</div>
	<script>
		function downloadCSV(csv, filename) {
			var csvFile;
			var downloadLink;
			csvFile = new Blob([ csv ], {
				type : "text/csv"
			});
			downloadLink = document.createElement("a");
			downloadLink.download = filename;
			downloadLink.href = window.URL.createObjectURL(csvFile);
			downloadLink.style.display = "none";
			document.body.appendChild(downloadLink);
			downloadLink.click();
		}
		function exportTableToCSV(filename) {
			var csv = [];
			var rows = document.querySelectorAll("table tr");

			for (var i = 0; i < rows.length; i++) {
				var row = [], cols = rows[i].querySelectorAll("td, th");

				for (var j = 0; j < cols.length; j++)
					row.push(cols[j].innerText);

				csv.push(row.join(","));
			}
			downloadCSV(csv.join("\n"), filename + ".csv");
		}
	</script>
</body>
</html>