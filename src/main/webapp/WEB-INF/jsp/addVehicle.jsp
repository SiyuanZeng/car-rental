<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle rental ---- Vehicle booking</title>
<script type="text/javascript">
	
	
</script>

</head>
<body>
	<center>
		<h1>Vehicle Rental Application ---- Add a Vehicle</h1>
	</center>
	<hr />

	<form action="addVehicleForm.action" method="post">
		<table>
			<tr>
				<td>Registration Number</td>
				<td><input type="text" name="registration_number"></input></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><select name="category">
						<option>Select vehicle category</option>
						<c:forEach items="${requestScope.c}" var="c">
							<option value="${c.category}">${c.category}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Fuel Type</td>
				<td><select name="fuel_type">
						<option>Select fuel type</option>
						<c:forEach items="${requestScope.v}" var="v">
							<option value="${v.fuelType}">${v.fuelType}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Daily Rent</td>
				<td><input type="text" name="daily_rent"></input></td>
			</tr>
			<tr>
				<td>Mileage</td>
				<td><input type="text" name="mileage"></input></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><textarea name="description" rows="4" cols="50"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></input></td>
				<td><input type="button" value="Cancel"
					onclick="javascript:window.location='index.jsp'"/></td>
			</tr>

		</table>
	</form>
</body>
</html>