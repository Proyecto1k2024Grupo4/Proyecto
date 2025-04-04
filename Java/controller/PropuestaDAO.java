package controller;

import db.DBConnection;
import model.EstadoPropuesta;
import model.Propuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropuestaDAO {

    // Instancias estaticas
    private static PropuestaDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into PROPUESTA(titulo, descripcion, fechaExpiracion, estado, idCongreso, numPasaportePolitico, fechaProposicion, fechaAceptacion, fechaPublicacion) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from PROPUESTA";
    private static final String SELECT_BY_ID_QUERY = "select * from PROPUESTA where id = ?";
    private static final String UPDATE_BY_ID_QUERY = "update PROPUESTA set ? = ? where id = ?";
    private static final String DELETE_BY_ID_QUERY = "delete * from PROPUESTA where id = ?";

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

    public void insertPropuesta(Propuesta propuesta) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, propuesta.getTitulo());
            statement.setString(2, propuesta.getDescripcion());
            statement.setDate(3, propuesta.getFechaExpiracion());
            statement.setString(4, propuesta.getDescripcion());
            statement.setInt(5, propuesta.getIdCongreso());
            statement.setString(6, propuesta.getNumPasaportePolitico());
            statement.setDate(7, propuesta.getFechaProposicion());
            statement.setDate(8, propuesta.getFechaAceptacion());
            statement.setDate(9, propuesta.getFechaPublicacion());
            statement.executeQuery();
        }
    }

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

    public Propuesta getPropuestaById(int id) throws SQLException{
        Persona persona
    }

    private Propuesta resultSetToPropuesta(ResultSet resultSet) throws SQLException{
        return new Propuesta(
            resultSet.getInt("id"),
            resultSet.getString("titulo"),
            resultSet.getString("descripcion"),
            resultSet.getDate("fechaExpiracion"),
            EstadoPropuesta.valueOf(resultSet.getString("estado")),
            resultSet.getInt("idCongreso"),
            resultSet.getString(" numPasaportePolitico"),
            resultSet.getDate("fechaProposicion"),
            resultSet.getDate("fechaExpiracion"),
            resultSet.getDate("fechaAceptacion")
        );
    }


}
