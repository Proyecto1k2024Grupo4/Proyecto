package controller;

import db.PersonaDAO;
import model.Persona;
import view.VistaPersona;

import java.sql.SQLException;
import java.util.List;

public class ControllerPersona {
    private PersonaDAO personaDAO;
    private VistaPersona vistaPersona;

    public ControllerPersona() {
        personaDAO = PersonaDAO.getInstance();
        vistaPersona = new VistaPersona();
    }

    public void mostrarTodasLasPersonas() {
        try {
            List<Persona> personas = personaDAO.getAllPersonas();
            vistaPersona.mostrarPersonas(personas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostarPersonaPasaporte() {
        try {
            String pasaporte = vistaPersona.obtenerPasaporte();
            Persona persona = personaDAO.getPersonaByNumPasaporte(pasaporte);
            vistaPersona.mostrarPersona(persona);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void crearPersona() {
        try {
            Persona persona = vistaPersona.crearPersona();
            personaDAO.insertarPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersona() {
        try {
            String pasaporte = vistaPersona.obtenerPasaporte();
            Persona persona = vistaPersona.crearPersona();
            personaDAO.updatePersona(persona, pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona() {
        try {
            String pasaporte = vistaPersona.obtenerPasaporte();
            personaDAO.deletePersonaByNumPasaporte(pasaporte);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
