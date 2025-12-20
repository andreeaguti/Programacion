import java.time.LocalDate;
import java.util.Scanner;

public class programaAgenda {
    public static void main (String[] args) {
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
                    System.out.println("\n¿Qué vas a insertar? 1.Persona | 2.Empresa");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    // Datos comunes para TODOS
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = sc.nextLine();

                    if (tipo == 1) { // Persona
                        System.out.print("Año de nacimiento (AAAA): ");
                        int ano = sc.nextInt();
                        System.out.print("Mes de nacimiento (1-12): ");
                        int mes = sc.nextInt();
                        System.out.print("Día de nacimiento (1-31): ");
                        int dia = sc.nextInt();
                        sc.nextLine();

                        // Creamos el objeto LocalDate
                        LocalDate fecha = LocalDate.of(ano, mes, dia);

                        // Ahora sí, pasamos 'fecha' que es de tipo LocalDate
                        if (miAgenda.anadirContacto(new Persona(nombre, telefono, fecha))) {
                            System.out.println("Persona añadida.");
                        }else {
                            System.out.println("Nombre duplicado o agenda llena");
                        }
                    }
                    else if (tipo == 2) { // Empresa'
                        System.out.println("Pagina web: ");
                        String paginaWeb = sc.nextLine();
                        if (miAgenda.anadirContacto(new Empresa(nombre, telefono, paginaWeb))){
                            System.out.println("Empresa añadida.");
                        }else {
                            System.out.println("Nombre duplicado o agenda llena");
                        }

                    }
                    break;

                case 2:
                    System.out.print("Nombre a eliminar: ");
                    String n = sc.nextLine();

                    if (miAgenda.eliminarContacto(n)) {
                        System.out.println("Eliminado.");
                    }else
                        System.out.println("No encontrado.");
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
