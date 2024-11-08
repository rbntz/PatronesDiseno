package laboral.state;

import laboral.model.Empleado;
import laboral.model.Nomina;

public class EstadoEnfermedad implements EstadoNomina {
	private String estado = "Enfermedad";

    @Override
    public void calcularSueldo(Nomina nomina, Empleado empleado) {
    	nomina.setSueldoCalculado(nomina.getSueldoCalculado()*0.75);
		System.out.println("Sueldo calculado con estado enfermedad: " + nomina.getSueldoCalculado());
    }
    
    public String getEstado() {
		return estado;
	}
}