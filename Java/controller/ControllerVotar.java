package controller;

import db.VotarDAO;
import model.Votar;
import view.VistaVotar;

import java.util.List;

/**
 * Clase
 * @autor Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class ControllerVotar {

    private VotarDAO votarDAO;
    private VistaVotar vistaVotar;

    public ControllerVotar(){
        this.votarDAO = VotarDAO.getInstance();
        this.vistaVotar = new VistaVotar();
    }

    /**
     * Metodo que inserta un voto en la base de datos
     */
    public void insertarVoto(){
        try {
            Votar voto = vistaVotar.crearVoto();
            votarDAO.insertVotar(voto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que muestra todos los votos de la base de datos
     */
    public void mostrarTodosLosVotos(){
        try {
            List<Votar> votos = votarDAO.getAllVotar();
            vistaVotar.mostrarVotos(votos);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que muestra los votos de un ciudadano en concreto identificado por un número de pasaporte
     */
    public void mostrarVotosPorNumeroPasaporte(){
        try {
            String numPasaporte = vistaVotar.pedirNumPasaporteCiudadano();
            List<Votar> votos = votarDAO.getVotosByNumPasaporte(numPasaporte);
            vistaVotar.mostrarVotos(votos);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que muestra todos los votos de una propuesta en concreto
     */
    public void mostrarVotosPorIdPropuesta(){
        try {
            int id = vistaVotar.pedirId();
            List<Votar> votos = votarDAO.getVotosByIdPropuesta(id);
            vistaVotar.mostrarVotos(votos);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que muestra un voto en concreto identificado por el número de pasaporte del ciudadano y el id
     * de la propuesta
     */
    public void mostrarVotosPorNumeroPasaporteEIdPropuesta(){
        try {
            int id = vistaVotar.pedirId();
            String numPasaporte = vistaVotar.pedirNumPasaporteCiudadano();
            Votar voto = votarDAO.getVotosByNumPasaporteAndIdPropuesta(numPasaporte, id);
            vistaVotar.mostrarVoto(voto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
