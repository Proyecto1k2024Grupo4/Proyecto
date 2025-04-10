package view;

import model.Pais;

import java.util.List;
import java.util.Scanner;
/**
 * Esta clase es responsable de interactuar con el usuario en relación a los Países,
 * mostrando información, creando nuevos países y obteniendo datos desde el usuario.
 */
public class VistaPais {
    private Scanner scanner;

    /**
     * Constructor de la clase VistaPais, inicializa el escáner para recibir datos del usuario.
     */
    public VistaPais() {
        scanner = new Scanner(System.in);
    }
    /**
     * Permite al usuario crear un nuevo País pidiendo la información necesaria.
     *
     * @return Un objeto {@link Pais} con los datos ingresados por el usuario.
     */
    public Pais crearPais() {
        System.out.println("Introduce el nombre del país:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el número de ciudadanos:");
        int numCiudadanos = scanner.nextInt();
        System.out.println("Introduce el número de políticos:");
        int numPoliticos = scanner.nextInt();

        return new Pais(nombre, numCiudadanos, numPoliticos);
    }
    /**
     * Muestra una lista de Países.
     *
     * @param paises Una lista de objetos {@link Pais} que serán mostrados en consola.
     */
    public void mostrarPaises(List<Pais> paises) {
        System.out.println("Lista de países:");
        for (Pais p : paises) {
            System.out.println(p);
        }
    }
    /**
     * Solicita al usuario ingresar el nombre de un País.
     *
     * @return El nombre del País ingresado por el usuario.
     */
    public String obtenerNombrePais() {
        System.out.println("Introduce el nombre del país:");
        return scanner.nextLine();
    }
    /**
     * Permite al usuario ingresar los datos actualizados para un País.
     *
     * @return Un objeto {@link Pais} con los datos actualizados.
     */
    public Pais obtenerDatosActualizados() {
        System.out.println("Introduce el nombre del país:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce nuevo número de ciudadanos:");
        int ciudadanos = scanner.nextInt();
        System.out.println("Introduce nuevo número de políticos:");
        int politicos = scanner.nextInt();

        return new Pais(nombre, ciudadanos, politicos);
    }
    /**
     * Muestra un solo País en consola.
     *
     * @param pais El objeto {@link Pais} que se va a mostrar.
     */
    public void mostrarPais(Pais pais) {
        if (pais != null)
            System.out.println(pais);
        else
            System.out.println("El país no existe.");
    }
    /**
     * Muestra un mensaje en consola.
     *
     * @param mensaje El mensaje que se desea mostrar al usuario.
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
