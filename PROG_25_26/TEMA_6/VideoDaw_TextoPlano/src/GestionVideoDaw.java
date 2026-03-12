import java.util.Scanner;
import java.time.LocalDate;
import java.io.IOException;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoDaw miVideoclub = new VideoDaw("A12345678", "Avda. Principal 1", LocalDate.now());
        String fichero = "articulos.txt";

        int opcion = 0;
        do {
            System.out.println("\n--- GESTIÓN TXT VIDEODAW ---");
            System.out.println("1. Registrar Película (Prueba)");
            System.out.println("2. Guardar en TXT");
            System.out.println("3. Cargar desde TXT");
            System.out.println("4. Mostrar Artículos");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        miVideoclub.getArticulosRegistrados().add(new Pelicula("P-001", "Inception", Genero.ACCION));
                        System.out.println("Película de prueba añadida.");
                        break;
                    case 2:
                        miVideoclub.guardarArticulosTXT(fichero);
                        System.out.println("Datos volcados al archivo TXT.");
                        break;
                    case 3:
                        miVideoclub.cargarArticulosTXT(fichero);
                        System.out.println("Datos recuperados del archivo TXT.");
                        break;
                    case 4:
                        for(Articulo a : miVideoclub.getArticulosRegistrados()) {
                            System.out.println(a);
                        }
                        break;
                    case 5:
                        System.out.println("Cerrando...");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        } while (opcion != 5);
    }
}

//MENU MIXTO
/*import java.util.Scanner;
import java.time.LocalDate;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VideoDaw videoDaw = new VideoDaw("A123", "Calle Luna", LocalDate.now());

        int opcion = 0;
        do {
            System.out.println("\n--- SISTEMA DE PERSISTENCIA MIXTO ---");
            System.out.println("1. Registrar Película Prueba");
            System.out.println("2. Guardar BINARIO (.dat)");
            System.out.println("3. Cargar BINARIO (.dat)");
            System.out.println("4. Exportar TXT (.txt)");
            System.out.println("5. Importar TXT (.txt)");
            System.out.println("6. Mostrar Artículos");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        videoDaw.getArticulosRegistrados().add(new Pelicula("P-001", "Origen", Genero.ACCION));
                        System.out.println("OK."); break;
                    case 2:
                        videoDaw.guardarBinario("datos.dat");
                        System.out.println("Binario guardado."); break;
                    case 3:
                        videoDaw = VideoDaw.cargarBinario("datos.dat");
                        System.out.println("Binario cargado."); break;
                    case 4:
                        videoDaw.exportarTXT("datos.txt");
                        System.out.println("TXT exportado."); break;
                    case 5:
                        videoDaw.importarTXT("datos.txt");
                        System.out.println("TXT importado."); break;
                    case 6:
                        for(Articulo a : videoDaw.getArticulosRegistrados()) System.out.println(a);
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 7);
    }
}*/