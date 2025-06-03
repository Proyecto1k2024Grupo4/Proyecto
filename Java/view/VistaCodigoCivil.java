package view;

import model.CodigoCivil;

import java.util.List;
import java.util.Scanner;

/**
 * Esta clase es responsable de interactuar con el usuario en relación a los Códigos Civiles,
 * mostrando información, creando nuevos códigos civiles y obteniendo datos desde el usuario.
 */
public class VistaCodigoCivil {
//    private Scanner scanner = new Scanner(System.in);
//
//    /**
//     * Muestra una lista de Códigos Civiles.
//     *
//     * @param codigos Una lista de objetos {@link CodigoCivil} que serán mostrados en consola.
//     */
//    public void mostrarCodigos(List<CodigoCivil> codigos) {
//        System.out.println("Lista de Códigos Civiles:");
//        for (CodigoCivil cc : codigos) {
//            System.out.println(cc);
//        }
//    }
//    /**
//     * Permite al usuario crear un nuevo Código Civil, pidiendo la información necesaria.
//     *
//     * @return Un objeto {@link CodigoCivil} con los datos ingresados por el usuario.
//     */
//    public CodigoCivil crearCodigoCivil() {
//        System.out.println("Introduce ID del código:");
//        int id = scanner.nextInt();
//
//        scanner.nextLine();
//        System.out.println("Introduce número de leyes:");
//        int numLeyes = scanner.nextInt();
//
//        System.out.println("Introduce fecha de modificación (YYYY-MM-DD):");
//        String fecha = scanner.nextLine();
//
//        return new CodigoCivil(id, numLeyes, fecha);
//    }
//    /**
//     * Solicita al usuario ingresar el ID de un Código Civil.
//     *
//     * @return El ID del Código Civil ingresado por el usuario.
//     */
//    public int obtenerId() {
//        System.out.print("Introduce el ID del Código Civil: ");
//        return Integer.parseInt(scanner.nextLine());
//    }
//    /**
//     * Permite al usuario ingresar los datos actualizados para un Código Civil.
//     *
//     * @return Un objeto {@link CodigoCivil} con los datos actualizados.
//     */
//    public CodigoCivil obtenerDatosActualizados() {
//        System.out.println("Introduce ID del código:");
//        int id = scanner.nextInt();
//
//        System.out.println("Introduce nuevo número de leyes:");
//        int numLeyes = scanner.nextInt();
//        scanner.nextLine();
//
//        System.out.println("Introduce nueva fecha de modificación:");
//        String fecha = scanner.nextLine();
//
//        return new CodigoCivil(id, numLeyes, fecha);
//    }
//
//    /**
//     * Muestra un mensaje en consola.
//     *
//     * @param mensaje El mensaje que se desea mostrar al usuario.
//     */
//    public void mostrarMensaje(String mensaje) {
//        System.out.println(mensaje);
//    }
//    /**
//     * Muestra un solo Código Civil en consola.
//     *
//     * @param cc El objeto {@link CodigoCivil} que se va a mostrar.
//     */
//    public void mostrarCodigo(CodigoCivil cc) {
//        if (cc != null)
//            System.out.println(cc);
//        else
//            System.out.println("No se encontró el código.");
//    }
}
