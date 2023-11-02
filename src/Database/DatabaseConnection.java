package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Datos de conexión a la base de datos
    private static final String URL = "jdbc:mysql://localhost:3306/crm-react";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para establecer una conexión a la base de datos
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Establecemos la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }

        return connection;
    }

    // Método para cerrar la conexión a la base de datos
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
