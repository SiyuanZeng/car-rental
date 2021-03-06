<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="/WEB-INF/tags/login.tld"  prefix="i18N"%>
<html>
<head>
<title>Login Page</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.8.0.min.js"></script>
	<script src="<c:url value="/resources/js/Watermark/jquery.watermark.js" />" ></script>
<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}

/*this is auto applied  */
.watermark {
    color: #999999 !important;
}

</style>
</head>
<body onload='document.f.j_username.focus();'>
	<center>
	<h3>Login with Username and Password (Custom Page)</h3>
	<%
		//allow access only if session exists
		String user = null;
		if (session.getAttribute("user") != null)
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
	Welcome, <%=userName%> !

	</br>
	</br>

	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>


	<form name='f' action="<c:url value='j_spring_security_check' />"
		method='POST'>

		<table>
			<tr>
				<td><i18N:message key="user" /></td>
				<td><input type='text' id='username' name='j_username' value=''></td>
			</tr>
			<tr>
				<td><i18N:message key="password" /></td>
				<td><input type='password' id='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit"
					value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
			<tr>
			</tr>
		</table>

	</form>
	</center>

<script type="text/javascript">
	$(function () {
		$("#username").watermark("User Name",{useNative:false});/*this is optional, can be true, then it will always be there.  */
		$("#password").watermark("Password", {useNative: false});
	});

</script>

</body>
</html>