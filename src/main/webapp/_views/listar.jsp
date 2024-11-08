<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado Empleados</title>
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

th, td {
	padding: 15px;
	text-align: center;
	background-color: #ffffff;
	border: 1px solid #dddddd;
	border-radius: 5px;
}

th {
	background-color: #4CAF50;
	color: white;
}

a {
	color: #4CAF50;
	text-decoration: none;
	font-weight: bold;
}

a:hover {
	color: #45a049;
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
</style>
</head>
<body>
	<div class="container">
		<h1>Listado Empleados</h1>

		<table>
			<tr>
				<th>Nombre</th>
				<th>DNI</th>
				<th>Sexo</th>
				<th>Categoría</th>
				<th>Años Trabajados</th>
				<th>Acciones</th>
			</tr>
			<c:forEach var="empleado" items="${lista}">
				<tr>
					<td><c:out value="${empleado.getNombre()}"></c:out></td>
					<td><c:out value="${empleado.getDNI()}"></c:out></td>
					<td><c:out value="${empleado.getSexo()}"></c:out></td>
					<td><c:out value="${empleado.getCategoria()}"></c:out></td>
					<td><c:out value="${empleado.getAnyos()}"></c:out></td>
					<td><a
						href="empresa?opcion=eliminar&dni=<c:out value='${empleado.getDNI()}' />">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<a href="javascript:history.back()" class="volver-btn">Volver</a>
	</div>
</body>
</html>
