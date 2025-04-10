package controller;

import db.CongresoDAO;
import model.Congreso;
import view.VistaCongreso;

import java.sql.SQLException;
import java.util.List;

public class ControllerCongreso {
    private CongresoDAO congresoDAO;
    private VistaCongreso vista;

    public ControllerCongreso() {
        congresoDAO = CongresoDAO.getInstance();
        vista = new VistaCongreso();
    }

    public void mostrarTodos() {
        try {
            List<Congreso> lista = congresoDAO.getAllCongresos();
            vista.mostrarCongresos(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearCongreso() {
        try {
            Congreso c = vista.crearCongreso();
            congresoDAO.insertCongreso(c);
            vista.mostrarMensaje("Congreso creado.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCongreso() {
//        try {
//            Congreso c = vista.obtenerDatosActualizados();
//            congresoDAO.update(c);
//            vista.mostrarMensaje("Congreso actualizado.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void eliminarCongreso() {
//        try {
//            int id = vista.obtenerId();
//            congresoDAO.delete(id);
//            vista.mostrarMensaje("Congreso eliminado.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void buscarPorId() {
//        try {
//            int id = vista.obtenerId();
//            Congreso c = congresoDAO.getById(id);
//            vista.mostrarCongreso(c);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
