package uniquindio.edu.co;

import uniquindio.edu.co.model.*;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine("CinePuls", 1327, "Armenia-Quindío");
        int opcion = 0;
        while (opcion != 22){
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu
                    1. Registrar Sala.
                    2. Obtener Información de Salas Ocupadas.
                    3. Registrar Pelicula.
                    4. Buscar Pelicula.
                    5. Registrar Asiento.
                    6. Buscar Asiento.
                    7. Programar Funciones.
                    8. Consultar Funcion.
                    9. Registrar Persona.
                    10. Buscar Persona.
                    11. Registrar Cliente.
                    12. Buscar Cliente.
                    13. Registrar Operario.
                    14. Buscar Operario.
                    15. Registrar Boleta.
                    16. Buscar Boleta.
                    17. Registrar Venta.
                    18. Buscar Venta.
                    19. Consultar Peliculas Disponibles.
                    20. Consultar Ingresos Obtenidos.
                    21. Consultar Ingresos por Funcion.
                    22. Salir del programa.
                    """));
            if(opcion == 1){
                int codigoSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Sala: "));
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre de la Sala: ");
                int capacidadMaxima = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el capacidad maxima de Personas en la Sala: "));
                int opccionEstado = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Tipo Sala
                        1. Tradicional.
                        2. Vip.
                        3. 3D.
                        """));
                TipoSala tipoSala = null;
                if(opccionEstado == 1){
                    tipoSala = TipoSala.TRADICIONAL;
                }else if(opccionEstado == 2){
                    tipoSala = TipoSala.VIP;
                }else if(opccionEstado == 3){
                    tipoSala = TipoSala.TRES_D;
                }
                cine.registrarSala(codigoSala, nombre, capacidadMaxima, tipoSala);
                JOptionPane.showMessageDialog(null, "Sala registrada con exito");
            }else if(opcion == 2){
                int codigoSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Sala:"));
                Sala sala = cine.buscarSala(codigoSala);
                if(sala != null){
                    JOptionPane.showMessageDialog(null, "Sala encontrada.\n"+sala.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Sala no encontrada");
                }
            }else if(opcion == 3){
                int codigoPelicula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Pelicula: "));
                String titulo = JOptionPane.showInputDialog(null, "Ingrese el nombre de la Pelicula: ");
                int duracionMinutos = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la duración de la Pelicula en minutos: "));
                String clasificacionEdad = JOptionPane.showInputDialog(null, "Ingrese la clasificación de edad de la Pelicula: ");
                int opcionEstado = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Genero
                        1. Accion.
                        2. Comedia.
                        3. Drama.
                        4. Terror.
                        5. Animacion.
                        """));
                Genero genero = null;
                if(opcionEstado == 1){
                    genero = Genero.ACCION;
                }else if(opcionEstado == 2){
                    genero = Genero.COMDEIA;
                }else if(opcionEstado == 3){
                    genero = Genero.DRAMA;
                }else if(opcionEstado == 4){
                    genero = Genero.TERROR;
                }else if(opcionEstado == 5){
                    genero = Genero.ANIMACION;
                }
                cine.registrarPelicula(codigoPelicula, titulo, duracionMinutos, clasificacionEdad, genero);
                JOptionPane.showMessageDialog(null, "Pelicula registrada con exito.");
            }else if(opcion == 4){
                int codigoPelicula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Pelicula: "));
                Pelicula pelicula = cine.buscarPelicula(codigoPelicula);
                if(pelicula != null){
                    JOptionPane.showMessageDialog(null, "Pelicula encontrada.\n"+pelicula.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Pelicula no encontrada");
                }
            }else if(opcion == 5){
                String fila = JOptionPane.showInputDialog(null, "Ingrese la fila del Asiento: ");
                int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de Asiento: "));
                int opcionEstado = Integer.parseInt(JOptionPane.showInputDialog(null, """
                        Estado Asiento
                        1. Libre.
                        2. Ocupado.
                        3. Reservado.
                        """));
                EstadoAsiento estado = null;
                if(opcionEstado == 1){
                    estado = EstadoAsiento.LIBRE;
                }else if(opcionEstado == 2){
                    estado = EstadoAsiento.OCUPADO;
                }else if(opcionEstado == 3){
                    estado = EstadoAsiento.RESERVADO;
                }
                cine.registrarAsiento(fila, numeroAsiento, estado);
                JOptionPane.showMessageDialog(null, "Asiento registrado con exito.");
            }else if(opcion == 6){
                String fila = JOptionPane.showInputDialog(null, "Ingrese la fila del Asiento: ");
                int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el número de Asiento: "));
                Asiento asiento = cine.buscarAsiento(fila, numeroAsiento);
                if(asiento != null){
                    JOptionPane.showMessageDialog(null, "Asiento encontrado con exito.\n"+asiento.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Asiento no encontrado");
                }
            }else if(opcion == 7){
                int codigoFuncion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el códio de la Funcion: "));
                String fechaPresentacion = JOptionPane.showInputDialog(null, "Ingrese la fecha de presentación de la Funcion: ");
                String horaInicio = JOptionPane.showInputDialog(null, "Ingrese la hora de inicio de la Funcion: ");
                double precioBaseBoleta = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el precio base de la Boleta: "));
                int codigoPelicula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Pelicula: "));
                int codigoSala = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Sala: "));
                cine.registrarFuncion(codigoFuncion,fechaPresentacion,horaInicio,precioBaseBoleta,codigoPelicula,codigoSala);
                JOptionPane.showMessageDialog(null, "La Funcion fue registrada con exito.");
            }else if(opcion == 8){
                int codigoFuncion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Funcion: "));
                Funcion funcion = cine.buscarFuncion(codigoFuncion);
                if(funcion != null){
                    JOptionPane.showMessageDialog(null, "Funcion encontrada con exito.\n"+funcion.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Funcion no encontrada");
                }
            }else if(opcion == 9){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento de la Persona: "));
                String nombreCompleto =  JOptionPane.showInputDialog(null, "Ingrese el nombre de la Persona: ");
                String correoElectronico = JOptionPane.showInputDialog(null, "Ingrese el correo de la Persona: ");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el telefono de la Persona: "));
                cine.registrarPersona(documento, nombreCompleto, correoElectronico, telefono);
                JOptionPane.showMessageDialog(null, "Persona registrado con exito.");
            }else if(opcion == 10){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento de la Persona: "));
                Persona persona = cine.buscarPersona(documento);
                if(persona != null){
                    JOptionPane.showMessageDialog(null, "Persona encontrada con exito.\n"+persona.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Persona no encontrada");
                }
            }else if(opcion == 11){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Cliente: "));
                String nombreCompleto =  JOptionPane.showInputDialog(null, "Ingrese el nombre del Cliente: ");
                String correoElectronico = JOptionPane.showInputDialog(null, "Ingrese el correo del Cliente: ");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el telefono del Cliente: "));
                int codigoAfiliacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de Afiliacion del Cliente: "));
                double porcentajeDescuento = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el porcentaje de descuento del Cliente: "));
                cine.registrarCliente(documento, nombreCompleto, correoElectronico, telefono, codigoAfiliacion, porcentajeDescuento);
                JOptionPane.showMessageDialog(null, "Cliente registrado con exito.");
            }else if(opcion == 12){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Cliente: "));
                Cliente cliente = cine.buscarCliente(documento);
                if(cliente != null){
                    JOptionPane.showMessageDialog(null, "Cliente encontrado con exito.\n"+cliente.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Cliente no encontrado");
                }
            }else if(opcion == 13){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Operario: "));
                String nombreCompleto =  JOptionPane.showInputDialog(null, "Ingrese el nombre del Operario: ");
                String correoElectronico = JOptionPane.showInputDialog(null, "Ingrese el correo del Operario: ");
                int telefono = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el telefono del Operario: "));
                int codigoEmpleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del Operario: "));
                String fechaContratacion = JOptionPane.showInputDialog(null, "Ingrese la fecha de contratacion del Operario: ");
                double salarioBasico = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese la salario del Operario: "));
                cine.registrarOperario(documento,nombreCompleto,correoElectronico,telefono,codigoEmpleado,fechaContratacion,salarioBasico);
                JOptionPane.showMessageDialog(null, "Operario registrado con exito.");
            }else if(opcion == 14){
                int documento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Operario: "));
                Operario operario = cine.buscarOperario(documento);
                if(operario != null){
                    JOptionPane.showMessageDialog(null, "Operario encontrado con exito.\n"+operario.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Operario no encontrado");
                }
            }else if(opcion == 15){
                int codigoBoleta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del Boleta: "));
                String fila = JOptionPane.showInputDialog(null, "Ingrese la fila del Asiento: ");
                int numeroAsiento = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de Asiento: "));
                double valorIndividualPagado = Double.parseDouble(JOptionPane.showInputDialog(null, "El valor Individual Pagado es: "));
                cine.registrarBoleta(codigoBoleta, fila, numeroAsiento, valorIndividualPagado);
                JOptionPane.showMessageDialog(null, "Boleta registrado con exito.");
            }else if(opcion == 16){
                int codigoBoleta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo del Boleta: "));
                Boleta boleta = cine.buscarBoleta(codigoBoleta);
                if(boleta != null){
                    JOptionPane.showMessageDialog(null, "Boleta encontrada con exito.\n"+boleta.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Boleta no encontrado");
                }
            }
            else if(opcion == 17){
                int codigoVenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de venta: "));
                String fechaRealzacion = JOptionPane.showInputDialog(null, "Ingrese la fecha de realizacion del venta: ");
                int documentoOperario = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Operario: "));
                int documentoCliente = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el documento del Cliente: "));
                int codigoFuncion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de la Funcion: "));
                Operario operario = cine.buscarOperario(documentoOperario);
                Cliente cliente = cine.buscarCliente(documentoCliente);
                cine.registrarVenta(codigoVenta,fechaRealzacion,documentoOperario,documentoCliente,codigoFuncion,operario,cliente);
                JOptionPane.showMessageDialog(null, "Venta registrado con exito.");
            }else if(opcion == 18){
                int codigoVenta = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el código de Venta: "));
                Venta venta = cine.buscarVenta(codigoVenta);
                if(venta != null){
                    JOptionPane.showMessageDialog(null, "Venta encontrado con exito.\n"+venta.toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Venta no encontrado");
                }
            }else if(opcion == 19){
                JOptionPane.showMessageDialog(null, cine.getListCinePeliculas());
            }else if(opcion == 20){
                double ingresosTotales = cine.calcularIngresosTotales();
                JOptionPane.showMessageDialog(null, "Ingresos totales: "+ingresosTotales);
            }else if(opcion == 21){
                int codigoFuncion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el codigo de la Funcion: "));
                double ingresoFuncion = cine.calcularIngresosPorFuncion(codigoFuncion);
                JOptionPane.showMessageDialog(null, "Los ingresos obtenidos para la funcion "+codigoFuncion+" son $:"+ingresoFuncion);
            }else if(opcion == 22){
                JOptionPane.showMessageDialog(null, "Salir del Programa.");
            }
        }
    }
}
