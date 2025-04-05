package controller;

import db.DBConnection;

import java.sql.Connection;

/**
 * Clase VotarDAO que se encarga de la comunicacion con la base de datos cuya funcion es de
 * busqueda e insercion de votos de la tabla VOTAR
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 05-04-2025
 */
public class VotarDAO {

    // Instancias estaticas
    private static VotarDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into VOTAR() values ()";
    private static final String SELECT_ALL_QUERY = "select * from VOTAR";
    private static final String SELECT_BY_NUM_PASAPORTE_QUERY = "select * from VOTAR where numPasaporteCiudadano = ?";
    private static final String SELECT_BY_NUM_PASAPORTE_AND_ID_PROPUESTA_QUERY = "select * from VOTAR where numPasaporteCiudadano = ? and idPropuesta = ?";
    private static final String SELECT_BY_ID_PROPUESTA_QUERY = "select * from VOTAR where idPropuesta = ?";


    // Constructor privado
    private VotarDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estatico para obtener la unica instancia de VotarDAO
     * @return instancia de VotarDAO
     */
    public static VotarDAO getInstance(){
        if (instance == null) {
            instance = new VotarDAO();
        }
        return instance;
    }

}
