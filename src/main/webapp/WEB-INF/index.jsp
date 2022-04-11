<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Books</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container w-100 h-100">
	<h1>All Books</h1>
	<table class="table table-striped w-100">
		<tr>
			<th scope="col">ID</th>
			<th scope="col">Title</th>
			<th scope="col">Language</th>
			<th scope="col">Number of Pages</th>
		</tr>
		<c:forEach var="oneBook" items="${books}">
			<tr>
				<th scope="row"><c:out value="${oneBook.id}"></c:out></th>
				<td><a href="/books/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
				<td><c:out value="${oneBook.language}"></c:out></td>
				<td><c:out value="${oneBook.numberOfPages}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>
