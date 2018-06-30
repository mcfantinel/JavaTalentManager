<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
	<spring:url value="/users/add" var="userActionUrl" />
	<form:form method="post" action="${userActionUrl}" modelAttribute="userForm">
		<table>
			<tr>
				<td><form:label path="username">
						<spring:message text="Username" />
					</form:label></td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td><form:label path="creationDate">
						<spring:message text="Creation Date" />
					</form:label></td>
				<td><form:input path="creationDate" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message text="Add User"/>" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>