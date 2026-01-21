import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n--- MENÚ  ---");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                case 2:
            }
        } while (opcion != 0);

    }
}