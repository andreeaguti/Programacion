import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import java.io.*;

public class GestionVideoDaw {

    private static Scanner sc = new Scanner(System.in);
    public static final String PATH = "Videodaw.dat";

    public static void main(String[] args) {
        VideoDaw miVideodaw = null;


        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();
            try {
                switch (opcion) {
                    case "1":
                        try {
                            System.out.println(" VIDEODAW ");
                            System.out.print("Introduzca el CIF: ");
                            String cif = sc.nextLine();

                            System.out.print("Introduzca la direccion: ");
                            String direccion = sc.nextLine();

                            List<Articulo> articulosRegistrados = new ArrayList<>();
                            List<Cliente> clientesRegistrados = new ArrayList<>();
                            List<Pelicula> peliculasRegistradas = new ArrayList<>();

                            miVideodaw = new VideoDaw(cif, direccion, LocalDate.now(), articulosRegistrados, clientesRegistrados, peliculasRegistradas);
                            System.out.println("\nVideoClub creado con éxito.\n");
                        } catch (Exception e) {
                            System.out.println("Error al crear la cuenta: " + e.getMessage());
                            return;
                        }
                        break;
                    case "2":
                        miVideodaw.registrarPelicula();
                        break;
                    case "3":
                        miVideodaw.registrarClientes();
                        break;
                    case "4":
                        miVideodaw.alquilarArticulo();
                        break;
                    case "6":
                        miVideodaw.darBajaCliente();
                        break;
                    case "7":
                        miVideodaw.darBajaArticulo();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }

        } while (!opcion.equals("8"));
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DE OPERACIONES ---");
        System.out.println("1. Crear y registrar VideoClub en la franquicia ");
        System.out.println("2. Registrar película en videoclub ");
        System.out.println("3. Crear y registrar cliente en videoclub ");
        System.out.println("4. Alquilar ");
        System.out.println("5. Devolver");
        System.out.println("6. Dar de baja cliente ");
        System.out.println("7. Dar de baja articulo");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    /*public static void abrirFichero(){
        final String path = ".\\src\\resources\\";
        String fileName = "Videodaw.dat";

        if (miVideodaw == null) {
            System.out.println("Error: El videoclub no está inicializado.");
            return;
        }

        try (FileReader file = new FileReader(path + fileName);
             BufferedReader bufferedReader = new BufferedReader(file);){
            String linea = "";
            while(linea != null){
                linea = bufferedReader.readLine();
                if(linea != null){
                    if(!linea.equals("")){
                        String[] datos = linea.split(",");
                        if (datos.length == 4){
                            String codigo = datos[0];
                            String titulo = datos[1];
                            Genero genero = Genero.valueOf(datos[2]);
                            boolean isAlquilada = Boolean.parseBoolean(datos[3]);

                            Pelicula p = new Pelicula(codigo, titulo, LocalDate.now(), null, genero, null, isAlquilada);

                            miVideodaw.getArticulosRegistrados().add(p);
                            miVideodaw.getPeliculasRegistradas().add(p);
                        }
                        System.out.println(linea);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }*/




}
