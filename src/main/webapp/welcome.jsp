<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="myerr.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
<script src="https://code.jquery.com/jquery-3.7.1.js"
	crossorigin="anonymous"></script>
<script src="myScript.js"></script>
</head>
<body class="text-bg-dark">
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
	<div class="container-fluid">
		<div class="text-bg-primary rounded p-5 m-5">
			<div class="row">
				<div class="col-sm-12">
					<div class="alert alert-success alert-dismissible fade show">
						<button class="btn-close" data-bs-dismiss="alert"></button>
						<span class="display-6">${greeting }</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<a class="d-block btn btn-outline-light mt-4 w-100"
						href="index.html">Home</a>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="p-5 m-5 text-bg-light rounded">
						<h1>Registered people:</h1>
						<div class="fs-4">
							<c:forEach items="${people }" var="person">
								<div id="${person.aadhaar }record">
									<c:set var="highlightClass"
										value="${aadhaarNumber == person.aadhaar ? 'text-success fw-bold fs-1 border border-danger border-3 rounded-pill px-3 mx-3 deletable' : ''}" />
									<span class="${highlightClass }">
										<c:out
											value="${person.aadhaar } ${person.fname } ${person.lname }" />
									</span>
									<c:if test="${aadhaarNumber == person.aadhaar }">
										<button id="deleteButton" class="btn-close text-bg-danger"
											title="delete person"></button>
										<span id="deleteAadhaar" hidden>${person.aadhaar }</span>
										<span id="deletedMessage" class="fw-bold text-bg-danger p-2"
											hidden="true"
											title="you can register the aadhaar again as a new user">Deleted aadhaar ${person.aadhaar } redirecting to home...</span>
									</c:if>
									<br />
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>