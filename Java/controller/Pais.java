package controller;

import db.DBConnection;
import model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaisDAO {
    private static PaisDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO PAIS (nombre, numCiudadanos, numPoliticos) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PAIS";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM PAIS WHERE nombre = ?";

    private PaisDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static PaisDAO getInstance() {
        if (instance == null) {
            instance = new PaisDAO();
        }
        return instance;
    }

    public void insertPais(Pais pais) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, pais.getNombre());
            statement.setInt(2, pais.getNumCiudadanos());
            statement.setInt(3, pais.getNumPoliticos());
            statement.executeUpdate();
        }
    }

    public List<Pais> getAllPaises() throws SQLException {
        List<Pais> paises = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                paises.add(resultSetToPais(resultSet));
            }
        }
        return paises;
    }

    private Pais resultSetToPais(ResultSet resultSet) throws SQLException {
        return new Pais(
                resultSet.getString("nombre"),
                resultSet.getInt("numCiudadanos"),
                resultSet.getInt("numPoliticos")
        );
    }
}