<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/style.css" type="text/css" rel="stylesheet">
<script src="back.js"></script>
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="functions.js"></script>
<title>Seminar</title>
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
			<b><%=registrationService.getRegistrationInfo().getName() %></b>
		</div>
		<p></p>

		<div>
			You are registered as a <b><%=registrationService.getRegistrationInfo().getEmploymentStatus() %></b>
		</div>
		<p></p>

		<div>
			Your e-mail confirmation will be sent to: <b><%=registrationService.getRegistrationInfo().getEmail() %></b>
		</div>
		<p></p>


		<table>
			<tr>
				<th>Your Courses</th>
				<th></th>
				<th>Cost</th>
			</tr>

			<%
					String[] courses=registrationService.getCourses();
				for(int i=0; i<courses.length;i++)
				{
					
				
				%>
			<tr>
				<td><%=courses[i] %></td>
				<td></td>
				<td>$<%=registrationService.getRegistrationInfo().getCostInfo().getEmployeeStatusCost() %></td>
				<td><button class="remove" value="<%= courses[i] %>">Remove</button></td>
			</tr>

			<%} %>


			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>


			<%
					if(registrationService.getRegistrationInfo().getHotel()!=null){
						
					
				
				%>
			<tr>
				<td>Hotel Accommodation</td>
				<td></td>
				<td>$<%=registrationService.getRegistrationInfo().getCostInfo().getHotelCost() %></td>
			</tr>

			<%} %>

			<%
					if(registrationService.getRegistrationInfo().getParking()!=null){
						
					
				%>

			<tr>
				<td>Parking Permit</td>
				<td></td>
				<td>$<%=registrationService.getRegistrationInfo().getCostInfo().getParkingCost() %></td>
			</tr>

			<%
					}
				%>

			<tr>
				<td></td>
				<td><b>Total: &nbsp;</b></td>

				<td>$<b><%=registrationService.getRegistrationInfo().getCostInfo().getTotal() %></b></td>
			</tr>
		</table>

		<br>

		<fieldset>
			<legend>
				<strong>More Actions:</strong>
			</legend>
			<input type="button" name="Submit" value="Edit Information"
				onclick="goBack()"> <input type="button" name="Submit"
				value="Add More Courses" onclick="goBack()"> <a
				href="checkout.jsp"><input type="button" name="Submit"
				value="Confirm Registration"></a>
			<!-- <form action="RegistrationServlet" method="post">
			<input type="button" name="Submit" value="Confirm Registration" >
			</form> -->
		</fieldset>







	</div>
</body>
</html>