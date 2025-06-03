package controller;

import db.DesarrollarDAO;
import model.Desarrollar;
import view.VistaDesarrollar;

import java.sql.SQLException;
import java.util.List;

public class ControllerDesarrollar {
//    private DesarrollarDAO desarrollarDAO;
//    private VistaDesarrollar vista;
//
//    public ControllerDesarrollar() {
//        desarrollarDAO = DesarrollarDAO.getInstance();
//        vista = new VistaDesarrollar();
//    }
//
//    public void mostrarTodosLosDesarrollos() {
//        try {
//            List<Desarrollar> desarrollos = desarrollarDAO.getAllDesarrollos();
//            vista.mostrarDesarrollos(desarrollos);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void crearRelacionDesarrollar() {
//        try {
//            Desarrollar desarrollar = vista.crearRelacion();
//            desarrollarDAO.insertDesarrollar(desarrollar);
//            vista.mostrarMensaje("Relación 'Desarrollar' creada correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void eliminarRelacionDesarrollar() {
//        try {
//            int idPais = vista.obtenerIdPais();
//            int idCodigo = vista.obtenerIdCodigoCivil();
//            desarrollarDAO.deleteDesarrollar(idPais, idCodigo);
//            vista.mostrarMensaje("Relación 'Desarrollar' eliminada correctamente.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void buscarRelacionesPorPais() {
//        try {
//            int idPais = vista.obtenerIdPais();
//            List<Desarrollar> relaciones = desarrollarDAO.getDesarrollosByPais(idPais);
//            vista.mostrarDesarrollos(relaciones);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
