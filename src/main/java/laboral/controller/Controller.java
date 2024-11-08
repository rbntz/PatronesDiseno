package laboral.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import laboral.dao.*;
import laboral.model.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet(description = "Administra peticiones a la tabla Empleado/Nomina", urlPatterns = { "/empresa" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String opcion = request.getParameter("opcion");

		System.out.println(opcion);

		if (opcion == null) {
			// Si "opcion" es null, redirigir a una página predeterminada o mostrar un
			// mensaje de error.
			response.sendRedirect("index.jsp");
			return;
		}

		/**
		 * Opciones del index.jsp.
		 */
		if (opcion.equals("listar")) {

			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			List<Empleado> lista = new ArrayList<>();

			try {
				lista = empleadoDAO.obtenerEmpleados();

				for (Empleado empleado : lista) {
					System.out.println(empleado);
				}

				request.setAttribute("lista", lista);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/_views/listar.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("eliminar")) {

			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			String dniEmpleado = request.getParameter("dni");
			System.out.println(dniEmpleado);

			try {
				empleadoDAO.eliminar(dniEmpleado);
				System.out.println("Registro eliminado satisfactoriamente...");

				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (opcion.equals("buscarEmpleado")) {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/_views/buscarEmpleado.jsp");

			requestDispatcher.forward(request, response);

		} else if (opcion.equals("filtrarEmpleados")) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/_views/filtrarEmpleados.jsp");
			if (requestDispatcher != null) {
				requestDispatcher.forward(request, response);
			} else {
				System.out.println("RequestDispatcher es null");
			}
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opcion = request.getParameter("opcion");

		/**
		 * Opciones del get de los distintos apartados del index.jsp
		 */
		if (opcion.equals("calcularNomina")) {
			NominaDAO nominaDAO = new NominaDAO();
			Nomina nomina = new Nomina();

			String dniEmpleado = request.getParameter("dni");
			System.out.println(dniEmpleado);

			try {
				nomina = nominaDAO.obtenerNomina(dniEmpleado);
				System.out.println(nomina.imprime());
				if (nomina == null) {
					request.setAttribute("error", "El DNI ingresado no existe.");
				} else if (nomina.getSueldoCalculado() < 0) { // Suponiendo que un sueldo no puede ser menor o igual a
																// cero
					request.setAttribute("error",
							"No se pudo calcular el sueldo para el empleado con DNI " + dniEmpleado + ".");
				} else {
					request.setAttribute("nomina", nomina);
				}
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/_views/calcularNomina.jsp");
				requestDispatcher.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("listarEmpleadosFiltrados")) {
			EmpleadoDAO empleadoDAO = new EmpleadoDAO();
			List<Empleado> lista = new ArrayList<>();

			String campo = request.getParameter("campo");
			Object valor = request.getParameter(campo); // Usa el valor del campo seleccionado como clave

			System.out.println(campo);
			System.out.println(valor);
			try {
				lista = empleadoDAO.filtrarEmpleados(campo, valor);

				if (lista.isEmpty()) {
					request.setAttribute("error", "No se encontraron empleados con ese filtro.");
				} else {
					request.setAttribute("lista", lista);
				}

				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/_views/listarEmpleadosFiltrados.jsp");
				requestDispatcher.forward(request, response);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}