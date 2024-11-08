package laboral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import laboral.conexion.Conexion;
import laboral.model.Nomina;
import laboral.model.Empleado;
import laboral.state.*;

public class NominaDAO {

    private Connection connection;
    private PreparedStatement statement;
    private boolean estadoOperacion;

    /**
     * Método que obtiene todas las nóminas registradas en la base de datos.
     * 
     * @return Lista de nóminas
     * @throws SQLException
     */
    public List<Nomina> obtenerNominas() throws SQLException {
        ResultSet resultSet = null;
        List<Nomina> listaNominas = new ArrayList<>();
        String sql = "SELECT * FROM Nomina";

        connection = obtenerConexion();

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Nomina nomina = new Nomina();
                nomina.setDniEmpleado(resultSet.getString("empleado_dni"));
                nomina.setSueldoCalculado(resultSet.getDouble("sueldoCalculado"));

                // Obtener el estado de la nómina desde la base de datos
                String estado = resultSet.getString("estado_nomina");
                switch (estado) {
                    case "Normal":
                        nomina.setEstado(new EstadoNormal());
                        break;
                    case "Enfermedad":
                        nomina.setEstado(new EstadoEnfermedad());
                        break;
                    case "Suspendido":
                        nomina.setEstado(new EstadoSuspendido());
                        break;
                    default:
                        nomina.setEstado(new EstadoNormal()); // Default a Normal si no se encuentra el estado
                }

                listaNominas.add(nomina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaNominas;
    }


    /**
     * Método que obtiene una nómina registrada en la base de datos por el DNI de un
     * empleado.
     * 
     * @param dniEmpleado DNI del empleado
     * @return La nómina del empleado
     * @throws SQLException
     */
    public Nomina obtenerNomina(String dniEmpleado) throws SQLException {
        ResultSet resultSet = null;
        Nomina nomina = new Nomina();
        Empleado empleado = null;  // Variable para almacenar los datos del empleado

        String sql = "SELECT * FROM Nomina WHERE empleado_dni = ?";
        connection = obtenerConexion();

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, dniEmpleado);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Obtener la nómina
                nomina.setDniEmpleado(resultSet.getString("empleado_dni"));
                nomina.setSueldoCalculado(resultSet.getDouble("sueldoCalculado"));

                // Obtener el estado de la nómina desde la base de datos
                String estado = resultSet.getString("estado_nomina");
                switch (estado) {
                    case "Normal":
                        nomina.setEstado(new EstadoNormal());
                        break;
                    case "Enfermedad":
                        nomina.setEstado(new EstadoEnfermedad());
                        break;
                    case "Suspendido":
                        nomina.setEstado(new EstadoSuspendido());
                        break;
                    default:
                        nomina.setEstado(new EstadoNormal()); // Default a Normal si no se encuentra el estado
                }

                EmpleadoDAO empleadoDAO = new EmpleadoDAO();
                
                empleado = empleadoDAO.obtenerEmpleado(dniEmpleado);

                // Ahora que tienes el objeto empleado con la categoría, pasa el empleado a calcular el sueldo
                if (empleado != null) {
                    nomina.calcularSueldo(empleado); // Pasa el empleado con sus datos completos
                } else {
                    // Si no se encontró el empleado, puedes manejar el error de alguna forma
                    System.out.println("Empleado no encontrado para el DNI: " + dniEmpleado);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nomina;
    }


    /**
     * Método que comprueba conexión a la base de datos.
     * 
     * @return La conexión a la base de datos
     * @throws SQLException
     */
    private Connection obtenerConexion() throws SQLException {
        return Conexion.getConnection();
    }
}
