package db;

import model.Congreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Clase CongresoDAO que proporciona acceso a la base de datos para la entidad Congreso.
 */
public class CongresoDAO {
//    private static CongresoDAO instance;
//    private Connection connection;
//
//    private static final String INSERT_QUERY = "INSERT INTO CONGRESO (numPoliticos, propAprobadas) VALUES (?, ?)";
//    private static final String SELECT_ALL_QUERY = "SELECT * FROM CONGRESO";
//    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CONGRESO WHERE id = ?";
//
//    /**
//     * Constructor privado para implementar el patrón Singleton.
//     */
//    private CongresoDAO() {
//        this.connection = DBConnection.getConnection();
//    }
//    /**
//     * Obtiene la instancia única de CongresoDAO.
//     * @return instancia de CongresoDAO
//     */
//
//    public static CongresoDAO getInstance() {
//        if (instance == null) {
//            instance = new CongresoDAO();
//        }
//        return instance;
//    }
//    /**
//     * Inserta un nuevo congreso en la base de datos.
//     * @param congreso El objeto Congreso que se va a insertar
//     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
//     */
//    public void insertCongreso(Congreso congreso) throws SQLException {
//        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
//            statement.setInt(1, congreso.getId());
//            statement.executeUpdate();
//        }
//    }
//    /**
//     * Recupera todos los congresos de la base de datos.
//     * @return Lista de objetos Congreso
//     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
//     */
//    public List<Congreso> getAllCongresos() throws SQLException {
//        List<Congreso> congresos = new ArrayList<>();
//        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
//            ResultSet resultSet = statement.executeQuery();
//            while (resultSet.next()) {
//                congresos.add(resultSetToCongreso(resultSet));
//            }
//        }
//        return congresos;
//    }
//    /**
//     * Convierte un ResultSet en un objeto Congreso.
//     * @param resultSet El ResultSet que contiene los datos de un congreso
//     * @return Objeto Congreso con los datos obtenidos del ResultSet
//     * @throws SQLException Si ocurre un error al procesar el ResultSet
//     */
//    private Congreso resultSetToCongreso(ResultSet resultSet) throws SQLException {
//        return new Congreso(
//                resultSet.getInt("id"),
//                resultSet.getString("nombre"));
//    }
}