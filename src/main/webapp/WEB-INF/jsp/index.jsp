<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle rental</title>
</head>
<body>
	<h3>Message : ${message}</h3>
	<h3>Username : ${username}</h3>
	<ul>
		<li><a href="booking.action">Book a Vehicle</a></li>
		<li><a href="addVehicle.action">Add a Vehicle</a></li>
		<li><a href="reporting.action">Vehicle Booking Report</a></li>
		<li><a href="customer.htm">Customer</a></li>
		<li><a href="vehicle.htm">Vehicle Controller</a></li>
		<li><a href="vehicleRental.htm">Vehicle Rental Controller</a></li>
		<li><a href="vehicleRentalReport.htm">Vehicle Rental Report	Controller</a></li>
		<li><a href="normalhour.htm">Welcome Controller</a></li>
		<li><a href="welcomeModelAndView.htm">Model And View Example</a></li>
		<li><a href="welcomeResponsive.htm">Responsive Design</a></li>

		<li><a href="task.htm">Add a task</a></li>


		<a href="<c:url value="/j_spring_security_logout" />"> Logout</a>
	</ul>
</body>
</html>