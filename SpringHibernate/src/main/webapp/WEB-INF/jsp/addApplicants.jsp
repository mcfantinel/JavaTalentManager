<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People-Ware - Add Applicant</title>
</head>
<body>
	<div class="container">
		<div class="well lead">Add Applicant</div>

		<form:form method="post" modelAttribute="applicant" class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="fullName">Full Name</label>
					<div class="col-md-7">
						<form:input type="text" path="fullName" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Contact Phone</label>
					<div class="col-md-7">
						<form:input type="text" path="phone" class="form-control input-sm" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="minSalary">Minimum Salary</label>
					<div class="col-md-7">
						<form:input type="text" path="minSalary" class="form-control input-sm" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="workingTime">Working Time</label>
					<div class="col-md-7">
						<form:radiobutton path="workingTime" value="FULL_TIME" /> Full Time
						<form:radiobutton path="workingTime" value="PART_TIME" /> Part Time
						<form:radiobutton path="workingTime" value="BOTH" /> Both
						<div class="has-error">
							<form:errors path="workingTime" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="academicDegree">Academic Degree</label>
					<div class="col-md-7">
						<form:select path="academicDegree.id" items="${academicDegreesList}" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="academicDegree" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatLeft">
					<input type="submit" value="Submit" id="btn" class="btn btn-primary btn-sm" /> 
					<input type="reset"	value="Reset" class="btn btn-primary btn-sm" />
				</div>
			</div>

		</form:form>
		
		<br />
		<br />
		
		<form:form method="post" modelAttribute="applicantSkills" class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />
			
			<div class="row">
				<div class="form-group col-md-6">
					<label class="col-md-2 control-lable" for="skill">Skill</label>
					<div class="col-md-4">
						<form:select path="skill.id" items="${skillsList}" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="skill" class="help-inline" />
						</div>
					</div>
				</div>
				<div class="form-group col-md-6">
					<label class="col-md-2 control-lable" for="scale">Scale</label>
					<div class="col-md-4">
						<form:radiobutton path="scale" value="1" /> 1
						<form:radiobutton path="scale" value="2" /> 2
						<form:radiobutton path="scale" value="3" /> 3
						<form:radiobutton path="scale" value="4" /> 4
						<form:radiobutton path="scale" value="5" /> 5
						<div class="has-error">
							<form:errors path="scale" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatLeft">
					<input type="submit" value="Add" id="btn" class="btn btn-primary btn-sm" /> 
					<input type="reset"	value="Reset" class="btn btn-primary btn-sm" />
				</div>
			</div>

		</form:form>
	</div>

</body>
</html>