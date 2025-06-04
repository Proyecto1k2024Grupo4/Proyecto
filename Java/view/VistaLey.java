package view;

import model.Ley;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Vista en consola para gestionar:
 *  - Mostrar todas las leyes
 *  - Mostrar una ley por ID
 *  - Crear / Actualizar
 *  - Mostrar leyes filtradas por Código Civil o por País
 */
public class VistaLey {

    private final Scanner scanner;

    public VistaLey() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Muestra todas las leyes.
     */
    public void mostrarTodasLasLeyes(List<Ley> lista) {
        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay leyes registradas.");
            return;
        }
        System.out.println("--- Todas las leyes ---");
        for (Ley ley : lista) {
            System.out.println(ley);
        }
    }

    /**
     * Muestra por pantalla una sola ley (o mensaje si es null).
     */
    public void mostrarLey(Ley ley) {
        if (ley == null) {
            System.out.println("No existe una ley con ese ID.");
        } else {
            System.out.println(ley);
        }
    }

    /**
     * Pide al usuario los datos para crear o actualizar una ley.
     * @param conId si es true, pedirá también el ID (para actualizar).
     * Si es falso, no pedirá el ID (para insertar).
     */
    public Ley crearLey(boolean conId) {
        Ley ley = null;
        boolean leyCorrecta = false;

        int id = 0;
        String descripcion;
        Date fechaAplicacion;
        Date fechaModificacion;
        Date fechaImplementacion;
        int idCodigoCivil;

        while (!leyCorrecta) {
            try {
                leyCorrecta = true;

                if (conId) {
                    id = pedirId();
                }

                System.out.print("Introduce una descripción: ");
                descripcion = pedirDescripcion();

                System.out.print("Introduce la fecha de aplicación (yyyy-MM-dd): ");
                fechaAplicacion = introducirFecha();

                System.out.print("Introduce la fecha de modificación (yyyy-MM-dd): ");
                fechaModificacion = introducirFecha();

                System.out.print("Introduce la fecha de implementación (yyyy-MM-dd): ");
                fechaImplementacion = introducirFecha();

                System.out.print("ID de Código Civil: ");
                idCodigoCivil = pedirId();

                if (conId) {
                    ley = new Ley(id, descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                } else {
                    ley = new Ley(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                }

            } catch (Exception e) {
                leyCorrecta = false;
                System.out.println("ERROR: " + e.getMessage());
            }
        }

        return ley;
    }

    /**
     * Pide al usuario un ID entero válido.
     * @return el entero introducido.
     */
    public int pedirId() {
        int id = -1;
        boolean correcto = false;

        while (!correcto) {
            try {
                System.out.print("Introduce el ID: ");
                id = Integer.parseInt(scanner.nextLine());
                correcto = true;
            } catch (NumberFormatException ex) {
                System.out.println("ID inválido. Debe ser un número entero.");
            }
        }

        return id;
    }

    /**
     * Pide y valida una descripción .
     */
    private String pedirDescripcion() {
        String descripcion;
        do {
            descripcion = scanner.nextLine().trim();
            if (descripcion.isEmpty() || descripcion.length() > 2000) {
                System.out.println("La descripción no puede estar vacía ni exceder 2000 caracteres.");
            }
        } while (descripcion.isEmpty() || descripcion.length() > 2000);
        return descripcion;
    }

    /**
     * Pide un String y lo convierte en java.sql.Date.
     * Si el formato no es yyyy-MM-dd, lo vuelve a pedir.
     */
    private Date introducirFecha() {
        Date fecha = null;
        boolean correcto = false;

        while (!correcto) {
            try {
                String fechaString = scanner.nextLine().trim();
                fecha = Date.valueOf(LocalDate.parse(fechaString));
                correcto = true;
            } catch (Exception e) {
                System.out.print("Fecha incorrecta. Formato válido: aaaa-MM-dd (Ejemplo: 1999-01-01): ");
            }
        }

        return fecha;
    }

    /**
     * Pide al usuario un ID de Código Civil .
     * @return ID válido
     */
    public int pedirIdCodigoCivil() {
        int id;
        boolean valido;
        do {
            System.out.print("Introduce el ID del Código Civil: ");
            String linea = scanner.nextLine().trim();
            try {
                id = Integer.parseInt(linea);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Debe ser un número entero.");
                valido = false;
                id = -1;
            }
        } while (!valido);
        return id;
    }

    /**
     * Pide al usuario un ID de País .
     * @return ID válido
     */
    public int pedirIdPais() {
        int id;
        boolean valido;
        do {
            System.out.print("Introduce el ID del País: ");
            String linea = scanner.nextLine().trim();
            try {
                id = Integer.parseInt(linea);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("ID inválido. Debe ser un número entero.");
                valido = false;
                id = -1;
            }
        } while (!valido);
        return id;
    }

    /**
     * Muestra la lista de leyes dependiendo de qué filtro se usó:
     *
     * @param lista       Lista de objetos Ley.
     * @param textoFiltro “Código Civil” o “País”.
     * @param valorFiltro El ID utilizado para filtrar.
     */
    public void mostrarLeyes(List<Ley> lista, String textoFiltro, int valorFiltro) {
        if (lista == null || lista.isEmpty()) {
            System.out.printf("No se encontraron leyes para %s = %d.%n", textoFiltro, valorFiltro);
            return;
        }

        System.out.printf("--- Leyes filtradas por %s = %d --- %n", textoFiltro, valorFiltro);

        if ("Código Civil".equals(textoFiltro)) {
            // Mostrar el objeto completo (incluye idCodigoCivil y pais si está relleno)
            for (Ley ley : lista) {
                System.out.println(ley);
            }
        } else {
            // Filtrado por País
            for (Ley ley : lista) {
                if (ley.getPais() != null) {
                    System.out.printf("Ley ID: %d, País: %d-%s%n",
                            ley.getId(),
                            ley.getPais().getId(),
                            ley.getPais().getNombre());
                } else {
                    System.out.printf("Ley ID: %d, País: desconocido%n", ley.getId());
                }
            }
        }
    }
}
