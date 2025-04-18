package view;

import model.EstadoPropuesta;
import model.Propuesta;

import java.sql.Date;
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
                System.out.println("Introduce el id: ");
                id = scanner.nextInt();
            } catch (Exception e){
                correcto = false;
                System.out.println("Error, por favor introduce un número entero.");
                scanner.next();
            }
        }

        return id;
    }

    /**
     * Metodo que pide los datos necesarios y crea una propuesta
     * @return Propuesta creada por el usuario
     */
    public Propuesta crearPropuesta(boolean conId){

        boolean propuestaCorrecta = false;
        Propuesta propuesta = null;

        System.out.println("\n---Creación de propuesta---");

        int id = 0;
        String titulo;
        String descripcion;
        Date fechaExpiracion;
        EstadoPropuesta estadoPropuesta = null;
        int idCongreso;
        String numPasaportePolitico;
        Date fechaProposicion;
        Date fechaAceptacion;
        Date fechaPublicacion;

        while (!propuestaCorrecta) {
            try {
                boolean estadoCorrecto = false;
                propuestaCorrecta = true;

                if(conId){
                    System.out.print("Introduce un id: ");
                    id = pedirId();
                }

                System.out.print("Introduce un título: ");
                titulo = scanner.nextLine();

                System.out.print("Introduce un título: ");
                descripcion = scanner.nextLine();

                System.out.print("Introduce una fecha de expiración (formato: 'año-mes-dia'): ");
                fechaExpiracion = introducirFecha();

                while (!estadoCorrecto){
                    try {
                        System.out.print("Introduce un estado (ACEPTACION, PUBLICACION, VOTACION, TERMINADA): ");
                        estadoCorrecto = true;
                        estadoPropuesta = EstadoPropuesta.valueOf(scanner.nextLine().toUpperCase());
                    } catch (Exception e) {
                        System.out.println("Error: el estado de la propuesta solo puede tener uno de estos valores:\n" +
                                "(ACEPTACION, PUBLICACION, VOTACION, TERMINADA)");
                        estadoCorrecto = false;
                        scanner.next();
                    }
                }
                idCongreso = scanner.nextInt();
                numPasaportePolitico = scanner.nextLine();
                fechaProposicion = introducirFecha();
                fechaAceptacion = introducirFecha();
                fechaPublicacion = introducirFecha();

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
                scanner.next();
            }

        }

        return propuesta;
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
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
                scanner.next();
            }
        }
        return fecha;
    }

}
