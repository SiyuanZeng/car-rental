<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>SimpleAjaxDemo</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$('#specimenType').change(function () {
		var selectedValue = $(this).prop('value');
		alert("abc");
		if (selectedValue == '-- Select a specimen type --') {
			$('#specimenName').empty();
		} else {
			alert("post")
			$.post('http://localhost:8080/car-rental/exchangejson', selectedValue, function(data) {
				var specimenNameList = data.specimenNameList;
				$('#specimenName').empty();
				$.each(specimenNameList, function(key, value) {
					$('#specimenName').append($('<option/>', {
						value : value,
						text : value
					}));
				});
			}, 'json');
		}
	});
});
</script>
</head>
<body>
	<form:form method="post" modelAttribute="specimen">
	<fieldset>
    	<legend>SimpleAjaxDemo:</legend>
		<table>
			<tr>
				<td align="right">Select Specimen Type: </td>
				<td><form:select id="specimenType" path="specimenType" items="${specimenTypeList}"></form:select></td>
			</tr>
			<tr>
				<td align="right">Select Specimen Name: </td>
				<td><form:select id="specimenName" path="specimenName"></form:select></td>
			</tr>
		</table>
	</fieldset>
	</form:form>
</body>
</html>