package com.decroly;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class SQLAccessMercaDaw {


    //ESTE METODO ME SIRVE PARA VER SOLO EL NOMBRE DE TODOS LOS PRODUCTOS
    public static List<String> getProductosName(){ //declaro metodo público, que devuelve una lista de cadenas de texto
        List<String> producto = new LinkedList<>();//Crea una lista vacía donde irás guardando los nombres que encuentres en la base de datos.

        //Sentencia SQL: Es como si escribieras la lista de la compra en un papel: el papel no compra la comida, solo contiene el mensaje de lo que necesitas
//Le indica a la base de datos que quieres extraer la columna nombre de la tabla llamada Producto
        String sqlProductoName = "SELECT nombre FROM Producto";

        //Llama a tu gestor de datos para establecer el enlace con MySQL.
        try(Connection connection = SqlDataManager.getConnection();

            //Crea un objeto de tipo Statement, que funciona como el "vehículo" que transportará tu consulta SQL hacia el servidor de la base de datos.
            Statement stament = connection.createStatement();

            //Ejecuta la consulta y guarda el resultado en un ResultSet
            ResultSet resultSets = stament.executeQuery(sqlProductoName)) {

            //El metodo .next() devuelve true mientras existan más filas por leer y mueve el puntero a la siguiente posicin.
            while (resultSets.next()) {
                //extrae el contenido de la primera columna de la fila actual (en este caso, la referencia) e inserta ese valor de texto dentro de tu lista producto.
                producto.add(resultSets.getNString(1));
            }

            //Captura cualquier error que ocurra durante la comunicación con la base de datos (por ejemplo, si la tabla no existe o la conexión falla).
        } catch (SQLException e) {
            //Lanza una excepción para detener el programa si hay un error.
            throw new RuntimeException(e);
        }

        //Una vez terminado el bucle y cerrada la conexión, el metodo entrega la lista llena con todas las referencias encontradas.
        return producto;
    }


    //ESTE METODO DEVUELVE UNA LISTA DE TODOS LOS PRODUCTOS, CON TODOS SUS ATRIBUTOS
    public static List<Producto> getProductos() {
        List<Producto> producto = new LinkedList<>();

        //Consulta SQL
        String sqlLista = "SELECT * FROM Producto";

        try (Connection connection = SqlDataManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSets = statement.executeQuery(sqlLista)) {

            while (resultSets.next()) { //los atributos
                int id = resultSets.getInt(1);
                String referencia = resultSets.getNString(2);
                String nombre = resultSets.getNString(3);
                String descripcion = resultSets.getNString(4);
                int id_tipo = resultSets.getInt(5);
                int cantidad = resultSets.getInt(6);
                double precio = resultSets.getDouble(7);
                int descCuento = resultSets.getInt(8);
                int iva = resultSets.getInt(9);
                boolean aplicar_dto = resultSets.getBoolean(10);

                producto.add(new Producto(id, referencia, nombre, descripcion, id_tipo, cantidad, precio,descCuento, iva, aplicar_dto));
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return producto;
    }

    //METODO PARA MOSTRAR DETALLE DE PRODUCTOS POR REFERENCIA
    public static Producto getProductoPorReferencia(String referencia){
        Producto p = null;

        //Consulta SQL
        String sqlProductos = "SELECT * FROM Producto WHERE referencia = ?";

        try(Connection connection = SqlDataManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlProductos)) {

            statement.setString(1, referencia); // Pasamos el texto de la referencia
            ResultSet resultSets = statement.executeQuery();

            while (resultSets.next()) {
                int id = resultSets.getInt(1);
                referencia = resultSets.getNString(2);
                String nombre = resultSets.getNString(3);
                String descripcion = resultSets.getNString(4);
                int id_tipo = resultSets.getInt(5);
                int cantidad = resultSets.getInt(6);
                double precio = resultSets.getDouble(7);
                int descCuento = resultSets.getInt(8);
                int iva = resultSets.getInt(9);
                boolean aplicar_dto = resultSets.getBoolean(10);

                p = new Producto(id, referencia, nombre, descripcion, id_tipo, cantidad, precio,descCuento, iva, aplicar_dto);
            }

        }catch (SQLException e){
            System.err.println("Error getting character: "+e.getMessage());
        }
        return p;
    }


    //METODO PARA MOSTRAR DETALLE DE PRODUCTOS POR TIPO
    public static Producto getProductoPorTipo(int tipo){
        Producto p = null;

        //Consulta SQL
        String sqlProductos = "SELECT * FROM Producto WHERE tipo = ?";

        try(Connection connection = SqlDataManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlProductos)) {

            statement.setInt(1, tipo); // Pasamos el texto de la referencia
            ResultSet resultSets = statement.executeQuery();

            while (resultSets.next()) {
                int id = resultSets.getInt(1);
                String referencia = resultSets.getNString(2);
                String nombre = resultSets.getNString(3);
                String descripcion = resultSets.getNString(4);
                int id_tipo = resultSets.getInt(5);
                int cantidad = resultSets.getInt(6);
                double precio = resultSets.getDouble(7);
                int descCuento = resultSets.getInt(8);
                int iva = resultSets.getInt(9);
                boolean aplicar_dto = resultSets.getBoolean(10);

                p = new Producto(id, referencia, nombre, descripcion, id_tipo, cantidad, precio,descCuento, iva, aplicar_dto);
            }

        }catch (SQLException e){
            System.err.println("Error getting character: "+e.getMessage());
        }
        return p;
    }


}
