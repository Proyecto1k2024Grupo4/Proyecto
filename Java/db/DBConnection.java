package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión con la base de datos y de la que solo puede existir una instancia que será llamada
 * por los diferentes DAOs cuando sea necesario.
 * @author Diego Fernando Valencia Correa 1ºK
 */
public class DBConnection {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://prop-in.cnyfmuf4d21m.us-east-1.rds.amazonaws.com/propin";
    private static final String USERNAME = "usuarioLectura";
    private static final String PASSWORD = "123";

    private static Connection connection;

    /**
     * Constructor privado que no puede ser utilizado
     */
    private DBConnection() {}

    /**
     * Metodo que sirve para recuperar la instancia de DBConecction
     * @return Objeto Connection con la conexión a la base de datos
     */
    public static Connection getConnection() {
        if (connection == null) {
            // Bloqueo sincronizado para evitar concurrencia
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                        // Establecer la conexión
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                    } catch ( SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }

    /**
     * Metodo que sirve para cerrar la conexión con la base de datos
     */
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

