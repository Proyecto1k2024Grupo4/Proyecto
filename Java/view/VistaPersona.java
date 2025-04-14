package view;

import model.Persona;
import model.Politico;
import model.Sexo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VistaPersona {
    public Scanner scan;

    public VistaPersona(){
        scan = new Scanner(System.in);
    }

    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("Lista de personas");
        for (Persona persona: personas)
            System.out.println(persona);
    }

    public Persona crearPersona (){
        String pasaporte = obtenerPasaporte();
        System.out.println("Introduce el nombre");
        String nombre = scan.next();
        System.out.println("Introduce el primer apellido");
        String apellido1 = scan.next();
        System.out.println("Introduce el segundo apellido");
        String apellido2 = scan.next();
        System.out.println("Introduce la fecha de nacimiento");
        Date fecha = obtenerFecha();
        System.out.println("Introduce el sexo(H,M)");
        Sexo sexo = Sexo.valueOf(scan.next());
        System.out.println("Introduce el pais (codigo)");
        int pais = scan.nextInt();
        return new Persona(pasaporte, nombre, apellido1, apellido2, fecha, sexo, pais);
    }

    public String obtenerPasaporte() throws IllegalArgumentException{
        System.out.println("Introduce el pasaporte");
        String numPasaporte = scan.next();
        if (!(numPasaporte.length() > 16))
            return numPasaporte;
        else
            throw new IllegalArgumentException("Error: el formato del pasaporte es incorrecto");
    }

    public void mostrarPersona(Persona persona) {
        if (persona!=null)
            System.out.println(persona);
        else
            System.out.println("No existe esta persona");
    }

    //Metodos para los politicos
    public Politico crearPolitico(){
        String pasaporte = obtenerPasaporte();
        System.out.println("Introduce el nombre");
        String nombre = scan.next();
        System.out.println("Introduce el primer apellido");
        String apellido1 = scan.next();
        System.out.println("Introduce el segundo apellido");
        String apellido2 = scan.next();
        System.out.println("Introduce la fecha de nacimiento");
        Date fecha = obtenerFecha();
        System.out.println("Introduce el sexo(H,M)");
        Sexo sexo = Sexo.valueOf(scan.next());
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


    public void mostrarPoliticos(List<Politico> politicos) {
        System.out.println("Lista de politicos");
        for (Politico politico:politicos)
            System.out.println(politico);
    }

    public Date obtenerFecha(){
        boolean correcto = false;
        Date fecha = null;
        while(!correcto){
            try {
                correcto = true;
                fecha = Date.valueOf(LocalDate.parse(scan.nextLine()));
            } catch (Exception e){
                System.out.println("Fecha incorrecta, por favor introduce la fecha con este formato (año-mes-dia) (Ejemplo: 1999-01-01): ");
                correcto = false;
                scan.next();
            }
        }
        return fecha;
    }

}
