package laboral.state;

import laboral.model.Empleado;
import laboral.model.Nomina;

public class EstadoSuspendido implements EstadoNomina {
	private String estado = "Suspendido";
	
    @Override
    public void calcularSueldo(Nomina nomina, Empleado empleado) {
        nomina.setSueldoCalculado(0);
        System.out.println("Sueldo calculado con estado suspendido: " + nomina.getSueldoCalculado());
    }

	public String getEstado() {
		return estado;
	}
}
