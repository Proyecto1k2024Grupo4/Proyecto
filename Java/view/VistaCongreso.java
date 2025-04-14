package view;

import model.Congreso;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaCongreso que gestiona la interacción con el usuario para los objetos Congreso.
 */
public class VistaCongreso {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra una lista de objetos Congreso por consola.
     * @param congresos Lista de congresos a mostrar.
     */
    public void mostrarCongresos(List<Congreso> congresos) {
        for (Congreso c : congresos) {
            System.out.println(c);
        }
    }

    /**
     * Solicita al usuario los datos para crear un nuevo objeto Congreso.
     * @return Objeto Congreso con los datos introducidos.
     */
    public Congreso crearCongreso() {
        System.out.println("Introduce datos del congreso:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new Congreso(id, nombre);
    }

    /**
     * Solicita al usuario los datos actualizados de un objeto Congreso.
     * @return Objeto Congreso con los datos actualizados.
     */
    public Congreso obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del congreso:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new Congreso(id, nombre);
    }

    /**
     * Solicita al usuario el ID de un congreso.
     * @return ID introducido por el usuario.
     */
    public int obtenerIdCongreso() {
        System.out.print("Introduce el ID del congreso: ");
        return scanner.nextInt();
    }

    /**
     * Muestra un objeto Congreso por consola.
     * @param congreso Congreso que se desea mostrar.
     */
    public void mostrarCongreso(Congreso congreso) {
        System.out.println("Congreso encontrado: " + congreso);
    }

    /**
     * Muestra un mensaje por consola.
     * @param mensaje Mensaje que se desea mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
