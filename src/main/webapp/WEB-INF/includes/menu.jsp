<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<link rel="stylesheet" href="/webjars/font-awesome/css/all.min.css" /> 
	<header>
		<nav class="d-flex justify-content-between px-4 align-items-center bg-nav ">
			<div class="d-flex align-items-center gap-3">
				<div id="icon">
					<a href="/" class="d-flex">
						<img id="imagen-icon" src="/img/icono2.png" alt="">
						<h4 class="pt-2 fw-bold custom-font">BIVI</h4>
					</a>
				</div>
				<div id="enlaces" class="d-flex align-items-center text-decoration-none text-light">
					<a class="py-2 px-4" href="/search">EXPLORAR</a>
					<a class="py-2 px-4" href="/books/new">CREAR</a>
					<a class="py-2 px-4" href="/about">ACERCA DE</a>
					<a class="py-2 px-4" href="/help">AYUDA</a>
				</div>
			</div>
			<!-- <div class="d-flex align-items-center gap-2">
					<input class="rounded-pill p-1 px-4 mx-2" id="search" name="search" type="search" placeholder="buscar">
					<label class="text-light bg-brown fs-4 py-2" for="search"><i class="fa-solid fa-magnifying-glass"></i></label>
				</div> -->
			<div>
				<!-- <div class="fs-1 text-light p-1 d-none gap-5">
						<i class="fa-solid fa-bars"></i>
						<i class="fa-regular fa-circle-user"></i>
					</div> -->
				<c:if test="${empty sessionScope}">
					<div id="buttons" class="d-flex gap-4">
						<a href="/users/new" class="sign fw-bold bg-sign-up">REGISTRARSE</a>
						<a href="/login" class="sign fw-bold bg-sign-in">INICIAR SESIÓN</a>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope}">
					<div class="fs-1 text-light p-1 gap-4">
						<i class="fa-solid fa-bars mx-3 c-cream"></i>
						<i class="fa-regular fa-circle-user mx-2 c-cream"></i>
					</div>
				</c:if>
			</div>
		</nav>
	</header>
</body>