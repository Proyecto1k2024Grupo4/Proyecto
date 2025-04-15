package controller;

import model.Desarrollar;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ABDELMOGHIT SAMINI 1KDAM
 * Controlador para gestionar una lista de objetos Desarrollar.
 */
public class ControllerDesarollar {
    private List<Desarrollar> desarrollos = new ArrayList<>();

    /**
     * Agrega un nuevo desarrollo a la lista.
     *
     * @param desarrollo el objeto Desarrollar a agregar
     */
    public void agregarDesarrollo(Desarrollar desarrollo) {
        desarrollos.add(desarrollo);
    }

    /**
     * Obtiene la lista de desarrollos.
     *
     * @return lista de objetos Desarrollar
     */
    public List<Desarrollar> obtenerDesarrollos() {
        return desarrollos;
    }

    /**
     * Elimina un desarrollo de la lista según el id del país y el id del código.
     *
     * @param idPais id del país
     * @param idCodigo id del código civil
     * @return true si se eliminó correctamente, false en caso contrario
     */
    public boolean eliminarDesarrollo(int idPais, int idCodigo) {
        return desarrollos.removeIf(d -> d.getIdPais() == idPais && d.getIdCodigoCivil() == idCodigo);
    }
}

