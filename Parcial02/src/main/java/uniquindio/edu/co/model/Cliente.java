package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona{
    // Atributos de la clase Cliente
    private int codigoAfiliacion;
    private double porcentajeDescuento;
    // Relaciones de la clase Cliente
    private List<Venta> listClienteVentas;
    private List<Boleta> listClienteBoletas;

    /**
     * Metodo constructor de la classe Cliente
     * @param documento del cliente
     * @param nombreCompleto del cliente
     * @param correoElectronico del cliente
     * @param telefono del cliente
     * @param codigoAfiliacion del cliente
     * @param porcentajeDescuento del cliente
     */
    public Cliente(int documento, String nombreCompleto, String correoElectronico, int telefono, int codigoAfiliacion, double porcentajeDescuento) {
        super(documento, nombreCompleto, correoElectronico, telefono);
        this.codigoAfiliacion = codigoAfiliacion;
        this.porcentajeDescuento = porcentajeDescuento;

        this.listClienteVentas = new ArrayList<>();
        this.listClienteBoletas = new ArrayList<>();
    }

    public int getCodigoAfiliacion() {
        return codigoAfiliacion;
    }

    public void setCodigoAfiliacion(int codigoAfiliacion) {
        this.codigoAfiliacion = codigoAfiliacion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public List<Venta> getListClienteVentas() {
        return listClienteVentas;
    }

    public void setListClienteVentas(List<Venta> listClienteVentas) {
        this.listClienteVentas = listClienteVentas;
    }

    public List<Boleta> getListClienteBoletas() {
        return listClienteBoletas;
    }

    public void setListClienteBoletas(List<Boleta> listClienteBoletas) {
        this.listClienteBoletas = listClienteBoletas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "documento='" + getDocumento() +
                ", nombreCompleto='" + getNombreCompleto() + "\'" +
                ", correoElectronico='" + getCorreoElectronico() +
                ", telefono=" + getTelefono() + '\'' +
                "codigoAfiliacion=" + codigoAfiliacion +
                ", porcentajeDescuento=" + porcentajeDescuento + '\'' +
                ", listClienteVentas=" + listClienteVentas +
                ", listClienteBoletas=" + listClienteBoletas + '\'' +
                '}';
    }
}
