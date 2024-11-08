<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Filtrado Empleados</title>
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
	max-width: 600px;
	margin: auto;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	background: #fff;
	padding: 20px;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	margin-top: 10px;
	border-radius: 5px;
	border: 1px solid #dddddd;
}

input[type="submit"] {
	background-color: #4CAF50;
	color: white;
	padding: 10px 15px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-top: 10px;
	width: 100%;
}

input[type="submit"]:hover {
	background-color: #45a049;
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
<script type="text/javascript">
	function mostrarInput() {
		const campo = document.getElementById("campo").value;
		const inputContainer = document.getElementById("inputContainer");

		inputContainer.innerHTML = ""; // Limpiar el contenedor

		if (campo) {
			let input = document.createElement("input");
			input.type = "text";
			input.name = campo; // Asigna el mismo nombre que el campo seleccionado
			input.placeholder = "Ingrese " + campo; // Mensaje orientativo

			inputContainer.appendChild(input);
		}
	}
</script>
</head>
<body>
	<div class="container">
		<h1>Identifica el campo a filtrar:</h1>
		<form action="empresa" method="post">
			<input type="hidden" name="opcion" value="listarEmpleadosFiltrados">
			<table>
				<tr>
					<td>Campo a filtrar:</td>
					<td><select id="campo" name="campo" onchange="mostrarInput()">
							<option value="">Seleccione un campo</option>
							<option value="nombre">Nombre</option>
							<option value="sexo">Sexo</option>
							<option value="categoria">Categoría</option>
							<option value="anyos">Años trabajados</option>
					</select></td>
				</tr>
			</table>
			<div id="inputContainer"></div>
			<input type="submit" value="Buscar">
		</form>
		<a href="javascript:history.back()" class="volver-btn">Volver</a>
	</div>
</body>
</html>

