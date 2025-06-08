package controller;

import db.DesarrollarDAO;
import model.Desarrollar;
import view.VistaDesarrollar;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Controlador encargado de gestionar las relaciones entre propuestas y leyes mediante la entidad 'Desarrollar'.
 * Se encarga de coordinar las operaciones CRUD: creación, eliminación y búsqueda de relaciones, interactuando con la capa de datos (DesarrollarDAO) y
 * mostrando resultados al usuario a través de la vista (VistaDesarrollar).
 * @author ABDELMOGHIT SAMINI 1KDAM
 */
public class ControllerDesarrollar {
    private DesarrollarDAO desarrollarDAO;
    private VistaDesarrollar vista;

    public ControllerDesarrollar() {
        desarrollarDAO = DesarrollarDAO.getInstance();
        vista = new VistaDesarrollar();
    }
   /**
    * Solicita datos al usuario para crear una nueva relación Desarrollar,
    * la persiste en la base de datos e informa del resultado.
*/
    public void crearRelacionDesarrollar() {
        try {
            vista.crearRelacion();
            Desarrollar rel = vista.getRelacionCreada();
            desarrollarDAO.insertDesarrollar(rel);
            vista.mostrarMensaje("Relación 'Desarrollar' creada correctamente.");
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al crear relación: " + e.getMessage());
        }
    }
    /**
         * Solicita al usuario los identificadores necesarios para eliminar
         * una relación Desarrollar y la elimina de la base de datos.
     */
    public void eliminarRelacionDesarrollar() {
        try {
            vista.pedirDatosEliminar();
            int idP = vista.getIdPropuesta();
            int idL = vista.getIdLey();
            desarrollarDAO.deleteDesarrollar(idP, idL);
            vista.mostrarMensaje("Relación 'Desarrollar' eliminada correctamente.");
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al eliminar relación: " + e.getMessage());
        }
    }
    /**
         * Permite al usuario buscar todas las relaciones Desarrollar asociadas
         * a una propuesta concreta e imprime el resultado.
     */

    public void buscarRelacionesPorPropuesta() {
        try {
            vista.pedirIdPropuestaBuscar();
            int idP = vista.getIdPropuesta();
            List<Desarrollar> lista = desarrollarDAO.getDesarrollosByPropuesta(idP);
            vista.mostrarDesarrollos(lista);
        } catch (SQLException e) {
            vista.mostrarMensaje("Error al buscar relaciones: " + e.getMessage());
        }
    }
}
