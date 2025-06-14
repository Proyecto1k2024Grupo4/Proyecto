package view;

import model.EstadoPropuesta;
import model.Propuesta;

import java.sql.Date;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaPropuesta que se encarga de pedir o mostrar los datos de las Propuestas al usuario.
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 13-04-2025
 */
public class VistaPropuesta {

    public Scanner scanner;

    /**
     * Constructor que no recibe parámetros
     */
    public VistaPropuesta(){
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo que muestra por pantalla todas las propuestas que se le pasen mediante
     * un List como parámetro.
     * @param propuestas Lista de propuestas a mostrar
     */
    public void mostrarPropuestas(List<Propuesta> propuestas){
        System.out.println("Lista de propuestas:");
        propuestas.forEach(System.out::println);
    }

    /**
     * Metodo que muestra por pantalla una propuesta.
     * @param propuesta Propuesta que se desea mostrar
     */
    public void mostrarPropuesta(Propuesta propuesta){
        System.out.println(propuesta);
    }

    /**
     * Metodo que pide un id de una propuesta o un código civil de manera correcta
     * @return int con el id
     */
    public int pedirId(){
        boolean correcto = false;
        int id = 0;

        while (!correcto){
            try {
                correcto = true;
                System.out.print("Introduce el id: ");
                id = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                correcto = false;
                System.out.println("Error, por favor introduce un número entero.");
                scanner.next();
            }
        }

        return id;
    }

    /**
     * Metodo que pide un String como nombre de pais que debe cumplir con el limite de caracteres
     * de la base de datos
     * @return String con el nombre del pais
     */
    public String pedirNombre(){
        boolean correcto = false;
        String nombre = "";

        while (!correcto){
            try{
                correcto = true;
                while (nombre.isEmpty() || nombre.length() > 64){
                    nombre = "";
                    System.out.print("Introduce el nombre del país: ");
                    nombre = scanner.nextLine();
                    if (nombre.isEmpty() || nombre.length() > 64){
                        System.out.println("El nombre debe tener entre 1 y 64 caracteres.");
                    }
                }
            } catch (Exception e){
                correcto = false;
                System.out.println(e.getMessage());
            }
        }

        return nombre;
    }


    /**
     * Metodo que pide los datos necesarios y crea una propuesta
     * @return Propuesta creada por el usuario
     */
    public Propuesta crearPropuesta(boolean conId){

        boolean propuestaCorrecta = false;
        Propuesta propuesta = null;

        int id = 0;
        String titulo;
        String descripcion;
        Date fechaExpiracion = null;
        EstadoPropuesta estadoPropuesta = null;
        int idCongreso;
        String numPasaportePolitico;
        Date fechaProposicion;
        Date fechaAceptacion = null;
        Date fechaPublicacion = null;

        while (!propuestaCorrecta) {
            try {
                boolean estadoCorrecto = false;
                propuestaCorrecta = true;
                String atributoSinValor;

                if(conId){
                    id = pedirId();
                }

                System.out.print("Introduce un título: ");
                titulo = scanner.nextLine();

                System.out.print("Introduce una descripción: ");
                descripcion = scanner.nextLine();

                System.out.print("Introduce una fecha de expiración (formato: 'año-mes-dia')\n(si no desea que haya fecha de expiración introduzca 'null'): ");
                atributoSinValor = scanner.nextLine();
                if(!atributoSinValor.equals("null")) {
                    fechaExpiracion = introducirFecha(atributoSinValor);
                }

                while (!estadoCorrecto){
                    try {
                        System.out.print("Introduce un estado (ACEPTACION, PUBLICACION, VOTACION, TERMINADA): ");
                        estadoCorrecto = true;
                        String estadoString = scanner.nextLine().toUpperCase();
                        estadoPropuesta = EstadoPropuesta.valueOf(estadoString);
                    } catch (Exception e) {
                        System.out.println("Error: el estado de la propuesta solo puede tener uno de estos valores:\n" +
                                "(ACEPTACION, PUBLICACION, VOTACION, TERMINADA)");
                        estadoCorrecto = false;
                    }
                }

                System.out.print("Del congreso -> ");
                idCongreso = pedirId();

                System.out.print("Introduce el numero del pasaporte del político: ");
                numPasaportePolitico = scanner.nextLine();

                System.out.print("Introduce una fecha de proposicion (formato: 'año-mes-dia'): ");
                fechaProposicion = introducirFecha();

                System.out.print("Introduce una fecha de aceptación (formato: 'año-mes-dia')\n(si no desea que haya fecha de expiración introduzca 'null'): ");
                atributoSinValor = scanner.nextLine();
                if(!atributoSinValor.equals("null")) {
                    fechaAceptacion = introducirFecha(atributoSinValor);
                }

                System.out.print("Introduce una fecha de publicacion (formato: 'año-mes-dia')\n(si no desea que haya fecha de expiración introduzca 'null'): ");
                atributoSinValor = scanner.nextLine();
                if(!atributoSinValor.equals("null")){
                    fechaPublicacion = introducirFecha(atributoSinValor);
                }

                if (conId){
                    propuesta = new Propuesta(id, titulo, descripcion, fechaExpiracion, estadoPropuesta,
                            idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion);
                } else {
                    propuesta = new Propuesta(titulo, descripcion, fechaExpiracion, estadoPropuesta,
                            idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion);
                }


            } catch (Exception e){
                propuestaCorrecta = false;
                System.out.println(e.getMessage());
            }

        }

        return propuesta;
    }

    /**
     * Metodo que recibe un String como parametro y si es correcto lo convierte en Date. Si no es correcto el formato, lo pide hasta que sea correcto.
     * @return Date Fecha formato SQL
     */
    private Date introducirFecha(String fechaIntroducidaAntes){
        boolean correcto = false;
        Date fecha = null;
        boolean primeraVez = true;
        while(!correcto){
            try {
                correcto = true;
                if(primeraVez){
                    primeraVez = false;
                    fecha = Date.valueOf(LocalDate.parse(fechaIntroducidaAntes));
                } else {
                    fecha = Date.valueOf(LocalDate.parse(scanner.nextLine()));
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
            }
        }
        return fecha;
    }

    /**
     * Metodo que pide un String y lo convierte en Date. Si no es correcto el formato, lo pide hasta que sea correcto.
     * @return Date Fecha formato SQL
     */
    private Date introducirFecha(){
        boolean correcto = false;
        Date fecha = null;
        while(!correcto){
            try {
                correcto = true;
                fecha = Date.valueOf(LocalDate.parse(scanner.nextLine()));
            } catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
            }
        }
        return fecha;
    }

}
