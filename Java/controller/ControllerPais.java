package controller;

import model.Pais;
import java.util.ArrayList;
import java.util.List;

public class ControllerPais {
    private List<Pais> paises = new ArrayList<>();

    public void agregarPais(Pais pais) {
        paises.add(pais);
    }

    public List<Pais> obtenerPaises() {
        return paises;
    }

    public Pais buscarPaisPorId(int id) {
        for (Pais p : paises) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean actualizarPais(Pais paisActualizado) {
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i).getId() == paisActualizado.getId()) {
                paises.set(i, paisActualizado);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarPais(int id) {
        return paises.removeIf(p -> p.getId() == id);
    }
}
