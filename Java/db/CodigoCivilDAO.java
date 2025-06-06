package db;

import model.CodigoCivil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
    * @author ABDELMOGHIT SAMINI 1KDAM
    * Proporciona métodos para realizar operaciones CRUD sobre la tabla
    * CODIGO_CIVIL en la base de datos, incluyendo inserción, consulta,
    * actualización y eliminación de registros.
 */
public class CodigoCivilDAO {
    private static CodigoCivilDAO instance;
    private Connection connection;

    // Sentencia SQ
    private static final String INSERT_QUERY = "INSERT INTO CODIGO_CIVIL (idPais, fechaModificacion) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CODIGO_CIVIL";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CODIGO_CIVIL WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE CODIGO_CIVIL SET idPais = ?, fechaModificacion = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM CODIGO_CIVIL WHERE id = ?";

    /**
     Constructor privado que establece la conexión a la base de datos.
     */
    private CodigoCivilDAO() {
        this.connection = DBConnection.getConnection();
    }
    /**
     Devuelve la instancia única de {@code CodigoCivilDAO}.
     @return instancia singleton de este DAO
     */
    public static CodigoCivilDAO getInstance() {
        if (instance == null) {
            instance = new CodigoCivilDAO();
        }
        return instance;
    }
    /**
     Inserta un nuevo CódigoCivil en la base de datos.
     @param codigoCivil objeto con los datos a persistir
     @throws SQLException si ocurre un error en la operación SQL
     */
    public void insertCodigoCivil(CodigoCivil codigoCivil) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, codigoCivil.getIdPais());
            statement.setDate(2, codigoCivil.getFecha());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                codigoCivil.setId(rs.getInt(1));
            }
        }
    }
    /**
     Recupera todos los códigos civiles de la base de datos.
     @return lista de objetos {@code CodigoCivil}
     @throws SQLException si ocurre un error en la consulta
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
     Obtiene un código civil por su ID.
     @param id identificador del código civil
     @return objeto {@code CodigoCivil} o {@code null} si no existe
     @throws SQLException si ocurre un error en la consulta
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
     Actualiza un código civil existente.
     @param codigo objeto con los datos actualizados (incluye ID)
     @throws SQLException si ocurre un error en la actualización
     */
    public void updateCodigoCivil(CodigoCivil codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, codigo.getIdPais());
            statement.setDate(2, codigo.getFecha());
            statement.setInt(3, codigo.getId());
            statement.executeUpdate();
        }
    }
    /**
         Elimina un código civil por su ID.
         @param id identificador del código civil a eliminar
         @throws SQLException si ocurre un error en la eliminación
     */
    public void deleteCodigoCivil(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
    /**
         Convierte la fila actual de un ResultSet en un objeto {@code CodigoCivil}.
         @param rs ResultSet posicionado en una fila válida
         @return objeto construido con los datos de la fila
         @throws SQLException si no se puede leer algún campo
     */
    private CodigoCivil resultSetToCodigoCivil(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        int idPais = rs.getInt("idPais");
        Date fecha = rs.getDate("fechaModificacion");
        return new CodigoCivil(id, idPais, fecha);
    }
}
