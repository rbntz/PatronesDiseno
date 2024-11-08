package laboral.factorymethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import laboral.model.Empleado;

public class EmpleadoFactoryConcreto extends EmpleadoFactory {

    // Implementación del método para crear un empleado a partir de un ResultSet
    @Override
    public Empleado crearEmpleado(ResultSet resultSet) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setNombre(resultSet.getString(1));
        empleado.setDNI(resultSet.getString(2));
        empleado.setSexo(resultSet.getString(3).charAt(0));
        empleado.setCategoria(resultSet.getInt(4));
        empleado.setAnyos(resultSet.getInt(5));

        return empleado;
    }
}