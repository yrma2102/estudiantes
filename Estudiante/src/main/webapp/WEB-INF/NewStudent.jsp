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
<div class="container">
		<h2>Nuevo Estudiante</h2>
		<form:form action="/students/new" method="POST" modelAttribute="student">
			<div class="form-group">
				<form:label path="nombre">First Name</form:label>
				<form:errors path="nombre" />
				<form:input class="form-control" path="nombre" />
			</div>
			<div class="form-group">
				<form:label path="apellido">Last Name</form:label>
				<form:errors path="apellido" />
				<form:input class="form-control" path="apellido" />
			</div>
			<div class="form-group">
				<form:label path="edad">Edad</form:label>
				<form:errors path="edad" />
				<form:input type="number" class="form-control" path="edad" />
			</div>
			<button>Agregar Estudiante</button>
		</form:form>
	</div>

</body>
</html>