package controller;

import db.CodigoCivilDAO;
import model.CodigoCivil;
import view.VistaCodigoCivil;

import java.sql.SQLException;
import java.util.List;

/**
 * @author ABDELMOGHIT SAMINI 1KDAM
 * Controlador para gestionar las operaciones relacionadas con Código Civil.
 */
public class ControllerCodigoCivil {
    private CodigoCivilDAO codigoDAO;
    private VistaCodigoCivil vista;
    /**
     * Constructor que inicializa el DAO y la vista.
     */
    public ControllerCodigoCivil() {
        codigoDAO = CodigoCivilDAO.getInstance();
        vista = new VistaCodigoCivil();
    }
    /**
     * Muestra todos los códigos civiles obtenidos desde la base de datos.
     */
    public void mostrarTodosLosCodigos() {
        try {
            List<CodigoCivil> codigos = codigoDAO.getAllCodigosCiviles();
            vista.mostrarCodigos(codigos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Crea un nuevo código civil a partir de los datos ingresados en la vista.
     */
    public void crearCodigoCivil() {
        try {
            CodigoCivil codigo = vista.crearCodigo();
            codigoDAO.insertCodigoCivil(codigo);
            vista.mostrarMensaje("Código Civil creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Actualiza un código civil con los datos proporcionados por la vista.
     */
    public void actualizarCodigoCivil() {
        try {
            CodigoCivil codigo = vista.obtenerDatosActualizados();
            codigoDAO.updateCodigoCivil(codigo);
            vista.mostrarMensaje("Código Civil actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Elimina un código civil según el ID proporcionado por la vista.
     */
    public void eliminarCodigoCivil() {
        try {
            int id = vista.obtenerIdCodigo();
            codigoDAO.deleteCodigoCivil(id);
            vista.mostrarMensaje("Código Civil eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Busca un código civil por su ID y lo muestra en la vista.
     */
    public void buscarCodigoPorId() {
        try {
            int id = vista.obtenerIdCodigo();
            CodigoCivil codigo = codigoDAO.getCodigoCivilById(id);
            vista.mostrarCodigo(codigo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
