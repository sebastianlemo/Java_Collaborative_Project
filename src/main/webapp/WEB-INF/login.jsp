<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Biblioteca Virtual - Iniciar sesión</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<sec:authorize access="isAuthenticated()">
		<!-- Ya has hecho login, ¿qué haces aquí? -->
		<c:redirect url="/books/new" />
	</sec:authorize>
	<div class="container-custom p-4">
		<c:if test="${errorMessage != null}">
			<div class="alert alert-danger">
				<c:out value="${errorMessage}"></c:out>
			</div>
		</c:if>
		<c:if test="${successMessage != null}">
			<div class="alert alert-success">
				<c:out value="${successMessage}"></c:out>
			</div>
		</c:if>
		<div class="d-flex align-items-center">
			<a href="/" class="sign bg-sign-up mx-3 fw-bold">Ir al Inicio</a>
		</div>
		<div class="my-3">
			<h1 class="sigmar-one fw-bold ms-3 c-red">Iniciar sesión</h1>
		</div>
		<form action="/login" method="post" class="form p-5 rounded d-flex flex-column">
			<div class="mb-3">
				<label class="form-label" for="">Correo</label>
				<input class="form-control" type="email" name="email">
			</div>
			<div class="mb-3">
				<label class="form-label" for="">Contraseña</label>
				<input class="form-control" type="password" name="password">
			</div>
			<span class="text-danger ">
				<c:out value="${userError}" />
			</span>
			<br>
			<div class="d-flex gap-3 align-items-center">
				<button class="submit fw-bold">Iniciar sesión</button>
				<p class="c-cream pt-3">si es su primera vez aquí <a href="/users/new" class="c-orange">regístrese</a></p>
			</div>
		</form>
	</div>
</body>

</html>