package db;

import model.Pais;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *   @author ABDELMOGHIT SAMINI 1KDAM
 * Clase PaisDAO que proporciona acceso a la base de datos para la entidad Pais.
 */
public class PaisDAO {
    private static PaisDAO instance;
    private Connection connection;

    public static final String PROCEDIMIENTO_INSERT = "{ CALL insertar_pais(?) }";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PAIS";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM PAIS WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE PAIS SET nombre = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM PAIS WHERE id = ?";

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
        try (CallableStatement cs = connection.prepareCall(PROCEDIMIENTO_INSERT)) {
            cs.setString(1, pais.getNombre());
            cs.execute();
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

    public Pais getPaisById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSetToPais(resultSet);
            }
        }
        return null;
    }

    public void updatePais(Pais pais) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, pais.getNombre());
            statement.setInt(2, pais.getId());
            statement.executeUpdate();
        }
    }

    public void deletePaisById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    private Pais resultSetToPais(ResultSet resultSet) throws SQLException {
        return new Pais(
                resultSet.getInt("id"),
                resultSet.getString("nombre")
        );
    }
}
