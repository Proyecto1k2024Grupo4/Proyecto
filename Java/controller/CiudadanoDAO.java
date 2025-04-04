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

    private CiudadanoDAO() { this.connection = DBConnection.getConnection(); }

    public static CiudadanoDAO getInstance(){
        if (instance==null)
            instance = new CiudadanoDAO();
        return instance;
    }

    public void insertarCiudadano(Ciudadano ciudadano) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, ciudadano.getNumPasaporte());
            statement.executeUpdate();
        }
    }

    public List<Ciudadano> getAllCiudadanos() throws SQLException {
        List<Ciudadano> ciudadanos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                ciudadanos.add(resultSetToCiudadano(resultSet));
        }
        return ciudadanos;
    }

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
    public void deleteCiudadanoByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

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
