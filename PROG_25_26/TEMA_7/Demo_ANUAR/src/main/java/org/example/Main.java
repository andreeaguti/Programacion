package org.example;

import com.decroly.SqlDataManager;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        Connection cn = SqlDataManager.getConnection();

        if (cn != null) {
            System.out.println("¡Conexión establecida con DC Universe! 🦸‍♂️");
        } else {
            System.out.println("No se pudo conectar. Revisa la consola para ver el error.");
        }
    }
}