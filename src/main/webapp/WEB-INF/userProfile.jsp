<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Document</title>
	<link rel="stylesheet" href="/webjars/font-awesome/css/all.min.css" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<%@include file="includes/menu.jsp" %>
	<div class="container p-4">

		<div class="d-flex justify-content-evenly gap-6">
			<img class="img-perfil"
				src="https://thumbs.dreamstime.com/b/vector-de-perfil-avatar-predeterminado-foto-usuario-medios-sociales-icono-183042379.jpg"
				alt="">
			<div class="d-flex flex-column gap-1 py-4">
				<h1 class="sigmar-one fw-bold my-2 c-red">
					<c:out value="${user.fullName()}"></c:out>
				</h1>
				<h2 class="fw-bold my-2 c-orange">
					<c:out value="${user.email}"></c:out>
				</h2>
			</div>
		</div>

		<div class="px-4 py-3 mt-5">
			<h2 class="sigmar-one fw-bold c-red">Descripción</h2>
		</div>
		<div class="description mx-4 p-4 rounded">
			<c:if test="${not empty user.descriptionPerfil}">
				<p class="c-orange fw-bold fs-4">
					<c:out value="${user.descriptionPerfil}"></c:out>
				</p>
			</c:if>
			<c:if test="${empty user.descriptionPerfil}">
				<p class="c-orange fw-bold fs-2 text-center mt-4 opacity-75">no tiene descripción</p>
			</c:if>
		</div>

		<div class="px-4 py-3 mt-5">
			<h2 class="sigmar-one fw-bold c-red">Géneros que le gusta</h2>
		</div>
		<div>
			<c:if test="${not empty user.genreLikes}">
				<p class="c-orange fw-bold fs-4">
					<c:out value="${user.genreLikes}"></c:out>
				</p>
			</c:if>
			<c:if test="${empty user.genreLikes}">
				<div class="description mx-4 p-4 rounded">
					<p class="c-orange fw-bold fs-2 text-center mt-4 opacity-75">no tiene ninguna preferencia por
						ahora</p>
				</div>
			</c:if>
		</div>

		<div class="px-4 py-3 mt-5">
			<h2 class="sigmar-one fw-bold c-red">Libros que publicó</h2>
		</div>
		<div class="d-flex flex-wrap gap-4 px-3">
			<c:if test="${not empty user.books}">
				<c:forEach items="${user.books}" var="book">
					<a class="book-mini-box" href="/books/${book.id}">
						<div class="p-4 mini-box">
							<img class="mini-portada" src="${book.imageUrl}" alt="">
							<div class="d-flex flex-column justify-content-evenly">
								<h4 class="c-orange fw-bold mt-3">
									<c:out value="${book.title}"></c:out>
								</h4>
								<h5 class="c-cream fw-bold">
									<c:out value="${book.description}"></c:out>...
								</h5>
							</div>
						</div>
					</a>
				</c:forEach>
			</c:if>
			<c:if test="${empty user.books}">
				<div class="description mx-4 p-4 rounded">
					<p class="c-orange fw-bold fs-2 text-center mt-4 opacity-75">no publicó ningún libro</p>
				</div>
			</c:if>
		</div>
	</div>
</body>

</html>