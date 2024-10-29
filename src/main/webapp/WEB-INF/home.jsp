<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Biblioteca Virtual - Inicio</title>
	<link rel="stylesheet" href="/webjars/font-awesome/css/all.min.css" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<%@include file="includes/menu.jsp" %>
	<div class="container">
		<c:if test="${not empty sessionScope}">
			<a href="/logout">Cerrar sesión</a>
		</c:if>

		<form action="/search" method="post">
			<div class="d-flex align-items-center gap-2 justify-content-center mt-3">
				<input class="form-control search rounded-pill p-1 px-4 mx-2" name="title" type="search"
					placeholder="buscar">
				<button class="lupa fs-2 pb-2 c-orange" for="search"><i
						class="fa-solid fa-magnifying-glass"></i></button>
			</div>
		</form>

		<div class="px-4 py-3 mt-5">
			<h2 class="sigmar-one fw-bold c-red">Tendencias</h2>
		</div>
		<div class="d-flex flex-wrap gap-4 px-2">
			<c:forEach items="${booksTop}" var="book" begin="0" end="2">
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
		</div>

		<div class="px-4 py-3 mt-5">
			<h2 class="sigmar-one fw-bold c-red">Recientes</h2>
		</div>
		<div class="d-flex flex-wrap gap-4 px-3">
			<c:forEach items="${recentBooks}" var="book">
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
		</div>
	</div>
</body>

</html>