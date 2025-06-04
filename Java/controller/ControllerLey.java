package controller;

import db.LeyDAO;
import model.Ley;
import view.VistaLey;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador para manejar la visualización en consola de:
 */
public class ControllerLey {

    private final LeyDAO leyDAO;
    private final VistaLey vistaLey;

    /**
     * Constructor que obtiene la instancia de LeyDAO e inicializa la VistaLey
     */
    public ControllerLey() {
        this.leyDAO = LeyDAO.getInstance();
        this.vistaLey = new VistaLey();
    }

    /**
     * Obtiene todas las leyes de la base de datos (incluyendo país)
     * y las muestra al usuario.
     */
    public void mostrarTodasLasLeyes() {
        try {
            List<Ley> leyes = leyDAO.getAllLey();
            // Llamamos a la vista genérica para listar todas
            vistaLey.mostrarTodasLasLeyes(leyes);
        } catch (SQLException e) {
            System.out.println("ERROR al obtener todas las leyes: " + e.getMessage());
        }
    }

    /**
     * Método que inserta una ley en la base de datos.
     */
    public void insertarLey() {
        try {
            Ley ley = vistaLey.crearLey(false);
            leyDAO.insertLey(ley);
            System.out.println("Ley insertada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al insertar ley: " + e.getMessage());
        }
    }

    /**
     * Método que muestra una ley con el ID que el usuario introduzca.
     */
    public void mostrarLeyPorId() {
        try {
            int id = vistaLey.pedirId();
            Ley ley = leyDAO.getByIdLey(id);
            vistaLey.mostrarLey(ley);
        } catch (Exception e) {
            System.out.println("ERROR al buscar ley por ID: " + e.getMessage());
        }
    }

    /**
     * Método que pide los datos de una ley al usuario y la actualiza en la BD.
     */
    public void actualizarLey() {
        try {
            Ley ley = vistaLey.crearLey(true);
            leyDAO.updateLeyById(ley);
            System.out.println("Ley actualizada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al actualizar ley: " + e.getMessage());
        }
    }

    /**
     * Método que pide un ID y borra la ley con ese ID de la base de datos.
     */
    public void borrarLey() {
        try {
            int id = vistaLey.pedirId();
            leyDAO.deleteLeyById(id);
            System.out.println("Ley eliminada correctamente.");
        } catch (Exception e) {
            System.out.println("ERROR al borrar ley: " + e.getMessage());
        }
    }

    /**
     * Pide al usuario el ID de Código Civil y muestra todas las leyes de ese código, junto al país.
     */
    public void mostrarLeyesPorCodigoCivil() {
        int idCc = vistaLey.pedirIdCodigoCivil();
        try {
            List<Ley> lista = leyDAO.getLeyesPorCodigoCivil(idCc);
            vistaLey.mostrarLeyes(lista, "Código Civil", idCc);
        } catch (SQLException e) {
            System.out.println("ERROR al obtener leyes por Código Civil: " + e.getMessage());
        }
    }

    /**
     * Pide al usuario el ID de País y muestra todas las leyes de ese país (a través de Código Civil).
     */
    public void mostrarLeyesPorPais() {
        int idPais = vistaLey.pedirIdPais();
        try {
            List<Ley> lista = leyDAO.getLeyesPorPais(idPais);
            vistaLey.mostrarLeyes(lista, "País", idPais);
        } catch (SQLException e) {
            System.out.println("ERROR al obtener leyes por País: " + e.getMessage());
        }
    }
}
