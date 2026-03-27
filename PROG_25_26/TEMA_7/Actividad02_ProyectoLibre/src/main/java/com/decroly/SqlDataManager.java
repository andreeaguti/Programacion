package com.decroly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlDataManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //SIEMPRE ESTE DRIVER
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String SCHEMA = "proyectoLibre"; //EL NOMBRE DE LA BASE DE DATOS
    private static final String USUARIO = "root"; //NOMBRE DE USUARIO EN SQL
    private static final String CLAVE = "daw12"; //CONTRASEÑA DE SQL

    public static Connection getConnection() {
        //Define un metodo que puedes llamar desde cualquier parte de tu código
        // (al ser static) y que te devolverá un objeto de tipo Connection
        Connection connection = null;
        //Crea una variable vacía para guardar la conexión. Se pone a null al principio por si algo falla y no se puede conectar.

        try{
            //Busca la clase por el nombre del driver
            Class.forName(DRIVER);
            //Busca en las librerías de tu proyecto la clase que pusimos en la variable DRIVER. Si no has añadido el JAR correctamente, aquí es donde saltará el primer error.

            //Obtiene la conexion
            connection = DriverManager.getConnection(URL+SCHEMA, USUARIO, CLAVE);
            //Es el momento en que Java intenta hablar con MySQL usando la URL, el USUARIO y la CLAVE. Si tod coincide, se crea el enlace real.

        }catch(ClassNotFoundException e){
            System.err.println("Error de acceso al driver: " + e.getMessage());
            //Si en la línea del Class.forName Java no encuentra el driver (el archivo .jar), el programa no se rompe, sino que viene aquí y te avisa.
        } catch (SQLException e) {
            System.err.println("Error de SQL: " + e.getMessage());
        }

        return connection;
        //Devuelve el resultado. Si tuvo éxito, devuelve la conexión activa; si falló, devuelve null.
    }

























}

