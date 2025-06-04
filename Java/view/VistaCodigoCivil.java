package view;

import model.CodigoCivil;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class VistaCodigoCivil {
    private final Scanner scanner = new Scanner(System.in);

    public void mostrarCodigos(List<CodigoCivil> codigos) {
        if (codigos == null || codigos.isEmpty()) {
            System.out.println("No se encontraron códigos civiles para ese país.");
        } else {
            for (CodigoCivil c : codigos) {
                System.out.println(c);
            }
        }
    }

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

    public int obtenerIdCodigo() {
        System.out.print("Introduce el ID del Código Civil: ");
        return Integer.parseInt(scanner.nextLine());
    }

    /**  pedir el ID del País para filtrar códigos civiles */
    public int solicitarIdPais() {
        System.out.print("Introduce el ID del País: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrarCodigo(CodigoCivil codigo) {
        if (codigo == null) {
            System.out.println("No existe un Código Civil con ese ID.");
        } else {
            System.out.println("Código Civil encontrado: " + codigo);
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
