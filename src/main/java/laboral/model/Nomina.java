package laboral.model;

import laboral.state.EstadoNomina;
import laboral.state.EstadoNormal;

public class Nomina {
    private String dniEmpleado;
    private double sueldoCalculado;
    private EstadoNomina estado;

    public static final double[] SUELDO_BASE = {1200, 1400, 1600, 1800, 2000, 2200, 2400, 2600, 2800, 3000};

    // Getters y setters
    public void setEstado(EstadoNomina estado) {
        this.estado = estado;
    }
    
    public void getEstado() {
    	this.estado = estado;
    }

    public void calcularSueldo(Empleado empleado) {
        if (estado != null) {
            estado.calcularSueldo(this, empleado);
        }
    }

    public void setSueldoCalculado(double sueldo) {
        this.sueldoCalculado = sueldo;
    }

    public double getSueldoCalculado() {
        return sueldoCalculado;
    }

    public String getDniEmpleado() {
        return dniEmpleado;
    }

    public void setDniEmpleado(String dniEmpleado) {
        this.dniEmpleado = dniEmpleado;
    }

    public String imprime() {
        return "Nómina de " + dniEmpleado + " con sueldo " + sueldoCalculado;
    }
}
