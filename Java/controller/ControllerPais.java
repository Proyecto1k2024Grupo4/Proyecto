package controller;

import db.PaisDAO;
import model.Pais;
import view.VistaPais;

import java.sql.SQLException;
import java.util.List;

public class ControllerPais {
    private PaisDAO paisDAO;
    private VistaPais vista;

    public ControllerPais() {
        paisDAO = PaisDAO.getInstance();
        vista = new VistaPais();
    }

    public void mostrarTodos() {
        try {
            List<Pais> lista = paisDAO.getAllPaises();
            vista.mostrarPaises(lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearPais() {
        try {
            Pais p = vista.crearPais();
            paisDAO.insertPais(p);
            vista.mostrarMensaje("País creado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPais() {
//        try {
//            Pais p = vista.obtenerDatosActualizados();
//            paisDAO.update(p);
//            vista.mostrarMensaje("País actualizado.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void eliminarPais() {
//        try {
//            String nombre = vista.obtenerNombrePais();
//            paisDAO.delete(nombre);
//            vista.mostrarMensaje("País eliminado.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void buscarPorNombre() {
//        try {
//            String nombre = vista.obtenerNombrePais();
//            Pais p = paisDAO.getBy(nombre);
//            vista.mostrarPais(p);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
   }
}
