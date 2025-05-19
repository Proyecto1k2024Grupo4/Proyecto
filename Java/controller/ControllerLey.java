package controller;

import db.LeyDAO;
import model.Ley;
import view.VistaLey;

import java.util.List;

/**
 * Clase ControllerLey que maneja la clase LeyDAO y muestra la información mediante la vista de Ley
 * @autor AbdelMoghit Samini 1ºK
 * @version 14-04-2025
 */
public class ControllerLey {

    private LeyDAO leyDAO;
    private VistaLey vistaLey;

    /**
        Construye un ControllerLey inicializando la instancia de DAO y la vista.
     */
    public ControllerLey() {
        leyDAO = LeyDAO.getInstance();
        vistaLey = new VistaLey();
    }
    /**
        Obtiene todas las leyes de la base de datos y las muestra al usuario.
     */
    public void mostrarTodasLasLeyes() {
        try {
            List<Ley> leyes = leyDAO.getAllLey();
            vistaLey.mostrarLeyes(leyes);
        } catch (Exception e) {
            System.out.println("Error al listar leyes: " + e.getMessage());
        }
    }
    /**
        Solicita un ID al usuario y muestra la ley correspondiente si existe.
     */
    public void mostrarLeyPorId() {
        try {
            int id = vistaLey.pedirId("Introduce el id de la ley: ");
            Ley ley = leyDAO.getByIdLey(id);
            vistaLey.mostrarLey(ley);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
        Solicita al usuario el ID de un código civil y lista las leyes asociadas.
     */
    public void mostrarLeyesPorCodigoCivil() {
        try {
            int idCc = vistaLey.pedirId("Introduce el id del Código Civil: ");
            List<Ley> leyes = leyDAO.getByCodigoCivil(idCc);
            vistaLey.mostrarLeyes(leyes);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    /**
        Crea una nueva ley solicitando datos al usuario y la persiste en la base de datos.
     */
    public void insertarLey() {
        try {
            Ley ley = vistaLey.crearLey(false);
            leyDAO.insertLey(ley);
            vistaLey.mostrarMensaje("Ley insertada correctamente");
        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    /**
         Actualiza una ley existente solicitando datos al usuario (incluye ID) y persiste cambios.
     */
    public void actualizarLey() {
        try {
            Ley ley = vistaLey.crearLey(true);
            leyDAO.updateLeyById(ley);
            vistaLey.mostrarMensaje("Ley actualizada correctamente");
        } catch (Exception e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    /**
         Elimina una ley según el ID que el usuario proporcione.
     */
    public void borrarLey() {
        try {
            int id = vistaLey.pedirId();
            leyDAO.deleteLeyById(id);
            vistaLey.mostrarMensaje("Ley eliminada correctamente");
        } catch (Exception e) {
            System.out.println("Error al borrar: " + e.getMessage());
        }
    }

}
