package db;

import db.DBConnection;
import model.Pais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PaisDAO que proporciona acceso a la base de datos para la entidad Pais.
 */
public class PaisDAO {
    private static PaisDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO PAIS (nombre, numCiudadanos, numPoliticos) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PAIS";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM PAIS WHERE nombre = ?";

    /**
     * Constructor privado para implementar el patrón Singleton.
     */
    private PaisDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Obtiene la instancia única de PaisDAO.
     * @return instancia de PaisDAO
     */
    public static PaisDAO getInstance() {
        if (instance == null) {
            instance = new PaisDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo país en la base de datos.
     * @param pais El objeto Pais que se va a insertar
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
     */
    public void insertPais(Pais pais) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, pais.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los países de la base de datos.
     * @return Lista de objetos Pais
     * @throws SQLException Si ocurre un error al ejecutar la consulta SQL
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
     * Convierte un ResultSet en un objeto Pais.
     * @param resultSet El ResultSet que contiene los datos de un país
     * @return Objeto Pais con los datos obtenidos del ResultSet
     * @throws SQLException Si ocurre un error al procesar el ResultSet
     */
    private Pais resultSetToPais(ResultSet resultSet) throws SQLException {
        return new Pais(
                resultSet.getString("nombre")
        );
    }
}