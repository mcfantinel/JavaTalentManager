<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>
<h3>Users List</h3>
<c:if test="${!empty users}">
	<table class="tg">
	<tr>
		<th width="80">User ID</th>
		<th width="120">UserName</th>
		<th width="120">Creation Date</th>
	</tr>
	<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.username}</td>
			<td>${user.creationDate}</td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>