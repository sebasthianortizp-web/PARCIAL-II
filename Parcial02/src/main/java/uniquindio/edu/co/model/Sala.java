package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    // Atributo de la clase Sala
    private int codigoSala;
    private String nombre;
    private int capacidadMaxima;
    private TipoSala tipoSala;

    // Relaciones de la clase Sala
    private List<Asiento> listSalaAsientos;
    private List<Pelicula> listSalaPeliculas;
    private List<Funcion> listSalaFunciones;
    private List<Boleta> listSalaBoletas;

    /**
     * Metodo constructor de la clase Sala
     * @param codigoSala de la sala
     * @param nombre de la sala
     * @param capacidadMaxima de la sala
     */
    public Sala(int codigoSala, String nombre, int capacidadMaxima, TipoSala tipoSala){
        this.codigoSala = codigoSala;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.tipoSala = tipoSala;

        this.listSalaAsientos = new ArrayList<>();
        this.listSalaPeliculas = new ArrayList<>();
        this.listSalaFunciones = new ArrayList<>();
        this.listSalaBoletas = new ArrayList<>();
    }

    public int getCodigoSala() {
        return codigoSala;
    }

    public void setCodigoSala(int codigoSala) {
        this.codigoSala = codigoSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Asiento> getListSalaAsientos() {
        return listSalaAsientos;
    }

    public void setListSalaAsientos(List<Asiento> listSalaAsientos) {
        this.listSalaAsientos = listSalaAsientos;
    }

    public List<Pelicula> getListSalaPeliculas() {
        return listSalaPeliculas;
    }

    public void setListSalaPeliculas(List<Pelicula> listSalaPeliculas) {
        this.listSalaPeliculas = listSalaPeliculas;
    }

    public List<Funcion> getListSalaFunciones() {
        return listSalaFunciones;
    }

    public void setListSalaFunciones(List<Funcion> listSalaFunciones) {
        this.listSalaFunciones = listSalaFunciones;
    }

    public List<Boleta> getListSalaBoletas() {
        return listSalaBoletas;
    }

    public void setListSalaBoletas(List<Boleta> listSalaBoletas) {
        this.listSalaBoletas = listSalaBoletas;
    }

    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "codigoSala=" + codigoSala +
                ", nombre='" + nombre + '\'' +
                ", capacidadMaxima=" + capacidadMaxima +
                ", tipoSala=" + tipoSala +
                '}';
    }
}
