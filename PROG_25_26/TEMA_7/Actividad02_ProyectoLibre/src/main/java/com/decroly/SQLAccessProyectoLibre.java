package com.decroly;

import com.decroly.excepciones.CineException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessProyectoLibre {

    // --- MÉTODOS PARA PELÍCULAS ---

    public static List<Pelicula> getPeliculas() {
        List<Pelicula> lista = new LinkedList<>();
        String sql = "SELECT * FROM peliculas";

        try (Connection connection = SqlDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                // Creamos el objeto Pelicula con los datos de la tabla
                Pelicula p = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("duracion"),
                        rs.getString("genero")
                );
                lista.add(p);
            }
        } catch (SQLException | CineException e) {
            System.err.println("Error al obtener películas: " + e.getMessage());
        }
        return lista;
    }

    public static int insertPelicula(Pelicula p) {
        int filasAfectadas = -1;
        String sql = "INSERT INTO peliculas (id, titulo, duracion, genero) VALUES (?, ?, ?, ?)";

        try (Connection connection = SqlDataManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, p.getId());
            ps.setString(2, p.getTitulo());
            ps.setInt(3, p.getDuracion());
            ps.setString(4, p.getGenero());

            filasAfectadas = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar película: " + e.getMessage());
        }
        return filasAfectadas;
    }

    // --- MÉTODOS PARA USUARIOS ---

    public static List<Usuario> getUsuarios() {
        List<Usuario> lista = new LinkedList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection connection = SqlDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email")
                );
                lista.add(u);
            }
        } catch (SQLException | CineException e) {
            System.err.println("Error al obtener usuarios: " + e.getMessage());
        }
        return lista;
    }

    public static int insertUsuario(Usuario u) {
        int res = -1;
        String sql = "INSERT INTO usuarios (id, nombre, email) VALUES (?, ?, ?)";

        try (Connection connection = SqlDataManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, u.getId());
            ps.setString(2, u.getNombre());
            ps.setString(3, u.getEmail());

            res = ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
        }
        return res;
    }

    // --- METODO PARA REGISTRAR VENTAS (ENTRADAS) ---

    public static int insertVenta(Entrada e) {
        int res = -1;
        // Aquí guardamos los datos básicos de la entrada
        String sql = "INSERT INTO ventas (id_sesion, fila, columna, precio_final) VALUES (?, ?, ?, ?)";

        try (Connection connection = SqlDataManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, e.getIdSesion());
            ps.setInt(2, e.getFila());
            ps.setInt(3, e.getColumna());
            ps.setDouble(4, e.calcularPrecioFinal());

            res = ps.executeUpdate();
        } catch (SQLException exception) {
            System.err.println("Error al registrar venta en BD: " + exception.getMessage());
        }
        return res;
    }
}