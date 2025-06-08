package app;

import controller.*;
import db.DBConnection;

import java.util.Scanner;

/**
 * Clase Main que se ejecuta al inicio del programa y desde la que se muestran los distintos menús y se piden
 * las opciones.
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 07-06-2025
 */
public class Main {

    // Opcion límite de los menús
    public static final int OPCION_MAX_PROPUESTAS = 12;
    public static final int OPCION_MAX_MENU = 5;
    public static final int OPCION_MAX_PERSONAS = 14;
    public static final int OPCION_MAX_LEYES = 6;
    public static final int OPCION_MAX_PAISES = 6;


    public static void main(String[] args) {

        // Variable que se utilizara en el main para controlar la opcion introducida por el usuario
        int opcion = 0;

        // Bucle principal del menu
        do {
            mostrarMenu();
            while (opcionMenuPrincipal(opcion)) {
                opcion = introducirOpcion();
                if (opcionMenuPrincipal(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y " + OPCION_MAX_MENU + ": ");
            }
            switch (opcion) {
                case 1 -> {
                    opcion = 0;
                    mostrarMenuPropuestas();
                    ControllerPropuesta controllerPropuesta = new ControllerPropuesta();
                    ControllerVotar controllerVotar = new ControllerVotar();
                    while (opcionMenuPropuestas(opcion)) {
                        opcion = introducirOpcion();
                        if (opcionMenuPropuestas(opcion))
                            System.out.print("Por favor, introduce una opcion entre 1 y " + OPCION_MAX_PROPUESTAS + ": ");
                    }
                    switch (opcion) {
                        case 1 -> controllerPropuesta.mostrarTodasLasPropuestas();
                        case 2 -> controllerPropuesta.mostrarPropuestaPorId();
                        case 3 -> controllerPropuesta.mostrarPropuestaPorIdCongreso();
                        case 4 -> controllerPropuesta.mostrarPropuestaPorNombrePais();
                        case 5 -> controllerPropuesta.insertarPropuesta();
                        case 6 -> controllerPropuesta.actualizarPropuesta();
                        case 7 -> controllerVotar.insertarVoto();
                        case 8 -> controllerVotar.mostrarTodosLosVotos();
                        case 9 -> controllerVotar.mostrarVotosPorNumeroPasaporte();
                        case 10 -> controllerVotar.mostrarVotosPorIdPropuesta();
                        case 11 -> controllerVotar.mostrarVotosPorNumeroPasaporteEIdPropuesta();
                        case 12 -> {}
                    }
                    opcion = 0;
                }
                case 2 -> {
                    opcion = 0;
                    mostrarMenuPersonas();
                    ControllerPersona controllerPersona = new ControllerPersona();
                    ControllerPolitico controllerPolitico = new ControllerPolitico();
                    ControllerCiudadano controllerCiudadano = new ControllerCiudadano();
                    opcion = 0;
                    while (opcionMenuPersonas(opcion)){
                        opcion = introducirOpcion();
                        if (opcionMenuPersonas(opcion))
                            System.out.println("Por favor, introduce una opcion entre 1 y 14: ");
                    }
                    switch (opcion) {
                        case 1 -> controllerPersona.mostrarTodasLasPersonas();
                        case 2 -> controllerPersona.mostrarPersonaPais();
                        case 3 -> controllerPersona.mostarPersonaPasaporte();
                        case 4 -> controllerPersona.eliminarPersona();
                        case 5 -> controllerPolitico.mostrarTodosLosPoliticos();
                        case 6 -> controllerPolitico.mostrarPoliticoPasaporte();
                        case 7 -> controllerPolitico.crearPolitco();
                        case 8 -> controllerPolitico.acutalizarPolitico();
                        case 9 -> controllerCiudadano.mostrarTodosLosCiudadanos();
                        case 10 -> controllerCiudadano.mostrarCiudadanoPasaporte();
                        case 11 -> controllerCiudadano.crearCiudadano();
                        case 12 -> controllerCiudadano.actualizarCiudadano();
                        case 13 ->{}
                    }
                    opcion = 0;
                }
                case 3 -> {
                    opcion = 0;
                    mostrarMenuLeyes();
                    ControllerLey controllerLey = new ControllerLey();
                    while (opcionMenuLeyes(opcion)) {
                        opcion = introducirOpcion();
                        if (opcionMenuLeyes(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion) {
                        case 1 -> controllerLey.mostrarTodasLasLeyes();
                        case 2 -> controllerLey.insertarLey();
                        case 3 -> controllerLey.mostrarLeyPorId();
                        case 4 -> controllerLey.actualizarLey();
                        case 5 -> controllerLey.borrarLey();
                        case 6 -> {}
                    }
                    opcion = 0;
                }
                case 4 -> {
                    opcion = 0;
                    mostrarMenuPaises();
                    ControllerPais controllerPais = new ControllerPais();
                    while (opcionMenuPaises(opcion)) {
                        opcion = introducirOpcion();
                        if (opcionMenuPaises(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion) {
                        case 1 -> controllerPais.mostrarTodosLosPaises();
                        case 2 -> controllerPais.buscarPaisPorId();
                        case 3 -> controllerPais.crearPais();
                        case 4 -> controllerPais.actualizarPais();
                        case 5 -> controllerPais.eliminarPais();
                        case 6 -> {}
                    }
                    opcion = 0;
                }
                case 5 -> {
                    DBConnection.closeConnection();
                    System.out.println("Saliendo...");
                }
            } // Fin del switch
        } while (opcion != 5);
    } // Fin del main

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Propuestas");
        System.out.println("2. Personas");
        System.out.println("3. Leyes");
        System.out.println("4. Paises");
        System.out.println("5. Salir");
        System.out.print("Por favor, seleccione la opcione que desee consultar (1-5): ");
    }

    /**
     * Metodo que verifica si la opción se sale de los límites del menú principal.
     * En caso de que no esté dentro de los límites devuelve true y el bucle se repite.
     *
     * @param opcion Opcion seleccionada del menú
     * @return boolean para ver si la opción está fuera del rango
     */
    public static boolean opcionMenuPrincipal(int opcion) {
        return opcion < 1 || opcion > OPCION_MAX_MENU;
    }

    /**
     * Metodo que verifica si la opción se sale de los límites del menú de propuestas.
     * En caso de que no esté dentro de los límites devuelve true y el bucle se repite.
     *
     * @param opcion Opcion seleccionada del menú
     * @return boolean para ver si la opción está fuera del rango
     */
    public static boolean opcionMenuPropuestas(int opcion) {
        return opcion < 1 || opcion > OPCION_MAX_PROPUESTAS;
    }

    /**
     * Metodo que verifica si la opción se sale de los límites del menú de personas.
     * En caso de que no esté dentro de los límites devuelve true y el bucle se repite.
     *
     * @param opcion Opcion seleccionada del menú
     * @return boolean para ver si la opción está fuera del rango
     */
    public static boolean opcionMenuPersonas(int opcion) {
        return opcion < 1 || opcion > OPCION_MAX_PERSONAS;
    }

    /**
     * Metodo que verifica si la opción se sale de los límites del menú de leyes.
     * En caso de que no esté dentro de los límites devuelve true y el bucle se repite.
     *
     * @param opcion Opcion seleccionada del menú
     * @return boolean para ver si la opción está fuera del rango
     */
    public static boolean opcionMenuLeyes(int opcion) {
        return opcion < 1 || opcion > OPCION_MAX_LEYES;
    }

    /**
     * Metodo que verifica si la opción se sale de los límites del menú de paises.
     * En caso de que no esté dentro de los límites devuelve true y el bucle se repite.
     *
     * @param opcion Opcion seleccionada del menú
     * @return boolean para ver si la opción está fuera del rango
     */
    public static boolean opcionMenuPaises(int opcion) {
        return opcion < 1 || opcion > OPCION_MAX_PAISES;
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPropuestas() {
        System.out.println("\n--- Menu de Propuestas ---");
        System.out.println("1. Mostrar todas las propuestas");
        System.out.println("2. Mostrar propuestas por id");
        System.out.println("3. Mostrar propuestas por id de congreso");
        System.out.println("4. Mostrar propuestas por nombre de país");
        System.out.println("5. Insertar propuesta");
        System.out.println("6. Actualizar propuesta");
        System.out.println("7. Insertar un voto");
        System.out.println("8. Mostrar todos los votos");
        System.out.println("9. Mostrar votos por número de pasaporte");
        System.out.println("10. Mostrar votos por id de propuesta");
        System.out.println("11. Muestra voto por número de pasaporte e id de propuesta");
        System.out.println("12. Volver atrás");
        System.out.print("Por favor, seleccione la opcione que desee consultar (1-" + OPCION_MAX_PROPUESTAS + "): ");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPersonas(){
        System.out.print("""
                \n--- Menus de Personas ---
                1. Mostrar todas las personas
                2. Mostrar todas las personas de un Pais
                3. Mostrar persona por su pasaporte
                4. Eliminar persona
                --- Politico ---
                5. Mostrar todos los politicos
                6. Mostrar politico por número de pasaporte
                7. Crear politico
                8. Actualizar politico
                --- Ciudadano ---
                9. Mostrar todos los ciudadanos
                10. Buscar ciudadano por número de pasaporte
                11. Crear ciudadano
                12. Actualizar ciudadano
                
                13. Volver atrás
                
                Selecciona una opción:\s""");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuLeyes() {
        System.out.println("\n--- Menu de Leyes ---");
        System.out.println("1. Mostrar todas las leyes");
        System.out.println("2. Insertar Ley");
        System.out.println("3. Mostrar ley por id");
        System.out.println("4. Actualizar Ley");
        System.out.println("5. Borrar Ley");
        System.out.println("6. Volver atrás");
        System.out.print("Por favor, seleccione la opcione que desee consultar (1-6): ");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPaises() {
        System.out.println("\n--- Menu de Paises ---");
        System.out.println("1. Mostrar todos los paises");
        System.out.println("2. Buscar pais por id");
        System.out.println("3. Crear pais");
        System.out.println("4. Actualizar pais");
        System.out.println("5. Eliminar pais");
        System.out.println("6. Volver atrás");
        System.out.print("Por favor, seleccione la opcione que desee consultar (1-6): ");
    }

    /**
     * Metodo que pide un número y controla los errores.
     *
     * @return int introducido por la persona
     */
    public static int introducirOpcion() {

        Scanner scanner = new Scanner(System.in);
        boolean correcto = false;
        int resultado = 0;

        while (!correcto) {
            try {
                correcto = true;
                resultado = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.print("Por favor, introduce un número: ");
                correcto = false;
            }
        }

        return resultado;
    }

}
