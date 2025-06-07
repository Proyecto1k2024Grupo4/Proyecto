package db;

import model.EstadoPropuesta;
import model.Propuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PropuestaDAO que se encarga de la comunicacion con la base de datos cuya funcion es de
 * busqueda, insercion y actualizacion de propuestas de la tabla PROPUESTA
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 05-04-2025
 */
public class PropuestaDAO {

    // Instancias estaticas
    private static PropuestaDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into PROPUESTA(titulo, descripcion, fechaExpiracion, estado, " +
            "idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from PROPUESTA";
    private static final String SELECT_BY_ID_QUERY = "select * from PROPUESTA where id = ?";
    private static final String SELECT_BY_ID_CONGRESO_QUERY = "select * from PROPUESTA where idCongreso = ?";
    private static final String SELECT_BY_NAME_PAIS = "select pr.* from PAIS p join CODIGO_CIVIL c on p.id = c.idPais join " +
            "PROPUESTA pr on c.id = pr.idCongreso where p.nombre = ?";
    private static final String UPDATE_BY_PROPUESTA_QUERY = "update PROPUESTA set titulo = ?, descripcion = ?, fechaExpiracion = ?, estado = ?, " +
            "numPasaportePolitico = ?, fechaProposicion = ?, fechaAceptacion = ?, fechaPublicacion = ? where id = ?";

    // Constructor privado
    private PropuestaDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estatico para obtener la unica instancia de PropuestaDAO
     * @return instancia de PropuestaDAO
     */
    public static PropuestaDAO getInstance(){
        if (instance == null) {
            instance = new PropuestaDAO();
        }
        return instance;
    }

    /**
     * Metodo que actualiza una propuesta mediante una instancia de Propuesta proporcionada como parametro
     * @param propuesta Propuesta que se desea actualizar
     * @throws SQLException Excepcion SQL
     */
    public void updatePropuestaByPropuesta(Propuesta propuesta) throws SQLException {
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_BY_PROPUESTA_QUERY)){
            statement.setString(1, propuesta.getTitulo());
            statement.setString(2, propuesta.getDescripcion());
            statement.setDate(3, propuesta.getFechaExpiracion());
            statement.setString(4, String.valueOf(propuesta.getEstado()));
            statement.setString(5, propuesta.getNumPasaportePolitico());
            statement.setDate(6, propuesta.getFechaProposicion());
            statement.setDate(7, propuesta.getFechaAceptacion());
            statement.setDate(8, propuesta.getFechaPublicacion());
            statement.setInt(9, propuesta.getId());
            statement.executeUpdate();
        }
    }

    /**
     * Metodo que inserta una propuesta con los datos de la instancia de Propuesta proporcionada
     * @param propuesta Propuesta que se desea insertar
     * @throws SQLException Excepcion SQL
     */
    public void insertPropuesta(Propuesta propuesta) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, propuesta.getTitulo());
            statement.setString(2, propuesta.getDescripcion());
            statement.setDate(3, propuesta.getFechaExpiracion());
            statement.setString(4, String.valueOf(propuesta.getEstado()));
            statement.setInt(5, propuesta.getIdCongreso());
            statement.setString(6, propuesta.getNumPasaportePolitico());
            statement.setDate(7, propuesta.getFechaProposicion());
            statement.setDate(8, propuesta.getFechaAceptacion());
            statement.setDate(9, propuesta.getFechaPublicacion());
            statement.executeUpdate();
        }
    }


    /**
     * Metodo que devuelve todas las propuestas en un List
     * @return List con todas las propuestas
     * @throws SQLException Excepción SQL
     */
    public List<Propuesta> getAllPropuesta() throws SQLException{
        List<Propuesta> propuestas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                propuestas.add(resultSetToPropuesta(resultSet));
            }
        }
        return propuestas;
    }

    /**
     * Metodo que recibe devuelve todas las propuestas que contengan el nombre del pais
     * proporcionado como parametro
     * @param nombre String con el nombre del pais
     * @return List con todas las propuestas del pais
     * @throws SQLException Excepcion SQL
     */
    public List<Propuesta> getPropuestasByNombrePais(String nombre) throws SQLException{
        List<Propuesta> propuestas = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME_PAIS)){
            statement.setString(1, nombre);
            ResultSet resultsSet = statement.executeQuery();
            while(resultsSet.next()){
                propuestas.add(resultSetToPropuesta(resultsSet));
            }
        }
        return propuestas;
    }

    /**
     * Metodo que devuelve una propuesta identificada por un id proporcionado
     * @param id Id de la propuesta que se desea recuperar
     * @return Propuesta con el id proporcionado
     * @throws SQLException Excepcion SQL
     */
    public Propuesta getPropuestaById(int id) throws SQLException{
        Propuesta propuesta = null;
        try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                propuesta = resultSetToPropuesta(resultSet);
            }
        }
        return propuesta;
    }

    /**
     * Metodo que devuelve propuestas identificadas por un id de congreso proporcionado
     * @param idCongreso Id del congreso al cual pertenecen las propuestas que se desean recuperar
     * @return Propuestas con el id del congreso proporcionado
     * @throws SQLException Excepcion SQL
     */
    public List<Propuesta> getPropuestaByIdCongreso(int idCongreso) throws SQLException{
        List<Propuesta> propuestas = new ArrayList<>();
        try(PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_CONGRESO_QUERY)){
            statement.setInt(1, idCongreso);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                propuestas.add(resultSetToPropuesta(resultSet));
            }
        }
        return propuestas;
    }

    /**
     * Metodo que transforma un ResultSet en un Propuesta
     * @param resultSet ResultSet que se desea trasnformar en propuesta
     * @return Propuesta trasnformada a partir de un ResultSet
     * @throws SQLException Excepcion SQL
     */
    private Propuesta resultSetToPropuesta(ResultSet resultSet) throws SQLException{
        return new Propuesta(
            resultSet.getInt("id"),
            resultSet.getString("titulo"),
            resultSet.getString("descripcion"),
            resultSet.getDate("fechaExpiracion"),
            EstadoPropuesta.valueOf(resultSet.getString("estado")),
            resultSet.getInt("idCongreso"),
            resultSet.getString("numPasaportePolitico"),
            resultSet.getDate("fechaProposicion"),
            resultSet.getDate("fechaExpiracion"),
            resultSet.getDate("fechaAceptacion")
        );
    }


}
