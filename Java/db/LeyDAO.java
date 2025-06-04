package db;

import model.Ley;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la tabla LEY, usando exactamente las mismas consultas SQL que en JavaFX.
 */
public class LeyDAO {

    private static LeyDAO instance;
    private final Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) values ( ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from LEY";
    private static final String SELECT_BY_ID_QUERY = "select * from LEY where id = ?";
    private static final String UPDATE_BY_LEY_QUERY = "update LEY set descripcion = ?, fechaAplicacion = ?, fechaModificacion = ?, fechaImplementacion = ? where id = ?";
    private static final String DELETE_BY_ID_QUERY = "delete from LEY where id = ?";

    private static final String SELECT_CON_CODCIVIL_Y_PAIS = """
        SELECT 
          LEY.id                  AS idLey,
          LEY.descripcion         AS descripcion,
          LEY.fechaAplicacion     AS fechaAplicacion,
          LEY.fechaModificacion   AS fechaModificacion,
          LEY.fechaImplementacion AS fechaImplementacion,
          LEY.idCodigoCivil       AS idCodigoCivil,
          PAIS.id                 AS idPais,
          PAIS.nombre             AS nombrePais
        FROM 
          LEY
          LEFT JOIN CODIGO_CIVIL ON LEY.idCodigoCivil = CODIGO_CIVIL.id
          LEFT JOIN PAIS       ON PAIS.id = CODIGO_CIVIL.idPais
        """;

    // Variante filtrada por País
    private static final String SELECT_CON_CODCIVIL_Y_PAIS_By_Pais = """
        SELECT 
          LEY.id AS idLey,
          LEY.descripcion AS descripcion,
          LEY.fechaAplicacion AS fechaAplicacion,
          LEY.fechaModificacion AS fechaModificacion,
          LEY.fechaImplementacion AS fechaImplementacion,
          LEY.idCodigoCivil AS idCodigoCivil,
          PAIS.id  AS idPais,
          PAIS.nombre AS nombrePais
        FROM 
          LEY
          LEFT JOIN CODIGO_CIVIL ON LEY.idCodigoCivil = CODIGO_CIVIL.id
          LEFT JOIN PAIS ON PAIS.id = CODIGO_CIVIL.idPais
        WHERE
          CODIGO_CIVIL.idPais = ?
        """;

    // Variante filtrada por Código Civil
    private static final String SELECT_CON_CODCIVIL_Y_PAIS_By_CodCivil = SELECT_CON_CODCIVIL_Y_PAIS +
            " WHERE CODIGO_CIVIL.id = ?";

    private LeyDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static LeyDAO getInstance() {
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
            statement.executeUpdate();
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
            statement.executeUpdate();
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
            statement.executeUpdate();
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
     * Devuelve todas las leyes cuyo CODIGO_CIVIL.id = idCodigoCivil,
     * rellenando también el atributo 'pais' dentro de cada Ley.
     */
    public List<Ley> getLeyesPorCodigoCivil(int idCodigoCivil) throws SQLException {
        List<Ley> lista = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_CON_CODCIVIL_Y_PAIS_By_CodCivil)) {
            ps.setInt(1, idCodigoCivil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(resultSetToLey(rs));
            }
        }
        return lista;
    }

    /**
     * Devuelve todas las leyes cuyo CODIGO_CIVIL.idPais = idPais,
     * rellenando también el atributo 'pais' dentro de cada Ley.
     */
    public List<Ley> getLeyesPorPais(int idPais) throws SQLException {
        List<Ley> lista = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(SELECT_CON_CODCIVIL_Y_PAIS_By_Pais)) {
            ps.setInt(1, idPais);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(resultSetToLey(rs));
            }
        }
        return lista;
    }

    /**
     * Metodo que transforma un ResultSet en una Ley
     * @param rs ResultSet que queremos tranformar
     * @return Ley que hemos obtenido del ResultSet
     * @throws SQLException Excepcion SQL
     */
    private Ley resultSetToLey(ResultSet rs) throws SQLException {
        return new Ley(
                rs.getInt("idLey"),
                rs.getString("descripcion"),
                rs.getDate("fechaAplicacion"),
                rs.getDate("fechaModificacion"),
                rs.getDate("fechaImplementacion"),
                rs.getInt("idCodigoCivil"),
                rs.getInt("idPais"),
                rs.getString("nombrePais")
        );
    }


}
