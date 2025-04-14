package view;

import model.Pais;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaPais que gestiona la interacción con el usuario
 * para operaciones relacionadas con la entidad País.
 */
public class VistaPais {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Muestra una lista de países por consola.
     * @param paises Lista de objetos Pais a mostrar.
     */
    public void mostrarPaises(List<Pais> paises) {
        for (Pais p : paises) {
            System.out.println(p);
        }
    }

    /**
     * Solicita al usuario los datos para crear un nuevo país.
     * @return Objeto Pais con los datos introducidos.
     */
    public Pais crearPais() {
        System.out.println("Introduce datos del país:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new Pais(id, nombre);
    }

    /**
     * Solicita al usuario los datos actualizados de un país.
     * @return Objeto Pais con los datos actualizados introducidos.
     */
    public Pais obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del país:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new Pais(id, nombre);
    }

    /**
     * Solicita al usuario el ID de un país.
     * @return ID introducido por el usuario.
     */
    public int obtenerIdPais() {
        System.out.print("Introduce el ID del país: ");
        return scanner.nextInt();
    }

    /**
     * Muestra por consola un país específico.
     * @param pais Objeto Pais que se desea mostrar.
     */
    public void mostrarPais(Pais pais) {
        System.out.println("País encontrado: " + pais);
    }

    /**
     * Muestra un mensaje por consola.
     * @param mensaje Texto del mensaje a mostrar.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
