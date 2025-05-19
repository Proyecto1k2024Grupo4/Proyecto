package view;

import model.Ley;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Clase de vista para la gestión de Leyes
 * @autor Abdel Moghit Samini 1ºK
 * @version 14-04-2025
 */
public class VistaLey {

    private Scanner scanner;

    /**
     * Constructor sin parámetros que crea una instancia de Scanner
     */
    public VistaLey() {
        scanner = new Scanner(System.in);
    }

    /**
     * Muestra por pantalla todas las leyes.
     * @param leyes lista de leyes
     */
    public void mostrarLeyes(List<Ley> leyes) {
        if (leyes.isEmpty()) {
            System.out.println("No hay leyes para mostrar.");
        } else {
            leyes.forEach(System.out::println);
        }
    }

    public void mostrarLey(Ley ley) {
        System.out.println(ley != null ? ley : "No existe una ley con ese ID.");
    }

    public Ley crearLey(boolean conId) {
        Ley ley = null;
        while (ley == null) {
            try {
                int id;
                if (conId) {
                    id = pedirId("Introduce el id de la ley: ");
                } else {
                    id = 0;
                }

                System.out.print("Descripción: ");
                String desc = scanner.nextLine().trim();

                Date app = leerFecha("Fecha de aplicación", false);
                Date mod = leerFecha("Fecha de modificación", false);
                Date imp = leerFecha("Fecha de implementación", true);

                int idCc = pedirId("Id del Código Civil asociado: ");

                if (conId) {
                    // Construye con ID
                    ley = new Ley(id, desc, app, mod, imp, idCc);
                } else {
                    // Construye sin ID
                    ley = new Ley(desc, app, mod, imp, idCc);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Intenta de nuevo.\n");
            }
        }
        return ley;
    }

    private Date leerFecha(String msg, boolean oblig) {
        Date date = null;
        boolean valido = false;
        while (!valido) {
            // Construyo el mensaje según
            String mensaje;
            if (oblig) {
                mensaje = msg + " (AAAA-MM-DD) [obligatorio]: ";
            } else {
                mensaje = msg + " (AAAA-MM-DD) [ENTER para omitir]: ";
            }
            System.out.print(mensaje);

            String line = scanner.nextLine().trim();
            // Si no es obligatorio y no escribe nada, aceptamos null
            if (line.isEmpty() && !oblig) {
                date = null;
                valido = true;
            } else {
                try {
                    date = Date.valueOf(line);
                    valido = true;
                } catch (IllegalArgumentException ex) {
                    System.out.println("Formato inválido, p.ej. 1999-01-01.");
                }
            }
        }
        return date;
    }


    public int pedirId() { return pedirId("Introduce el id: "); }
    public int pedirId(String msg) {
        boolean valido = false;
        int valor = 0;
        while (!valido) {
            System.out.print(msg);
            String line = scanner.nextLine().trim();
            try {
                valor = Integer.parseInt(line);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ser un número entero.");
            }
        }
        return valor;
    }


    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
