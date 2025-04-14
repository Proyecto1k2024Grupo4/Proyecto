package view;

import model.Congreso;
import java.util.List;
import java.util.Scanner;

public class VistaCongreso {
    private Scanner scanner = new Scanner(System.in);

    public void mostrarCongresos(List<Congreso> congresos) {
        for (Congreso c : congresos) {
            System.out.println(c);
        }
    }

    public Congreso crearCongreso() {
        System.out.println("Introduce datos del congreso:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        return new Congreso(id, nombre);
    }

    public Congreso obtenerDatosActualizados() {
        System.out.println("Introduce datos actualizados del congreso:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre nuevo: ");
        String nombre = scanner.nextLine();

        return new Congreso(id, nombre);
    }

    public int obtenerIdCongreso() {
        System.out.print("Introduce el ID del congreso: ");
        return scanner.nextInt();
    }

    public void mostrarCongreso(Congreso congreso) {
        System.out.println("Congreso encontrado: " + congreso);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
