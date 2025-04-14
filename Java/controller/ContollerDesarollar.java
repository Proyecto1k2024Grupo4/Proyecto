package controller;

import model.Desarrollar;
import java.util.ArrayList;
import java.util.List;

public class ContollerDesarollar  {
    private List<Desarrollar> desarrollos = new ArrayList<>();

    public void agregarDesarrollo(Desarrollar desarrollo) {
        desarrollos.add(desarrollo);
    }

    public List<Desarrollar> obtenerDesarrollos() {
        return desarrollos;
    }

    public boolean eliminarDesarrollo(int idPais, int idCodigo) {
        return desarrollos.removeIf(d -> d.getIdPais() == idPais && d.getIdCodigoCivil() == idCodigo);
    }
}
