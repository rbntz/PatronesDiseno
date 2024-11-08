package laboral.state;

import laboral.model.Empleado;
import laboral.model.Nomina;

public interface EstadoNomina {
    void calcularSueldo(Nomina nomina, Empleado empleado);
}

