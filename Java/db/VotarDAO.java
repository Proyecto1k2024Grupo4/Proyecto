package db;

import model.Votar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase VotarDAO que se encarga de la comunicacion con la base de datos cuya funcion es de
 * busqueda e insercion de votos de la tabla VOTAR
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 05-04-2025
 */
public class VotarDAO {

    // Instancias estaticas
    private static VotarDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into VOTAR(numPasaporteCiudadano, idPropuesta, decision) values (?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from VOTAR";
    private static final String SELECT_BY_NUM_PASAPORTE_QUERY = "select * from VOTAR where numPasaporteCiudadano = ?";
    private static final String SELECT_BY_NUM_PASAPORTE_AND_ID_PROPUESTA_QUERY = "select * from VOTAR where numPasaporteCiudadano = ? and idPropuesta = ?";
    private static final String SELECT_BY_ID_PROPUESTA_QUERY = "select * from VOTAR where idPropuesta = ?";


    // Constructor privado
    private VotarDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estatico para obtener la unica instancia de VotarDAO
     * @return instancia de VotarDAO
     */
    public static VotarDAO getInstance(){
        if (instance == null) {
            instance = new VotarDAO();
        }
        return instance;
    }

    /**
     * Metodo que devuelve un List con todos los votos de una propuesta identificada por el id introducido como parametro
     * @param idPropuesta Id de la porpuesta de la que queremos obtener sus votos
     * @return List con instancias de la clase Votar con los votos de la propuesta
     * @throws SQLException Excepcion SQL
     */
    public List<Votar> getVotosByIdPropuesta(int idPropuesta) throws SQLException{
        List<Votar> votos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_PROPUESTA_QUERY)){
            statement.setInt(1, idPropuesta);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                votos.add(resultSetToVotar(resultSet));
            }
        }
        return votos;
    }

    /**
     * Metodo que devuelve el voto de un ciudadano identificado por el numero de pasaporte introducido a una propuesta
     * identificada por el id proporcionado.
     * @param numPasaporteCiudadano Numero de pasaporte del ciudadano del que queremos ver su voto
     * @param idPropuesta Id de la propuesta de la que queremos saber el voto del ciudadano
     * @return Instancia Votar con el voto del ciudadano
     * @throws SQLException Excepcion SQL
     */
    public Votar getVotosByNumPasaporteAndIdPropuesta(String numPasaporteCiudadano, int idPropuesta) throws SQLException{
        Votar voto = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_PASAPORTE_AND_ID_PROPUESTA_QUERY)){
            statement.setString(1, numPasaporteCiudadano);
            statement.setInt(2, idPropuesta);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                voto = resultSetToVotar(resultSet);
            }
        }
        return voto;
    }

    /**
     * Metodo que devuelve un List con todos los votos a propuestas del ciudadano con el paporte introducido como parametro
     * @param numPasaporteCiudadano Numero de pasarporte del ciudadano del que queremos obtener sus votos
     * @return List con instancias de la clase Votar con todos los votos del ciudadano
     * @throws SQLException Excepcion SQL
     */
    public List<Votar> getVotosByNumPasaporte(String numPasaporteCiudadano) throws SQLException{
        List<Votar> votos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NUM_PASAPORTE_QUERY)){
            statement.setString(1, numPasaporteCiudadano);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                votos.add(resultSetToVotar(resultSet));
            }
        }
        return votos;
    }

    /**
     * Metodo que devuelve un List con todos los votos de las propuestas
     * @return List con instancias de la clase Votar con todos los votos a propuestas
     * @throws SQLException Excepcion SQL
     */
    public List<Votar> getAllVotar() throws SQLException{
        List<Votar> votos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                votos.add(resultSetToVotar(resultSet));
            }
        }
        return votos;
    }

    /**
     * Metodo que inserta una votacion a traves de una instancia de Votar
     * @param votar Instancia de la clase Votar que se desea insertar
     * @throws SQLException Excepion SQL
     */
    public void insertVotar(Votar votar) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, votar.getNumPasaporteCiudadano());
            statement.setInt(2, votar.getIdPropuesta());
            statement.setBoolean(3, votar.getDecision());
            statement.executeQuery();
        }
    }

    /**
     * Metodo que recibe un ResultSet y lo transforma en una instancia de Votar que luego devuelve
     * @param resultSet ResultSet que queremos transformar
     * @return Instancia de la clase Votar que hemos tranformado del ResultSet
     * @throws SQLException Excepcion SQL
     */
    public Votar resultSetToVotar(ResultSet resultSet) throws SQLException{
        Votar voto = new Votar(
                resultSet.getString("numPasaporteCiudadano"),
                resultSet.getInt("idPropuesta"),
                resultSet.getBoolean( "decision")
        );

        return voto;
    }


}
