<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="container-sm">
		<h1 class="fs-1">Respuesta correcta de <c:out value="${quest.text}" /></h1>
		<form action="/answers/${quest.id}/correct" method="post" class="form">
			<label class="form-label fs-2" for="answerId">Elige la respuesta correcta</label><br>
			<c:forEach items="${quest.answers}" var="answer">
				<input type="radio" id="${answer.text}" name="answerId" value="${answer.id}">
				<label class="form-label" for="${answer.text}">${answer.text}</label><br>
			</c:forEach>
			<div class="text-end">
				<button type="submit" class="btn btn-primary fw-bold">Enviar</button>
			</div>
		</form>
	</div>
</body>
</html>