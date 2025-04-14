package app;

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

        do {
            mostrarMenu();
            while (opcion < 1 && opcion > 5){
                opcion = introducirOpcion();
                if (opcion < 1 && opcion > 5){
                    System.out.print("Por favor, introduce una opcion entre 1 y 5: ");
                }
            }
            switch (opcion) {
                case 1 -> {
                    System.out.println("");
                }
                case 2 -> {
                    System.out.println("Persona creada correctamente.");
                }
                case 3 -> {
                    System.out.println("Persona actualizada correctamente.");
                }
                case 4 -> {
                    System.out.println("Persona eliminada correctamente.");
                }
                case 5 -> {
                    System.out.println("Saliendo...");
                }
            }
        } while (opcion != 5);


    }

    /**
     * Metod que muestra el menu de opciones principal
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
