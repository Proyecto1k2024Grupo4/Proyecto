package view;

import model.Votar;

import java.util.List;
import java.util.Scanner;

/**
 * Clase
 * @autor Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class VistaVotar {

    public Scanner scanner;

    /**
     * Constructor que no recibe parámetros
     */
    public VistaVotar(){
        scanner = new Scanner(System.in);
    }

    /**
     * Metodo que muestra por pantalla los votos que se le pasen como parámetro en forma de List
     * @param votos Lista de votos a mostrar
     */
    public void mostrarVotos(List<Votar> votos){
        System.out.println("Lista de votos");
        votos.forEach(System.out::println);
    }

    /**
     * Metodo que recibe un voto y muestra su información
     * @param voto Voto que se desea mostrar
     */
    public void mostrarVoto(Votar voto){
        System.out.println(voto);
    }

    /**
     * Metodo que pide de manera correcta el número de pasaporte de un ciudadano
     * @return Numero de pasaporte de un ciudadano
     */
    public String pedirNumPasaporteCiudadano(){
        boolean correcto = false;
        String numPasaporte = null;

        while (!correcto){

            try{
                correcto = true;
                while (numPasaporte.length() > 16){
                    System.out.print("\nIntroduce el número de pasaporte del ciudadano: ");
                    numPasaporte = scanner.nextLine();
                    if (numPasaporte.length() > 16){
                        System.out.println("El número de pasaporte no debe tener más de 16 caracteres.");
                    }
                }

            } catch (Exception e){
                correcto = false;
                System.out.println(e.getMessage());
                scanner.next();
            }

        }

        return numPasaporte;
    }

    /**
     * Metodo que pide un id de una propuesta manera correcta
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
     * Metodo que pide un boolean al usuario y lo retorna. Se asegura de que el dato introducido
     * es correcto
     * @return boolean con la decisión del usuario
     */
    public boolean pedirDecision(){

        boolean correcto = false;
        boolean resultado = false;

        while (!correcto){
            try {
                correcto = true;
                resultado = Boolean.getBoolean(scanner.nextLine());
            } catch (Exception e){
                correcto = false;
                System.out.println("Decisión inválida, por favor introduce true o false: ");
                scanner.next();
            }
        }

        return resultado;

    }

    /**
     * Metodo que pide datos al usuario y crea un objeto de Votar
     * @return Objeto de Votar con los datos pedidos
     */
    public Votar crearVoto(){

        boolean votoCorrecto = false;
        Votar voto = null;

        String numPasaporteCiudadano;
        int idPropuesta;
        boolean decision;

        System.out.println("\n---Creación de Voto---");

        while(!votoCorrecto){

            try {
                votoCorrecto = true;
                System.out.print("Introduce un numero de pasaporte: ");
                numPasaporteCiudadano = scanner.nextLine();

                System.out.print("Introduce el id de la propuesta: ");
                idPropuesta = pedirId();

                System.out.print("Introduce tu decisión (true/false): ");
                decision = pedirDecision();

                voto = new Votar(numPasaporteCiudadano, idPropuesta, decision);
            } catch (Exception e){
                votoCorrecto = false;
                System.out.println(e.getMessage());
                scanner.next();
            }
        }

        return voto;

    }

}
