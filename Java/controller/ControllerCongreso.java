package controller;

import model.Congreso;
import view.VistaCongreso;

import java.util.ArrayList;
import java.util.List;

/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Controlador para gestionar una lista de congresos.
 */
public class ControllerCongreso {
    private List<Congreso> congresos;
    private VistaCongreso vista;
     /**
         * Constructor que inicializa la lista de congresos y la vista asociada.
         */
    public ControllerCongreso() {
        congresos = new ArrayList<>();
        vista = new VistaCongreso();
    }

     /**
     * Muestra todos los congresos almacenados utilizando la vista.
     */
    public void mostrarTodosLosCongresos() {
        vista.mostrarCongresos(congresos);
    }

         /**
     * Crea un nuevo congreso solicitando los datos a la vista
     * y lo añade a la lista de congresos.
     * Muestra un mensaje de confirmación tras la creación.
     */
    public void crearCongreso() {
        Congreso nuevoCongreso = vista.crearCongreso();
        congresos.add(nuevoCongreso);
        vista.mostrarMensaje("Congreso creado correctamente.");
    }

    /**
     * Elimina un congreso de la lista según el ID proporcionado por la vista.
     * Muestra un mensaje indicando si la eliminación fue exitosa o no.
     */
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

    /**
     * Busca un congreso por ID  y lo muestra.
     * Si no se encuentra, muestra un mensaje indicándolo.
     */
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

    /**
     * Actualiza los datos de un congreso existente.
     * Solicita los datos actualizados a la vista y reemplaza el congreso correspondiente.
     * Muestra un mensaje según si se realizó la actualización correctamente.
     */
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
