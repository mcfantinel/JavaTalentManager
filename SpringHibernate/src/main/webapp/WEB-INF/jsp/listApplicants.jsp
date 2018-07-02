<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<style type="text/css">
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People-Ware - List Applicants</title>
</head>

<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading">
				<span class="lead">Applicants</span>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Contact Number</th>
						<th>Minimum Salary</th>
						<th>Working Time</th>
						<th>Academic Degree</th>
						<th width="100"></th>
						<th width="100"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listApplicants}" var="applicant">
						<tr>
							<td>${applicant.fullName}</td>
							<td>${applicant.email}</td>
							<td>${applicant.phone}</td>
							<td>${applicant.minSalary}</td>
							<td>${applicant.workingTime}</td>
							<td>${applicant.academicDegree.name}</td>
							<td><a href="<c:url value='/edit-emp-${applicant.id}' />"
								class="btn btn-success custom-width">view</a></td>
							<td><a href="<c:url value='/delete-emp-${applicant.id}' />"
								class="btn btn-danger custom-width">delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="well">
			<a href="<c:url value='/addemp.do' />">Add New Applicant</a>
		</div>
	</div>
</body>

</html>