package controller;

import db.DBConnection;
import model.Politico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoliticoDAO {


    private static PoliticoDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO POLITICO (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento, fechaIniciacion, fechaRetirada, idCongreso)" +
            "VALUES (?, ?, ?, ?, ?,? ,?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM POLITICO";
    private static final String SELECT_BY_PASAPORTE_QUERY = "SELECT * FROM PERSONA WHERE numPasaporte = ?";
    private static final String UPDATE_FECHA_QUERY = "UPDATE POLITICO SET fechaRetirada = ? WHERE numPasaporte = ?";
    private static final String DELETE_QUERY = "DELETE FROM POLITICO WHERE numPasaporte = ?";
    private static final String TOTAL_POLITICOS_QUERY = "SELECT COUNT(*) FROM POLITICO";

    //Constructor privado con la conexion

    private PoliticoDAO() { this.connection = DBConnection.getConnection(); }


    public static synchronized PoliticoDAO getInstance(){
        if (instance == null)
            instance = new PoliticoDAO();
        return instance;
    }

    public void insertarPolitico(Politico politico) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, politico.getNumPasaporte());
            statement.setString(2, politico.getNombre());
            statement.setString(3, politico.getPrimerApellido());
            statement.setString(4, politico.getSegundoApellido());
            statement.setString(5, politico.getFnac());
            statement.setString(6, String.valueOf(politico.getSexo()));
            statement.setString(7, String.valueOf(politico.getPaisNacimiento()));
            statement.setString(8, politico.getFechaIniciacion());
            statement.setString(9, politico.getFechaRetirada());
            statement.setInt(10, politico.getIdCongreso());
            statement.executeUpdate();
        }
    }
}
