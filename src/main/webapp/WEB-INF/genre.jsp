<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<h1>New Genre</h1>
		<form:form action="/genres/new" method="post" modelAttribute="genre" class="border border-4 border-secondary p-5 rounded d-flex flex-column">

			<form:label class="col-sm-4 col-form-label" path="description">description</form:label>
			<form:input class="col-sm-6 form-control" type="text" path="description" id="description" />
			<form:errors class="text-danger" path="description" />

			<br>
			<button class="rounded button">Crear</button>
		</form:form>
	</div>
</body>
</html>