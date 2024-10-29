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
		<h1 class="fs-1">Respuestas para <c:out value="${quest.text}" /></h1>
		<form action="/answers/${quest.id}/new" method="post" class="form">
			<c:forEach var="i" begin="1" end="4">
				<label class="form-label" for="alternativa${i}">alternativa${i}</label>
				<input class="form-control" type="text" id="alternativa${i}" name="answers">

			</c:forEach>
			<button>Enviar</button>
		</form>
	</div>
</body>
</html>