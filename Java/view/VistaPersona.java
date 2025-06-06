package view;

import model.Ciudadano;
import model.Persona;
import model.Politico;
import model.Sexo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Clase VistaPersona que se encarga de la interacción con el usuario y la gestión de Personas, Ciudadanos y Politicos
 */
public class VistaPersona {
    public Scanner scan;

    public VistaPersona(){
        scan = new Scanner(System.in);
    }

    /**
     * Metodo que muestra por consola una lista de Persona
     * @param personas Lista de Persona a mostrar
     */
    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("Lista de personas");
        for (Persona persona: personas)
            System.out.println(persona);
    }

    /**
     * Metodo para crear una persona pidiendo los datos al usuario por consola
     * @return objeto Persona con los datos introducidos
     */
    public Persona crearPersona (){
        String pasaporte = obtenerPasaporte();
        System.out.println("Introduce el nombre");
        String nombre = scan.nextLine();
        System.out.println("Introduce el primer apellido");
        String apellido1 = scan.nextLine();
        System.out.println("Introduce el segundo apellido");
        String apellido2 = scan.nextLine();
        System.out.println("Introduce la fecha de nacimiento");
        Date fecha = obtenerFecha();
        System.out.println("Introduce el sexo(H,M)");
        Sexo sexo = Sexo.valueOf(scan.nextLine());
        System.out.println("Introduce el pais (codigo)");
        int pais = scan.nextInt();
        return new Persona(pasaporte, nombre, apellido1, apellido2, fecha, sexo, pais);
    }

    /**
     * Metodo para pedir un pasaporte por consola
     * @return String con el pasaporte
     */
    public String obtenerPasaporte(){
        String numPasaporte = null;
        boolean bien = false;
        while (!bien) {
            System.out.println("Introduce el pasaporte");
            numPasaporte = scan.nextLine();
            if (!(numPasaporte.length() > 16))
                bien = true;
            else
                System.out.println("Error: el formato del pasaporte es incorrecto");
        }
        return numPasaporte;
    }

    /**
     * Metodo que muestra una persona por consola
     * @param persona Objeto de persona que se quiere mostrar
     */
    public void mostrarPersona(Persona persona) {
        if (persona!=null)
            System.out.println(persona);
        else
            System.out.println("No existe esta persona");
    }

    /**
     * Metodo para crear un politico pidiendo sus datos por pantalla
     * @return objeto Politico con los datos introducidos
     */
    //Metodos para los politicos
    public Politico crearPolitico(){
        String pasaporte = obtenerPasaporte();
        System.out.println("Introduce el nombre");
        String nombre = scan.nextLine();
        System.out.println("Introduce el primer apellido");
        String apellido1 = scan.nextLine();
        System.out.println("Introduce el segundo apellido");
        String apellido2 = scan.nextLine();
        System.out.println("Introduce la fecha de nacimiento");
        Date fecha = obtenerFecha();
        System.out.println("Introduce el sexo(H,M)");
        Sexo sexo = Sexo.valueOf(scan.nextLine());
        System.out.println("Introduce el pais (codigo)");
        int pais = scan.nextInt();
        System.out.println("Introduce la fecha de iniciacion");
        Date fechaInicio = obtenerFecha();
        System.out.println("Introduce la fecha de retirada");
        Date fechaRetirada = obtenerFecha();
        System.out.println("Introduce el congreso (id)");
        int congreso = scan.nextInt();
        return new Politico(pasaporte, nombre, apellido1, apellido2, fecha, sexo, pais, fechaInicio, fechaRetirada, congreso);
    }

    public int pedirPais(){
        boolean esCorrecto = false;
        int pais;
        do {
            System.out.println("Introduce el codigo del pais:");
            pais = scan.nextInt();
            if (pais < 0 || pais > 20)
                System.out.println("No existe este pais en nuestra base de datos");
            else esCorrecto = true;
        }while (!esCorrecto);
        return pais;
    }


    /**
     * Metodo que muestra por pantalla los politicos de una lista
     * @param politicos Lista de Politico que queremos mostrar
     */
    public void mostrarPoliticos(List<Politico> politicos) {
        System.out.println("Lista de politicos");
        for (Politico politico:politicos)
            System.out.println(politico);
    }

    /**
     * Metodo para pedir una fecha
     * @return Date con la fecha introducida
     */
    public Date obtenerFecha(){
        boolean correcto = false;
        Date fecha = null;
        while(!correcto){
            try {
                correcto = true;
                fecha = Date.valueOf(LocalDate.parse(scan.nextLine()));
            } catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
            }
        }
        return fecha;
    }

    //Metodos de Ciudadano

    /**
     * Metodo que muestra por consola los ciudadanos de una lista
     * @param ciudadanos Lista de Ciudadano que queremos mostrar
     */
    public void mostrarCiudadanos(List<Ciudadano> ciudadanos) {
        System.out.println("Lista de ciudadanos");
        for (Ciudadano ciudadano: ciudadanos)
            System.out.println(ciudadano);
    }

}
