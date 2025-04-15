package view;

import model.Ley;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase
 * @autor Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class VistaLey {

    Scanner scanner;

    /**
     * Constructor sin parámetros que crea una instancia de Scanner
     */
    public VistaLey(){
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo que muestra por pantalla todas las leyes.
     * @param leyes
     */
    public void mostrarLeyes(List<Ley> leyes){
        System.out.println("Lista de leyes:");
        leyes.forEach(System.out::println);
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
                    System.out.print("Introduce un id: ");
                    id = pedirId();
                }

                System.out.print("Introduce una descripción: ");
                descripcion = scanner.nextLine();

                System.out.print("Introduce la fecha de aplicación: ");
                fechaAplicacion = introducirFecha();

                System.out.print("Introduce la fecha de modificación: ");
                fechaModificacion = introducirFecha();

                System.out.print("Introduce la fecha de implementación: ");
                fechaImplementacion = introducirFecha();

                System.out.print("Introduce el id del código civil: ");
                idCodigoCivil = pedirId();

                if(conId){
                    ley = new Ley(id, descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                } else {
                    ley = new Ley(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil);
                }

            } catch (Exception e){
                leyCorrecta = false;
                System.out.println(e.getMessage());
                scanner.next();
            }
        }

        return ley;

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
                System.out.println("Introduce el id: ");
                id = scanner.nextInt();
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
                correcto = true;
                fecha = Date.valueOf(LocalDate.parse(scanner.nextLine()));
            } catch (Exception e){
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
                scanner.next();
            }
        }
        return fecha;
    }


}
