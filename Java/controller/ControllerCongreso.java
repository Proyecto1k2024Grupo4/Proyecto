package controller;
import model.Congreso;
import java.util.ArrayList;
import java.util.List;

public class ControllerCongreso {
    private List<Congreso> congresos = new ArrayList<>();

    public void agregarCongreso(Congreso congreso) {
        congresos.add(congreso);
    }

    public List<Congreso> obtenerCongresos() {
        return congresos;
    }

    public Congreso buscarCongresoPorId(int id) {
        for (Congreso c : congresos) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public boolean actualizarCongreso(Congreso congresoActualizado) {
        for (int i = 0; i < congresos.size(); i++) {
            if (congresos.get(i).getId() == congresoActualizado.getId()) {
                congresos.set(i, congresoActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarCongreso(int id) {
        return congresos.removeIf(c -> c.getId() == id);
    }
}

