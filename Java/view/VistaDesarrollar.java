package view;

import model.Desarrollar;
import java.util.List;
import java.util.Scanner;

public class VistaDesarrollar {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarDesarrollos(List<Desarrollar> desarrollos) {
        for (Desarrollar d : desarrollos) {
            System.out.println(d);
        }
    }

    public Desarrollar crearDesarrollo() {
        System.out.println("Introduce datos de la relación Desarrollar:");
        System.out.print("ID País: ");
        int idPais = scanner.nextInt();
        System.out.print("ID Código Civil: ");
        int idCodigo = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Año de desarrollo: ");
        int anio = scanner.nextInt();

        return new Desarrollar(idPais, idCodigo, anio);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

