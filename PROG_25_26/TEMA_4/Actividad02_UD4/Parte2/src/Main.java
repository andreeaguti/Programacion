import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Agenda miAgenda = new Agenda();

        int opcion;

        do {
            System.out.println("\n--- MENÚ  ---");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Visualizar agenda");
            System.out.println("5. Numero de contactos de mi agenda");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    miAgenda.anadeContacto();
                    break;
                case 2:
                    miAgenda.buscarContacto();
                    break;
                case 3:
                    miAgenda.eliminarContacto();
                    break;
                case 4:
                    miAgenda.visualizaAgenda();
                    break;
                case 5:
                    miAgenda.numeroContactos();
                    break;
            }
        } while (opcion != 0);

    }
}