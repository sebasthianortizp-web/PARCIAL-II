package uniquindio.edu.co.model;

import java.util.List;

/**
 * Clase de tipo record que permite determinar el detalle de una venta
 * @param cantidadBoletas del detalle de venta
 * @param valorTotal del detalle de venta
 * @param codigoDetalle del detalle de venta
 * @param boleta asociada al detalle de la venta
 */
public record DetalleVenta(int cantidadBoletas, double valorTotal, int codigoDetalle, Boleta boleta) {

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "cantidadBoletas=" + cantidadBoletas +
                ", valorTotal=" + valorTotal +
                ", codigoDetalle=" + codigoDetalle +
                ", boleta=" + (boleta != null ? boleta.getCodigoBoleta() : "N/A") +
                '}';
    }
}
