<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="myerr.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="text-bg-dark">
	<div class="container-fluid">
			<div class="text-bg-primary rounded p-5 m-5 d-flex flex-column justify-content-center align-items-center flex-nowrap display-1">
				Welcome ${name}
				<a class="d-block btn btn-outline-light mt-4 w-50" href="index.html">Home</a>
				<div class = "p-5 m-5 text-bg-light rounded">
					<h1>Registered people:</h1>
					<div class="display-6">
						<c:forEach items="${people }" var="person">
							<c:set var="highlightClass" value="${aadhaarNumber == person.aadhaar ? 'text-success fw-bold' : ''}"/>
							<span class=${highlightClass }>
								<c:out value="${person.aadhaar } ${person.fname } ${person.lname }"/><br/>
							</span>
						</c:forEach>
					</div>
				</div>
			</div>
	</div>
</body>
</html>