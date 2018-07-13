<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment portal</title>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"
	integrity="sha256-h0cGsrExGgcZtSZ/fRz4AwV+Nn6Urh/3v3jFRQ0w9dQ="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.1.0/css/all.css"
	integrity="sha384-lKuwvrZot6UHsBSfcMvOkWwlCMgc0TaWr+30HWe3a4ltaBwTZhyTEggF5tJv8tbt"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<center>
			<h1>Payment Portal</h1>
			<form action="yourOrder">
				<div class="row">
					<div class="col s2" style="margin-top: 0.9em;">Enter card
						number</div>
					<div class="col s10">
						<input type="number" min="0" required="">
					</div>
				</div>
				<div class="row">
					<div class="col s2" style="margin-top: 0.9em;">Pick expiry
						date</div>
					<div class="col s2">
						<input type="text" class="datepicker">
					</div>
					<div class="col s2"></div>
					<div class="col s2" style="margin-top: 0.9em;">Enter CVV</div>
					<div class="col s2">
						<input type="password">
					</div>
				</div>
				<div class="row">
					<div class="col s4"></div>
					<div class="col s2" style="margin-top: 0.9em;">Enter otp:</div>
					<div class="col s2">
						<input type="number">
					</div>
				</div>
				<button class="btn waves-effect waves-light" type="submit">
					Pay <i class="fas fa-credit-card"></i>
				</button>
			</form>
		</center>
	</div>
	<script>
		$(document).ready(function() {
			$('.datepicker').datepicker();
		});
	</script>
</body>
</html>