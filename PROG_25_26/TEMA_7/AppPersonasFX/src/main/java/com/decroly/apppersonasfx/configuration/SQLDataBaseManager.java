package com.decroly.apppersonasfx.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta clase se encarga exclusivamente de gestionar la conexión física
 * con el servidor de bases de datos MySQL.
 */
public class SQLDataBaseManager {

    // El Driver es la "librería" que permite a Java hablar el idioma de MySQL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    // Dirección local del servidor (localhost) y el puerto estándar (3306)
    private static final String URL = "jdbc:mysql://localhost:3306/";

    // Nombre exacto de la base de datos (Schema) que creaste en Workbench
    private static final String SCHEMA = "dawpeople";

    // Credenciales de acceso que configuraste al instalar MySQL
    private static final String USUARIO = "root";
    private static final String CLAVE = "daw12";

    /**
     * Intenta establecer una conexión con la base de datos.
     * @return Objeto Connection si tiene éxito, o null si hay algún error.
     */
    public static Connection getConnection(){
        Connection connection = null;

        try {
            // 1. Cargar el Driver en la memoria del programa
            Class.forName(DRIVER);

            // 2. Intentar abrir la puerta usando la URL completa, el usuario y la clave
            connection = DriverManager.getConnection(URL + SCHEMA, USUARIO, CLAVE);

        } catch (ClassNotFoundException e) {
            // Este error salta si no tienes el "mysql-connector" en tu archivo pom.xml
            System.out.println("Error de acceso al driver: " + e.getMessage());
        } catch (SQLException e) {
            // Este error salta si el usuario/clave están mal o la DB no existe en Workbench
            System.out.println("Error de SQL: " + e.getMessage());
        }

        return connection;
    }
}