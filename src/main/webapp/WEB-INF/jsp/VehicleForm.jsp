<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>


	<center>
		<h2>Add a New Vehicle</h2>
	</center>
	<h3>
		<%
			//allow access only if session exists
			String user = null;
			if (session.getAttribute("user") == null) {
				response.sendRedirect("login.html");
			} else
				user = (String) session.getAttribute("user");
			String userName = null;
			String sessionID = null;
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("user"))
						userName = cookie.getValue();
					if (cookie.getName().equals("JSESSIONID"))
						sessionID = cookie.getValue();
			}
			}
		%>
		Username :<%=user%>
	</h3>

	<h3>
		Hello,
		<%=userName%>, Login successful. Your Session ID=<%=sessionID%></h3>

	<form:form method="POST" commandName="vehicle">

		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td>Registration Number :</td>
				<td><form:input path="registrationNumber" /></td>
				<td><form:errors path="registrationNumber" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Category :</td>
				<td><form:select path="category">
						<form:option value="NONE" label="--- Select ---" />
						<c:forEach items="${categoryList}" var="c">
							<option value="${c.category}">${c.category}</option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="category" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Fuel Type :</td>
				<td><form:select path="fuelType">
						<form:option value="NONE" label="--- Select ---" />
						<c:forEach items="${fuelTypeList}" var="f">
							<option value="${f.fuelType}">${f.fuelType}</option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="fuelType" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Manufacturer :</td>
				<td><form:input path="manufacturer" /></td>
				<td><form:errors path="manufacturer" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Daily Rent :</td>
				<td><form:input path="dailyRent" /></td>
				<td><form:errors path="dailyRent" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Mileage :</td>
				<td><form:input path="mileage" /></td>
				<td><form:errors path="mileage" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:textarea path="description" /></td>
				<td><form:errors path="description" cssClass="error" /></td>
			</tr>


			<form:hidden path="secretValue" />

			<tr>
				<td colspan="3"><input type="submit" /></td>
				<td><input type="button" value="Cancel"
					onCLick="history.back()" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>