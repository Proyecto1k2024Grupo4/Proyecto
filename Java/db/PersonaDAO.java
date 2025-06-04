package db;

import model.Persona;
import model.Sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PersonaDAO que se encarga de la comunicacion con la base de datos cuya funcion es de busqueda, insercion y actualizacion de las personas en la tabla PERSONAS
 * @author Jonathan Villaba Morán
 * @version 7/4/25
 */

public class PersonaDAO {

    //Instancia unica
    private static PersonaDAO instance;
    //Conexion
    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO PERSONA (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento)" +
            "VALUES (?, ?, ?, ?, ?, ?,?)";
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

    /**
     * Metodo que devuelve la instancia de la clase PersonaDAO
     * @return instancia unica de PersonaDAO
     */
    public static synchronized PersonaDAO getInstance(){
        if (instance == null)
            instance = new PersonaDAO();
        return instance;
   }

    /**
     * Inserta una persona en la base de datos
     * @param persona objeto de Persona
     * @throws SQLException
     */
    public void insertarPersona(Persona persona) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, persona.getNumPasaporte());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getPrimerApellido());
            statement.setString(4, persona.getSegundoApellido());
            statement.setDate(5, persona.getFnac());
            statement.setString(6, String.valueOf(persona.getSexo()));
            statement.setString(7, String.valueOf(persona.getPaisNacimiento()));
            statement.executeUpdate();
        }
    }

    /**
     * Recupera todas las personas dentro de la base de datos
     * @return lista de objetos Persona
     * @throws SQLException
     */
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


    /**
     * Recupera la persona con el numero de pasaporte que se indique
     * @param numPasaporte
     * @return Objeto de Ciudadano o null
     * @throws SQLException
     */
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

    /**
     * Actualiza los datos de una persona existente buscandolo por su numero de pasaporte
     * @param persona Objeto persona con los datos actualizados
     * @param pasaporte para saber en que persona hacer el update
     * @throws SQLException
     */
    public void updatePersona (Persona persona, String pasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getPrimerApellido());
            statement.setString(3, persona.getSegundoApellido());
            statement.setDate(4, persona.getFnac());
            statement.setString(5, String.valueOf(persona.getSexo()));
            statement.setString(6, String.valueOf(persona.getPaisNacimiento()));
            statement.setString(7, pasaporte);
            statement.executeUpdate();
        }
    }

    /**
     * Metodo que borra a una persona a partir de su numero de pasaporte
     * @param numPasaporte
     * @throws SQLException
     */
    public void deletePersonaByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un objeto Persona en Resultset
     * @param resultSet
     * @return objeto Persona con los datos del Resultset
     * @throws SQLException
     */
    private Persona resultSetToPersona(ResultSet resultSet) throws SQLException {
        return new Persona(
                resultSet.getString("numPasaporte"),
                resultSet.getString("nombre"),
                resultSet.getString("primerApellido"),
                resultSet.getString("segundoApellido"),
                resultSet.getDate("fnac"),
                Sexo.valueOf(resultSet.getString("sexo")),
                resultSet.getInt("paisNacimiento")
        );
    }

    /**
     * Obtiene el total de personas
     * @return numero con el total de personas
     * @throws SQLException
     */
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
