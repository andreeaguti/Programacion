import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        ArrayList<String> libros = new ArrayList<String>();


        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {

            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    biblioteca.crearLibro();
                    break;
                case "2":
                    Biblioteca.mostrarLibros();
                    break;
                case "3":
                    Biblioteca.eliminarLibro();
                    break;
                case "4":
                    Biblioteca.guardarEnFichero();
                    break;
                case "5":
                    System.out.println("Guardando y cerrando programa...");
                    Biblioteca.guardarEnFichero();
                    break;
            }
        }while (!opcion.equals("5"));
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DE OPERACIONES ---");
        System.out.println("1. Crear Libro y registrarlo en la Biblioteca");
        System.out.println("2. Mostrar Libros existentes por (ISBN, titulo, Autor, Fecha)");
        System.out.println("3. Eliminar Libro por ISBN ");
        System.out.println("4. Guardar Libros en el fichero.");
        System.out.println("5. Guardar y Salir ");
        System.out.print("Seleccione una opción: ");
    }
}
