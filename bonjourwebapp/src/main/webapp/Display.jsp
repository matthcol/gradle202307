<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello GoodBye</title>
</head>
<body>
<h1>${title}</h1>
<p>You've reached this place with HTTP method: ${method}</p>
<p>${place} it's ${clock}</p>
<p>Parameter(s) of the request:
<ul>
<% for (Map.Entry<String,String[]> p : request.getParameterMap().entrySet()) {%>
	<li><%= p.getKey() %>: <%= Arrays.toString(p.getValue()) %>
<% } %>
</ul>
</body>
</html>