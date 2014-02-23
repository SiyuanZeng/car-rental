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

#category {
	width: 155px;
}

#content {
	text-align: center;
}


#description {
	width: 155px;
}

#submitButton,#cancelButton {
	margin-top: 25px;
}



</style>

<title>Seed - Add a task</title>


</head>
<body>
	<div id="content">
		<!-- start of page content -->

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
			<%=user%>

		</h3>


		<%@include  file="EditableGrid/EditableGrid_addTask.html" %>
		<form:form id="taskForm" method="POST" name="task" commandName="task">

			<form:errors path="*" cssClass="errorblock" element="div" />

			<table>
				<tr>
					<td>Task Name :</td>
					<td><form:input path="name" ></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="name" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Deadline :</td>
					<td><form:input path="deadline"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="deadline" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Start Time :</td>
					<td><form:input path="startTime"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="startTime" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Time Requirement:</td>
					<td><form:input path="time"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="time" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Happy Time :</td>
					<td><form:input path="happyTime"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="happyTime" cssClass="error" /></td>
				</tr>
				<tr>
					<td>End Time :</td>
					<td><form:input path="endTime"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="endTime" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Category :</td>
					<td><form:input path="category.name"></form:input></td>
					<td><form:errors path="category.name" cssClass="error" /></td>

				</tr>

				<tr>
					<td>Description :</td>
					<td><form:textarea path="description" /></td>
					<td></td>
					<td></td>
					<td><form:errors path="description" cssClass="error" /></td>
				</tr>


				<tr>
					<td></td>
					<td><input id="submitButton" type="submit" value="Save"></input></td>
					<td><input id="cancelButton" type="button" value="Cancel" onclick="javascript:window.location='welcome'" /></td>
					<td></td>
				</tr>
			</table>
		</form:form>

	</div>



</body>


</html>

<link href="<c:url value="/resources/css/jquery.datepick.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery.datepick.js" />"></script>

<!-- time picker -->
<link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.21/themes/redmond/jquery-ui.css" />

<!-- time picker Plugin files below -->
<link href="<c:url value="/resources/css/ptTimeSelect/jquery.ptTimeSelect.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/ptTimeSelect/jquery.ptTimeSelect.js" />"></script>

<script type="text/javascript">

	$(document).ready((function() { $('#deadline').datepick(); }));

	// time picker
    $(document).ready(function(){ $('#startTime, #happyTime, #endTime').ptTimeSelect(); });


	// time calculation
	$(document).ready(function(){
		  $("#time").blur(function(){
			  if (($('#startTime').val() != '') && ($('#time').val() != '')){

					var startTime = $('#startTime').val();
					var time = $('#time').val();

					var piece = startTime.split(/[\:\s]/);

				    var mins = piece[0]*60 + +piece[1] + parseInt(time);
					var hour = mins%(24*60)/60 | 0;
					var minute = $.adjustDigits(mins%60);

					var str ="";
					if (hour>=13){ hour = hour -12; str= hour+":" +minute+" " +"PM"; }
					if (hour<12){  str= hour.toString()+":"+ minute.toString()+" AM";}
					if(hour>=12 && hour < 13) {str=hour+":" +minute+" " + "PM";}
					$('#endTime').val(str);
			  }
			});

			$.adjustDigits=function (J){ return (J<10? '0':'') + J; };
});



</script>
