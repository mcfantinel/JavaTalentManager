<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>People-Ware Recruitment</title>

</head>
<body>
	<div id="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a href="<c:url value='/' />" class="navbar-brand">People-Ware Recruitment Web App</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="<c:url value='/applicants/listApplicants' />">Applicants</a></li>
				<li><a href="<c:url value='/jobOffers/listJobOffers' />">Job Offers</a></li>
			</ul>
		</div>
		</nav>
	</div>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">People-Ware Recruitment App</h1>
			<p>This webpage was developed by Manoel Capaverde as a recruitment management web app for People-Ware.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="<c:url value='/applicants/addApplicants' />" role="button">New Applicants</a>
				<a class="btn btn-primary btn-lg" href="<c:url value='/jobOffers/addJobOffers' />" role="button">New Job Offers</a>
			</p>
		</div>
	</div>
	
	<br />
	<br />

	<div id="footer">
		<div class="clearfix">
			<p> © 2018 People-Ware. No Rights Reserved.</p>
		</div>
	</div>
	<br />
	<br />
</body>

</html>