package view;

import model.Congreso;

import java.util.List;
import java.util.Scanner;
/**
 * Esta clase es responsable de interactuar con el usuario en relación a los Congresos,
 * mostrando información, creando nuevos congresos y obteniendo datos desde el usuario.
 */
public class VistaCongreso {
    private Scanner scanner;
    /**
     * Constructor de la clase VistaCongreso, inicializa el escáner para recibir datos del usuario.
     */
    public VistaCongreso() {
        scanner = new Scanner(System.in);
    }
    /**
     * Permite al usuario crear un nuevo Congreso pidiendo la información necesaria.
     *
     * @return Un objeto {@link Congreso} con los datos ingresados por el usuario.
     */
    public Congreso crearCongreso() {
        System.out.println("Introduce el ID del Congreso:");
        int id = scanner.nextInt();
        System.out.println("Introduce el número de políticos:");
        int numPoliticos =scanner.nextInt();
        System.out.println("Introduce el número de propuestas aprobadas:");
        int propAprobadas =scanner.nextInt();

        return new Congreso(id, numPoliticos, propAprobadas);
    }
    /**
     * Muestra una lista de Congresos.
     *
     * @param lista Una lista de objetos {@link Congreso} que serán mostrados en consola.
     */
    public void mostrarCongresos(List<Congreso> lista) {
        System.out.println("Lista de Congresos:");
        for (Congreso c : lista) {
            System.out.println(c);
        }
    }
    /**
     * Solicita al usuario ingresar el ID de un Congreso.
     *
     * @return El ID del Congreso ingresado por el usuario.
     */
    public int obtenerId() {
        System.out.println("Introduce el ID del Congreso:");
        return scanner.nextInt();
    }
    /**
     * Permite al usuario ingresar los datos actualizados para un Congreso.
     *
     * @return Un objeto {@link Congreso} con los datos actualizados.
     */
    public Congreso obtenerDatosActualizados() {
        System.out.println("Introduce el ID del Congreso:");
        int id = scanner.nextInt();
        System.out.println("Introduce nuevo número de políticos:");
        int politicos =scanner.nextInt();
        System.out.println("Introduce nuevo número de propuestas aprobadas:");
        int aprobadas = scanner.nextInt();

        return new Congreso(id, politicos, aprobadas);
    }
    /**
     * Muestra un solo Congreso en consola.
     *
     * @param c El objeto {@link Congreso} que se va a mostrar.
     */
    public void mostrarCongreso(Congreso c) {
        if (c != null)
            System.out.println(c);
        else
            System.out.println("Congreso no encontrado.");
    }
    /**
     * Muestra un mensaje en consola.
     *
     * @param msg El mensaje que se desea mostrar al usuario.
     */
    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
