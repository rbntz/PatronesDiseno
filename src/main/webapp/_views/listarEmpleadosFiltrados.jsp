<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Empleados Filtrados</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	color: #333;
	margin: 0;
	padding: 20px;
}

h1 {
	text-align: center;
	color: #4CAF50;
}

table {
	width: 100%;
	margin: 20px 0;
	border-collapse: collapse;
}

td {
	padding: 15px;
	text-align: center;
	background-color: #ffffff;
	border: 1px solid #dddddd;
	border-radius: 5px;
}

.container {
	max-width: 800px;
	margin: auto;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	background: #fff;
	padding: 20px;
}

.volver-btn {
	display: inline-block;
	padding: 10px 20px;
	margin-top: 20px;
	font-size: 16px;
	color: white;
	background-color: #4CAF50;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	text-decoration: none; /* Para que no tenga subrayado */
	transition: background-color 0.3s ease;
}

.error-message {
	color: red;
	background-color: #f8d7da;
	border: 1px solid #f5c6cb;
	padding: 10px;
	border-radius: 5px;
	margin: 20px 0;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Listado Empleado</h1>

		<!-- Mostrar mensaje de error -->
		<c:if test="${not empty error}">
			<div class="error-message">
				<c:out value="${error}"></c:out>
			</div>
		</c:if>

		<table>
			<tr>
				<td>Nombre</td>
				<td>DNI</td>
				<td>Sexo</td>
				<td>Categoría</td>
				<td>Años trabajados</td>
			</tr>
			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td><c:out value="${empleado.getNombre()}"></c:out></td>
					<td><c:out value="${empleado.getDNI()}"></c:out></td>
					<td><c:out value="${empleado.getSexo()}"></c:out></td>
					<td><c:out value="${empleado.getCategoria()}"></c:out></td>
					<td><c:out value="${empleado.getAnyos()}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<a href="javascript:history.back()" class="volver-btn">Volver</a>
	</div>
</body>
</html>
