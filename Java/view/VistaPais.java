package view;

import model.Pais;
import java.util.List;
import java.util.Scanner;

public class VistaPais {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarPaises(List<Pais> paises) {
        for (Pais p : paises) {
            System.out.println(p);
        }
    }

    public Pais crearPais() {
        System.out.println("Introduce datos del país:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new Pais(id, nombre);
    }

    public Pais obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del país:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new Pais(id, nombre);
    }

    public int obtenerIdPais() {
        System.out.print("Introduce el ID del país: ");
        return scanner.nextInt();
    }

    public void mostrarPais(Pais pais) {
        System.out.println("País encontrado: " + pais);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
