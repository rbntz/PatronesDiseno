package laboral.factorymethod;

import java.sql.ResultSet;
import java.sql.SQLException;

import laboral.model.Empleado;

public abstract class EmpleadoFactory {
    
    // Método abstracto que cada subclase debe implementar
    public abstract Empleado crearEmpleado(ResultSet resultSet) throws SQLException;
    
}




