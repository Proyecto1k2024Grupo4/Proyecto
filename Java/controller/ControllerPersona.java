package controller;

import db.PersonaDAO;
import model.Persona;
import view.VistaPersona;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para la gestión de personas, actúa de intermediario entre VistaPersona y PersonaDAO
 * @author Jonathan Villaba Moran 1ºK
 * @version 14/04/2025
 */
public class ControllerPersona {
    private PersonaDAO personaDAO;
    private VistaPersona vistaPersona;

    public ControllerPersona() {
        personaDAO = PersonaDAO.getInstance();
        vistaPersona = new VistaPersona();
    }


    /**
     * Muestra todas personas las registradas
     */
    public void mostrarTodasLasPersonas() {
        try {
            List<Persona> personas = personaDAO.getAllPersonas();
            vistaPersona.mostrarPersonas(personas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Muestra a la persona con el numero de pasaporte indicado
     */
    public void mostarPersonaPasaporte() {
        try {
            String pasaporte = vistaPersona.obtenerPasaporte();
            Persona persona = personaDAO.getPersonaByNumPasaporte(pasaporte);
            vistaPersona.mostrarPersona(persona);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo para crear una persona
     */
    public void crearPersona() {
        try {
            Persona persona = vistaPersona.crearPersona();
            personaDAO.insertarPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarPersonaPais(){
        try {
            List<Persona> personas = personaDAO.getAllPersonasPais(vistaPersona.pedirPais());
            vistaPersona.mostrarPersonas(personas);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo para actualizar a una persona con nuevos datos
     */
    public void actualizarPersona() {
        try {
            Persona persona = vistaPersona.crearPersona();
            String pasaporte = persona.getNumPasaporte();
            personaDAO.updatePersona(persona, pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que elimina una persona de la base de datos con el pasaporte que se le indica
     */
    public void eliminarPersona() {
        try {
            String pasaporte = vistaPersona.obtenerPasaporte();
            personaDAO.deletePersonaByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
