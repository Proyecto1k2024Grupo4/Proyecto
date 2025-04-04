package controller;

import db.DBConnection;
import model.Congreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CongresoDAO {
    private static CongresoDAO instance;
    private Connection connection;

    private static final String INSERT_QUERY = "INSERT INTO CONGRESO (numPoliticos, propAprobadas) VALUES (?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM CONGRESO";
    private static final String SELECT_BY_ID_QUERY = "SELECT * FROM CONGRESO WHERE id = ?";

    private CongresoDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static CongresoDAO getInstance() {
        if (instance == null) {
            instance = new CongresoDAO();
        }
        return instance;
    }

    public void insertCongreso(Congreso congreso) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, congreso.getNumPoliticos());
            statement.setInt(2, congreso.getPropAprobadas());
            statement.executeUpdate();
        }
    }

    public List<Congreso> getAllCongresos() throws SQLException {
        List<Congreso> congresos = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                congresos.add(resultSetToCongreso(resultSet));
            }
        }
        return congresos;
    }

    private Congreso resultSetToCongreso(ResultSet resultSet) throws SQLException {
        return new Congreso(
                resultSet.getInt("id"),
                resultSet.getInt("numPoliticos"),
                resultSet.getInt("propAprobadas")
        );
    }
}