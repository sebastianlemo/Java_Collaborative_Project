<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<div class="container">
		<div id="book-box" class="border border-warning d-flex m-5 p-4 rounded-4 gap-4">
			<img class="portada rounded-4" src="${book.imageUrl}" alt="">
			<div id="info" class="p-3 mx-2 d-flex flex-column justify-content-around">
				<section>
					<h3 class="sigmar-one c-orange">Título</h3>
					<h4 class="sigmar-one c-cream">${book.title}</h4>
				</section>
				<section>
					<h3 class="sigmar-one c-orange">Descripción</h3>
					<h4 class="sigmar-one c-cream">${book.description}</h4>
				</section>
				<section>
					<h3 class="sigmar-one c-orange">Publicado por</h3>
					<h4 class="sigmar-one c-cream"><a href="/users/${book.user.id}">${book.user.firstName}</a></h4>
				</section>
				<section>
					<h3 class="sigmar-one c-orange">N° de páginas</h3>
					<h4 class="sigmar-one c-cream">${book.numberOfPages}</h4>
				</section>


				<section>
					<h3 class="sigmar-one c-orange mb-3">Géneros</h3>
					<div class="d-flex flex-wrap gap-2 ">
						<c:forEach items="${book.genres}" var="genre">
							<div class="sigmar-one rounded-pill genre-chip px-4 py-3 c-cream ">
								${genre.description} </div>
						</c:forEach>
					</div>
				</section>
			</div>
		</div>

		<a href="/quests/${book.id}/new">Crear quest</a>

		<h1 class="sigmar-one my-3 c-red">Comentarios</h1>
		<c:forEach items="${book.comments}" var="comment">
			<div class="card mb-3 rounded">
				<div class="card-body">
					<h4 class="card-title fw-bold c-orange">${comment.user.firstName}:</h4>
					<h5 class="card-tex fw-bold">${comment.content}</h5>
				</div>
			</div>
		</c:forEach>

		<form:form action="/comments/${book.id}/new" method="POST" modelAttribute="comment" class="form">
			<div class="form-group">
				<form:label class="form-label fs-2" for="content" path="content">Comentar:
				</form:label>
				<form:textarea rows="3" class="form-control c-red fs-5 fw-bold" path="content" />
			</div>
			<div class="d-flex gap-3 align-items-center my-3">
				<button class="submit fw-bold">Enviar</button>
			</div>
		</form:form>
	</div>
</body>

</html>