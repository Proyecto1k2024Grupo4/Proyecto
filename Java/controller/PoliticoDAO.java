package controller;

import db.DBConnection;
import model.Politico;
import model.Sexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PoliticoDAO {


    private static PoliticoDAO instance;

    private Connection connection;

    //Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO POLITICO (numPasaporte, nombre, primerApellido, segundoApellido, fnac, sexo, paisNacimiento, fechaIniciacion, fechaRetirada, idCongreso)" +
            "VALUES (?, ?, ?, ?, ?,? ,?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM POLITICO";
    private static final String SELECT_BY_PASAPORTE_QUERY = "SELECT * FROM PERSONA WHERE numPasaporte = ?";
    private static final String UPDATE_FECHA_QUERY = "UPDATE POLITICO SET fechaRetirada = ? WHERE numPasaporte = ?";
    private static final String DELETE_QUERY = "DELETE FROM POLITICO WHERE numPasaporte = ?";
    private static final String TOTAL_POLITICOS_QUERY = "SELECT COUNT(*) FROM POLITICO";

    //Constructor privado con la conexion

    private PoliticoDAO() { this.connection = DBConnection.getConnection(); }


    public static synchronized PoliticoDAO getInstance(){
        if (instance == null)
            instance = new PoliticoDAO();
        return instance;
    }

    public void insertarPolitico(Politico politico) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, politico.getNumPasaporte());
            statement.setString(2, politico.getNombre());
            statement.setString(3, politico.getPrimerApellido());
            statement.setString(4, politico.getSegundoApellido());
            statement.setString(5, politico.getFnac());
            statement.setString(6, String.valueOf(politico.getSexo()));
            statement.setString(7, String.valueOf(politico.getPaisNacimiento()));
            statement.setString(8, politico.getFechaIniciacion());
            statement.setString(9, politico.getFechaRetirada());
            statement.setInt(10, politico.getIdCongreso());
            statement.executeUpdate();
        }
    }

    public List<Politico> getAllPoliticos() throws SQLException {
        List<Politico> politicos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)){
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next())
                politicos.add(resultSetToPolitico(resultSet));
        }
        return politicos;
    }

    public Politico getPoliticoByNumPasaporte (String numPasaporte) throws SQLException {
        Politico politico = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_PASAPORTE_QUERY)){
            statement.setString(1, numPasaporte);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                politico = resultSetToPolitico(resultSet);
            return politico;
        }
    }

    public void updatePolitico (String fecha, String pasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_FECHA_QUERY)){
            statement.setString(1, fecha);
            statement.setString(2, pasaporte);
            statement.executeUpdate();
        }
    }

    public void deletePersonaByNumPasaporte(String numPasaporte) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)){
            statement.setString(1, numPasaporte);
            statement.executeUpdate();
        }
    }

    private Politico resultSetToPolitico(ResultSet resultSet) throws SQLException {
        return new Politico(
                resultSet.getString("numPasaporte"),
                resultSet.getString("nombre"),
                resultSet.getString("primerApellido"),
                resultSet.getString("segundoApellido"),
                resultSet.getString("fnac"),
                Sexo.valueOf(resultSet.getString("sexo")),
                resultSet.getInt("paisNacimiento"),
                resultSet.getString("fechaIniciacion"),
                resultSet.getString("fechaRetirada"),
                resultSet.getInt("idCongreso")
        );
    }

    public int totalPoliticos () throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_POLITICOS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                total = resultSet.getInt(1);
        }
        return total;
    }
}
