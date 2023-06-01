<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Students</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
<h1>All students</h1>

	<a href="/students/new"> Agrega Estudiante</a> |
	<a href="/contacts/new"> Agrega Licencia</a>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Direccion</th>
				<th>Ciudad</th>
				<th>Estado</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="estudiante">
				<tr>
					<td>${ estudiante.nombre}</td>
					<td>${ estudiante.nombre}</td>
					<td>${ estudiante.getContact().getDireccion() }</td>
					<td>${ estudiante.getContact().getCiudad() }</td>
					<td>${ estudiante.getContact().getEstado() }</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>