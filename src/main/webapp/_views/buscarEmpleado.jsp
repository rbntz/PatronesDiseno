<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calcular Sueldo Empleado</title>
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

input[type="text"] {
	width: 80%;
	padding: 10px;
	border: 1px solid #cccccc;
	border-radius: 5px;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background-color: #45a049;
}

.container {
	max-width: 600px;
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
		<h1>Calcular Sueldo Empleado</h1>
		<form action="empresa" method="post">
			<input type="hidden" name="opcion" value="calcularNomina">
			<table>
				<tr>
					<td>DNI Empleado:</td>
					<td><input type="text" name="dni" size="50"></td>
				</tr>
			</table>
			<input type="submit" value="Buscar">
		</form>
		<a href="javascript:history.back()" class="volver-btn">Volver</a>
	</div>
</body>
</html>
