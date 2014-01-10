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

<title>Seed - Review a task</title>


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
		<div id="clock">
			<%@include  file="Clock/Clock.html" %>
		</div>
		<%@include  file="EditableGrid/EditableGrid_reviewTask.html" %>
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

