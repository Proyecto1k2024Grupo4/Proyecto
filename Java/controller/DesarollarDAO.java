package controller;

import db.DBConnection;
import model.Desarrollar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesarrollarDAO {
    private static DesarrollarDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DESARROLLAR";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM DESARROLLAR WHERE idPropuesta = ? AND idLey = ?";

    private DesarrollarDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static DesarrollarDAO getInstance() {
        if (instance == null) {
            instance = new DesarrollarDAO();
        }
        return instance;
    }

    public void insertDesarrollar(Desarrollar desarrollar) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, desarrollar.getIdPropuesta());
            statement.setInt(2, desarrollar.getIdLey());
            statement.executeUpdate();
        }
    }

    public List<Desarrollar> getAllDesarrollar() throws SQLException {
        List<Desarrollar> desarrollarList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                desarrollarList.add(resultSetToDesarrollar(resultSet));
            }
        }
        return desarrollarList;
    }

    private Desarrollar resultSetToDesarrollar(ResultSet resultSet) throws SQLException {
        return new Desarrollar(
                resultSet.getInt("idPropuesta"),
                resultSet.getInt("idLey")
        );
    }
}