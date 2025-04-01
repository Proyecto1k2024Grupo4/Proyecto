package controller;

import db.DBConnection;

import java.sql.Connection;

public class VotarDAO {

    // Instancias estaticas
    private static VotarDAO instance;
    private Connection connection;

    // SENTENCIAS SQL

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
