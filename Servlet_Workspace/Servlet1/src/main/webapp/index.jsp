<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jeevan </title>
<link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/css/style.css">
</head>
<body>
<div class="container">
<a>This is me</a>
</div>
<h1>This is Servlet1</h1>
<form action="<%= application.getContextPath()%>/third" method="post">
<input name="message" placeholder="enter something" tpe="text">
<button type="submit">Submit</button>
</form>
</body>
</html>