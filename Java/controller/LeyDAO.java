package controller;

import db.DBConnection;
import model.Ley;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeyDAO {

    // Instancias estaticas
    private static LeyDAO instance;
    private Connection connection;

    // SENTENCIAS SQL
    private static final String INSERT_QUERY = "insert into LEY(descripcion, fechaAplicacion, fechaModificacion, fechaImplementacion, idCodigoCivil) values ( ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "select * from LEY";
    private static final String SELECT_BY_ID_QUERY = "select * from LEY where id = ?";
    private static final String SELECT_BY_CODIGO_CIVIL_QUERY = "select * from LEY where idCodigoCivil = ?";

    // Constructor privado
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
