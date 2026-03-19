package com.decroly;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



public class SQLAccessMercaDaw {



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

    public static List<Character> getCharacters(){
        List<Character> productos = new LinkedList<>();

        //Consulta SQL
        String sqlProducto = "SELECT * FROM producto";

        try(Connection connection = SqlDataManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSets = statement.executeQuery(sqlProducto)) {
            while (resultSets.next()) {
                int id = resultSets.getInt(1);
                String name = resultSets.getNString(2);
                String fullname = resultSets.getNString(3);
                String gender = resultSets.getNString(7);
                String race = resultSets.getNString(8);
                String aligment = resultSets.getNString(9);

                productos.add(new Character(id, name, fullname, gender, race, aligment));

            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return  productos;
    }



}
