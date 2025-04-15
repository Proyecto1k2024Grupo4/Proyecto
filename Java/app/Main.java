package app;

import controller.ControllerPersona;
import controller.ControllerPolitico;
import controller.ControllerPropuesta;

import java.util.Scanner;

/**
 * Clase Main que se ejecuta al inicio del programa y desde la que se muestra el menu con las
 * opciones
 * @autor Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class Main {
    public static void main(String[] args) {

        int opcion = 0;

        // Condicionales para los menús

        boolean menuPersonas = false;
        boolean menuLeyes = false;
        boolean menuPaises = false;

        do {
            opcion = 0;
            mostrarMenu();
            while (opcionMenuPrincipal(opcion)){
                opcion = introducirOpcion();
                if (opcionMenuPrincipal(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
            }
            switch (opcion) {
                case 1 -> {
                    opcion = 0;
                    mostrarMenuPropuestas();
                    ControllerPropuesta controllerPropuesta = new ControllerPropuesta();
                    while (opcionMenuPropuestas(opcion)){
                        opcion = introducirOpcion();
                        if (opcionMenuPropuestas(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion){
                        case 1 -> {
                            controllerPropuesta.mostrarTodasLasPropuestas();
                        }
                        case 2 -> {
                            controllerPropuesta.mostrarPropuestaPorId();
                        }
                        case 3 -> {
                            controllerPropuesta.mostrarPropuestaPorIdCongreso();
                        }
                        case 4 -> {
                            controllerPropuesta.insertarPropuesta();
                        }
                        case 5 -> {
                            controllerPropuesta.actualizarPropuesta();
                        }
                    }
                }
                case 2 -> {
                    opcion = 0;
                    mostrarMenuPersonas();
                    ControllerPersona controllerPersona = new ControllerPersona();
                    ControllerPolitico controllerPolitico = new ControllerPolitico();
                    while (opcionMenuPersonas(opcion)){
                        opcion = introducirOpcion();
                        if (opcionMenuPersonas(opcion)) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion){
                        case 1 -> {
                            controllerPersona.mostrarTodasLasPersonas();
                        }
                        case 2 -> {
                            controllerPersona.mostarPersonaPasaporte();
                        }
                        case 3 -> {
                            controllerPersona.crearPersona();
                        }
                        case 4 -> {
                            controllerPersona.actualizarPersona();
                        }
                        case 5 -> {
                            controllerPersona.eliminarPersona();
                        }
                        case 6 -> {
                            controllerPolitico.mostrarTodosLosPoliticos();
                        }
                        case 7 -> {
                            controllerPolitico.mostrarPoliticoPasaporte();
                        }
                        case 8 -> {
                            controllerPolitico.crearPolitco();
                        }
                        case 9 -> {
                            controllerPolitico.acutalizarPolitico();
                        }
                        case 10 -> {
                            controllerPolitico.eliminarPolitico();
                        }
                    }
                }
                case 3 -> {
                    opcion = 0;
                    mostrarMenuLeyes();
                    while (menuLeyes){
                        opcion = introducirOpcion();
                        if (menuLeyes) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion){
                        case 1 -> {

                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                    }
                }
                case 4 -> {
                    opcion = 0;
                    mostrarMenuPaises();
                    while (menuPaises){
                        opcion = introducirOpcion();
                        if (menuPaises) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                    switch (opcion){
                        case 1 -> {

                        }
                        case 2 -> {

                        }
                        case 3 -> {

                        }
                    }
                }
                case 5 -> {
                    opcion = 0;
                    System.out.println("Saliendo...");
                }
            }
        } while (opcion != 5);


    }

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

    public static boolean opcionMenuPrincipal(int opcion){
        return opcion < 1 || opcion > 5;
    }

    public static boolean opcionMenuPropuestas(int opcion){
        return opcion < 1 || opcion > 5;
    }

    public static boolean opcionMenuPersonas(int opcion){
        return opcion < 1 || opcion > 6;
    }

    public static boolean opcionMenuLeyes(int opcion){
        return opcion < 1 || opcion > 5;
    }

    public static boolean opcionMenuPaises(int opcion){
        return opcion < 1 || opcion > 5;
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPropuestas(){
        System.out.println("--- Menu de Propuestas ---");
        System.out.println("1. Mostrar todas las propuestas");
        System.out.println("2. Mostrar propuestas por id");
        System.out.println("3. Mostrar propuestas por id de congreso");
        System.out.println("4. Insertar propuesta");
        System.out.println("5. Actualizar propuesta");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPersonas(){
        System.out.println("--- Menu de Personas ---");
        System.out.println("1. Mostrar todas las personas");
        System.out.println("2. Mostrar persona por número de pasaporte");
        System.out.println("3. Crear persona");
        System.out.println("4. Actualizar persona");
        System.out.println("5. Eliminar persona");
        System.out.println("6. Mostrar todos los politicos");
        System.out.println("7. Mostrar politicos por pasaporte");
        System.out.println("8. Crear politico");
        System.out.println("9. Actualizar politico");
        System.out.println("10. Eliminar político");

    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuLeyes(){
        System.out.println("--- Menu de Leyes ---");
        System.out.println("1. Mostrar todas las propuestas");
        System.out.println("2. Mostrar propuestas por id");
        System.out.println("3. Mostrar propuestas por id de congreso");
        System.out.println("4. Insertar propuesta");
        System.out.println("5. Actualizar propuesta");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPaises(){
        System.out.println("--- Menu de Paises ---");
        System.out.println("1. Mostrar todas las propuestas");
        System.out.println("2. Mostrar propuestas por id");
        System.out.println("3. Mostrar propuestas por id de congreso");
        System.out.println("4. Insertar propuesta");
        System.out.println("5. Actualizar propuesta");
    }

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
                scanner.next();
            }
        }

        return resultado;
    }

}
