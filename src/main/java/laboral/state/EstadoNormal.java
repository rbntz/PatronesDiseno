package laboral.state;

import laboral.model.Empleado;
import laboral.model.Nomina;

public class EstadoNormal implements EstadoNomina {
	private String estado;
	
	@Override
	public void calcularSueldo(Nomina nomina, Empleado empleado) {
		System.out.println("Sueldo calculado con estado normal: " + nomina.getSueldoCalculado());
	}
	
	public String getEstado() {
		return "Normal";
	}
}