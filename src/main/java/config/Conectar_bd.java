package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conectar_bd {

    private static final String URL = "jdbc:mysql://localhost:3306/cactpfinal";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public Connection obtenerConexion() throws SQLException {

        Connection conn = null;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            // Crear la tabla si no existe
            crearTablaMascotas(conn);

            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }

    private void crearTablaMascotas(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS mascotas("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "nombre VARCHAR(30) NOT NULL,"
                + "raza VARCHAR(30) NOT NULL)";

        try (Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la tabla de mascotas", e);
        }
    }
}
