package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Operario extends Persona{
    // Atributos de la clase Operario
    private int codigoEmpleado;
    private String fechaContratacion;
    private double salarioBasico;
    // Relaciones de la clase Operario
    private List<Venta> listOperarioVentas;

    /**
     * Metodo constructor de la clase Operario
     * @param documento del operario
     * @param nombreCompleto del operario
     * @param correoElectronico del operario
     * @param telefono del operario
     * @param codigoEmpleado del operario
     * @param fechaContratacion del operario
     * @param salarioBasico del operario
     */
    public Operario(int documento, String nombreCompleto, String correoElectronico, int telefono, int codigoEmpleado, String fechaContratacion, double salarioBasico) {
        super(documento, nombreCompleto, correoElectronico, telefono);
        this.codigoEmpleado = codigoEmpleado;
        this.fechaContratacion = fechaContratacion;
        this.salarioBasico = salarioBasico;

        this.listOperarioVentas = new ArrayList<>();
    }

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalarioBasico() {
        return salarioBasico;
    }

    public void setSalarioBasico(double salarioBasico) {
        this.salarioBasico = salarioBasico;
    }

    public List<Venta> getListOperarioVentas() {
        return listOperarioVentas;
    }

    public void setListOperarioVentas(List<Venta> listOperarioVentas) {
        this.listOperarioVentas = listOperarioVentas;
    }

    @Override
    public String toString() {
        return "Operario{" +
                "documento='" + getDocumento() +
                ", nombreCompleto='" + getNombreCompleto() + "\'" +
                ", correoElectronico='" + getCorreoElectronico() +
                ", telefono=" + getTelefono() + '\'' +
                "codigoEmpleado=" + codigoEmpleado +
                ", fechaContratacion='" + fechaContratacion + '\'' +
                ", salarioBasico=" + salarioBasico +
                '}';
    }
}

