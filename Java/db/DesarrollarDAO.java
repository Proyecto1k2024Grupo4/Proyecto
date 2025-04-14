package db;

import model.Desarrollar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  @author ABDELMOGHIT SAMINI 1KDAM
 * Clase DesarrollarDAO que proporciona acceso a la base de datos para la entidad Desarrollar.
 */
public class DesarrollarDAO {

    private static DesarrollarDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM DESARROLLAR";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM DESARROLLAR WHERE idPropuesta = ? AND idLey = ?";

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private DesarrollarDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la instancia única de DesarrollarDAO.
     * @return instancia de DesarrollarDAO
     */
    public static DesarrollarDAO getInstance() {
        if (instance == null) {
            instance = new DesarrollarDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo desarrollo en la base de datos.
     * @param desarrollar El objeto Desarrollar que se va a insertar
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
    public void insertDesarrollar(Desarrollar desarrollar) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, desarrollar.getIdPropuesta());
            statement.setInt(2, desarrollar.getIdLey());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los desarrollos de la base de datos.
     * @return Lista de objetos Desarrollar
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
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

    /**
     * Convierte un ResultSet en un objeto Desarrollar.
     * @param resultSet El ResultSet que contiene los datos de un desarrollo
     * @return Objeto Desarrollar con los datos obtenidos del ResultSet
     * @throws SQLException Si ocurre un error al procesar el ResultSetl
     */
    private Desarrollar resultSetToDesarrollar(ResultSet resultSet) throws SQLException {
        return new Desarrollar(
                resultSet.getInt("idPropuesta"),
                resultSet.getInt("idLey"),
                resultSet.getInt("anio"));
    }
}