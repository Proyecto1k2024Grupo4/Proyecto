package controller;

import db.PoliticoDAO;
import model.Politico;
import view.VistaPersona;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Controlador para la gestión de politicos, actua de intermediario entre vistaPersona y PoliticoDAO
 * @author Jonathan Villaba Moran 1ºK
 * @version 14/04/2025
 */
public class ControllerPolitico {
    private PoliticoDAO politicoDAO;
    //Aqui quiza con la VistaPersona basta
    private VistaPersona vistaPolitico;

    public ControllerPolitico() {
        politicoDAO = PoliticoDAO.getInstance();
        vistaPolitico = new VistaPersona();
    }

    /**
     * Muestra todos los politicos registrados
     */
    public void mostrarTodosLosPoliticos(){
        try {
            List<Politico> politicos = politicoDAO.getAllPoliticos();
            vistaPolitico.mostrarPoliticos(politicos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra a el politico con el numero de pasaporte indicado
     */
    public void mostrarPoliticoPasaporte(){
        try {
            String pasaporte = vistaPolitico.obtenerPasaporte();
            Politico politico = politicoDAO.getPoliticoByNumPasaporte(pasaporte);
            vistaPolitico.mostrarPersona(politico);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    /**
     * Metodo para crear un politico
     */
    public void crearPolitco() {
        try {
            Politico politico = vistaPolitico.crearPolitico();
            politicoDAO.insertarPolitico(politico);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar a un politico con nuevos datos
     */
    public void acutalizarPolitico() {
        try {
            Politico politico = vistaPolitico.crearPolitico();
            politicoDAO.updatePolitico(politico);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo que elimina un politico de la base de datos con el pasaporte que se le indica
     */
    public void eliminarPolitico() {
        try {
            String pasaporte = vistaPolitico.obtenerPasaporte();
            politicoDAO.deletePoliticoByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
