package view;

import model.Desarrollar;

import java.util.List;
import java.util.Scanner;
/**
 * Clase VistaDesarrollar que maneja la interacción con el usuario para gestionar
 * las relaciones 'Desarrollar'. Esta clase permite crear, eliminar y buscar relaciones,
 * así como mostrar mensajes y resultados al usuario.
 */
public class VistaDesarrollar {
    private Scanner scanner = new Scanner(System.in);
    private Desarrollar desarrollar;

    private int idPropuesta;
    private int idLey;
    /**
     * Método que solicita al usuario los datos necesarios para crear una relación
     * 'Desarrollar' y almacena estos datos en el objeto 'Desarrollar'.
     */
    public void crearRelacion() {
        System.out.println("Introduce datos de la relación Desarrollar:");
        System.out.print("ID Propuesta: ");
        idPropuesta = scanner.nextInt();
        System.out.print("ID Ley: ");
        idLey = scanner.nextInt();
        scanner.nextLine();

        desarrollar = new Desarrollar();
    }
    /**
     * Método que devuelve la relación 'Desarrollar' creada a partir de los datos del usuario.
     * @return Objeto Desarrollar con los datos introducidos por el usuario.
     */
    public Desarrollar getRelacionCreada() {
        return desarrollar;
    }

    /**
     * Método que solicita al usuario los datos necesarios para eliminar una relación 'Desarrollar'.
     */
    public void pedirDatosEliminar() {
        System.out.print("Introduce el ID de la Propuesta a eliminar: ");
        idPropuesta = scanner.nextInt();
        System.out.print("Introduce el ID de la Ley a eliminar: ");
        idLey = scanner.nextInt();
        scanner.nextLine();
    }
    /**
     * Método que solicita al usuario el ID de la propuesta para buscar sus relaciones.
     */
    public void pedirIdPropuestaBuscar() {
        System.out.print("Introduce el ID de la Propuesta para buscar desarrollos: ");
        idPropuesta = scanner.nextInt();
        scanner.nextLine();
    }
    /**
     * Método que devuelve el ID de la propuesta que se ha ingresado para búsqueda o eliminación.
     * @return El ID de la propuesta.
     */
    public int getIdPropuesta() {
        return idPropuesta;
    }
    /**
     * Método que devuelve el ID de la ley que se ha ingresado para búsqueda o eliminación.
     * @return El ID de la ley.
     */
    public int getIdLey() {
        return idLey;
    }
    /**
     * Método que muestra un mensaje al usuario en la consola.
     * @param mensaje El mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    /**
     * Método que muestra una lista de objetos 'Desarrollar' al usuario.
     * @param desarrollos Lista de objetos 'Desarrollar' a mostrar.
     */
    public void mostrarDesarrollos(List<Desarrollar> desarrollos) {
        for (Desarrollar d : desarrollos) {
            System.out.println(d);
        }
    }
}
