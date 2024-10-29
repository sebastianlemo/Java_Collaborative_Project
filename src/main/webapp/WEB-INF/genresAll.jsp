<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container">
		<a href="/">home</a>
		<a href="/genres/new">Create genre</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>genres</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${genres}" var="genre">
					<tr>
						<td><c:out value="${genre.description}"></c:out></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>