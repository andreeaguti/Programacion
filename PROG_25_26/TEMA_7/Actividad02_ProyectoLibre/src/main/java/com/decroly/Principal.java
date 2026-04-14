package com.decroly;

import com.decroly.excepciones.CineException;

import java.sql.Connection;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionCine cine = null;
        String archivo = "cine_decroly.dat";

        //INTENTO DE CARGA CON LA BASE DE DATOS
        Connection cn = SqlDataManager.getConnection();

        if (cn != null) {
            System.out.println("¡Conexión establecida!️");
        } else {
            System.out.println("No se pudo conectar. Revisa la consola para ver el error.");
        }

        //INTENTO DE CARGA ARCHIVO BINARIO
        try {
            cine = GestionCine.cargarDatos(archivo);
            System.out.println("DATOS CARGADOS CORRECTAMENTE");
        } catch (Exception e) {
            System.out.println("No se encontraron datos previos. Creando sistema nuevo...");
            try {
                cine = new GestionCine();
            } catch (CineException ex) {
                System.err.println("Error al inicializar: " + ex.getMessage());
                return;
            }
        }

        int opcion = 0;
        do {
            opcion = mostrarMenu(sc);

            switch (opcion) {
                case 1: // REGISTRAR PELÍCULA
                    System.out.println("\n--- REGISTRO DE PELÍCULA ---");
                    try {
                        System.out.print("Introduzca ID (número): ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Introduzca Título: ");
                        String titulo = sc.nextLine();

                        System.out.print("Introduzca Duración (minutos): ");
                        int duracion = Integer.parseInt(sc.nextLine());

                        System.out.print("Introduzca Género: ");
                        String genero = sc.nextLine();

                        Pelicula p = new Pelicula(id, titulo, duracion, genero);

                        //La guardo en el fichero y en la base de datos
                        cine.anadirPelicula(p);
                        SQLAccessProyectoLibre.insertPelicula(p);

                        System.out.println("¡Película registrada con éxito!");

                    } catch (NumberFormatException e) {
                        System.out.println("ERROR: El ID y la duración deben ser números.");
                    } catch (CineException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 2: // PROGRAMAR SESIÓN
                    System.out.println("\n--- CREAR SESIÓN PARA CARTELERA ---");
                    System.out.print("Introduce el nombre de la película para la sesión: ");
                    String nombrePeli = sc.nextLine();
                    Pelicula peliEncontrada = cine.buscarPeliculaPorNombre(nombrePeli);

                    if (peliEncontrada != null) {
                        try {
                            System.out.print("ID de la sesión: ");
                            int idS = Integer.parseInt(sc.nextLine());
                            System.out.print("Hora: ");
                            String hora = sc.nextLine();

                            // Creo una sala
                            Sala salaProvisional = new Sala(1, 10, 10);

                            Sesion nuevaSesion = new Sesion(idS, peliEncontrada, salaProvisional, hora);

                            cine.anadirSesion(nuevaSesion);

                            System.out.println("¡Sesión añadida a la cartelera!");
                        } catch (Exception e) {
                            System.out.println("Error al crear sesión: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Error: Esa película no existe en el catálogo. Regístrala primero.");
                    }
                    break;

                case 3: // MOSTRAR CARTELERA
                    cine.mostrarCartelera();
                    break;

                case 4: // REGISTRAR USUARIO
                    System.out.println("\nREGISTRO DE USUARIO");
                    try {
                        System.out.print("Introduzca ID de usuario: ");
                        int idU = Integer.parseInt(sc.nextLine());
                        System.out.print("Nombre: ");
                        String nombreU = sc.nextLine();
                        System.out.print("Email: ");
                        String emailU = sc.nextLine();

                        Usuario user = new Usuario(idU, nombreU, emailU);

                        cine.anadirUsuario(user);
                        SQLAccessProyectoLibre.insertUsuario(user);

                        System.out.println("Usuario guardado.");

                    } catch (CineException e) {
                        System.out.println("ERROR: " + e.getMessage());
                    }
                    break;

                case 5: // VENDER ENTRADA
                    System.out.println("\nVENTA DE ENTRADAS");
                    try {
                        System.out.print("Precio base: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.println("¿Tipo? (1-Normal, 2-Estudiante): ");
                        String tipo = sc.nextLine();

                        Entrada e;
                        if (tipo.equals("2")) {
                            e = new EntradaEstudiante(1, 101, 5, 5, precio);
                        } else {
                            e = new EntradaNormal(1, 101, 5, 5, precio);
                        }

                        cine.venderEntrada(e);
                        SQLAccessProyectoLibre.insertVenta(e);

                    } catch (Exception e) {
                        System.out.println("Error en la venta: " + e.getMessage());
                    }
                    break;

                case 6: // VER VENTAS
                    cine.mostrarVentas();
                    break;

                case 7: // GUARDAR Y SALIR
                    System.out.println("Guardando datos en el archivo binario...");
                    try {
                        cine.guardarDatos(archivo);
                        System.out.println("¡Datos guardados! Saliendo del sistema...");
                    } catch (Exception e) {
                        System.err.println("No se pudo guardar: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 7);
    }

    // METODO MENU
    public static int mostrarMenu(Scanner sc) {
        System.out.println("\n********** CINE DECROLY 2026 **********");
        System.out.println("1. Registrar Película");
        System.out.println("2. Programar Sesión");
        System.out.println("3. Ver Cartelera");
        System.out.println("4. Registrar Usuario");
        System.out.println("5. Vender Entrada ");
        System.out.println("6. Ver Registro de Ventas");
        System.out.println("7. Salir y Guardar");
        System.out.print("Seleccione una opción: ");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}