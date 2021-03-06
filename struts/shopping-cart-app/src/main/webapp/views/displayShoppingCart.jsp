<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>shopping cart</title>
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
<jsp:include page="header.jsp" />
</head>
<body>

	<div class="container">
		<center>

			<h1>Shopping cart</h1>
			<br>
			<form action="addToCart">
				<div class="row">
					<div class="col s1"></div>
					<div class="col s2">
						<select name="selected" class="browser-default" required>
							<option value="" disabled selected>Select your product</option>
							<s:iterator value="productList">
								<option value="<s:property value='productId' />">
									<s:property value="productName" />
								</option>
							</s:iterator>
							<label>select phone</label>
						</select>
					</div>
					<div class="col s1"></div>
					<div class="col s1" style="margin-top: 0.9em;">
						<p1>Quantity:</p1>
					</div>
					<div class="col s2">
						<input id="quantity" placeholder="Quantity" type="number" min="0"
							name="quantity" class="validate" required="">
					</div>
					<div class="col s1 " style="margin-top: 0.9em;">Total amount
					</div>
					<div class="col s1" style="margin-top: 0.9em;">
						<s:property value="displayAmount" />
						<i class="fas fa-rupee-sign"></i>
					</div>
					<div class="col s1"></div>
					<div class="col s2">
						<button class="btn waves-effect waves-light" type="submit">
							Add to cart<i class="fas fa-cart-plus"></i>
						</button>
					</div>

				</div>
			</form>
			<br>
			<div class="row">
				<table class="striped">
					<tr>
						<th>#</th>
						<th>Product</th>
						<th>Unit price</th>
						<th>Quantity</th>
						<th>Total price</th>
					</tr>
					<s:iterator value="lineItemList">
						<tr>
							<td></td>
							<td><s:property value="product.productName" /></td>
							<td><s:property value="product.productPrice" /></td>
							<td><s:property value="quantity" /></td>
							<td><s:property value="totalPrice" /></td>
						</tr>
					</s:iterator>
				</table>
			</div>
			<form action="payment">
				<button class="btn waves-effect waves-light" type="submit">
					Proceed for payment <i class="fas fa-credit-card"></i>
				</button>
			</form>
	</div>
	</center>
	</div>
	<script>
		$(document).ready(function() {
			$('select').formSelect();

			$('#quantity').on('input', function(e) {

			})
		});
	</script>
</body>
</html>
