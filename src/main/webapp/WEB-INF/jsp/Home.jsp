<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<h1>Home Page</h1>
	<%-- No caching --%>


	<%-- 设置标头 --%>
	<%
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
	%>
	Welcome,.
	<br />
	<a href="Signout">Sign Out</a>
	<br />
	<a href="Inbox"> Goto Inbox</a>
</body>
</html>