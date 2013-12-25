<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h2>Successfully add a new vehicle</h2>

	<table>
		<tr>
			<td>RegistrationNumber :</td>
			<td>${vehicle.registrationNumber}</td>
		</tr>
		<tr>
			<td>FuelType :</td>
			<td>${vehicle.fuelType}</td>
		</tr>
		<tr>
			<td>Manufacturer :</td>
			<td>${vehicle.manufacturer}</td>
		</tr>
		<tr>
			<td>Mileage :</td>
			<td>${vehicle.mileage}</td>
		</tr>
		<tr>
			<td>Category :</td>
			<td>${vehicle.category}</td>
		</tr>
		<tr>
			<td>DailyRent :</td>
			<td>${vehicle.dailyRent}</td>
		</tr>
		<tr>
			<td>Description :</td>
			<td>${vehicle.description}</td>
		</tr>
		<tr>
			<td><input type="button" value="Cancel"	onclick="javascript:window.location='index.jsp'"/></td>
		</tr>
	</table>
</body>
</html>