package uniquindio.edu.co.model;

public class Boleta {
    // Atributos de la clase Boleta
    private int codigoBoleta;
    public String fila;
    public int numeroAsiento;
    public double valorIndividualPagado;
    // Relaciones de la clase Boleta
    private  DetalleVenta detalleVenta;

    /**
     * Metodo constructor de la clase boleta
     * @param codigoBoleta de la boleta
     * @param fila de la boleta
     * @param numeroAsiento de la boleta
     * @param valorIndividualPagado de la boleta
     */
    public Boleta(int codigoBoleta, String fila, int numeroAsiento, double valorIndividualPagado) {
        this.codigoBoleta = codigoBoleta;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.valorIndividualPagado = valorIndividualPagado;
    }

    /**
     * Metodo que me permite calcular el valor individual a pagar por boleta
     * aplicando los recargos por TipoSala y el porcentaje de descuento del cliente
     * @param funcion para la cual se compra la boleta
     * @param cliente que compra a boleta
     * @return
     */
    public double calcularValorIndividual(Funcion funcion, Cliente cliente){
        double precioBase = funcion.getPrecioBaseBoleta();
        TipoSala tipoSala = funcion.getSala().getTipoSala();
        double precioConRecargo = precioBase;
        if (tipoSala == TipoSala.VIP){
            precioConRecargo = precioBase * 1.30;
        }else if( tipoSala == TipoSala.TRES_D){
            precioConRecargo = precioBase * 1.20;
        }
        double valorFinal = precioConRecargo;
        if(cliente != null && cliente.getPorcentajeDescuento() > 0){
            valorFinal = precioConRecargo * (1 - cliente.getPorcentajeDescuento());
        }
        return valorFinal;
    }
    public int getCodigoBoleta() {
        return codigoBoleta;
    }

    public void setCodigoBoleta(int codigoBoleta) {
        this.codigoBoleta = codigoBoleta;
    }

    public String getFila() {
        return fila;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public double getValorIndividualPagado() {
        return valorIndividualPagado;
    }

    public void setValorIndividualPagado(double valorIndividualPagado) {
        this.valorIndividualPagado = valorIndividualPagado;
    }

    public DetalleVenta getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(DetalleVenta detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    @Override
    public String toString() {
        return "Boleta{" +
                "codigoBoleta=" + codigoBoleta +
                ", fila='" + fila + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", valorIndividualPagado=" + valorIndividualPagado +
                '}';
    }
}
