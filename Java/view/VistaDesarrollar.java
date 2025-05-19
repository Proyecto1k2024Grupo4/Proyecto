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

        // Creamos el objeto correctamente con los valores
        desarrollar = new Desarrollar(idPropuesta, idLey);
    }

    public Desarrollar getRelacionCreada() {
        return desarrollar;
    }

    public void pedirDatosEliminar() {
        System.out.print("Introduce el ID de la Propuesta a eliminar: ");
        idPropuesta = scanner.nextInt();
        System.out.print("Introduce el ID de la Ley a eliminar: ");
        idLey = scanner.nextInt();
        scanner.nextLine();
    }

    public int getIdPropuesta() {
        return idPropuesta;
    }

    public int getIdLey() {
        return idLey;
    }

    public void pedirIdPropuestaBuscar() {
        System.out.print("Introduce el ID de la Propuesta para buscar desarrollos: ");
        idPropuesta = scanner.nextInt();
        scanner.nextLine();
    }

    public void mostrarDesarrollos(List<Desarrollar> desarrollos) {
        if (desarrollos.isEmpty()) {
            System.out.println("No hay desarrollos para esa propuesta.");
        } else {
            desarrollos.forEach(System.out::println);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
