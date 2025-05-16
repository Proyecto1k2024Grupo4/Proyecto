package controller;

import db.PropuestaDAO;
import model.Propuesta;
import view.VistaPropuesta;

import java.util.List;

/**
 * Clase ControllerPropuesta que se encarga de gestionar la vista y la clase DAO de Propuesta
 * @autor Diego Fernando Valencia Correa 1ºK
 * @version 14-04-2025
 */
public class ControllerPropuesta {

    private PropuestaDAO propuestaDAO;
    private VistaPropuesta vistaPropuesta;

    /**
     * Constructor sin parametros que recibe la instancia de PropuestaDAO e inicializa la VistaPropuesta
     */
    public ControllerPropuesta(){
        this.propuestaDAO = PropuestaDAO.getInstance();
        this.vistaPropuesta = new VistaPropuesta();
    }

    /**
     * Metodo que pide todas las propuestas a PropuestaDAO y las muestra mediante el metodo mostrarPropuestas
     * de la clase VistaPropuesta
     */
    public void mostrarTodasLasPropuestas(){
        try {
            List<Propuesta> propuestas = propuestaDAO.getAllPropuesta();
            vistaPropuesta.mostrarPropuestas(propuestas);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Metodo que muestra una propuesta segun el id que se desee
     */
    public void mostrarPropuestaPorId(){
        try {
            System.out.println("--- Mostrar Propuesta por ID ---");
            int id = vistaPropuesta.pedirId();
            Propuesta propuesta = propuestaDAO.getPropuestaById(id);
            vistaPropuesta.mostrarPropuesta(propuesta);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    /**
     * Metodo que muestra una propuesta segun el id del congreso que se desee
     */
    public void mostrarPropuestaPorIdCongreso(){
        try {
            System.out.println("--- Mostrar Propuesta por ID de Congreso ---");
            int id = vistaPropuesta.pedirId();
            Propuesta propuesta = propuestaDAO.getPropuestaByIdCongreso(id);
            vistaPropuesta.mostrarPropuesta(propuesta);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    /**
     * Metodo que pide instroduce una propuesta en la base de datos con la PropuestaDAO pidendole los datos mediante la vista
     */
    public void insertarPropuesta(){
        try {
            System.out.println("--- Insertar Propuesta ---");
            Propuesta propuesta = vistaPropuesta.crearPropuesta(false);
            propuestaDAO.insertPropuesta(propuesta);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }

    /**
     * Metodo que pide instroduce una propuesta en la base de datos con la PropuestaDAO pidendole los datos mediante la vista
     */
    public void actualizarPropuesta(){
        try {
            System.out.println("--- Actualizar Propuesta ---");
            Propuesta propuesta = vistaPropuesta.crearPropuesta(true);
            propuestaDAO.updatePropuestaByPropuesta(propuesta);
        } catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }


}
