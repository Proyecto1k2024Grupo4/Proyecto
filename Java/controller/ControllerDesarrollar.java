package controller;

import db.DesarrollarDAO;
import model.Desarrollar;
import view.VistaDesarrollar;

import java.sql.SQLException;
import java.util.List;
/**
 * La clase ControllerDesarrollar es el controlador que maneja la lógica de negocio
 * relacionada con las operaciones CRUD sobre la entidad 'Desarrollar'. Esta clase
 * conecta la vista (VistaDesarrollar) y la capa de acceso a datos (DesarrollarDAO).
 */
public class ControllerDesarrollar {
    private DesarrollarDAO desarrollarDAO;
    private VistaDesarrollar vista;

    public ControllerDesarrollar() {
        desarrollarDAO = DesarrollarDAO.getInstance();
        vista = new VistaDesarrollar();
    }
    /**
     * Método que maneja la creación de una relación 'Desarrollar' en la base de datos.
     * Recibe los datos introducidos por el usuario a través de la vista y los pasa al DAO
     * para ser insertados en la base de datos.
     */
    public void crearRelacionDesarrollar() {
        try {
            vista.crearRelacion();
            Desarrollar desarrollar = vista.getRelacionCreada();
            desarrollarDAO.insertDesarrollar(desarrollar);
            vista.mostrarMensaje("Relación 'Desarrollar' creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que maneja la eliminación de una relación 'Desarrollar' de la base de datos.
     * Solicita al usuario los datos necesarios y los pasa al DAO para eliminar la relación.
     */
    public void eliminarRelacionDesarrollar() {
        try {
            vista.pedirDatosEliminar();
            int idPropuesta = vista.getIdPropuesta();
            int idLey = vista.getIdLey();
            desarrollarDAO.deleteDesarrollar(idPropuesta, idLey);
            vista.mostrarMensaje("Relación 'Desarrollar' eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Método que permite buscar relaciones 'Desarrollar' por el ID de la propuesta.
     * Solicita al usuario el ID de la propuesta, realiza la búsqueda en el DAO y muestra
     * los resultados en la vista.
     */
    public void buscarRelacionesPorPais() {
        try {
            vista.pedirIdPropuestaBuscar();
            int idPropuesta = vista.getIdPropuesta();
            List<Desarrollar> relaciones = desarrollarDAO.getDesarrollosByPais(idPropuesta);
            vista.mostrarDesarrollos(relaciones);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
