package controller;

import db.LeyDAO;
import model.Ley;
import view.VistaLey;

import java.sql.SQLException;
import java.util.List;

/**
 * Clase ControllerLey que maneja la clase LeyDAO y muestra la información mediante la vista de Ley
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class ControllerLey {

    private LeyDAO leyDAO;
    private VistaLey vistaLey;

    /**
     * Constructor que obtiene la instancia de LeyDAO e inicializa la VistaLey
     */
    public ControllerLey(){
        this.leyDAO = LeyDAO.getInstance();
        vistaLey = new VistaLey();
    }

    /**
        Obtiene todas las leyes de la base de datos y las muestra al usuario.
     */
    public void mostrarTodasLasLeyes(){
        try {
            List<Ley> leyes = leyDAO.getAllLey();
            vistaLey.mostrarLeyes(leyes);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que inserta una ley en la base de datos
     */
    public void insertarLey(){
        try {
            Ley ley = vistaLey.crearLey(false);
            leyDAO.insertLey(ley);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que muestra una ley con el Id que el usuario introduzca
     */
    public void mostrarLeyPorId(){
        try {
            int id = vistaLey.pedirId();
            Ley ley = leyDAO.getByIdLey(id);
            vistaLey.mostrarLey(ley);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que pide los datos de una ley al usuario y
     */
    public void actualizarLey(){
        try {
            Ley ley = vistaLey.crearLey(true);
            leyDAO.updateLeyById(ley);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Metodo que pide un Id y borra la ley con ese Id de la base de datos
     */
    public void borrarLey(){
        try {
            int id = vistaLey.pedirId();
            leyDAO.deleteLeyById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Pide al usuario el ID de Código Civil y muestra todas las leyes de ese código, junto al país.
     */
    public void mostrarLeyesPorCodigoCivil() {
        int idCc = vistaLey.pedirIdCodigoCivil();
        try {
            List<Ley> lista = leyDAO.getLeyesPorCodigoCivil(idCc);
            vistaLey.mostrarLeyes(lista, "Código Civil", idCc);
        } catch (SQLException e) {
            System.out.println("ERROR al obtener leyes por Código Civil: " + e.getMessage());
        }
    }

    /**
     * Pide al usuario el ID de País y muestra todas las leyes de ese país (a través de Código Civil).
     */
    public void mostrarLeyesPorPais() {
        int idPais = vistaLey.pedirIdPais();
        try {
            List<Ley> lista = leyDAO.getLeyesPorPais(idPais);
            vistaLey.mostrarLeyes(lista, "País", idPais);
        } catch (SQLException e) {
            System.out.println("ERROR al obtener leyes por País: " + e.getMessage());
        }
    }
}
