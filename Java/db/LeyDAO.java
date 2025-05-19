package db;

import model.Ley;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase LeyDAO que se encarga de la comunicacion con la base de datos cuya funcion es de
 * busqueda, insercion, elmiminacion, y actualizacion de leyes de la tabla LEY
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 05-04-2025
 */
public class LeyDAO {

    // Instancias estaticas
    private static LeyDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY =
            "INSERT INTO LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) VALUES (?,?,?,?,?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM LEY";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM LEY WHERE id = ?";
    private static final String SELECT_BY_CODIGO_CIVIL_QUERY = "SELECT * FROM LEY WHERE idCodigoCivil = ?";
    private static final String UPDATE_QUERY =
            "UPDATE LEY SET descripcion = ?, fechaAplicacion = ?, fechaModificacion = ?, fechaImplementacion = ?, idCodigoCivil = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM LEY WHERE id = ?";

    private LeyDAO() {
        connection = DBConnection.getConnection();
    }

    public static LeyDAO getInstance() {
        if (instance == null) instance = new LeyDAO();
        return instance;
    }

    public void insertLey(Ley ley) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(INSERT_QUERY)) {
            st.setString(1, ley.getDescripcion());
            st.setDate(2, ley.getFechaAplicacion());
            st.setDate(3, ley.getFechaModificacion());
            st.setDate(4, ley.getFechaImplementacion());
            st.setInt(5, ley.getIdCodigoCivil());
            st.executeUpdate();
        }
    }

    public List<Ley> getAllLey() throws SQLException {
        List<Ley> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(SELECT_ALL_QUERY);
             ResultSet rs = st.executeQuery()) {
            while (rs.next()) list.add(resultSetToLey(rs));
        }
        return list;
    }

    public Ley getByIdLey(int id) throws SQLException {
        Ley ley = null;
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
            st.setInt(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) ley = resultSetToLey(rs);
            }
        }
        return ley;
    }

    public List<Ley> getByCodigoCivil(int idCodigoCivil) throws SQLException {
        List<Ley> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_CODIGO_CIVIL_QUERY)) {
            st.setInt(1, idCodigoCivil);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) list.add(resultSetToLey(rs));
            }
        }
        return list;
    }

    public void updateLeyById(Ley ley) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(UPDATE_QUERY)) {
            st.setString(1, ley.getDescripcion());
            st.setDate(2, ley.getFechaAplicacion());
            st.setDate(3, ley.getFechaModificacion());
            st.setDate(4, ley.getFechaImplementacion());
            st.setInt(5, ley.getIdCodigoCivil());
            st.setInt(6, ley.getId());
            st.executeUpdate();
        }
    }

    public void deleteLeyById(int id) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setInt(1, id);
            st.executeUpdate();
        }
    }

    private Ley resultSetToLey(ResultSet rs) throws SQLException {
        return new Ley(
                rs.getInt("id"),
                rs.getString("descripcion"),
                rs.getDate("fechaAplicacion"),
                rs.getDate("fechaModificacion"),
                rs.getDate("fechaImplementacion"),
                rs.getInt("idCodigoCivil")
        );
    }
}
