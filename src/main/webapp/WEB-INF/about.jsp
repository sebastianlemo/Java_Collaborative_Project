<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Biblioteca Virtual</title>
    <link rel="stylesheet" href="/webjars/font-awesome/css/all.min.css" />
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <%@include file="includes/menu.jsp" %>
    <h2 class="text-center fs-1 fscolor my-4">Bienvenidos a Biblioteca Virtual!</h2>
        
        <div class="container d-flex flex-column  gap-4 w-75">
            <article>
                <p class="mx-5"> Nuestro equipo ha desarrollado esta plataforma web con el objetivo de ofrecer un espacio donde las personas puedan almacenar y compartir sus libros con otros usuarios.</p>
            </article>

            <article>
                <p class="mx-5">Aunque nuestra plataforma no se centra en la creación de libros, sí proporcionamos un medio para que los usuarios puedan compartir sus obras con el público y descubrir los trabajos de otros. Además, permitimos que los usuarios comenten y ofrezcan consejos sobre los distintos libros, lo cual es de gran beneficio para aquellos que desean adentrarse en el mundo de la lectura y la creación literaria.</p>
            </article>

            <article>
                <p class="mx-5">El contenido está diseñado para facilitar el intercambio de ideas y fomentar una comunidad activa de lectores y escritores, brindando una plataforma accesible para compartir conocimientos y opiniones sobre diversas obras literarias.</p>
            </article>
            <h4 class="fs-5 fw-bold fscolor ms-5">¡Disfruta compartiendo y descubriendo libros!</h4> 
            <a href="/privacy" class="fs-5 fw-bold fscolor ms-5">Politica de Privacidad</a>
        </div>
</body>
</html>