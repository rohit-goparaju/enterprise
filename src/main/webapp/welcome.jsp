<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="vh-100 d-flex justify-content-center align-items-center">
			<div class="w-75 text-bg-primary rounded p-5 d-flex flex-column justify-content-center align-items-center display-1" style="height: 200px;">
				Welcome ${name}
				<a class="d-block btn btn-outline-light mt-4 w-50" href="index.html">Home</a>
			</div>
		</div>
	</div>
</body>
</html>