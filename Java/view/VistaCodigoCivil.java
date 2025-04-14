package view;

import model.CodigoCivil;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaCodigoCivil que gestiona la interacción con el usuario para los objetos CodigoCivil.
 */
public class VistaCodigoCivil {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra una lista de objetos CodigoCivil por consola.
     * @param codigos Lista de códigos civiles a mostrar.
     */
    public void mostrarCodigos(List<CodigoCivil> codigos) {
        for (CodigoCivil c : codigos) {
            System.out.println(c);
        }
    }

    /**
     * Solicita al usuario los datos para crear un nuevo objeto CodigoCivil.
     * @return Objeto CodigoCivil con los datos introducidos.
     */
    public CodigoCivil crearCodigo() {
        System.out.println("Introduce datos del código civil:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new CodigoCivil(id, nombre);
    }

    /**
     * Solicita al usuario los datos actualizados de un objeto CodigoCivil.
     * @return Objeto CodigoCivil con los datos actualizados.
     */
    public CodigoCivil obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del código civil:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new CodigoCivil(id, nombre);
    }

    /**
     * Solicita al usuario el ID de un código civil.
     * @return ID introducido por el usuario.
     */
    public int obtenerIdCodigo() {
        System.out.print("Introduce el ID del código civil: ");
        return scanner.nextInt();
    }

    /**
     * Muestra un objeto CodigoCivil por consola.
     * @param codigo Código civil que se desea mostrar.
     */
    public void mostrarCodigo(CodigoCivil codigo) {
        System.out.println("Código civil encontrado: " + codigo);
    }

    /**
     * Muestra un mensaje por consola.
     * @param mensaje Mensaje que se desea mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
