package inventoryplusmanager.demo1.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    public static Connection connection = null;

    // Realiza la conexión para MySQL sin una base de datos en específico
    public static Connection connection(String username, String password) throws ClassNotFoundException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = doConnection("", username, password);
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar si está cerrada la conexión: " + e);
            throw new RuntimeException(e);
        }
        return connection;
    }

    // Realiza la conexión para una base de datos SQL específica
    public static Connection connection(String db, String username, String password) throws ClassNotFoundException {
        try {
            if (connection == null || connection.isClosed()) {
                connection = doConnection(db, username, password);
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar si está cerrada la conexión: " + e);
            throw new RuntimeException(e);
        }
        return connection;
    }

    // Cierra la conexión
    public static void closeConnection(Connection connection) {
        try {
            if (DBConnector.connection != null && !DBConnector.connection.isClosed()) {
                DBConnector.connection.close();
                System.out.println("Conexión cerrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión: " + e);
        }
    }

    private static Connection doConnection(String db, String username, String password) throws ClassNotFoundException {
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbUrl = URL;
            if (!db.isEmpty()) {
                dbUrl += db;
            }
            conn = DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.err.println("Error al crear la conexión: " + e);
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            System.err.println("Error al crear la conexión: " + e);
            throw new ClassNotFoundException(e.toString());
        }
        System.out.println("Conexión creada: " + conn);
        return conn;
    }
}
