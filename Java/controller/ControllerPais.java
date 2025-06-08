package controller;

import db.PaisDAO;
import model.Pais;
import view.VistaPais;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

/**
 * Controlador para gestionar operaciones CRUD de la entidad País.
 * Esta clase conecta la vista (VistaPais) con la capa de acceso a datos (PaisDAO),
 * proporcionando métodos para listar, buscar, crear, actualizar y eliminar países.
 * @author ABDELMOGHIT SAMINI 1KDAM
 */
public class ControllerPais {
    private PaisDAO paisDAO;
    private VistaPais vista;
    /**
     Crea una instancia de ControllerPais inicializando el DAO y la vista.
     */
    public ControllerPais() {
        this.paisDAO = PaisDAO.getInstance();
        vista = new VistaPais();
    }
/**
    Obtiene todos los países de la base de datos y los muestra al usuario.
 */
    public void mostrarTodosLosPaises() {
        try {
            List<Pais> paises = paisDAO.getAllPaises();
            vista.mostrarPaises(paises);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
         Solicita al usuario un ID de país y muestra la información si existe.
     */
    public void buscarPaisPorId() {
        try {
            int id = vista.obtenerIdPais();
            Pais pais = paisDAO.getPaisById(id);
            vista.mostrarPais(pais);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
         Solicita al usuario los datos de un nuevo país y lo inserta en la base de datos.
     */

    public void crearPais() {
        try {
            Pais pais = vista.crearPais();
            paisDAO.insertPais(pais);
            vista.mostrarMensaje("País creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
         Solicita al usuario los datos actualizados de un país existente y persiste los cambios.
     */
    public void actualizarPais() {
        try {
            Pais pais = vista.obtenerDatosActualizados();
            paisDAO.updatePais(pais);
            vista.mostrarMensaje("País actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Solicita al usuario el ID de un país y lo elimina .
     * captura la excepción y notifica al usuario.
     */
    public void eliminarPais() {
        try {
            int id = vista.obtenerIdPais();
            paisDAO.deletePaisById(id);
            vista.mostrarMensaje("País eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            vista.mostrarMensaje("Error al eliminar: " + e.getMessage());
        }
    }

}
