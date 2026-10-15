package uniquindio.edu.co.model;

import java.util.ArrayList;
import java.util.List;

public class Cine {
    // Atributos de la clase Cine
    public String nombreComercial;
    public int nit;
    public String direccion;
    // Relacions de la clase Cine
    private List<Sala> listCineSalas;
    private List<Asiento> listCineAsientos;
    private List<Pelicula> listCinePeliculas;
    private List<Funcion> listCineFunciones;
    private List<Persona> listCinePersonas;
    private List<Venta> listCineVentas;
    private List<Boleta> listCineBoletas;

    /**
     * Metodo constructor de la clase Cine
     * @param nombreComercial del Cine
     * @param nit del Cine
     * @param direccion del Cine
     */
    public Cine(String nombreComercial, int nit, String direccion) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;

        listCineSalas = new ArrayList<>();
        listCineAsientos = new ArrayList<>();
        listCinePeliculas = new ArrayList<>();
        listCineFunciones = new ArrayList<>();
        listCinePersonas = new ArrayList<>();
        listCineVentas = new ArrayList<>();
        listCineBoletas = new ArrayList<>();
    }

    /**
     * Metodo que permite registrar una sala
     * @param codigoSala de la sala
     * @param nombre de la sala
     * @param capacidadMaxima de la sala
     * @return
     */
    public boolean registrarSala(int codigoSala, String nombre, int capacidadMaxima, TipoSala tipoSala){
        boolean existe = false;
        Sala sala = buscarSala(codigoSala);
        if (sala == null){
            Sala sal = new Sala(codigoSala, nombre, capacidadMaxima, tipoSala);
            listCineSalas.add(sal);
        }
        return existe;
    }
    /**
     * Metodo que permite buscar una sala
     * @param codigoSala de la sala
     * @return
     */
    public Sala buscarSala(int codigoSala){
        Sala encontrar = null;
        for(int i = 0; i<listCineSalas.size(); i++){
            Sala sala = listCineSalas.get(i);
            if(sala.getCodigoSala() == codigoSala){
                encontrar = sala;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite saber si una sala esta disponible para otra funcion
     * @param sala de la funcion
     * @param fecha de la funcion
     * @param horaInicio de la funcion
     * @param duracionPeliculaMinutos de la funcion
     * @return
     */
    public boolean esSalaDisponible(Sala sala, String fecha, String horaInicio, int duracionPeliculaMinutos){
        boolean disponible = true;
        for(int i = 0; i<listCineFunciones.size(); i++){
            Funcion fun = listCineFunciones.get(i);
            if(fun.getSala().getCodigoSala() == sala.getCodigoSala() && fun.getFechaPresentacion().equalsIgnoreCase(fecha)){
                disponible = false;
            }
        }
        return disponible;
    }
    /**
     * Metodo que me permite registrar una funcion
     * @param codigoFuncion de la funcion
     * @param fechaPresentacion de la funcion
     * @param horaInicio de la funcion
     * @param precioBaseBoleta de la funcion
     * @param codigoPelicula de la funcion
     * @param codigoSala de la funcion
     * @return
     */
    public boolean registrarFuncion(int codigoFuncion, String fechaPresentacion, String horaInicio, double precioBaseBoleta, int codigoPelicula, int codigoSala){
        boolean existe = false;
        Funcion funcion = buscarFuncion(codigoFuncion);
        if(funcion == null){
            Pelicula pelicula = buscarPelicula(codigoPelicula);
            Sala sala = buscarSala(codigoSala);
            if(pelicula != null && sala != null){
                if (esSalaDisponible(sala, fechaPresentacion, horaInicio, pelicula.getDuracionMinutos())) {
                    Funcion funcion1 = new Funcion(codigoFuncion, fechaPresentacion, horaInicio, precioBaseBoleta, pelicula, sala);
                    listCineFunciones.add(funcion1);
                    pelicula.getListPeliculaFunciones().add(funcion1);
                    existe = true;
                }
            }
        }
        return existe;
    }
    /**
     * Metodo que me permite buscar una funcion
     * @param codigoFuncion de la funcion
     * @return
     */
    public Funcion buscarFuncion(int codigoFuncion){
        Funcion encontrar = null;
        for(int i = 0; i<listCineFunciones.size(); i++){
            Funcion funcion = listCineFunciones.get(i);
            if(funcion.getCodigoFuncion() == codigoFuncion){
                encontrar = funcion;
                break;
            }
        }
        return encontrar;
    }
    /**
     * Metodo que me permite registrar un asiento
     * @param fila del asiento
     * @param numeroAsiento del asiento
     * @return
     */
    public boolean registrarAsiento(String fila, int numeroAsiento, EstadoAsiento esatdo){
        boolean existe = false;
        Asiento asiento = buscarAsiento(fila, numeroAsiento);
        if (asiento == null){
            Asiento asient = new Asiento(fila, numeroAsiento, esatdo);
            listCineAsientos.add(asient);
        }
        return existe;
    }
    /**
     * Metodo que permite encontrar un asiento
     * @param numeroAsiento del asiento
     * @return
     */
    public Asiento buscarAsiento(String fila, int numeroAsiento){
        Asiento encontrar = null;
        for(int i = 0; i<listCineAsientos.size(); i++){
            Asiento asiento = listCineAsientos.get(i);
            if(asiento.getFila().equalsIgnoreCase(fila) && asiento.getNumeroAsiento() == numeroAsiento){
                encontrar = asiento;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite registrar una pelicula
     * @param codigoPelicula de la pelicula
     * @param titulo de la pelicula
     * @param duracionMinutos de la pelicula
     * @param clacificacionEdad de la pelicula
     * @param genero de la pelicula
     * @return
     */
    public boolean registrarPelicula(int codigoPelicula, String titulo, int duracionMinutos, String clacificacionEdad, Genero genero){
        boolean existe = false;
        Pelicula pelicula = buscarPelicula(codigoPelicula);
        if (pelicula == null){
            Pelicula peli = new Pelicula(codigoPelicula, titulo, duracionMinutos, clacificacionEdad, genero);
            listCinePeliculas.add(peli);
        }
        return existe;
    }
    /**
     * Metodo que me permite buscar una pelicula
     * @param codigoPelicula de la pelicula
     * @return
     */
    public Pelicula buscarPelicula(int codigoPelicula){
        Pelicula encontrar = null;
        for(int i = 0; i<listCinePeliculas.size(); i++){
            Pelicula pelicula = listCinePeliculas.get(i);
            if(pelicula.getCodigoPalicula() == codigoPelicula){
                encontrar = pelicula;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite registrar a una persona
     * @param documento de la persona
     * @param nombreCompleto de la persona
     * @param correoElectronico de la persona
     * @param telefono de la persona
     * @return
     */
    public boolean registrarPersona(int documento, String nombreCompleto, String correoElectronico, int telefono){
        boolean existe = false;
        Persona persona = buscarPersona(documento);
        if(persona == null){
            Persona perso = new Persona(documento, nombreCompleto, correoElectronico, telefono);
            listCinePersonas.add(perso);
        }
        return existe;
    }
    /**
     * Metodo que me permite buscar a una persona
     * @param documento de la persona
     * @return
     */
    public Persona buscarPersona(int documento){
        Persona encontrar = null;

        for(int i = 0; i<listCinePersonas.size(); i++){
            Persona persona = listCinePersonas.get(i);
            if(persona.getDocumento() == documento){
                encontrar = persona;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite registrar un cliente
     * @param documento del cliente
     * @param nombreCompleto del cliente
     * @param correoElectronico del cliente
     * @param telefono del cliente
     * @param codigoAfiliacion del cliente
     * @param porcentajeDescuento del cliente
     * @return
     */
    public boolean registrarCliente(int documento, String nombreCompleto, String correoElectronico, int telefono, int codigoAfiliacion, double porcentajeDescuento){
        boolean existe = false;
        Persona persona = buscarPersona(documento);
        if(persona == null){
            Cliente cliente = new Cliente(documento, nombreCompleto, correoElectronico, telefono, codigoAfiliacion, porcentajeDescuento);
            listCinePersonas.add(cliente);
        }
        return existe;
    }

    /**
     * Mertodo que me permite registrar un operario
     * @param documento del operario
     * @param nombreCompleto del operario
     * @param correoElectronico del operario
     * @param telefono del operario
     * @param codigoEmpleado del operario
     * @param fechaContratacion del operario
     * @param salarioBasico del operario
     * @return
     */
    public boolean registrarOperario(int documento, String nombreCompleto, String correoElectronico, int telefono, int codigoEmpleado, String fechaContratacion, double salarioBasico){
        boolean existe = false;
        Persona persona = buscarPersona(documento);
        if(persona == null){
            Operario operario = new Operario(documento, nombreCompleto, correoElectronico, telefono, codigoEmpleado, fechaContratacion, salarioBasico);
            listCinePersonas.add(operario);
        }
        return existe;
    }

    /**
     * Metodo que permite buscar una venta
     * @param codigoVenta de la venta
     * @return
     */
    public Venta buscarVenta(int codigoVenta){
        Venta encontrar = null;
        for(int i = 0; i<listCineVentas.size(); i++){
            Venta venta = listCineVentas.get(i);
            if(venta.getCodigoVenta() == codigoVenta){
                encontrar = venta;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite buscar a un Operario
     * @param documento del operario
     * @return
     */
    public Operario buscarOperario(int documento){
        Operario encontrar = null;
        for(int i = 0; i<listCinePersonas.size(); i++){
            Persona persona = listCinePersonas.get(i);
            if(persona.getDocumento() == documento){
                encontrar = (Operario) persona;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite encontrar a un Cliente
     * @param documento del cliente
     * @return
     */
    public Cliente buscarCliente(int documento){
        Cliente encontrar = null;
        for(int i = 0; i<listCinePersonas.size(); i++){
            Persona persona = listCinePersonas.get(i);
            if(persona.getDocumento() == documento){
                encontrar = (Cliente) persona;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que me permite registrar una venta
     * @param codigoVenta de la venta
     * @param fechaRealizacion de la venta
     * @param documentoOperario de la venta
     * @param documentoCliente de la venta
     * @param codigoFuncion de la venta
     * @param operario de la venta
     * @param cliente de la venta
     * @return
     */
    public boolean registrarVenta (int codigoVenta, String fechaRealizacion, int documentoOperario, int documentoCliente, int codigoFuncion, Operario operario, Cliente cliente){
        boolean existe = false;
        Venta venta = buscarVenta(codigoVenta);
        if (venta == null) {
            Operario opera = buscarOperario(documentoOperario);
            Cliente clien = buscarCliente(documentoCliente);
            Funcion funcion = buscarFuncion(codigoFuncion);
            if(operario != null && cliente != null && funcion != null){
                boolean todosDisponibles = true;
                for(int i = 0; i<listCineBoletas.size(); i++){
                    Boleta boleta = listCineBoletas.get(i);
                    if(!funcion.esAsientoDisponible(boleta.getFila(), boleta.getNumeroAsiento())){
                        todosDisponibles = false;
                        break;
                    }
                }
                if (todosDisponibles) {
                    Venta nuevaVenta = new Venta(codigoVenta, fechaRealizacion, operario, cliente);
                    for(int i = 0; i<listCineBoletas.size(); i++){
                        Boleta boleta = listCineBoletas.get(i);
                        double valorIndividual = boleta.calcularValorIndividual(funcion, cliente);
                        boleta.setValorIndividualPagado(valorIndividual);
                        DetalleVenta detalle = new DetalleVenta(1, boleta.getValorIndividualPagado(), i + 1, boleta);
                        boleta.setDetalleVenta(detalle);
                        nuevaVenta.getListDetallesVenta().add(detalle);
                        funcion.getListFuncionBoletas().add(boleta);
                        cliente.getListClienteBoletas().add(boleta);
                    }
                    listCineVentas.add(nuevaVenta);
                    cliente.getListClienteVentas().add(nuevaVenta);
                    operario.getListOperarioVentas().add(nuevaVenta);
                    existe = true;
                }
            }
        }
        return existe;
    }

    /**
     * Metodo que me permite saber la ocupacion de una funcion
     * @param codigoFuncion de la funcion
     * @return
     */
    public int calcularOcupacionFuncion(int codigoFuncion){
        int ocupacion = 0;
        Funcion funcion = buscarFuncion(codigoFuncion);
        if(funcion != null){
            ocupacion = funcion.getListFuncionBoletas().size();
        }
        return ocupacion;
    }

    /**
     * Metodo que me permite calcular el porcentaje de ocupacion de una funcion
     * @param codigoFuncion de la funcion
     * @return
     */
    public double calcularPorcentajeOcupacion(int codigoFuncion){
        double porcentajeOcupacion = 0.0;
        Funcion funcion = buscarFuncion(codigoFuncion);
        if(funcion != null && funcion.getSala() != null && funcion.getSala().getCapacidadMaxima() > 0){
            porcentajeOcupacion = ((double) funcion.getListFuncionAsientos().size() / funcion.getSala().getCapacidadMaxima()) * 100;
        }
        return porcentajeOcupacion;
    }

    /**
     * Metodo que permite calcular los ingresos por funcion
     * @param codigoFuncion de la funcion
     * @return
     */
    public double calcularIngresosPorFuncion(int codigoFuncion){
        double ingresosPorFuncion = 0.0;
        Funcion funcion = buscarFuncion(codigoFuncion);
        if(funcion != null){
            for(Boleta boleta : funcion.getListFuncionBoletas()){
                ingresosPorFuncion += boleta.getValorIndividualPagado();
            }
        }
        return ingresosPorFuncion;
    }

    /**
     * Metodo que permite calcular el total de ingresos por funciones
     * @return
     */
    public double calcularIngresosTotales(){
        double total = 0.0;
        for( Venta venta : listCineVentas){
            total += venta.calcularValorTotal();
        }
        return total;
    }

    /**
     * Metodo que permite buscar un Boleta
     * @param codigoBoleta de la Boleta
     * @return
     */
    public Boleta buscarBoleta(int codigoBoleta){
        Boleta encontrar = null;
        for(int i = 0; i<listCineBoletas.size(); i++){
            Boleta boleta = listCineBoletas.get(i);
            if(boleta.getCodigoBoleta() == codigoBoleta){
                encontrar = boleta;
                break;
            }
        }
        return encontrar;
    }

    /**
     * Metodo que mepermite registrar una Boleta
     * @param codigoBoleta de la boleta
     * @param fila de la boleta
     * @param numeroAsiento de la boleta
     * @param valorIndividualPagado de la boleta
     * @return
     */
    public boolean registrarBoleta(int codigoBoleta, String fila, int numeroAsiento, double valorIndividualPagado){
        boolean existe = false;
        Boleta boleta = buscarBoleta(codigoBoleta);
        if(boleta == null){
            Boleta bolet = new Boleta(codigoBoleta, fila, numeroAsiento, valorIndividualPagado);
            listCineBoletas.add(bolet);
        }
        return existe;
    }
    public List<Pelicula> obtenerPeliculasDisponibles(){
        return new ArrayList<>(listCinePeliculas);
    }
    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }
    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Sala> getListCineSalas() {
        return listCineSalas;
    }

    public void setListCineSalas(List<Sala> listCineSalas) {
        this.listCineSalas = listCineSalas;
    }

    public List<Asiento> getListCineAsientos() {
        return listCineAsientos;
    }

    public void setListCineAsientos(List<Asiento> listCineAsientos) {
        this.listCineAsientos = listCineAsientos;
    }

    public List<Pelicula> getListCinePeliculas() {
        return listCinePeliculas;
    }

    public void setListCinePeliculas(List<Pelicula> listCinePeliculas) {
        this.listCinePeliculas = listCinePeliculas;
    }

    public List<Funcion> getListCineFunciones() {
        return listCineFunciones;
    }

    public void setListCineFunciones(List<Funcion> listCineFunciones) {
        this.listCineFunciones = listCineFunciones;
    }

    public List<Persona> getListCinePersonas() {
        return listCinePersonas;
    }

    public void setListCinePersonas(List<Persona> listCinePersonas) {
        this.listCinePersonas = listCinePersonas;
    }

    public List<Venta> getListCineVentas() {
        return listCineVentas;
    }

    public void setListCineVentas(List<Venta> listCineVentas) {
        this.listCineVentas = listCineVentas;
    }

    public List<Boleta> getListCineBoletas() {
        return listCineBoletas;
    }

    public void setListCineBoletas(List<Boleta> listCineBoletas) {
        this.listCineBoletas = listCineBoletas;
    }

    @Override
    public String toString() {
        return "Cine{" +
                "nombreComercial='" + nombreComercial + '\'' +
                ", nit=" + nit +
                ", direccion='" + direccion + '\'' +
                ", listCineSalas=" + listCineSalas +
                ", listCineAsientos=" + listCineAsientos +
                ", listCinePeliculas=" + listCinePeliculas +
                ", listCineFunciones=" + listCineFunciones +
                ", listCinePersonas=" + listCinePersonas +
                ", listCineVentas=" + listCineVentas +
                ", listCineBoletas=" + listCineBoletas +
                '}';
    }
}
