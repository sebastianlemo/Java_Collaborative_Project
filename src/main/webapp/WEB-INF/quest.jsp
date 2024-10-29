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
<body class="container-sm">
	<h1 class="fs-1">Preguntas para <c:out value="${book.title}" /></h1>

	<form:form action="/quests/${book.id}/new" method="post" modelAttribute="quest" class="form">

			<form:label class="form-label fs-2" path="text">pregunta</form:label>
			<form:input class="col-sm-6 form-control" type="text" path="text" id="text" />
			<form:errors class="text-danger" path="text" />

			<div class="text-end py-2 mt-4">
				<button type="submit" class="btn btn-primary fw-bold">Guardar</button>
			</div>
		</form:form>
</body>
</html>