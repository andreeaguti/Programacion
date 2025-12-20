import java.util.Scanner;

public class ProgramaAgenda {
        public static void ProgramaAgenda (String[] args) {
            Scanner sc = new Scanner(System.in);
            Agenda miAgenda = new Agenda(100);
            int opcion;

            do {
                System.out.println("\n--- MENÚ AGENDA ---");
                System.out.println("1. Añadir contacto");
                System.out.println("2. Eliminar contacto");
                System.out.println("3. Listar toda la agenda");
                System.out.println("4. Buscar posición de un contacto");
                System.out.println("0. Salir");
                System.out.print("Elige una opción: ");

                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Introduce el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Introduce el teléfono: ");
                        String telefono = sc.nextLine();

                        Contacto nuevo = new Contacto(nombre, telefono);
                        if (miAgenda.anadirContacto(nuevo)) {
                            System.out.println("Contacto añadido correctamente.");
                        } else {
                            System.out.println("Error: No se pudo añadir (agenda llena o nombre duplicado).");
                        }
                        break;

                    case 2:
                        System.out.print("Nombre a eliminar: ");
                        String n = sc.nextLine();

                        if (miAgenda.eliminarContacto(n)) {
                            System.out.println("Eliminado.");
                        }else System.out.println("No encontrado.");
                        break;

                    case 3:
                        System.out.println(miAgenda.mostrarInfoTodosContactos());
                        break;
                    case 4:
                        System.out.print("Nombre a buscar: ");
                        String nomBuscar = sc.nextLine();
                        int pos = miAgenda.buscarContactoNombre(nomBuscar);
                        if (pos != -1) {
                            System.out.println("El contacto está en la posición: " + pos);
                        } else {
                            System.out.println("Contacto no encontrado.");
                        }
                        break;

                }
            } while (opcion != 0);
    }
}
