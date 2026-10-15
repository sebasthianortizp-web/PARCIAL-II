package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    // Atributos de la clase Pelicula
    private int codigoPalicula;
    public String titulo;
    public int duracionMinutos;
    public String clacificacionEdad;
    private Genero genero;

    // Relaciones de la clase Pelicula
    private List<Funcion> listPeliculaFunciones;

    /**
     * Metodo constructor de la clase Pelicula
     * @param codigoPelicula de la pelicula
     * @param titulo de la pelicula
     * @param duracionMinutos de la pelicula
     * @param clacificacionEdad de la pelicula
     * @param genero de la pelicula
     */
    public Pelicula(int codigoPelicula, String titulo, int duracionMinutos, String clacificacionEdad, Genero genero) {
        this.codigoPalicula = codigoPelicula;
        this.titulo = titulo;
        this.duracionMinutos = duracionMinutos;
        this.clacificacionEdad = clacificacionEdad;
        this.genero = genero;

        this.listPeliculaFunciones = new ArrayList<>();
    }

    public int getCodigoPalicula() {
        return codigoPalicula;
    }

    public void setCodigoPalicula(int codigoPalicula) {
        this.codigoPalicula = codigoPalicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public String getClacificacionEdad() {
        return clacificacionEdad;
    }

    public void setClacificacionEdad(String clacificacionEdad) {
        this.clacificacionEdad = clacificacionEdad;
    }

    public List<Funcion> getListPeliculaFunciones() {
        return listPeliculaFunciones;
    }

    public void setListPeliculaFunciones(List<Funcion> listPeliculaFunciones) {
        this.listPeliculaFunciones = listPeliculaFunciones;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "codigoPalicula=" + codigoPalicula +
                ", titulo='" + titulo + '\'' +
                ", duracionMinutos=" + duracionMinutos +
                ", clacificacionEdad='" + clacificacionEdad + '\'' +
                ", genero=" + genero +
                '}';
    }
}

