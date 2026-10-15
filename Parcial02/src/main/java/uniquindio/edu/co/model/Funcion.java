package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Funcion {
    // Atributos de la clase Funcion
    private int codigoFuncion;
    public String fechaPresentacion;
    public String horaInicio;
    public double precioBaseBoleta;

    // Relaciones de la clase Funcion
    private Pelicula pelicula;
    private List<Asiento> listFuncionAsientos;
    private List<Boleta> listFuncionBoletas;
    private Sala sala;

    /**
     * Metodo constructor de la clase Funcion
     * @param codigoFuncion de la funcion
     * @param fechaPresentacion de la funcion
     * @param horaInicio de la funcion
     * @param precioBaseBoleta de la funcion
     */
    public Funcion(int codigoFuncion, String fechaPresentacion, String horaInicio, double precioBaseBoleta, Pelicula pelicual, Sala sala) {
        this.codigoFuncion = codigoFuncion;
        this.fechaPresentacion = fechaPresentacion;
        this.horaInicio = horaInicio;
        this.precioBaseBoleta = precioBaseBoleta;
        this.pelicula = pelicual;
        this.sala = sala;

        this.listFuncionAsientos = new ArrayList<>();
        this.listFuncionBoletas = new ArrayList<>();

    }

    /**
     * Metodo que me permite determinar el estado de un asiento
     * @param fila del asiento
     * @param numeroAsiento del asiento
     * @return
     */
    public boolean esAsientoDisponible (String fila, int numeroAsiento){
        boolean esDisponible = true;
        for(int i = 0; i<listFuncionBoletas.size(); i++){
            Boleta boleta = listFuncionBoletas.get(i);
            if(boleta.getFila().equalsIgnoreCase(fila) && boleta.getNumeroAsiento() == numeroAsiento){
                esDisponible = false;
                break;
            }
        }
        return esDisponible;
    }

    public int getCodigoFuncion() {
        return codigoFuncion;
    }

    public void setCodigoFuncion(int codigoFuncion) {
        this.codigoFuncion = codigoFuncion;
    }

    public String getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(String fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getPrecioBaseBoleta() {
        return precioBaseBoleta;
    }

    public void setPrecioBaseBoleta(double precioBaseBoleta) {
        this.precioBaseBoleta = precioBaseBoleta;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public List<Asiento> getListFuncionAsientos() {
        return listFuncionAsientos;
    }

    public void setListFuncionAsientos(List<Asiento> listFuncionAsientos) {
        this.listFuncionAsientos = listFuncionAsientos;
    }

    public List<Boleta> getListFuncionBoletas() {
        return listFuncionBoletas;
    }

    public void setListFuncionBoletas(List<Boleta> listFuncionBoletas) {
        this.listFuncionBoletas = listFuncionBoletas;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {
        return "Funcion{" +
                "codigoFuncion=" + codigoFuncion +
                ", fechaPresentacion='" + fechaPresentacion + '\'' +
                ", horaInicio='" + horaInicio + '\'' +
                ", precioBaseBoleta=" + precioBaseBoleta +
                ", pelicula=" + pelicula.getTitulo() +
                ", sala=" + sala.getNombre() +
                '}';
    }
}
