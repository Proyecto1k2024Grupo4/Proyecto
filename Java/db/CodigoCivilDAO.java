package db;

import model.CodigoCivil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CodigoCivilDAO que proporciona acceso a la base de datos para la entidad CodigoCivil.
 */
public class CodigoCivilDAO {
//    private static CodigoCivilDAO instance;
//    private Connection connection;
//
//    private static final String INSERT_QUERY = "INSERT INTO CODIGO_CIVIL (numLeyes, fechaModificacion) VALUES (?, ?)";
//    private static final String SELECT_ALL_QUERY = "SELECT * FROM CODIGO_CIVIL";
//    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CODIGO_CIVIL WHERE id = ?";
//
//    /**
//     * Constructor privado para implementar el patrón Singleton.
//     */
//    private CodigoCivilDAO() {
//        this.connection = DBConnection.getConnection();
//    }
//
//    /**
//     * Obtiene la instancia única de CodigoCivilDAO.
//     * @return instancia de CodigoCivilDAO
//     */
//    public static CodigoCivilDAO getInstance() {
//        if (instance == null) {
//            instance = new CodigoCivilDAO();
//        }
//        return instance;
//    }
//    /**
//     * Inserta un nuevo código civil en la base de datos.
//     * @param codigoCivil El objeto CodigoCivil que se va a insertar
//     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
//     */
//    public void insertCodigoCivil(CodigoCivil codigoCivil) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
//            statement.setInt(1, codigoCivil.getId());
//            statement.executeUpdate();
//        }
//    }
//    /**
//     * Recupera todos los códigos civiles de la base de datos.
//     * @return Lista de objetos CodigoCivil
//     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
//     */
//    public List<CodigoCivil> getAllCodigosCiviles() throws SQLException {
//        List<CodigoCivil> codigos = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                codigos.add(resultSetToCodigoCivil(resultSet));
//            }
//        }
//        return codigos;
//    }
//
//    /**
//     * Convierte un ResultSet en un objeto CodigoCivil.
//     * @param resultSet El ResultSet que contiene los datos de un código civil
//     * @return Objeto CodigoCivil con los datos obtenidos del ResultSet
//     * @throws SQLException Si ocurre un error al procesar el ResultSet
//     */
//    private CodigoCivil resultSetToCodigoCivil(ResultSet resultSet) throws SQLException {
//        return new CodigoCivil(
//                id, resultSet.getInt("id"),
//                fecha);
//    }
}
