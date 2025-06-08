package view;

import model.Ley;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaLey que se encarga de pedir o mostrar datos sobre las leyes a los usuarios
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class VistaLey {

    private Scanner scanner;

    /**
     * Constructor sin parámetros que crea una instancia de Scanner
     */
    public VistaLey(){
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

    /**
     * Metodo que muestra por pantalla una ley.
     * @param ley
     */
    public void mostrarLey(Ley ley){
        System.out.println(ley);
    }

    /**
     * Metodo que pide los datos al usuario y crea una ley
     * @param conId si es true, pedirá también el ID (para actualizar).
     * @return Ley con los datos proporcionados
     */
    public Ley crearLey(boolean conId){

        Ley ley = null;
        boolean leyCorrecta = false;

        int id = 0;
        String descripcion;
        Date fechaAplicacion;
        Date fechaModificacion;
        Date fechaImplementacion;
        int idCodigoCivil;

        while(!leyCorrecta){
            try {
                leyCorrecta = true;

                if(conId){
                    id = pedirId();
                }

                System.out.print("Introduce una descripción: ");
                descripcion = pedirDescripcion();

                System.out.print("Introduce la fecha de aplicación: ");
                fechaAplicacion = introducirFecha();

                System.out.print("Introduce la fecha de modificación: ");
                fechaModificacion = introducirFecha();

                System.out.print("Introduce la fecha de implementación: ");
                fechaImplementacion = introducirFecha();

                System.out.print("Del código civil - ");
                idCodigoCivil = pedirId();

                if(conId){
                    ley = new Ley(id, descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                } else {
                    ley = new Ley(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                }

            } catch (Exception e){
                leyCorrecta = false;
                System.out.println(e.getMessage());
            }
        }

        return ley;

    }

    /**
     * Metodo que pide una descripcion que cumpla con el limite de caracteres de la base de datos
     * @return String con una descripcion
     */
    private String pedirDescripcion(){
        boolean correcto = false;
        String descripcion = "";

        while (descripcion.isEmpty() || descripcion.length() > 2000){
            descripcion = scanner.nextLine();
            if (descripcion.isEmpty() || descripcion.length() > 2000){
                System.out.println("La descripción no puede estár vacia o tener más de 2000 caracteres.");
            }
        }

        return descripcion;

    }

    /**
     * Metodo que pide un id de una ley de manera correcta
     * @return int con el id
     */
    public int pedirId(){
        boolean correcto = false;
        int id = 0;

        while (!correcto){
            try {
                correcto = true;
                System.out.print("Introduce el id: ");
                id = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e){
                correcto = false;
                System.out.println("Error, por favor introduce un número entero.");
                scanner.next();
            }
        }

        return id;
    }

    /**
     * Metodo que pide un String y lo convierte en Date. Si no es correcto el formato, lo pide hasta que sea correcto.
     * @return Date Fecha formato SQL
     */
    private Date introducirFecha(){
        boolean correcto = false;
        Date fecha = null;
        while(!correcto){
            try {
                String fechaString = scanner.nextLine();
                fecha = Date.valueOf(LocalDate.parse(fechaString));
                correcto = true;
            } catch (Exception e){
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
            }
        }
        return fecha;
    }


}
