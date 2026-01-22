import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Taller miTaller = new Taller();

        int opcion;

        do {
            System.out.println("\n--- MENÚ  ---");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Visualizar matrículas");
            System.out.println("4. Visualizar coches");
            System.out.println("5. Visualizar taller");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    miTaller.anadeElemento();
                    break;
                case 2:
                    miTaller.eliminaElemento();
                    break;
                case 3:
                    miTaller.visualizaMatriculas();
                    break;
                case 4:
                    miTaller.visualizaCoches();
                    break;
                case 5:
                    miTaller.visualizaTaller();
                    break;
            }
        } while (opcion != 0);

    }
}