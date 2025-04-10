package view;

import model.Ley;

import java.util.Scanner;
/**
 * Esta clase es responsable de interactuar con el usuario en relación a las Leyes,
 * solicitando información sobre propuestas y leyes, y mostrando mensajes al usuario.
 */
public class VistaDesrollar {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Solicita al usuario ingresar el ID de una Propuesta.
     *
     * @return El ID de la propuesta ingresada por el usuario.
     */
    public int obtenerIdPropuesta() {
        System.out.println("Introduce el ID de la Propuesta:");
        return scanner.nextInt();
    }
    /**
     * Permite al usuario crear una nueva Ley a partir de una propuesta, solicitando
     * la información necesaria para la creación de la ley.
     *
     * @return Un objeto {@link Ley} con los datos ingresados por el usuario.
     */
    public Ley crearLeyDesdePropuesta() {
        System.out.println("Introduce el ID de la nueva Ley:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Introduce la descripción:");
        String descripcion = scanner.nextLine();
        System.out.println("Introduce la fecha de implementación:");
        String fImpl = scanner.nextLine();
        System.out.println("Introduce la fecha de aplicación:");
        String fAplica = scanner.nextLine();
        System.out.println("Introduce la fecha de modificación:");
        String fMod = scanner.nextLine();

        return new Ley(id, descripcion, fImpl, fAplica, fMod);
    }

    /**
     * Muestra un mensaje al usuario en consola.
     *
     * @param mensaje El mensaje que se desea mostrar al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
