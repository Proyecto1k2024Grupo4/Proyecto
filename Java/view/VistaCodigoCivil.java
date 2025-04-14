package view;

import model.CodigoCivil;
import java.util.List;
import java.util.Scanner;

public class VistaCodigoCivil {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarCodigos(List<CodigoCivil> codigos) {
        for (CodigoCivil c : codigos) {
            System.out.println(c);
        }
    }

    public CodigoCivil crearCodigo() {
        System.out.println("Introduce datos del código civil:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new CodigoCivil(id, nombre);
    }

    public CodigoCivil obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del código civil:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new CodigoCivil(id, nombre);
    }

    public int obtenerIdCodigo() {
        System.out.print("Introduce el ID del código civil: ");
        return scanner.nextInt();
    }

    public void mostrarCodigo(CodigoCivil codigo) {
        System.out.println("Código civil encontrado: " + codigo);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
