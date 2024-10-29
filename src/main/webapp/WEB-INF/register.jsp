<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Biblioteca Virtual - Registrarse</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<sec:authorize access="isAuthenticated()">
		<!-- Ya has hecho login, no puedes registrarte -->
		<c:redirect url="/books/new" />
	</sec:authorize>
	<div class="container-custom p-4">
		<c:if test="${successMessage != null}">
			<div class="alert alert-info">
				<c:out value="${successMessage}"></c:out>
			</div>
		</c:if>
		<div class="d-flex justify-content-between align-items-center">
			<a href="/" class="sign bg-sign-up mx-3 fw-bold">Ir al Inicio</a>
		</div>
		<div class="my-3">
			<h1 class="sigmar-one fw-bold ms-3 c-red">Registrarse</h1>
		</div>

		<form:form  action="/users/new" modelAttribute="user" class="form">
			<div class="mb-3">
				<form:label for="firstName" class="form-label" path="firstName">Nombre</form:label>
				<form:input type="text" class="form-control" path="firstName" id="firstName" />
				<form:errors class="text-danger" path="firstName" />
			</div>
			<div class="mb-3">
				<form:label for="lastName" class="form-label" path="lastName">Apellido</form:label>
				<form:input type="text" class="form-control" path="lastName" id="lastName" />
				<form:errors class="text-danger" path="lastName" />
			</div>
			<div class="mb-3">
				<form:label for="email" class="form-label" path="email">Correo</form:label>
				<form:input type="text" class="form-control" path="email" id="email" />
				<form:errors class="text-danger" path="email" />
			</div>
			<div class="mb-3">
				<form:label for="password" class="form-label" path="password">Contraseña</form:label>
				<form:input type="password" class="form-control" path="password" id="password" />
				<form:errors class="text-danger" path="password" />
			</div>
			<div class="mb-3">
				<form:label for="passwordConfirmation" class="form-label" path="passwordConfirmation">Confirmar contraseña
				</form:label>
				<form:input type="password" class="form-control" path="passwordConfirmation" id="passwordConfirmation" />
				<form:errors class="text-danger" path="passwordConfirmation" />
			</div>
			<div class="d-flex gap-3 align-items-center">
				<button class="submit fw-bold">Registrarse</button>
				<p class="c-cream pt-3">si ya se ha registrado <a href="/login" class="c-orange">inicie sesión</a></p>
			</div>
		</form:form>
	</div>

</body>

</html>