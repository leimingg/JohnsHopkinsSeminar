<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hopkins Seminar</title>
<link href="css/style.css" type="text/css" rel="stylesheet">
<link href="css/creditcardjs-v0.10.12.min.css" rel="stylesheet">
<script src="back.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="functions.js"></script>
</head>
<body>
	<jsp:useBean id="registrationService" scope="session"
		class="service.RegistrationServiceImplement" />
	<div class="header">
		<img alt="Johns Hokins Header" src="images/EP Header.png">
	</div>
	<div class="main">


		<h3>JOHNS HOPKINS ANNUAL SOFTWARE DEVELOPMENT SEMINAR</h3>

		<div>
			<b><%= registrationService.getRegistrationInfo().getName() %></b>
		</div>
		<p></p>

		<div>
			You are registered as a <b><%= registrationService.getRegistrationInfo().getEmploymentStatus() %></b>.
		</div>
		<p></p>

		<div>
			Your total cost for the seminar is: <b>$<%= registrationService.getRegistrationInfo().getCostInfo().getTotal() %>0
			</b>.
		</div>

		<br>

		<fieldset>
			<legend>
				<strong>Payment Details</strong>
			</legend>
			<div class="input">
				<!-- <h4>Payment Details</h4> -->
				<div class="ccjs-card">
					<label class="ccjs-number"> Card Number <input
						name="card-number" class="ccjs-number"
						placeholder="**** **** **** ****">
					</label> <label class="ccjs-csc"> Security Code <input name="csc"
						class="ccjs-csc" placeholder="***">
					</label>

					<button type="button" class="ccjs-csc-help">?</button>

					<label class="ccjs-name"> Name on Card <input name="name"
						class="ccjs-name">
					</label>

					<fieldset class="ccjs-expiration">
						<legend>Expiration</legend>
						<select name="month" class="ccjs-month">
							<option selected disabled>MM</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select> <select name="year" class="ccjs-year">
							<option selected disabled>YY</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
						</select>
					</fieldset>

					<select name="card-type" class="ccjs-hidden-card-type">
						<option value="amex" class="ccjs-amex">American Express</option>
						<option value="discover" class="ccjs-discover">Discover</option>
						<option value="mastercard" class="ccjs-mastercard">MasterCard</option>
						<option value="visa" class="ccjs-visa">Visa</option>
						<option value="diners-club" class="ccjs-diners-club">Diners
							Club</option>
						<option value="jcb" class="ccjs-jcb">JCB</option>

					</select>
				</div>
			</div>
		</fieldset>

		<script src="scripts/creditcardjs-v0.10.12.min.js"></script>

		<br>
		<fieldset>
			<legend>
				<strong>More Actions:</strong>
			</legend>
			<div class="button">
				<input type="button" name="Submit" value="Edit Information"
					onclick="goBack()"> <input type="button" name="Submit"
					value="Add More Courses" onclick="goBack()"> <a
					href="confirmation.jsp"><input id="confirm" type="submit"
					value="Confirm Registration"></a>
			</div>
		</fieldset>
	</div>

</body>
</html>