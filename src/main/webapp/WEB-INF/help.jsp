<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Biblioteca Virtual - Ayuda</title>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" href="/css/style.css">
</head>

<body>
	<%@include file="includes/menu.jsp" %>
	<div class="container">
		<div class="row">
			<div class="col-4">
				<div id="simple-list-example"
					class="d-flex flex-column gap-2 simple-list-example-scrollspy text-center">
					<br>
					<h4>Contenido</h4>
					<ol class="text-start">
						<li><a class="p-1 rounded" href="#introduccion">Introducción</a></li>
						<li><a class="p-1 rounded" href="#newBook">Cómo crear un libro</a></li>
						<li><a class="p-1 rounded" href="#searchBook">Cómo buscar y acceder a libros</a>
						</li>
						<li><a class="p-1 rounded" href="#adminBooks">Administrar tu biblioteca</a></li>

						<li><a class="p-1 rounded" href="#contact">Contacto</a></li>
					</ol>
				</div>
			</div>
			<div class="col-8">
				<div data-bs-spy="scroll" data-bs-target="#simple-list-example" data-bs-offset="0"
					data-bs-smooth-scroll="true" class="scrollspy-example" tabindex="0">
					<h1 class="fs-1 fw-bold">Ayuda</h1>
					<h2>Bienvenido a la Biblioteca Virtual</h2>
					<p>¡Gracias por visitar nuestra Biblioteca Virtual! En esta página encontrarás toda
						la
						información que necesitas para aprovechar al máximo nuestras funcionalidades. Si
						tienes
						alguna pregunta que no se responde aquí, no dudes en ponerte en contacto con
						nuestro
						equipo
						de soporte.</p>
					<h4 id="introduccion">Introducción</h4>
					<p>Nuestra Biblioteca Virtual te permite crear, gestionar y explorar libros
						digitales de
						manera
						sencilla. En esta sección encontrarás una visión general de las principales
						funciones y
						características.</p>
					<h4 id="newBook">Cómo crear un libro</h4>
					<p>
					<ol>
						<li>Iniciar sesión: Asegúrate de haber iniciado sesión en tu cuenta.</li>
						<li> Ir a la sección de creación: Dirígete a la pestaña "Crear libro" en el menú
							principal.</li>
						<li>Completar la información: Rellena los campos necesarios como título,
							descripción, N° de páginas y géneros.</li>
						<li>Subir el contenido: Puedes cargar el archivo del libro en formatos
							compatibles
						</li>
						<li>Revisar y publicar: Antes de publicar, revisa tu libro para asegurarte de
							que
							todo esté correcto. Luego, haz clic en "Publicar".</li>
					</ol>

					</p>
					<h4 id="searchBook">Cómo buscar y acceder a libros</h4>
					<p>
					<ol>
						<li>Utilizar la barra de búsqueda: Introduce el título o palabras clave
							en la
							barra
							de
							búsqueda ubicada en la parte superior de la página.</li>
						<li>Explorar géneros: Navega por las géneros y subgéneros para
							descubrir nuevos
							libros.</li>
						<li> Acceder al libro: Haz clic en el título del libro para acceder a su página
							de
							detalles.
						</li>
					</ol>
					</p>
					<h4 id="adminBooks">Administrar tu biblioteca</h4>
					<p>
					<ol>
						<li>Ver tus libros: Accede a tu perfil y selecciona la opción "Mis libros" para
							ver todos los libros que has creado o guardado.</li>
						<li>Editar o eliminar: Puedes editar la información de un libro o eliminarlo
							desde "Mis libros".</li>
					</ol>
					</p>

					<h4 id="contact">Contacto</h4>
					<p>
						Si necesitas más ayuda o tienes preguntas adicionales, no dudes en ponerte en
						contacto con nosotros:
					<ul>
						<li>Correo electrónico: soporte@bivi.flam.eu.org</li>
						<!--li>Teléfono: +123 456 7890</li-->
					</ul>

					Nuestro equipo está aquí para ayudarte y responder a cualquier consulta que
					puedas tener. ¡Estamos comprometidos en brindarte la mejor experiencia posible
					en nuestra Biblioteca Virtual!
					</p>
				</div>
			</div>
		</div>
	</div>
</body>

</html>