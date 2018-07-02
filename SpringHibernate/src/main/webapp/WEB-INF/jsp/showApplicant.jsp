<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People-Ware - Show Applicant</title>
</head>
<body>
	<div class="container">
		<div class="well lead">Show Applicant</div>

		<form:form method="post" modelAttribute="applicant"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="fullName">Full
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="fullName"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" class="form-control input-sm"
							disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Contact
						Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" class="form-control input-sm"
							disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="minSalary">Minimum
						Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="minSalary"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="workingTime">Working
						Time</label>
					<div class="col-md-7">
						<form:input type="text" path="workingTime"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="academicDegree.name">Academic
						Degree</label>
					<div class="col-md-7">
						<form:input type="text" path="academicDegree.name"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>

		</form:form>

		<br /> <br />

		<div class="generic-container">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">Applicants Skills</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Skill</th>
							<th>Scale</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${applicant.applicantSkills}"
							var="applicantSkills">
							<tr>
								<td>${applicantSkills.skill.skill}</td>
								<td>${applicantSkills.scale}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

			<br /> <br />

			<div class="generic-container">
				<div class="panel panel-default">
					<!-- Default panel contents -->
						<div class="panel-heading">
							<span class="lead">Job Offers That Matches Applicant</span>
						</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Job Offer</th>
									<th>Company</th>
									<th>Contact Number</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${qualifiedJobOffers}" var="qualifiedJobOffer">
									<tr>
										<td>${qualifiedJobOffer.jobOffer.name}</td>
										<td>${qualifiedJobOffer.jobOffer.company.name}</td>
										<td>${qualifiedJobOffer.jobOffer.company.phone}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

		</div>
</body>
</html>
