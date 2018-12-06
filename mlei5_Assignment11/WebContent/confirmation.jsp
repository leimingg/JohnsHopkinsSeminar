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
			An e-mail confirmation will be sent to: <b><a
				href="mailto:<%= registrationService.getRegistrationInfo().getEmail() %>"><%= registrationService.getRegistrationInfo().getEmail() %></a></b>.
		</div>
		<p></p>

		<div class="output">
			If you do not receive the e-mail confirmation or if you need to
			update your registration information, please contact the conference
			committee at <a href="mailto:registration@seminar.jhu.edu">registration@seminar.jhu.edu</a>
			or at (410) 410-4100.
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
	<p></p>
		<div class="button">
	        <a href="PdfServlet"><input id="pdf" type="submit" value="Print Confirmation in PDF"></a>
	        <a href="ExcelServlet"><input id="excel" type="submit" value="Print Confirmation in Excel"></a>
		</div>



	</div>
</body>
</html>