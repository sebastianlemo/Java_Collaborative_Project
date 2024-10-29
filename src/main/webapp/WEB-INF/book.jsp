<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Biblioteca Virtual - Libro</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<div class="container-custom p-4">
		<div class="d-flex align-items-center">
			<a href="/" class="sign bg-sign-up mx-3 fw-bold">ir al Inicio</a>
		</div>
		<div class="my-3">
			<h1 class="sigmar-one fw-bold ms-3 c-red">Crear libro</h1>
		</div>
		<form:form action="/books/new" modelAttribute="book" class="form">
			<div class="mb-3">
				<form:label for="title" class="form-label" path="title">Título</form:label>
				<form:input type="text" class="form-control" path="title" />
				<form:errors class="text-danger" path="title" />
			</div>
			<div class="mb-3">
				<form:label for="description" class="form-label" path="description">Descripción</form:label>
				<form:textarea rows="4" class="form-control" path="description" />
				<form:errors class="text-danger" path="description" />
			</div>
			<div class="mb-3">
				<form:label for="numberOfPages" class="form-label" path="numberOfPages">N° de páginas</form:label>
				<form:input type="number" class="form-control" path="numberOfPages" />
				<form:errors class="text-danger" path="numberOfPages" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="genres">genres</form:label>
				<div class="d-flex flex-column mt-2 px-3 gap-2 c-cream">
					<form:checkboxes class="mx-2" path="genres" items="${genres}" itemLabel="description"
						itemValue="id" />
				</div>
			</div>
			<div class="mb-3">
				<form:label for="imageUrl" class="form-label" path="imageUrl">url de la portada</form:label>
				<form:input type="text" class="form-control" path="imageUrl" />
				<form:errors class="text-danger" path="imageUrl" />
			</div>
			<div class="d-flex gap-3 align-items-center my-2">
				<button class="submit fw-bold">Guardar</button>
			</div>

		</form:form>
	</div>

</body>

</html>