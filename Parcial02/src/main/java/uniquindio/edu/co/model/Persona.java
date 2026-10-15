package uniquindio.edu.co.model;

public class Persona {
    // Atributos de la clase Persona
    private int documento;
    private String nombreCompleto;
    private String correoElectronico;
    private int telefono;

    /**
     * Metodo constructor de la clase Persona
     * @param documento de la persona
     * @param nombreCompleto de la persona
     * @param correoElectronico de la persona
     * @param telefono de la persona
     */
    public Persona(int documento, String nombreCompleto, String correoElectronico, int telefono) {
        this.documento = documento;
        this.nombreCompleto = nombreCompleto;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "documento=" + documento +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
