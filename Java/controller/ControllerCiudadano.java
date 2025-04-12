package controller;

import db.CiudadanoDAO;
import model.Ciudadano;
import model.Persona;

import java.sql.SQLException;
import java.util.List;

public class ControllerCiudadano {
    private CiudadanoDAO ciudadanoDAO;
    private VistaPersona vistaCiudadano;

    public ControllerCiudadano() {
        ciudadanoDAO = CiudadanoDAO.getInstance();
        vistaCiudadano = new VistaPersona();
    }

    public void mostrarTodosLosCiudadanos() {
        try {
            List<Ciudadano> ciudadanos = ciudadanoDAO.getAllCiudadanos();
            vistaCiudadano.mostrarPersonas(ciudadanos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarCiudadanoPasaporte() {
        try {
            String pasaporte = vistaCiudadano.obtenerPasaporte();
            Ciudadano ciudadano = ciudadanoDAO.getCiudadanoByNumPasaporte(pasaporte);
            vistaCiudadano.mostrarPersona(ciudadano);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void crearCiudadano(){
        try {
            Ciudadano ciudadano = vistaCiudadano.crearPersona();
            ciudadanoDAO.insertarCiudadano(ciudadano);
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }

    public void eliminarCiudadano() {
        try {
            String pasaporte = vistaCiudadano.obtenerPasaporte();
            ciudadanoDAO.deleteCiudadanoByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
