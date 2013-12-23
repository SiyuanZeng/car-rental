<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="carrental.model.ReportEntry"%>
<%@page import="java.util.List"%>
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
		<h1>Vehicle Rental Application ---- Vehicle booking report</h1>
	</center>
	<hr />
	<form>
		<table border="1">
			<tr>
				<td>Vehicle Type</td>
				<td>Total No of Vehicles Type</td>
				<td>Total No of Vehicles Rented</td>
				<td>Total Rent Earned</td>
			</tr>
			
				<c:forEach items="${requestScope.reportList}" var="reportList">
				<tr>
					<td>${reportList.vehicleType}</td>
					<td>${reportList.totalNumOfVehicles}</td>
					<td>${reportList.totalNumOfVehiclesRent}</td>
					<td>${reportList.totalRentEarned}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="Cancel"
			onclick="javascript:window.location='index.jsp'" />
	</form>
</body>
</html>