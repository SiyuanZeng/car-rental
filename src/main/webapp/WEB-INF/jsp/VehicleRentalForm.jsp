<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>

<title>Vehicle rental ---- Vehicle booking</title>
<script type="text/javascript">
$(document).ready(function(){
	$('#category').change(function (){
		var selectedValue = "category="+$(this).prop('value');
		if (selectedValue == '--- Select ---') {
			$('#category').empty();
		} else {
			$.post('http://localhost:8080/car-rental/vehicleRental.htm?registrationNumber=true', selectedValue, function(data) {
				$('#registrationNumber').empty();
				$.each(data, function(key, value) {
					$('#registrationNumber').append($('<option/>', {
						value : value.registrationNumber,
						text : value.registrationNumber
					}));
				});
			}, 'json');
		}
	});

	$('#bookedTo').blur(function () {
		var $f = $(this).closest("form");
		if ($('#bookedFrom').val() && $('#bookedTo').val()){

		var sDate = $('#bookedFrom').val();
		var eDate = $('#bookedTo').val();

		var day = sDate.split("-")[0];
		var month = sDate.split("-")[1];
		var reg = $('#registrationNumber').val();
		var year = sDate.split("-")[2];

		var day1 = eDate.split("-")[0];
		var month1 = eDate.split("-")[1];
		var year1 = eDate.split("-")[2];

		var date1 = new Date(year - 1900, month - 1, day);
		var date2 = new Date(year1 - 1900, month1 - 1, day1);

		var diff = date2.getTime() - date1.getTime();
		diff = diff / (1000 * 60 * 60 * 24);

		var days = day1 - day;
		if (day < days && month == month1 && year == year1) {
			days = day1 - day;
		} else {
			if (month > month1 || day > day1) {
				if (year > year1) {
					return false;
				}
			} else {
				days = 30 * (month1 - month);
			}
		}
		$.calculateRent(diff, reg );
	}
		else{
			alert("Please put valid date");
			return;
		}


	});

	$.calculateRent = function( days, r ) {
		url = "http://localhost:8080/car-rental/vehicleRental.htm?rent=true&registrationNumber=" + r + "&days=" + days;
		var xhr;
		xhr = new XMLHttpRequest();
		xhr.open("GET", url, true);
		xhr.send(null);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				document.getElementById("totalRent").value = xhr.responseText;
			}
		};
	};


});


</script>
</head>
<body>
	<center><h2>Rent a Vehicle</h2></center>
	<h3>
		<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("user") == null) {
			response.sendRedirect("login.html");
		} else
			user = (String) session.getAttribute("user");
	%>
		Username :
		<%=user%></h3>
	<form:form method="POST" name="vehicleRental" commandName="vehicleRental">

		<form:errors path="*" cssClass="errorblock" element="div" />

		<table>
			<tr>
				<td>Customer Name :</td>
				<td><form:input path="customerName" /></td>
				<td><form:errors path="customerName" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Category :</td>
				<td><form:select path="category" onchange="fnGetCategory(this)">
						<form:option value="NONE" label="--- Select ---" />
						<c:forEach items="${categoryList}" var="c">
							<option value="${c.category}">${c.category}</option>
						</c:forEach>
					</form:select></td>
				<td><form:errors path="category" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Vehicle Registration Number</td>
				<td>
					<div>
						<form:select path="registrationNumber">
							<form:option value="NONE" label="--- Select ---"></form:option>
						</form:select>
					</div>
				</td>
				<td><form:errors path="registrationNumber" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Booked From</td>
				<td><form:input path="bookedFrom"></form:input></td>
				<td><form:errors path="bookedFrom" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Booked To</td>
				<td><form:input path="bookedTo"	onblur="fnGetTotalRent(this.form)"></form:input></td>
				<td><form:errors path="bookedTo" cssClass="error" /></td>
			</tr>


			<tr>
				<td>Total Rent</td>
				<td>
					<div id="rent">
						<form:input path="totalRent"></form:input>
					</div>

				</td>
				<td><form:errors path="totalRent" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Payment Rec<form:hidden path="paymentStatus" value=""></form:hidden></td>
				<td><form:checkbox path="paymentStatus" value="paid" ></form:checkbox></td>
				<td><form:errors path="paymentStatus" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></input></td>
				<td><input type="button" value="Cancel"
					onclick="javascript:window.location='welcome'" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>