import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static Set<Libro> biblioteca = new HashSet<>();

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {

            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    //crear producto

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":
                    biblioteca.guardarEnFichero();
                    break;
                case "5":
                    System.out.println("Guardando y cerrando programa...");
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
