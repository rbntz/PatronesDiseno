<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Men� de Opciones</title>
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

td a {
	text-decoration: none;
	color: #4CAF50;
	font-weight: bold;
}

td a:hover {
	color: #45a049;
}

.container {
	max-width: 600px;
	margin: auto;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	background: #fff;
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Men� de Opciones N�minas</h1>
		<table>
			<tr>
				<td><a href="empresa?opcion=listar">Listar Empleados</a></td>
			</tr>
			<tr>
				<td><a href="empresa?opcion=buscarEmpleado">Mostrar Salario
						de un Empleado</a></td>
			</tr>
			<tr>
				<td><a href="empresa?opcion=filtrarEmpleados">Modificar
						Datos Empleados</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
