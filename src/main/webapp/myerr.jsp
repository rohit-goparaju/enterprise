<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Following error occured</h1>
	<h2>Error Message</h2>
		<%= exception.getMessage() %><br><hr>
	<h2>Stack Trace</h2>
	<% exception.printStackTrace(new PrintWriter(out)); %>
	<br>
	<a href="index.html">Back to home</a>
</body>
</html>