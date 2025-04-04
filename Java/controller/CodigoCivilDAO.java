package controller;

import db.DBConnection;
import model.CodigoCivil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CodigoCivilDAO {
    private static CodigoCivilDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO CODIGO_CIVIL (numLeyes, fechaModificacion) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CODIGO_CIVIL";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CODIGO_CIVIL WHERE id = ?";

    private CodigoCivilDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static CodigoCivilDAO getInstance() {
        if (instance == null) {
            instance = new CodigoCivilDAO();
        }
        return instance;
    }

    public void insertCodigoCivil(CodigoCivil codigoCivil) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, codigoCivil.getNumLeyes());
            statement.setDate(2, codigoCivil.getFechaModificacion());
            statement.executeUpdate();
        }
    }

    public List<CodigoCivil> getAllCodigosCiviles() throws SQLException {
        List<CodigoCivil> codigos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                codigos.add(resultSetToCodigoCivil(resultSet));
            }
        }
        return codigos;
    }

    private CodigoCivil resultSetToCodigoCivil(ResultSet resultSet) throws SQLException {
        return new CodigoCivil(
                resultSet.getInt("id"),
                resultSet.getInt("numLeyes"),
                resultSet.getDate("fechaModificacion")
        );
    }
}
