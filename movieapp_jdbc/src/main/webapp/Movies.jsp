<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Movie</title>
</head>
<body>
	<p>
		<h1>Movies</h1>
		<ul>
			<c:forEach items="${movies}" var="m">
				<li>${m} <!--  ${m.title} (${m.year})  -->
			</c:forEach>
		</ul>
	</p>
</body>
</html>