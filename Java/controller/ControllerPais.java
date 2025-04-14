package controller;

import model.Pais;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador para gestionar una lista de países.
 */
public class ControllerPais {
    private List<Pais> paises = new ArrayList<>();

    /**
     * Agrega un país a la lista.
     * @param pais País a agregar.
     */
    public void agregarPais(Pais pais) {
        paises.add(pais);
    }

    /**
     * Obtiene la lista completa de países.
     * @return Lista de países.
     */
    public List<Pais> obtenerPaises() {
        return paises;
    }

    /**
     * Busca un país por su ID.
     * @param id ID del país.
     * @return País si se encuentra, o null si no existe.
     */
    public Pais buscarPaisPorId(int id) {
        for (Pais p : paises) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Actualiza un país existente.
     * @param paisActualizado Objeto país actualizado.
     * @return true si se actualizó, false si no se encontró.
     */
    public boolean actualizarPais(Pais paisActualizado) {
        for (int i = 0; i < paises.size(); i++) {
            if (paises.get(i).getId() == paisActualizado.getId()) {
                paises.set(i, paisActualizado);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina un país por su ID.
     * @param id ID del país a eliminar.
     * @return true si se eliminó, false si no se encontró.
     */
    public boolean eliminarPais(int id) {
        return paises.removeIf(p -> p.getId() == id);
    }
}
