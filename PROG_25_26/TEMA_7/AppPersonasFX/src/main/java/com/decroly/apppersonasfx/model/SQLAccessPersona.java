package com.decroly.apppersonasfx.model;

import com.decroly.apppersonasfx.configuration.SQLDataBaseManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase DAO (Data Access Object).
 * Contiene toda la lógica CRUD (Create, Read, Update, Delete) para la entidad Persona.
 */
public class SQLAccessPersona {



    /**
     * Obtiene todas las personas de la base de datos.
     * @return Una lista (LinkedList) con todos los objetos Persona encontrados.
     */
    public static List<Persona> getAllpersonas(){
        List<Persona> personas = new LinkedList<>();

        // Consulta SQL para traer todas las filas de la tabla 'person'
        String sqlpersonas = "SELECT * FROM person";

        // 'try-with-resources': Cierra automáticamente la conexión y el statement al terminar
        try(Connection connection = SQLDataBaseManager.getConnection();
            Statement stament = connection.createStatement();
            ResultSet resultSets = stament.executeQuery(sqlpersonas)) {

            // Recorremos el cursor (ResultSet) fila por fila
            while (resultSets.next()) {
                // Sacamos los datos de las columnas por su posición
                String dni = resultSets.getNString(1);
                String name = resultSets.getNString(2);
                String surname = resultSets.getNString(3);
                String email = resultSets.getNString(4);
                int age = resultSets.getInt(5);
                String phone = resultSets.getNString(6);

                // Mapeamos los datos de la DB a un objeto Java usando el patrón Builder
                Persona p = Persona.builder()
                        .dni(dni)
                        .name(name)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();

                personas.add(p);
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        return personas;
    }

    public static List<Persona> getpersonasByNameContains(String name){
        List<Persona> personas = new LinkedList<>();

        //Sentencia SQL
        String sqlpersonas = "SELECT * FROM person where name like ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlpersonas)){

            statement.setString(1, name+"%");
            ResultSet resultSets = statement.executeQuery();

            while (resultSets.next()) {
                String dni = resultSets.getNString(1);
                String nameDB = resultSets.getNString(2);
                String surname = resultSets.getNString(3);
                String email = resultSets.getNString(4);
                int age = resultSets.getInt(5);
                String phone = resultSets.getNString(6);

                //Uso de patron builder
                Persona p = Persona.builder()
                        .dni(dni)
                        .name(nameDB)
                        .surname(surname)
                        .email(email)
                        .age(age)
                        .phone(phone)
                        .build();

                personas.add(p);
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }

        return personas;
    }


    /**
     * Busca una persona específica por su DNI.
     */
    public static Persona getPersonaByDni(String dni){
        Persona p = null;
        // Usamos '?' para evitar Inyección SQL (Seguridad)
        String sqlpersonas = "SELECT * FROM person WHERE dni = ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlpersonas)){

            // Sustituimos el '?' por el valor real del DNI
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Si existe, construimos el objeto
                p = Persona.builder()
                        .dni(resultSet.getNString(1))
                        .name(resultSet.getNString(2))
                        .surname(resultSet.getNString(3))
                        .email(resultSet.getNString(4))
                        .age(resultSet.getInt(5))
                        .phone(resultSet.getNString(6))
                        .build();
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return p;
    }

    /**
     * Busca una persona por su correo electrónico.
     */
    public static Persona getPersonaByEmail(String email){
        Persona p = null;
        String sqlpersonas = "SELECT * FROM person WHERE email = ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlpersonas)){

            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                p = Persona.builder()
                        .dni(resultSet.getNString(1))
                        .name(resultSet.getNString(2))
                        .surname(resultSet.getNString(3))
                        .email(resultSet.getNString(4))
                        .age(resultSet.getInt(5))
                        .phone(resultSet.getNString(6))
                        .build();
            }
        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return p;
    }

    /**
     * Inserta una nueva persona en la base de datos.
     * @return true si se insertó correctamente.
     */
    public static boolean createPersona(Persona persona){
        boolean result = false;
        String sqlInsertpersonas = "INSERT INTO person (dni, name, surname, email, age, phone) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlInsertpersonas)){

            // Pasamos los datos del objeto Java a la sentencia SQL
            statement.setString(1, persona.getDni());
            statement.setString(2, persona.getName());
            statement.setString(3, persona.getSurname());
            statement.setString(4, persona.getEmail());
            statement.setInt(5, persona.getAge());
            statement.setString(6, persona.getPhone());

            statement.execute();
            result = true;

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return result;
    }

    /**
     * Actualiza los datos de una persona existente filtrando por su DNI.
     */
    public boolean updatePersona(Persona persona){
        boolean result = false;
        String sqlUpdatePersona = "UPDATE person set name = ?, surname = ?," +
                "email = ?, age = ?, phone = ?  where dni = ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlUpdatePersona))
        {
            statement.setString(1, persona.getName());
            statement.setString(2, persona.getSurname());
            statement.setString(3, persona.getEmail());
            statement.setInt(4, persona.getAge());
            statement.setString(5, persona.getPhone());
            statement.setString(6, persona.getDni()); // El DNI se usa para el WHERE

            statement.executeUpdate();
            result = true;

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return result;
    }

    /**
     * Elimina una persona de la base de datos según su DNI.
     */
    public boolean deletePersonaByDNI(String dni){
        boolean result = false;
        String sqlDeletepersonas = "DELETE FROM person WHERE dni = ?";

        try(Connection connection = SQLDataBaseManager.getConnection();
            PreparedStatement statement = connection.prepareStatement(sqlDeletepersonas)){

            statement.setString(1, dni);
            statement.execute();
            result = true;

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
        return result;
    }
}