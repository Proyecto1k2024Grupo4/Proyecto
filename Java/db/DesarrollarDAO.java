package db;

import model.Desarrollar;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
    @author ABDELMOGHIT SAMINI 1KDAM
    Gestiona la relación entre propuestas y leyes, permitiendo
    insertar nuevas asociaciones, consultar las existentes y eliminarlas.
    Implementa el patrón singleton para reutilizar la conexión.
 */
public class DesarrollarDAO {
    private static DesarrollarDAO instance;
    private Connection connection;

    // Consultas ajustadas al DDL
    private static final String INSERT_QUERY =
            "INSERT INTO DESARROLLAR (idPropuesta, idLey) VALUES (?, ?)";
    private static final String SELECT_BY_PROPUESTA_QUERY =
            "SELECT * FROM DESARROLLAR WHERE idPropuesta = ?";
    private static final String DELETE_QUERY =
            "DELETE FROM DESARROLLAR WHERE idPropuesta = ? AND idLey = ?";

    /**
     Constructor privado para inicializar conexión.
     */
    private DesarrollarDAO() {
        this.connection = DBConnection.getConnection();
    }
    /**
         Devuelve la instancia singleton de DesarrollarDAO.
         @return instancia única
     */
    public static DesarrollarDAO getInstance() {
        if (instance == null) {
            instance = new DesarrollarDAO();
        }
        return instance;
    }
/**

 Inserta una nueva relación Desarrollar en la base de datos.
 @param desarrollar objeto relación con IDs de propuesta y ley
 @throws SQLException si falla la operación SQL
  */

    public void insertDesarrollar(Desarrollar desarrollar) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(INSERT_QUERY)) {
            st.setInt(1, desarrollar.getIdPropuesta());
            st.setInt(2, desarrollar.getIdLey());
            st.executeUpdate();
        }
    }
    /**
         Retorna la lista de relaciones Desarrollar para una propuesta.
         @param idPropuesta identificador de la propuesta
         @return lista de objetos Desarrollar
         @throws SQLException si falla la consulta
     */

    public List<Desarrollar> getDesarrollosByPropuesta(int idPropuesta) throws SQLException {
        List<Desarrollar> list = new ArrayList<>();
        try (PreparedStatement st = connection.prepareStatement(SELECT_BY_PROPUESTA_QUERY)) {
            st.setInt(1, idPropuesta);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    list.add(new Desarrollar(
                            rs.getInt("idPropuesta"),
                            rs.getInt("idLey")
                    ));
                }
            }
        }
        return list;
    }
    /**
     Elimina una relación Desarrollar especificada por IDs.
     @param idPropuesta identificador de la propuesta
     @param idLey identificador de la ley
     @throws SQLException si falla la eliminación
     */

    public void deleteDesarrollar(int idPropuesta, int idLey) throws SQLException {
        try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
            st.setInt(1, idPropuesta);
            st.setInt(2, idLey);
            st.executeUpdate();
        }
    }
}
