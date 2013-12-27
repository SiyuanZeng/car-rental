<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Successfully add a new reservation</h2>
	<table>
		<tr>
			<td>CustomerName :</td>
			<td>${vehicleRental.customerName}</td>
		</tr>
		<tr>
			<td>Category :</td>
			<td>${vehicleRental.category}</td>
		</tr>
		<tr>
			<td>RegistrationNumber :</td>
			<td>${vehicleRental.registrationNumber}</td>
		</tr>
		<tr>
			<td>Booked From :</td>
			<td>${vehicleRental.bookedFrom}</td>
		</tr>
		<tr>
			<td>Booked To :</td>
			<td>${vehicleRental.bookedTo}</td>
		</tr>
		<tr>
			<td>Total Rent :</td>
			<td>${vehicleRental.totalRent}</td>
		</tr>
		<tr>
			<td>PaymentStatus :</td>
			<td>${vehicleRental.paymentStatus}</td>
		</tr>
		<tr>
			<td><input type="button" value="Return"	onclick="javascript:window.location='welcome'"/></td>
		</tr>
	</table>
</body>
</html>