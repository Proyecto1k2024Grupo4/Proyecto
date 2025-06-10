package view;

import model.CodigoCivil;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaCodigoCivil que gestiona la interacción con el usuario
 * para operaciones relacionadas con la entidad {@link CodigoCivil}.
 * Proporciona métodos para mostrar códigos civiles, crear nuevos,
 * actualizar existentes, solicitar IDs y mostrar mensajes.
 * @author ABDELMOGHIT SAMINI
*/

public class VistaCodigoCivil {
    private final Scanner scanner = new Scanner(System.in);

   
    /**
     * Muestra una lista de códigos civiles por consola.
     * Si la lista está vacía o es nula, muestra un mensaje informativo.
     * @param codigos lista de objetos CodigoCivil a mostrar
     */
    public void mostrarCodigos(List<CodigoCivil> codigos) {
        if (codigos == null || codigos.isEmpty()) {
            System.out.println("No se encontraron códigos civiles para ese país.");
        } else {
            for (CodigoCivil c : codigos) {
                System.out.println(c);
            }
        }
    }

      /**
     * Solicita al usuario los datos necesarios para crear un nuevo código civil.
     * @return objeto CodigoCivil creado con los datos introducidos
     */
    public CodigoCivil crearCodigo() {
        System.out.println("Introduce datos del Código Civil:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("ID del País: ");
        int idPais = Integer.parseInt(scanner.nextLine());
        System.out.print("Fecha (yyyy-mm-dd): ");
        Date fecha = Date.valueOf(scanner.nextLine());
        return new CodigoCivil(id, idPais, fecha);
    }
      /**
     * Solicita al usuario los datos actualizados de un código civil existente.
     * @return objeto CodigoCivil con los datos actualizados
     */

    public CodigoCivil obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del Código Civil:");
        System.out.print("ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Nuevo ID del País: ");
        int idPais = Integer.parseInt(scanner.nextLine());
        System.out.print("Nueva Fecha (yyyy-mm-dd): ");
        Date fecha = Date.valueOf(scanner.nextLine());
        return new CodigoCivil(id, idPais, fecha);
    }
     /**
         * Solicita al usuario el ID de un código civil.
         * @return ID del código civil introducido
         */
    public int obtenerIdCodigo() {
        System.out.print("Introduce el ID del Código Civil: ");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Solicita al usuario el ID de un país para filtrar códigos civiles.
     * @return ID del país introducido
     */
    /**  pedir el ID del País para filtrar códigos civiles */
    public int solicitarIdPais() {
        System.out.print("Introduce el ID del País: ");
        return Integer.parseInt(scanner.nextLine());
    }
    /**
         * Muestra por consola un código civil concreto o un mensaje
         * si no existe ninguno con el ID proporcionado.
         * @param codigo objeto CodigoCivil a mostrar
         */
    public void mostrarCodigo(CodigoCivil codigo) {
        if (codigo == null) {
            System.out.println("No existe un Código Civil con ese ID.");
        } else {
            System.out.println("Código Civil encontrado: " + codigo);
        }
    }
  /**
     * Muestra un mensaje informativo por consola.
     * @param mensaje texto a mostrar al usuario
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
