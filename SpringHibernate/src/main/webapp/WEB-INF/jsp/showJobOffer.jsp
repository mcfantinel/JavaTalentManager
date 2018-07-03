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
<title>People-Ware - Show Job Offer</title>
</head>
<body>
	<div class="container">
		<div class="well lead">Show Job Offer</div>

		<form:form method="post" modelAttribute="jobOffer"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="name">Name</label>
					<div class="col-md-7">
						<form:input type="text" path="name" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="description">Description</label>
					<div class="col-md-7">
						<form:input type="text" path="description" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="company.name">Company</label>
					<div class="col-md-7">
						<form:input type="text" path="company.name" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="minSalary">Minimum Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="minSalary" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="maxSalary">Maximum Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="maxSalary" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="workingTime">Working Time</label>
					<div class="col-md-7">
						<form:input type="text" path="workingTime"
							class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="academicDegree.name">Academic Degree</label>
					<div class="col-md-7">
						<form:input type="text" path="academicDegree.name" class="form-control input-sm" disabled="true" />
					</div>
				</div>
			</div>

		</form:form>

		<br /> <br />

		<div class="generic-container">
			<div class="panel panel-default">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<span class="lead">Job Offer Skills</span>
				</div>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Skill</th>
							<th>Scale</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobOffer.jobOfferSkills}" var="jobOfferSkills">
							<tr>
								<td>${jobOfferSkills.skill.skill}</td>
								<td>${jobOfferSkills.scale}</td>
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
							<span class="lead">Applicants That Matches Job Offer</span>
						</div>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>Email</th>
									<th>Contact Number</th>
									<th>Total Points</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${qualifiedApplicants}" var="qualifiedApplicant">
									<tr>
										<td>${qualifiedApplicant.applicant.fullName}</td>
										<td>${qualifiedApplicant.applicant.email}</td>
										<td>${qualifiedApplicant.applicant.phone}</td>
										<td>${qualifiedApplicant.totalPoints}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

		</div>
</body>
</html>
