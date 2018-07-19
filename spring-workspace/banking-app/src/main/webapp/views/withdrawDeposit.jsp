<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Withdraw/Deposit</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<jsp:include page="header.jsp" />
</head>
<body>

	<div class="container" id="animation">
		<center>
			<h2>Withdraw/Deposit</h2>
		</center>
		<br> <br>
		<form onsubmit="return confirmTransaction()" method="post"
			action="withdrawDeposit">

			<div class="input-field">

				<input id="amount" type="number" class="validate" name="amount"
					required="" aria-required="true"> <label for="amount">Enter
					Amount <i class="fa fa-inr"></i>
				</label> <span class="helper-text" data-error="Enter Amount"></span>
			</div>
			<p>
				<label><input checked name="type" type="radio" value="D"><span>Deposit</span></label>
			</p>
			<p>
				<label><input name="type" type="radio" value="W"><span>Withdraw</span></label>
			</p>
			<center>
				<button class="btn waves-effect waves-light" type="submit">
					Perform transaction <i class="material-icons right">account_balance_wallet
					</i>
				</button>
				<br>
			</center>
		</form>
		<center>
			<div style="color: red">
				<s:if test="fieldErrors.get('transError').size() > 0">
					<s:property value="fieldErrors.get('transError').get(0)" />

				</s:if>
			</div>
		</center>
	</div>
	<script type="text/javascript">
		function confirmTransaction() {
			var type = document.querySelector('input[name="type"]:checked').value;
			if (type === "D")
				type = "Deposit";
			else
				type = "Withdraw";
			var amount = document.getElementById("amount").value;
			return confirm(type + " of amount " + amount + ". Are you sure?");

		}
	</script>
</body>
</html>