package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    // Atributos de la clase Venta
    private int codigoVenta;
    private String fechaRealizacion;
    // Relaciones de la clase Venta
    private List<DetalleVenta> listDetallesVenta;
    private Boleta boleta;
    private Operario operario;
    private Cliente cliente;

    /**
     * Metodo constructor de la clase Venta
     * @param codigoVenta de la venta
     * @param fechaRealizacion de la venta
     */
    public Venta(int codigoVenta, String fechaRealizacion, Operario operario, Cliente cliente) {
        this.codigoVenta = codigoVenta;
        this.fechaRealizacion = fechaRealizacion;
        this.operario = operario;
        this.cliente = cliente;

        this.listDetallesVenta = new ArrayList<>();
    }

    /**
     * Metodo que me permite saber el acumulado de las ventas por boleta
     * @return
     */
    public double calcularValorTotal(){
        double total = 0.0;
        for(int i = 0; i<listDetallesVenta.size(); i++){
            DetalleVenta detalle = listDetallesVenta.get(i);
            total += detalle.valorTotal();
        }
        return total;
    }
    public int getCodigoVenta() {
        return codigoVenta;
    }

    public void setCodigoVenta(int codigoVenta) {
        this.codigoVenta = codigoVenta;
    }

    public String getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(String fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public List<DetalleVenta> getListDetallesVenta() {
        return listDetallesVenta;
    }

    public void setListDetallesVenta(List<DetalleVenta> listDetallesVenta) {
        this.listDetallesVenta = listDetallesVenta;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Operario getOperario() {
        return operario;
    }

    public void setOperario(Operario operario) {
        this.operario = operario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "codigoVenta=" + codigoVenta +
                ", fechaRealizacion='" + fechaRealizacion + '\'' +
                ", listDetallesVenta=" + listDetallesVenta +
                ", boleta=" + boleta +
                ", operario=" + (operario != null ? operario.getNombreCompleto() : "N/A") +
                ", cliente=" + (cliente != null ? cliente.getNombreCompleto() : "N/A") +
                '}';
    }
}
