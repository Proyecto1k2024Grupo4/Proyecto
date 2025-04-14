package controller;

import db.CiudadanoDAO;
import model.Ciudadano;
import model.Persona;
import view.VistaPersona;

import java.sql.SQLException;
import java.util.List;

public class ControllerCiudadano {
    private CiudadanoDAO ciudadanoDAO;
    private VistaPersona vistaCiudadano;

    public ControllerCiudadano() {
        ciudadanoDAO = CiudadanoDAO.getInstance();
        vistaCiudadano = new VistaPersona();
    }

    /**
     * Muestra todos los ciudadanos registrados
     */
    public void mostrarTodosLosCiudadanos() {
        try {
            List<Ciudadano> ciudadanos = ciudadanoDAO.getAllCiudadanos();
            vistaCiudadano.mostrarCiudadanos(ciudadanos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra a el ciudadano con el numero de pasaporte indicado
     */
    public void mostrarCiudadanoPasaporte() {
        try {
            String pasaporte = vistaCiudadano.obtenerPasaporte();
            Ciudadano ciudadano = ciudadanoDAO.getCiudadanoByNumPasaporte(pasaporte);
            vistaCiudadano.mostrarPersona(ciudadano);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para crear un ciudadano
     */
    public void crearCiudadano(){
        try {
            Ciudadano ciudadano = vistaCiudadano.crearCiudadano();
            ciudadanoDAO.insertarCiudadano(ciudadano);
        } catch (SQLException e) {
             e.printStackTrace();
        }
    }

    /**
     * Metodo que elimina un ciudadano de la base de datos con el pasaporte que se le indica
     */
    public void eliminarCiudadano() {
        try {
            String pasaporte = vistaCiudadano.obtenerPasaporte();
            ciudadanoDAO.deleteCiudadanoByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
