<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<select name="reg_no">
	<option>Select</option>
	<c:forEach items="${vehicle}" var="v">
		<option>${v.registrationNumber}</option>
	</c:forEach>
</select>
