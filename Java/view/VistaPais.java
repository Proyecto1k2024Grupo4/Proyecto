package view;

import model.Pais;

import java.util.List;
import java.util.Scanner;

/**
 * Vista sobre Pais que se encarga de pedir o mostrar datos a los usuarios
 * @author ABDELMOGHIT SAMINI 1KDAM
 */
public class VistaPais {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarPaises(List<Pais> paises) {
        paises.forEach(System.out::println);
    }

    public Pais crearPais() {
        System.out.print("Nombre del país: ");
        String nombre = scanner.nextLine();
        return new Pais(nombre);
    }

    public Pais obtenerDatosActualizados() {
        System.out.print("ID del país a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Nuevo nombre del país: ");
        String nombre = scanner.nextLine();
        return new Pais(id, nombre);
    }

    public int obtenerIdPais() {
        System.out.print("Introduce el ID del país: ");
        return scanner.nextInt();
    }

    public void mostrarPais(Pais pais) {
        if (pais != null) {
            System.out.println("País encontrado: " + pais);
        } else {
            System.out.println("No se encontró el país con ese ID.");
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
