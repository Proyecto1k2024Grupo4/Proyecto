package controller;

import db.DBConnection;
import model.Ciudadano;
import model.Sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PersonaDAO que se encarga de la comunicacion con la base de datos cuya funcion es de busqueda, insercion y actualizacion de los ciudadanos en la tabla CIUDADANOS
 * @author Jonathan Villaba Morán
 * @version 7/4/25
 */

public class CiudadanoDAO {
    //Instancia unica
    private static CiudadanoDAO instance;
    //Conexion
    private Connection connection;

    //Consultas SQL
    private static final String INSERT_QUERY = "INSERT INTO CIUDADANO (numPasaporte) VALUES (?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CIUDADANO";
    private static final String SELECT_BY_PASAPORTE_QUERY = "SELECT * FROM CIUDADANO WHERE numPasaporte = ?";
    private static final String DELETE_QUERY = "DELETE FROM CIUDADANO WHERE numPasaporte = ?";
    private static final String TOTAL_CIUDADANOS_QUERY = "SELECT COUNT(*) FROM CIUDADANO";

    /*
    Constructor privado para evitar que se instancie externamente.
    Obtiene la conexion a la base de datos
     */
    private CiudadanoDAO() { this.connection = DBConnection.getConnection(); }

    /**
     * Metodo que devuelve la instancia de la clase CiudadanoDAO
     * @return instancia unica de CiudadanoDAO
     */
    public static CiudadanoDAO getInstance(){
        if (instance==null)
            instance = new CiudadanoDAO();
        return instance;
    }

    /**
     * Inserta un ciudadano en la base de datos
     * @param ciudadano objeto de ciudadano
     * @throws SQLException
     */
    public void insertarCiudadano(Ciudadano ciudadano) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, ciudadano.getNumPasaporte());
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todos los ciudadanos dentro de la base de datos
     * @return lista de objetos Ciudadano
     * @throws SQLException
     */
    public List<Ciudadano> getAllCiudadanos() throws SQLException {
        List<Ciudadano> ciudadanos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                ciudadanos.add(resultSetToCiudadano(resultSet));
        }
        return ciudadanos;
    }

    /**
     * Recupera el ciudadano con el numero de pasaporte que se indique
     * @param numPasaporte
     * @return Objeto de Ciudadano o null
     * @throws SQLException
     */
    public Ciudadano getCiudadanoByNumPasaporte (String numPasaporte) throws  SQLException {
        Ciudadano ciudadano = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PASAPORTE_QUERY)) {
            statement.setString(1, numPasaporte);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                ciudadano = resultSetToCiudadano(resultSet);
        }
        return ciudadano;
    }

    /**
     * Convierte un objeto Ciudadano en Resultset
     * @param resultSet
     * @return objeto Ciudadano con los datos del Resultset
     * @throws SQLException
     */
    private Ciudadano resultSetToCiudadano(ResultSet resultSet) throws SQLException {
        return new Ciudadano(
                resultSet.getString("numPasaporte"),
                resultSet.getString("nombre"),
                resultSet.getString("primerApellido"),
                resultSet.getString("segundoApellido"),
                resultSet.getString("fnac"),
                Sexo.valueOf(resultSet.getString("sexo")),
                resultSet.getInt("paisNacimiento")
        );
    }
    /**
     * Metodo que borra a un ciudadano a partir de su numero de pasaporte
     * @param numPasaporte
     * @throws SQLException
     */
    public void deleteCiudadanoByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene el total de ciudadanos
     * @return numero con el total de ciudadanos
     * @throws SQLException
     */
    public int totalCiudadanos() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_CIUDADANOS_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                total = resultSet.getInt(1);
        }
        return total;
    }
}
