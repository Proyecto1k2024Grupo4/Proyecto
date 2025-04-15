package db;

import model.CodigoCivil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Clase CodigoCivilDAO que proporciona acceso a la base de datos
 * para la entidad CodigoCivil utilizando el patrón Singleton.
 */
public class CodigoCivilDAO {
    private static CodigoCivilDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO CODIGO_CIVIL (id, idPais, fechaModificacion) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CODIGO_CIVIL";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CODIGO_CIVIL WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE CODIGO_CIVIL SET idPais = ?, fechaModificacion = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM CODIGO_CIVIL WHERE id = ?";

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private CodigoCivilDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la instancia única de CodigoCivilDAO.
     * @return instancia de CodigoCivilDAO
     */
    public static CodigoCivilDAO getInstance() {
        if (instance == null) {
            instance = new CodigoCivilDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo registro de Código Civil en la base de datos.
     * @param codigoCivil Objeto CodigoCivil a insertar
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
    public void insertCodigoCivil(CodigoCivil codigoCivil) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, codigoCivil.getId());
            statement.setInt(2, codigoCivil.getIdPais());
            statement.setString(3, codigoCivil.getFecha());
            statement.executeUpdate();
        }
    }
    /**
     * Recupera todos los registros de Código Civil de la base de datos.
     * @return Lista de objetos CodigoCivil
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
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
    /**
     * Recupera un registro de Código Civil por su ID.
     * @param id Identificador del Código Civil
     * @return Objeto CodigoCivil si se encuentra, null en caso contrario
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
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
    /**
     * Actualiza un registro de Código Civil existente en la base de datos.
     * @param codigo Objeto CodigoCivil con los datos actualizados
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
    public void updateCodigoCivil(CodigoCivil codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, codigo.getIdPais());
            statement.setString(2, codigo.getFecha());
            statement.setInt(3, codigo.getId());
            statement.executeUpdate();
        }
    }
    /**
     * Elimina un registro de Código Civil por su ID.
     * @param id Identificador del Código Civil a eliminar
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
    public void deleteCodigoCivil(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    /**
     * Convierte un ResultSet en un objeto CodigoCivil.
     * @param rs El ResultSet que contiene los datos de un Código Civil
     * @return Objeto CodigoCivil con los datos obtenidos del ResultSet
     * @throws SQLException Si ocurre un error al procesar el ResultSet
     */
    private CodigoCivil resultSetToCodigoCivil(ResultSet rs) throws SQLException {
        Date id = rs.getInt("id");
        int idPais = rs.getInt("idPais");
        String fecha = rs.getString("fechaModificacion");
        return new CodigoCivil(id, idPais, fecha);
    }
}
