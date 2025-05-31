package db;

import model.Politico;
import model.Sexo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PoliticoDAO que se encarga de la comunicacion con la base de datos cuya funcion es de busqueda, insercion y actualizacion de los politicos en la tabla POLITICOS
 * @author Jonathan Villaba Morán
 * @version 10/4/25
 */

public class PoliticoDAO {

    //Instancia unica
    private static PoliticoDAO instance;
    //Conexion
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO POLITICO (numPasaporte, fechaIniciacion, fechaRetirada, idCongreso)" +
            "VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM POLITICO";
    private static final String SELECT_BY_PASAPORTE_QUERY = "SELECT * FROM PERSONA WHERE numPasaporte = ?";
    private static final String UPDATE_FECHA_QUERY = "UPDATE POLITICO SET fechaRetirada = ? WHERE numPasaporte = ?";
    private static final String DELETE_QUERY = "DELETE FROM POLITICO WHERE numPasaporte = ?";
    private static final String TOTAL_POLITICOS_QUERY = "SELECT COUNT(*) FROM POLITICO";

    /*
    Constructor privado para evitar que se instancie externamente.
    Obtiene la conexion a la base de datos
     */
    private PoliticoDAO() { this.connection = DBConnection.getConnection(); }

    /**
     * Metodo que devuelve la instancia de la clase PoliticoDAO
     * @return instancia unica de PoliticoDAO
     */
    public static synchronized PoliticoDAO getInstance(){
        if (instance == null)
            instance = new PoliticoDAO();
        return instance;
    }

    /**
     * Inserta un politico en la base de datos
     * @param politico objeto de Politico
     * @throws SQLException
     */
    public void insertarPolitico(Politico politico) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, politico.getNumPasaporte());
            statement.setDate(2, politico.getFechaIniciacion());
            statement.setDate(3, politico.getFechaRetirada());
            statement.setInt(4, politico.getIdCongreso());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los politicos dentro de la base de datos
     * @return lista de objetos Politico
     * @throws SQLException
     */
    public List<Politico> getAllPoliticos() throws SQLException {
        List<Politico> politicos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                politicos.add(resultSetToPolitico(resultSet));
        }
        return politicos;
    }

    /**
     * Recupera el politico con el numero de pasaporte que se indique
     * @param numPasaporte
     * @return Objeto de Politico o null
     * @throws SQLException
     */
    public Politico getPoliticoByNumPasaporte (String numPasaporte) throws SQLException {
        Politico politico = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PASAPORTE_QUERY)){
            statement.setString(1, numPasaporte);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                politico = resultSetToPolitico(resultSet);
            return politico;
        }
    }

    /**
     * Actualiza los datos de un politico para ponerle su fecha de retirada buscandolo por su numero de pasaporte
     * @param fecha String con el nuevo valor de la fecha que queremos actualizar
     * @param pasaporte para saber en que politico hacer el update
     * @throws SQLException
     */
    public void updatePolitico (Date fecha, String pasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_FECHA_QUERY)){
            statement.setDate(1, fecha);
            statement.setString(2, pasaporte);
            statement.executeUpdate();
        }
    }

    /**
     * Metodo que borra a un politico a partir de su numero de pasaporte
     * @param numPasaporte
     * @throws SQLException
     */
    public void deletePoliticoByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un objeto Politico en Resultset
     * @param resultSet
     * @return objeto Politico con los datos del Resultset
     * @throws SQLException
     */
    private Politico resultSetToPolitico(ResultSet resultSet) throws SQLException {
        return new Politico(
                resultSet.getString("numPasaporte"),
                resultSet.getString("nombre"),
                resultSet.getString("primerApellido"),
                resultSet.getString("segundoApellido"),
                resultSet.getDate("fnac"),
                Sexo.valueOf(resultSet.getString("sexo")),
                resultSet.getInt("paisNacimiento"),
                resultSet.getDate("fechaIniciacion"),
                resultSet.getDate("fechaRetirada"),
                resultSet.getInt("idCongreso")
        );
    }

    /**
     * Obtiene el total de politicos
     * @return numero con el total de politicos
     * @throws SQLException
     */
    public int totalPoliticos () throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_POLITICOS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                total = resultSet.getInt(1);
        }
        return total;
    }
}
