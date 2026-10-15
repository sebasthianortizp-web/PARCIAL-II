package uniquindio.edu.co.model;

public class Asiento {
    //Atributos de la clase Asiento
    private String fila;
    private int numeroAsiento;
    private EstadoAsiento estado;

    /**
     * Metodo constructor de la clase  Asiento
     */
    public Asiento(String fila, int numeroAsiento, EstadoAsiento estado){
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
        this.estado = estado;
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

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "fila='" + fila + '\'' +
                ", numeroAsiento=" + numeroAsiento +
                ", estado=" + estado +
                '}';
    }
}
