package controller;

import db.CongresoDAO;
import model.Congreso;
import view.VistaCongreso;

import java.sql.SQLException;
import java.util.List;

/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Controlador para gestionar una lista de congresos.
 */
public class ControllerCongreso {
    private List<Congreso> congresos;
    private VistaCongreso vista;

    public ControllerCongreso() {
        congresos = new ArrayList<>();
        vista = new VistaCongreso();
    }

    public void mostrarTodosLosCongresos() {
        vista.mostrarCongresos(congresos);
    }

    public void crearCongreso() {
        Congreso nuevoCongreso = vista.crearCongreso();
        congresos.add(nuevoCongreso);
        vista.mostrarMensaje("Congreso creado correctamente.");
    }

    public void eliminarCongreso() {
        int id = vista.obtenerIdCongreso();
        boolean eliminado = false;
        List<Congreso> copia = new ArrayList<>(congresos);
        for (Congreso c : copia) {
            if (c.getId() == id) {
                congresos.remove(c);
                eliminado = true;
            }
        }
        if (eliminado) {
            vista.mostrarMensaje("Congreso eliminado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró ningún congreso con ese ID.");
        }
    }

    public void buscarCongresoPorId() {
        int id = vista.obtenerIdCongreso();
        boolean encontrado = false;
        for (Congreso c : congresos) {
            if (c.getId() == id) {
                vista.mostrarCongreso(c);
                encontrado = true;
            }
        }
        if (!encontrado) {
            vista.mostrarMensaje("No se encontró ningún congreso con ese ID.");
        }
    }

    public void actualizarCongreso() {
        Congreso actualizado = vista.obtenerDatosActualizados();
        boolean modificado = false;
        for (int i = 0; i < congresos.size(); i++) {
            if (congresos.get(i).getId() == actualizado.getId()) {
                congresos.set(i, actualizado);
                modificado = true;
            }
        }
        if (modificado) {
            vista.mostrarMensaje("Congreso actualizado correctamente.");
        } else {
            vista.mostrarMensaje("No se encontró ningún congreso con ese ID.");
        }
    }
}
