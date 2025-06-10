package view;

import model.Pais;

import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaPais encargada de gestionar la interacción con el usuario
 * para operaciones relacionadas con objetos {@link Pais}.
 * @author ABDELMOGHIT SAMINI
 */
public class VistaPais {
    private Scanner scanner = new Scanner(System.in);
  
    /**
     * Muestra por consola todos los países proporcionados en la lista.
     * @param paises lista de objetos Pais a mostrar
     */
    public void mostrarPaises(List<Pais> paises) {
        paises.forEach(System.out::println);
    }

      /**
     * Solicita al usuario los datos para crear un nuevo país.
     * @return nuevo objeto Pais con el nombre introducido
     */
    public Pais crearPais() {
        System.out.print("Nombre del país: ");
        String nombre = scanner.nextLine();
        return new Pais(nombre);
    }
      /**
         * Solicita al usuario los datos necesarios para actualizar un país existente.
         * @return objeto Pais con el ID y nuevo nombre introducido
         */
    public Pais obtenerDatosActualizados() {
        System.out.print("ID del país a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nuevo nombre del país: ");
        String nombre = scanner.nextLine();
        return new Pais(id, nombre);
    }

        /**
         * Solicita al usuario el ID de un país.
         * @return ID del país introducido por el usuario
         */
    public int obtenerIdPais() {
        System.out.print("Introduce el ID del país: ");
        return scanner.nextInt();
    }
     /**
         * Muestra un país concreto por consola si existe,
         * o un mensaje indicando que no se ha encontrado.
         * @param pais objeto Pais a mostrar
         */
    public void mostrarPais(Pais pais) {
        if (pais != null) {
            System.out.println("País encontrado: " + pais);
        } else {
            System.out.println("No se encontró el país con ese ID.");
        }
    }
      /**
         * Muestra un mensaje genérico por consola.
         * @param mensaje texto del mensaje a mostrar
         */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
