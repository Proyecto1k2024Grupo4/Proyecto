package db;

import model.Ley;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase LeyDAO que se encarga de la comunicacion con la base de datos cuya funcion es de
 * busqueda, insercion, elmiminacion, y actualizacion de leyes de la tabla LEY
 * @author Diego Fernando Valencia Correa 1ºK
 * @version 05-04-2025
 */
public class LeyDAO {

    // Instancias estaticas
    private static LeyDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) values ( ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from LEY";
    private static final String SELECT_BY_ID_QUERY = "select * from LEY where id = ?";
    private static final String UPDATE_BY_LEY_QUERY = "update LEY set descripcion = ?, fechaAplicacion = ?, fechaModificacion = ?, fechaImplementacion = ? where id = ?";
    private static final String DELETE_BY_ID_QUERY = "delete from LEY where id = ?";


    /**
     * Constructor privado que no recibe parametro y que obtiene la conexion con la base de datos
     */
    private LeyDAO(){
        this.connection = DBConnection.getConnection();
    }

    /**
     * Metodo estatico para obtener la unica instancia de LeyDAO
     * @return instancia de LeyDAO
     */
    public static LeyDAO getInstance(){
        if (instance == null) {
            instance = new LeyDAO();
        }
        return instance;
    }

    /**
     * Metodo que acutaliza una ley recibiendo una instancia de ley. Este metodo actualiza la ley con ese mismo id.
     * @param ley Ley que queremos actualizar
     * @throws SQLException Excepcion SQL
     */
    public void updateLeyById(Ley ley) throws SQLException{
        try(PreparedStatement statement = connection.prepareStatement(UPDATE_BY_LEY_QUERY)){
            statement.setString(1, ley.getDescripcion());
            statement.setDate(2, ley.getFechaAplicacion());
            statement.setDate(3, ley.getFechaModificacion());
            statement.setDate(4, ley.getFechaImplementacion());
            statement.setInt(5, ley.getId());
            statement.executeQuery();
        }
    }

    /**
     * Metodo que borra una ley segun el id proporcionado
     * @param id Id de la ley que queremos borrar
     * @throws SQLException Excepcion SQL
     */
    public void deleteLeyById(int id) throws SQLException{
        try (PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID_QUERY)) {
            statement.setInt(1, id);
            statement.executeQuery();
        }
    }

    /**
     * Metodo para insertar una ley al que se le pasa un objeto de la clase Ley
     * @param ley Instancia de la clase ley
     * @throws SQLException Excepcion SQL
     */
    public void insertLey(Ley ley) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)){
            statement.setString(1, ley.getDescripcion());
            statement.setDate(2, ley.getFechaAplicacion());
            statement.setDate(3, ley.getFechaModificacion());
            statement.setDate(4, ley.getFechaImplementacion());
            statement.setInt(5, ley.getIdCodigoCivil());
            statement.executeQuery();
        }
    }

    /**
     * Metodo que devuelve una ley segun el id que se introduza como parametro
     * @param id Id de la ley que queremos recuperar
     * @return Ley con el id introducido
     * @throws SQLException Excepcion SQL
     */
    public Ley getByIdLey(int id) throws SQLException {
        Ley ley = null;

        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_QUERY)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                ley = resultSetToLey(resultSet);
            }
        }

        return ley;
    }

    /**
     * Metodo que devuelve un List con todas las leyes
     * @return List con todas las leyes
     * @throws SQLException Excepcion SQL
     */
    public List<Ley> getAllLey() throws SQLException{
        List<Ley> leyes = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                leyes.add(resultSetToLey(resultSet));
            }
        }
        return leyes;
    }

    /**
     * Metodo que transforma un ResultSet en una Ley
     * @param resultSet ResultSet que queremos tranformar
     * @return Ley que hemos obtenido del ResultSet
     * @throws SQLException Excepcion SQL
     */
    private Ley resultSetToLey(ResultSet resultSet) throws  SQLException{
        return new Ley(
                resultSet.getInt("id"),
                resultSet.getString("descripcion"),
                resultSet.getDate("fechaAplicacion"),
                resultSet.getDate("fechaModificacion"),
                resultSet.getDate("fechaImplementacion"),
                resultSet.getInt("idCodigoCivil")
        );
    }
}
