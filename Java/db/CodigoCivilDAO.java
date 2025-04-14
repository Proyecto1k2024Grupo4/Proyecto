package db;

import model.CodigoCivil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CodigoCivilDAO {
    private static CodigoCivilDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO CODIGO_CIVIL (id, idPais, fechaModificacion) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CODIGO_CIVIL";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CODIGO_CIVIL WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE CODIGO_CIVIL SET idPais = ?, fechaModificacion = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM CODIGO_CIVIL WHERE id = ?";

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
            statement.setInt(1, codigoCivil.getId());
            statement.setInt(2, codigoCivil.getIdPais());
            statement.setString(3, codigoCivil.getFecha());
            statement.executeUpdate();
        }
    }

    public List<CodigoCivil> getAllCodigosCiviles() throws SQLException {
        List<CodigoCivil> codigos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                codigos.add(resultSetToCodigoCivil(rs));
            }
        }
        return codigos;
    }

    public CodigoCivil getCodigoCivilById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return resultSetToCodigoCivil(rs);
            }
            return null;
        }
    }

    public void updateCodigoCivil(CodigoCivil codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, codigo.getIdPais());
            statement.setString(2, codigo.getFecha());
            statement.setInt(3, codigo.getId());
            statement.executeUpdate();
        }
    }

    public void deleteCodigoCivil(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private CodigoCivil resultSetToCodigoCivil(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int idPais = rs.getInt("idPais");
        String fecha = rs.getString("fechaModificacion");
        return new CodigoCivil(id, idPais, fecha);
    }
}
