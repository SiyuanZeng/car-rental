<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>

<link href="<c:url value="/resources/css/jquery.datepick.css" />" rel="stylesheet">
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jquery.datepick.js" />"></script>
<script type="text/javascript">

	$(function() { $('#deadline').datepick(); });

</script>

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

#taskForm {
	padding: 20px;
	width: 500px;
	display: block;
	background: #FAFAFA;
	margin: 0 auto;
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
		<h1>Create a Task</h1>
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

		<%@include  file="EditableGrid/EditableGrid.html" %>
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
					<td>Time Requirement:</td>
					<td><form:input path="time"></form:input></td>
					<td></td>
					<td></td>
					<td><form:errors path="time" cssClass="error" /></td>
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
					<td><input id="cancelButton" type="button" value="Cancel"
						onclick="javascript:window.location='welcome'" /></td>
					<td></td>
				</tr>
			</table>
		</form:form>

	</div>



</body>


</html>
