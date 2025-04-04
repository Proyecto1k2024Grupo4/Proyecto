package controller;

import db.DBConnection;
import model.Persona;
import model.Sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    //Instancia unica
    private static PersonaDAO instance;
    //Conexion
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento)" +
            "VALUES (?, ?, ?, ?, ?,? ,?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM PERSONA";
    private static final String SELECT_BY_PASAPORTE_QUERY = "SELECT * FROM PERSONA WHERE numPasaporte = ?";
    private static final String UPDATE_QUERY = "UPDATE PERSONA SET nombre = ?, primerApellido = ?, segundoApellido = ?, fnac = ?, sexo = ?, paisNacimiento = ?" +
            "WHERE numPasaporte = ?";
    private static final String DELETE_QUERY = "DELETE FROM PERSONA WHERE numPasaporte = ?";
    private static final String TOTAL_PERSONAS_QUERY = "SELECT COUNT(*) FROM PERSONA";

    /*
    Constructor privado para evitar que se instancie externamente.
    Obtiene la conexion a la base de datos
     */

    private PersonaDAO(){
        this.connection = DBConnection.getConnection();
    }

    public static synchronized PersonaDAO getInstance(){
        if (instance == null)
            instance = new PersonaDAO();
        return instance;
    }

    public void insertarPersona(Persona persona) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, persona.getNumPasaporte());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getPrimerApellido());
            statement.setString(4, persona.getSegundoApellido());
            statement.setString(5, persona.getFnac());
            statement.setString(6, String.valueOf(persona.getSexo()));
            statement.setString(7, String.valueOf(persona.getPaisNacimiento()));
            statement.executeUpdate();
        }
    }
    public List<Persona> getAllPersonas() throws SQLException {
        List<Persona> personas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personas.add(resultSetToPersona(resultSet));
            }
        }
        return personas;
    }

    public Persona getPersonaByNumPasaporte (String numPasaporte) throws SQLException {
        Persona persona = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PASAPORTE_QUERY)) {
            statement.setString(1, numPasaporte);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona = resultSetToPersona(resultSet);
            }
        }
        return persona;
    }

    public void updatePersona (Persona persona) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, persona.getNumPasaporte());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getPrimerApellido());
            statement.setString(4, persona.getSegundoApellido());
            statement.setString(5, persona.getFnac());
            statement.setString(6, String.valueOf(persona.getSexo()));
            statement.setString(7, String.valueOf(persona.getPaisNacimiento()));
            statement.executeUpdate();
        }
    }

    public void deletePersonaByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

    private Persona resultSetToPersona(ResultSet resultSet) throws SQLException {
        return new Persona(
                resultSet.getString("numPasaporte"),
                resultSet.getString("nombre"),
                resultSet.getString("primerApellido"),
                resultSet.getString("segundoApellido"),
                resultSet.getString("fnac"),
                Sexo.valueOf(resultSet.getString("sexo")),
                resultSet.getInt("paisNacimiento")
        );
    }

    public int totalPersonas () throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PERSONAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                total = resultSet.getInt(1);
        }
        return total;
    }
}
