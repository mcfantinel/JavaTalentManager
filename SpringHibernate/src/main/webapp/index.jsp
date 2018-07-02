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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="./static/css/app.css" rel="stylesheet"></link>

</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">People-Ware Recruitment Web App</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="active"><a href="<c:url value='/applicants/listApplicants' />">Applicants</a></li>
			<li><a href="<c:url value='/jobOffers/listJobOffers' />">Job Offers</a></li>
		</ul>

	</div>
	</nav>

</body>

</html>