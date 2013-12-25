<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle rental ---- Vehicle booking</title>
<script type="text/javascript">
	function fnGetCategory(category) {

		var cat = category.options[category.selectedIndex].value;
		var Url = "getRegNo.action?category=" + cat;
		var xhr;

		xhr = new XMLHttpRequest();
		//alert(cat);

		xhr.open("GET", Url, true);
		xhr.send(null);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				//alert(xhr.responseText);
				document.getElementById("reg").innerHTML = xhr.responseText;
			}
		};

	}
	function fnGetTotalRent(f) {
		var sDate = f.booked_from.value;
		var eDate = f.booked_to.value;
		alert(f.reg_no);
		var reg = f.reg_no.options[f.reg_no.selectedIndex].value;

		var day = sDate.split("-")[0];
		var month = sDate.split("-")[1];
		var year = sDate.split("-")[2];

		var day1 = eDate.split("-")[0];
		var month1 = eDate.split("-")[1];
		var year1 = eDate.split("-")[2];

		var date1 = new Date(year - 1900, month - 1, day);
		var date2 = new Date(year1 - 1900, month1 - 1, day1);

		var diff = date2.getTime() - date1.getTime();
		diff = diff / (1000 * 60 * 60 * 24);

		//alert("diff="+diff);

		var days = day1 - day;
		if (day < days && month == month1 && year == year1) {
			days = day1 - day;
		} else {
			if (month > month1 || day > day1) {
				if (year > year1) {
					alert("booked from/start date should be less then booked to/end date");
					return false;
				}
			} else {
				days = 30 * (month1 - month);
			}
		}
		calculateRent(diff, reg);
	}
	function calculateRent(days, r) {
		url = "getRent.action?r=" + r + "&days=" + days;
		var xhr;

		xhr = new XMLHttpRequest();

		xhr.open("GET", url, true);
		xhr.send(null);
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				alert(xhr.responseText);
				document.getElementById("total_rent").value = xhr.responseText;
			}

		};

	}
</script>

</head>
<body>
	<center>
		<h1>Vehicle Rental Application ---- Vehicle booking</h1>
	</center>
	<hr />
	<form action="bookVehicleForm.action" method="post">
		<table>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="customer_name"></input></td>
			</tr>
			<tr>
				<td>Category</td>
				<td><select name="category" onchange="fnGetCategory(this)">
						<option>Select category</option>
						<c:forEach items="${requestScope.v}" var="v">
							<option value="${v.category}">${v.category}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Vehicle Registration Number</td>
				<td>
					<div id="reg">
						<select name="reg_no">
							<option>Select</option>
						</select>
					</div>
				</td>
			</tr>


			<tr>
				<td>Booked From</td>
				<td><input type="text" name="booked_from"></input></td>
			</tr>
			<tr>
				<td>Booked To</td>
				<td><input type="text" name="booked_to"
					onblur="fnGetTotalRent(this.form)"></input></td>
			</tr>


			<tr>
				<td>Total Rent</td>
				<td>
					<div id="rent">
						<input type="text" name="total_rent" id="total_rent"></input>
					</div>

				</td>
			</tr>
			<tr>
				<td>Payment Rec</td>
				<td><input type="checkbox" name="payment" value="paid"></input></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></input></td>
				<td><input type="button" value="Cancel"
					onclick="javascript:window.location='index.jsp'" /></td>
			</tr>

		</table>
	</form>
</body>
</html>