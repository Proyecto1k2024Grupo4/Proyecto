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

   
    /**
     * Constructor privado que establece la conexión con la base de datos.
     */
    private PaisDAO() {
        this.connection = DBConnection.getConnection();
    }

      /**
     * Devuelve la instancia única de PaisDAO (patrón Singleton).
     * @return instancia única de PaisDAO
     */
    public static PaisDAO getInstance() {
        if (instance == null) {
            instance = new PaisDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo país en la base de datos.
     * @param pais objeto Pais a insertar
     * @throws SQLException si ocurre un error al ejecutar la sentencia SQL
     */
    public void insertPais(Pais pais) throws SQLException {
        try (CallableStatement cs = connection.prepareCall(PROCEDIMIENTO_INSERT)) {
            cs.setString(1, pais.getNombre());
            cs.execute();
        }
    }

     /**
     * Recupera todos los países de la base de datos.
     * @return lista de objetos Pais
     * @throws SQLException si ocurre un error al acceder a la base de datos
     */
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

     /**
     * Recupera un país por su ID.
     * @param id identificador del país
     * @return objeto Pais correspondiente, o null si no se encuentra
     * @throws SQLException si ocurre un error al ejecutar la consulta
     */
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

       /**
     * Actualiza los datos de un país existente en la base de datos.
     * @param pais objeto Pais con los datos actualizados
     * @throws SQLException si ocurre un error al ejecutar la actualización
     */
    public void updatePais(Pais pais) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, pais.getNombre());
            statement.setInt(2, pais.getId());
            statement.executeUpdate();
        }
    }
     /**
         * Elimina un país de la base de datos usando su ID.
         * @param id identificador del país a eliminar
         * @throws SQLException si ocurre un error al ejecutar la eliminación
         */
    public void deletePaisById(int id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
      /**
         * Convierte un ResultSet en un objeto Pais.
         * @param resultSet conjunto de resultados de la consulta
         * @return objeto Pais construido a partir del ResultSet
         * @throws SQLException si ocurre un error al acceder a los datos del ResultSet
         */
    private Pais resultSetToPais(ResultSet resultSet) throws SQLException {
        return new Pais(
                resultSet.getInt("id"),
                resultSet.getString("nombre")
        );
    }
}
