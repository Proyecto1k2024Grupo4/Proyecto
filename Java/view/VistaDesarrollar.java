package view;

import model.Desarrollar;

import java.util.List;
import java.util.Scanner;
/**
 * Clase VistaDesarrollar que maneja la interacción con el usuario para gestionar
 * las relaciones 'Desarrollar'. Esta clase permite crear, eliminar y buscar relaciones,
 * así como mostrar mensajes y resultados al usuario.
 * @author ABDELMOGHIT SAMINI
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

        // Creamos el objeto correctamente con los valores
        desarrollar = new Desarrollar(idPropuesta, idLey);
    }

     /**
     * Devuelve el objeto {@link Desarrollar} creado tras la llamada a {@link #crearRelacion()}.
     * @return objeto Desarrollar con los datos introducidos por el usuario
     */
    public Desarrollar getRelacionCreada() {
        return desarrollar;
    }

      /**
     * Solicita al usuario los datos necesarios para eliminar una relación 'Desarrollar'.
     */
    public void pedirDatosEliminar() {
        System.out.print("Introduce el ID de la Propuesta a eliminar: ");
        idPropuesta = scanner.nextInt();
        System.out.print("Introduce el ID de la Ley a eliminar: ");
        idLey = scanner.nextInt();
        scanner.nextLine();
    }
    /**
         * Devuelve el ID de la propuesta introducido por el usuario.
         * @return ID de la propuesta
         */
    public int getIdPropuesta() {
        return idPropuesta;
    }
    /**
         * Devuelve el ID de la ley introducido por el usuario.
         * @return ID de la ley
         */
    public int getIdLey() {
        return idLey;
    }
      /**
         * Solicita al usuario el ID de la propuesta para realizar una búsqueda de desarrollos.
         */
    public void pedirIdPropuestaBuscar() {
        System.out.print("Introduce el ID de la Propuesta para buscar desarrollos: ");
        idPropuesta = scanner.nextInt();
        scanner.nextLine();
    }
      /**
         * Muestra una lista de objetos {@link Desarrollar} o un mensaje si la lista está vacía.
         * @param desarrollos lista de relaciones 'Desarrollar' a mostrar
         */
    public void mostrarDesarrollos(List<Desarrollar> desarrollos) {
        if (desarrollos.isEmpty()) {
            System.out.println("No hay desarrollos para esa propuesta.");
        } else {
            desarrollos.forEach(System.out::println);
        }
    }
   /**
     * Muestra un mensaje.
     * @param mensaje texto a mostrar al usuario
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
