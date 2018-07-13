<%@page import="com.techlabs.model.Transaction"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<jsp:include page="header.jsp" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

</head>
<body>
	<%
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		String username=(String)session.getAttribute("username");
		String fileName=username+" "+timeStamp;
	%>
	<div class="container" id="animation">
		<h2 align="center">Passbook</h2>


		<div class="row">
			<form action="WithdrawDepositController" method="get">
				<button class="btn waves-effect waves-light" style="float: left;"
					type="submit">
					Withdraw/Deposit <i class="fa fa-inr"></i>
				</button>
			</form>
			<button class="btn waves-effect waves-light" style="float: right;"
				onclick="exportTableToCSV('<%=fileName%>')">
				Export to csv <i class="fas fa-file-export"></i>
			</button>
		</div>
		<p>
		<center>

			<table class="striped">
				<tr>
					<th></th>
					<th>Name</th>
					<th>Amount</th>
					<th>Type</th>
					<th>Date</th>
				</tr>
				<%
					ArrayList<Transaction> records = (ArrayList<Transaction>) request
															.getAttribute("transactions");
													if(records.isEmpty()){
														out.print("<p>No records to display</p>");
													}
													else
													for (Transaction trans : records) {
				%>
				<tr>
					<td><i class="material-icons">account_balance_wallet</i></td>
					<td><%=trans.getName()%></td>
					<td><%=trans.getAmount()%></td>
					<td>
						<%
							if(trans.getType().equals("W"))
												out.print("Withdraw");
												else
													out.print("Deposit");
						%>
					</td>
					<td><%=trans.getDate()%></td>
				</tr>
				<%
					}
				%>
			</table>



		</center>
	</div>
	<script type="text/javascript">
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

				for (var j = 1; j < cols.length; j++)
					row.push(cols[j].innerText);

				csv.push(row.join(","));
			}
			downloadCSV(csv.join("\n"), filename + ".csv");
		}
	</script>
	</ body>
</html>