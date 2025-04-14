package controller;

import db.PoliticoDAO;
import model.Politico;
import view.VistaPersona;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class ControllerPolitico {
    private PoliticoDAO politicoDAO;
    //Aqui quiza con la VistaPersona basta
    private VistaPersona vistaPolitico;

    public ControllerPolitico() {
        politicoDAO = PoliticoDAO.getInstance();
        vistaPolitico = new VistaPersona();
    }

    public void mostrarTodosLosPoliticos(){
        try {
            List<Politico> politicos = politicoDAO.getAllPoliticos();
            vistaPolitico.mostrarPoliticos(politicos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPoliticoPasaporte(){
        try {
            String pasaporte = vistaPolitico.obtenerPasaporte();
            Politico politico = politicoDAO.getPoliticoByNumPasaporte(pasaporte);
            vistaPolitico.mostrarPersona(politico);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void crearPolitco() {
        try {
            Politico politico = vistaPolitico.crearPolitico();
            politicoDAO.insertarPolitico(politico);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void acutalizarPolitico() {
        try {
            Date fecha = vistaPolitico.obtenerFecha();
            String pasaporte = vistaPolitico.obtenerPasaporte();
            politicoDAO.updatePolitico(fecha, pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPolitico() {
        try {
            String pasaporte = vistaPolitico.obtenerPasaporte();
            politicoDAO.deletePoliticoByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
