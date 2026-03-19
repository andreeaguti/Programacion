package com.decroly;

import java.sql.Connection;

public class Inventario {
    public static void main(String[] args) {



        Connection cn = SqlDataManager.getConnection();

        if (cn != null) {
            System.out.println("¡Conexión establecida con mercaDaw! 🦸‍♂️");
        } else {
            System.out.println("No se pudo conectar. Revisa la consola para ver el error.");
        }
    }
}