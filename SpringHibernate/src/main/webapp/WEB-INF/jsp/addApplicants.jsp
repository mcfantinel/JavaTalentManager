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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People-Ware - Add Applicant</title>
</head>
<body>
<div id="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand">People-Ware Recruitment Web App</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a
					href="<c:url value='/applicants/listApplicants' />">Applicants</a></li>
				<li><a href="<c:url value='/jobOffers/listJobOffers' />">Job Offers</a></li>
			</ul>

		</div>
		</nav>
	</div>
	
	<br />
	<br />
	<br />
	<br />
	<div class="container">
		<div class="well lead">Add Applicant</div>

		<form:form method="post" modelAttribute="applicant"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="fullName">Full
						Name</label>
					<div class="col-md-7">
						<form:input type="text" path="fullName"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="fullName" class="help-inline text-danger" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline text-danger" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Contact
						Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="phone" class="help-inline  text-danger" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="minSalary">Minimum
						Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="minSalary"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="minSalary" class="help-inline  text-danger" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="workingTime">Working
						Time</label>
					<div class="col-md-7">
						<form:radiobutton path="workingTime" value="FULL_TIME" />
						Full Time
						<form:radiobutton path="workingTime" value="PART_TIME" />
						Part Time
						<form:radiobutton path="workingTime" value="BOTH" />
						Both
						<div class="has-error">
							<form:errors path="workingTime" class="help-inline  text-danger" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="academicDegree">Academic
						Degree</label>
					<div class="col-md-7">
						<form:select path="academicDegree.id"
							items="${academicDegreesList}" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="academicDegree" class="help-inline  text-danger" />
						</div>
					</div>
				</div>
			</div>

			<div class="has-error">
				<form:errors path="applicantSkills" class="help-inline text-danger" />
			</div>
			<c:forEach items="${skillsList}" var="skill" varStatus="s">
				<div class="row skill_class" id="skill_${s.index}">
					<div class="form-group col-md-4">
						<label class="col-md-2 control-lable"
							for="applicantSkills[${s.index}].skill.skill">Skill</label>
						<div class="col-md-4">
							<form:input type="hidden"
								path="applicantSkills[${s.index}].skill.id"
								class="form-control input-sm" value="${skill.id}" />
							<form:input type="text"
								path="applicantSkills[${s.index}].skill.skill"
								class="form-control input-sm" disabled="true"
								value="${skill.skill}" />
						</div>
					</div>
					<div class="form-group col-md-7">
						<label class="col-md-2 control-lable"
							for="applicantSkills[${s.index}].scale">Scale</label>
						<div class="col-md-5">
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="0" />
							None
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="1" />
							1
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="2" />
							2
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="3" />
							3
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="4" />
							4
							<form:radiobutton path="applicantSkills[${s.index}].scale"
								value="5" />
							5
							<div class="has-error">
								<form:errors path="applicantSkills[${s.index}].scale"
									class="help-inline error" />
							</div>
						</div>
					</div>
				</div>
			</c:forEach>

			<!-- <a id="btnAddSkill" class="btn btn-primary btn-sm">Add Skill</a> -->

			<div class="row">
				<div class="form-actions text-center">
					<input type="submit" value="Submit" id="btn"
						class="btn btn-primary btn-sm" /> <input type="reset"
						value="Reset" class="btn btn-primary btn-sm" />
				</div>
			</div>
		</form:form>

	</div>
	
	<br />
	<br />
	
	<div id="footer">
		<div class="clearfix">
			<div id="connect">
				<a href="#" target="_blank" class="facebook"></a> <a href="#"
					target="_blank" class="googleplus"></a> <a href="#" target="_blank"
					class="twitter"></a>
			</div>
			<p>© 2018 People-Ware. No Rights Reserved.</p>
		</div>
	</div>
	
	<br />
	<br />

</body>
</html>
