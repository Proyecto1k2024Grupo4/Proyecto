package controller;

import db.PaisDAO;
import model.Pais;
import view.VistaPais;

import java.sql.SQLException;
import java.util.List;

public class ControllerPais {
//    private PaisDAO paisDAO;
//    private VistaPais vista;
//
//    public ControllerPais() {
//        paisDAO = PaisDAO.getInstance();
//        vista = new VistaPais();
//    }
//
//    public void mostrarTodosLosPaises() {
//        try {
//            List<Pais> paises = paisDAO.getAllPaises();
//            vista.mostrarPaises(paises);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void crearPais() {
//        try {
//            Pais pais = vista.crearPais();
//            paisDAO.insertPais(pais);
//            vista.mostrarMensaje("País creado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void actualizarPais() {
//        try {
//            Pais pais = vista.obtenerDatosActualizados();
//            paisDAO.updatePais(pais);
//            vista.mostrarMensaje("País actualizado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void eliminarPais() {
//        try {
//            int id = vista.obtenerIdPais();
//            paisDAO.deletePais(id);
//            vista.mostrarMensaje("País eliminado correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void buscarPaisPorId() {
//        try {
//            int id = vista.obtenerIdPais();
//            Pais pais = paisDAO.getPaisById(id);
//            vista.mostrarPais(pais);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
