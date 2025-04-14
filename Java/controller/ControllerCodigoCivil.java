package controller;

import db.CodigoCivilDAO;
import model.CodigoCivil;
import view.VistaCodigoCivil;

import java.sql.SQLException;
import java.util.List;

public class ControllerCodigoCivil {
    private CodigoCivilDAO codigoDAO;
    private VistaCodigoCivil vista;

    public ControllerCodigoCivil() {
        codigoDAO = CodigoCivilDAO.getInstance();
        vista = new VistaCodigoCivil();
    }

    public void mostrarTodosLosCodigos() {
        try {
            List<CodigoCivil> codigos = codigoDAO.getAllCodigosCiviles();
            vista.mostrarCodigos(codigos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearCodigoCivil() {
        try {
            CodigoCivil codigo = vista.crearCodigo();
            codigoDAO.insertCodigoCivil(codigo);
            vista.mostrarMensaje("Código Civil creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCodigoCivil() {
        try {
            CodigoCivil codigo = vista.obtenerDatosActualizados();
            codigoDAO.updateCodigoCivil(codigo);
            vista.mostrarMensaje("Código Civil actualizado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCodigoCivil() {
        try {
            int id = vista.obtenerIdCodigo();
            codigoDAO.deleteCodigoCivil(id);
            vista.mostrarMensaje("Código Civil eliminado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
