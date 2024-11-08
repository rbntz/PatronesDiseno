package laboral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laboral.conexion.Conexion;
import laboral.model.*;
import laboral.factorymethod.*;

public class EmpleadoDAO {
	private Connection connection;
	private PreparedStatement statement;
	private boolean estadoOperacion;

	/**
	 * Método que elimina a un empleado junto a su nómina de la base de datos.
	 * 
	 * @param dniEmpleado
	 * @return
	 * @throws SQLException
	 */
	public boolean eliminar(String dniEmpleado) throws SQLException {
		boolean estadoOperacion = false;
		Connection connection = null;
		PreparedStatement statementNomina = null;
		PreparedStatement statementEmpleado = null;

		try {
			connection = obtenerConexion();
			connection.setAutoCommit(false);

			String sqlNomina = "DELETE FROM Nomina WHERE empleado_dni=?";
			statementNomina = connection.prepareStatement(sqlNomina);
			statementNomina.setString(1, dniEmpleado);
			int filasEliminadasNomina = statementNomina.executeUpdate();

			if (filasEliminadasNomina > 0) {
				String sqlEmpleado = "DELETE FROM Empleado WHERE dni=?";
				statementEmpleado = connection.prepareStatement(sqlEmpleado);
				statementEmpleado.setString(1, dniEmpleado);
				int filasEliminadasEmpleado = statementEmpleado.executeUpdate();

				estadoOperacion = filasEliminadasEmpleado > 0;
			}

			connection.commit();

		} catch (SQLException e) {
			if (connection != null) {
				connection.rollback();
			}
			e.printStackTrace();
		} 

		return estadoOperacion;
	}

	/**
	 * Método que obtiene todos los empleados de la base de datos.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Empleado> obtenerEmpleados() throws SQLException {
		ResultSet resultSet = null;
		List<Empleado> listaEmpleados = new ArrayList<>();

		String sql = null;
		estadoOperacion = false;
		connection = obtenerConexion();

		try {
			sql = "SELECT * FROM Empleado";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				// Usamos la Factory Concreta para crear el empleado
	            EmpleadoFactory factory = new EmpleadoFactoryConcreto();
	            Empleado empleado = factory.crearEmpleado(resultSet);
	            listaEmpleados.add(empleado);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaEmpleados;
	}

	/**
	 * Método que filtra los empleados de una base de datos por cualquiera de los
	 * campos de la tabla Empleado (menos DNI)
	 * 
	 * @param campo
	 * @param valor
	 * @return
	 * @throws SQLException
	 */
	public List<Empleado> filtrarEmpleados(String campo, Object valor) throws SQLException {
	    ResultSet resultSet = null;
	    List<Empleado> listaEmpleados = new ArrayList<>();

	    String sql = null;
	    estadoOperacion = false;
	    connection = obtenerConexion();

	    try {
	        // Crear la consulta SQL con un marcador de posición para el campo y el valor
	        sql = "SELECT * FROM Empleado WHERE " + campo + " = ?";
	        statement = connection.prepareStatement(sql);

	        // Verificar si el valor es un String o un Integer y establecer el parámetro correspondiente
	        if (valor instanceof String) {
	            statement.setString(1, (String) valor);
	        } else if (valor instanceof Integer) {
	            statement.setInt(1, (Integer) valor);
	        }

	        resultSet = statement.executeQuery();

	        while (resultSet.next()) {
	            // Usamos la Factory Concreta para crear el empleado
	            EmpleadoFactory factory = new EmpleadoFactoryConcreto();
	            Empleado empleado = factory.crearEmpleado(resultSet);
	            listaEmpleados.add(empleado);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return listaEmpleados;
	}


	/**
	 * Método que obtiene un empleado de la base de datos por su DNI.
	 * 
	 * @param dniEmpleado
	 * @return
	 * @throws SQLException
	 */
	public Empleado obtenerEmpleado(String dniEmpleado) throws SQLException {
	    ResultSet resultSet = null;
	    Empleado empleado = new Empleado();

	    String sql = null;
	    estadoOperacion = false;
	    connection = obtenerConexion();

	    try {
	        sql = "SELECT * FROM Empleado WHERE DNI = '" + dniEmpleado + "'";
	        statement = connection.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            // Usamos la Factory Concreta para crear el empleado
	            EmpleadoFactory factory = new EmpleadoFactoryConcreto();
	            empleado = factory.crearEmpleado(resultSet);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return empleado;
	}


	/**
	 * Método que comprueba la conexión a la base de datos.
	 * 
	 * @return
	 * @throws SQLException
	 */
	private Connection obtenerConexion() throws SQLException {
		return Conexion.getConnection();
	}

}