package app;

import controller.ControllerCiudadano;
import controller.ControllerPersona;
import controller.ControllerPolitico;

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
        boolean menuPrincipal = opcion < 1 && opcion > 5;
        boolean menuPropuestas = opcion < 1 && opcion > 5;
        boolean menuPersonas = opcion < 1 && opcion > 14;

        do {
            mostrarMenu();
            while (menuPrincipal){
                opcion = introducirOpcion();
                if (menuPrincipal) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
            }
            switch (opcion) {
                case 1 -> {
                    opcion = 0;
                    mostrarMenuPropuestas();
                    while (menuPropuestas){
                        opcion = introducirOpcion();
                        if (menuPropuestas) System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                    }
                }
                case 2 -> {
                    ControllerPersona controllerPersona = new ControllerPersona();
                    ControllerPolitico controllerPolitico = new ControllerPolitico();
                    ControllerCiudadano controllerCiudadano = new ControllerCiudadano();
                    opcion = 0;
                    mostrarMenuPersonas();
                    while (menuPersonas){
                        opcion = introducirOpcion();
                        if (menuPersonas)
                            System.out.println("Por favor, introduce una opcion entre 1 y 14: ");
                    } switch (opcion) {
                        case 1 -> controllerPersona.mostrarTodasLasPersonas();
                        case 2 -> controllerPersona.mostarPersonaPasaporte();
                        case 3 -> controllerPersona.crearPersona();
                        case 4 -> controllerPersona.actualizarPersona();
                        case 5 -> controllerPersona.eliminarPersona();
                        case 6 -> controllerPolitico.mostrarTodosLosPoliticos();
                        case 7 -> controllerPolitico.mostrarPoliticoPasaporte();
                        case 8 -> controllerPolitico.crearPolitco();
                        case 9 -> controllerPolitico.acutalizarPolitico();
                        case 10 -> controllerPolitico.eliminarPolitico();
                        case 11 -> controllerCiudadano.mostrarTodosLosCiudadanos();
                        case 12 -> controllerCiudadano.mostrarCiudadanoPasaporte();
                        case 13 -> controllerCiudadano.crearCiudadano();
                        case 14 -> controllerCiudadano.eliminarCiudadano();
                    }
                }
                case 3 -> {
                    opcion = 0;
                    System.out.println("Persona actualizada correctamente.");
                }
                case 4 -> {
                    opcion = 0;
                    System.out.println("Persona eliminada correctamente.");
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

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPropuestas(){
        System.out.println("--- Menu de Propuestas ---");
        System.out.println("1. Propuestas");
        System.out.println("2. Personas");
        System.out.println("3. Leyes");
        System.out.println("4. Paises");
        System.out.println("5. Salir");
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPersonas(){
        System.out.println("""
                --- Menus de Personas ---
                1. Mostrar todas las personas
                2. Mostrar persona por su pasaporte
                3. Crear persona
                4. Modificar persona
                5. Eliminar persona
                --- Politico ---
                6. Mostrar todos los politicos
                7. Mostrar politico por su pasaporte
                8. Crear politico
                9. Retirar un politico
                10. Eliminar politico
                --- Ciudadano ---
                11. Mostrar todos los ciudadanos
                12. Mostrar ciudadano por su pasaporte
                13. Crear ciudadano
                14. Eliminar ciudadano
                """);
    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuLeyes(){

    }

    /**
     * Metodo que muestra el menu de opciones principal
     */
    public static void mostrarMenuPaises(){

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
