package controller;

import db.CongresoDAO;
import model.Congreso;
import view.VistaCongreso;

import java.sql.SQLException;
import java.util.List;

public class ControllerCongreso {
//    private CongresoDAO congresoDAO;
//    private VistaCongreso vista;
//
//    public ControllerCongreso() {
//        congresoDAO = CongresoDAO.getInstance();
//        vista = new VistaCongreso();
//    }
//
//    public void mostrarTodosLosCongresos() {
//        try {
//            List<Congreso> congresos = congresoDAO.getAllCongresos();
//            vista.mostrarCongresos(congresos);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void crearCongreso() {
//        try {
//            Congreso congreso = vista.crearCongreso();
//            congresoDAO.insertCongreso(congreso);
//            vista.mostrarMensaje("Congreso creado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void actualizarCongreso() {
//        try {
//            Congreso congreso = vista.obtenerDatosActualizados();
//            congresoDAO.updateCongreso(congreso);
//            vista.mostrarMensaje("Congreso actualizado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void eliminarCongreso() {
//        try {
//            int id = vista.obtenerIdCongreso();
//            congresoDAO.deleteCongreso(id);
//            vista.mostrarMensaje("Congreso eliminado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void buscarCongresoPorId() {
//        try {
//            int id = vista.obtenerIdCongreso();
//            Congreso congreso = congresoDAO.getCongresoById(id);
//            vista.mostrarCongreso(congreso);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
