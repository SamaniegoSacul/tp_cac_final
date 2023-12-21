package dao;

import config.Conectar_bd;
import interfaces.Crud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mascotas;

public class MascotasDao implements Crud {

    // Importo lo que necesito
    Conectar_bd conexionBD = new Conectar_bd();
    Connection conn;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Mascotas mascotas = new Mascotas();

    @Override
    public List<Mascotas> listarMascotas() {

        ArrayList<Mascotas> listMascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Mascotas mascotas = new Mascotas();

                mascotas.setId(resultSet.getInt("id"));
                mascotas.setNombre(resultSet.getString("nombre"));
                mascotas.setRaza(resultSet.getString("raza"));

                listMascotas.add(mascotas);
            }
        } catch (Exception e) {

            e.printStackTrace();

        }

        return listMascotas;

    }

    @Override
    public Mascotas verMascota(int id) {

        String sql = "SELECT * FROM mascotas WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                mascotas.setId(resultSet.getInt("id"));
                mascotas.setNombre(resultSet.getString("nombre"));
                mascotas.setRaza(resultSet.getString("raza"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mascotas;
    }

    @Override
    public Boolean agregar(Mascotas mascotas) {
        String sql = "INSERT INTO mascotas (nombre, raza) VALUES (?, ?)";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, mascotas.getNombre());
            preparedStatement.setString(2, mascotas.getRaza());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean editar(Mascotas mascotas) {
        String sql = "UPDATE mascotas SET nombre=?, raza=? WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, mascotas.getNombre());
            preparedStatement.setString(2, mascotas.getRaza());
            preparedStatement.setInt(3, mascotas.getId());

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean borrar(int id) {

        String sql = "DELETE FROM mascotas WHERE id=?";

        try {

            conn = conexionBD.obtenerConexion();
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int filasAfectadas = preparedStatement.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
