package controller;

import model.Congreso;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Controlador para gestionar una lista de congresos.
 */
public class ControllerCongreso {
    private List<Congreso> congresos = new ArrayList<>();

    /**
     * Agrega un congreso a la lista.
     * @param congreso Congreso a agregar.
     */
    public void agregarCongreso(Congreso congreso) {
        congresos.add(congreso);
    }

    /**
     * Obtiene la lista completa de congresos.
     * @return Lista de congresos.
     */
    public List<Congreso> obtenerCongresos() {
        return congresos;
    }

    /**
     * Busca un congreso por su ID.
     * @param id ID del congreso.
     * @return Congreso si se encuentra, o null si no existe.
     */
    public Congreso buscarCongresoPorId(int id) {
        for (Congreso c : congresos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    /**
     * Actualiza un congreso existente.
     * @param congresoActualizado Objeto congreso actualizado.
     * @return true si se actualizó, false si no se encontró.
     */
    public boolean actualizarCongreso(Congreso congresoActualizado) {
        for (int i = 0; i < congresos.size(); i++) {
            if (congresos.get(i).getId() == congresoActualizado.getId()) {
                congresos.set(i, congresoActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un congreso por su ID.
     * @param id ID del congreso a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminarCongreso(int id) {
        return congresos.removeIf(c -> c.getId() == id);
    }
}
