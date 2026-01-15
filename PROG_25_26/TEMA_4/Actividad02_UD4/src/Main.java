import java.util.TreeSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    //Validación para nombre
        MiUtils.comprobarPatronRepetidamente("^[A-Z][a-zA-Z]*$", "Introduzca el nombre: ");
    //Validación para número de teléfono
        MiUtils.comprobarPatronRepetidamente("^[679][0-9]{8}$", "Introduzca el numero de teléfono: ");
    //Validación para el correo
        MiUtils.comprobarPatronRepetidamente("[a-z0-9._-]+@[a-z]+\\.[a-z]{2,4}", "Introduzca el correo: ");

        int opcion;

        do {
            System.out.println("\n--- MENÚ  ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Listar toda la agenda");
            System.out.println("4. Buscar posición de un contacto");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                case 2:
                case 3:
                case 4:
            }
        } while (opcion != 0);






    }
}