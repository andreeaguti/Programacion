import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario miInventario = new Inventario("Tienda DAW", 100);
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE INVENTARIO =====");
            System.out.println("1. Mostrar lista (Tipo y Nombre)");
            System.out.println("2. Mostrar un animal concreto");
            System.out.println("3. Mostrar todos los datos de todos");
            System.out.println("4. INSERTAR ANIMAL"); // <--- Aquí está el cambio
            System.out.println("5. Eliminar animal");
            System.out.println("6. Vaciar inventario");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 4:
                    System.out.println("\n¿Qué vas a insertar? 1.Perro | 2.Gato | 3.Canario | 4.Loro");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    // Datos comunes para TODOS
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Estado: ");
                    String estado = sc.nextLine();
                    LocalDate fecha = LocalDate.now();

                    if (tipo == 1) { // PERRO
                        System.out.print("Raza: ");
                        String raza = sc.nextLine();
                        miInventario.insertarMascota(new Perro(nombre, edad, estado, fecha, raza, false));
                    }
                    else if (tipo == 2) { // GATO
                        miInventario.insertarMascota(new Gato(nombre, edad, estado, fecha));
                    }
                    else if (tipo == 3) { // CANARIO
                        System.out.print("Color: ");
                        String color = sc.nextLine();
                        System.out.print("¿Canta? (true/false): ");
                        boolean canta = sc.nextBoolean();
                        // El constructor de Canario pide: nombre, edad, estado, fecha, pico, vuela, color, canta
                        miInventario.insertarMascota(new Canario(nombre, edad, estado, fecha, "Corto", true, color, canta));
                    }
                    else if (tipo == 4) { // LORO
                        System.out.print("Origen: ");
                        String origen = sc.nextLine();
                        System.out.print("¿Habla? (true/false): ");
                        boolean habla = sc.nextBoolean();
                        // El constructor de Loro pide: nombre, edad, estado, fecha, pico, vuela, origen, habla
                        // OJO: Si tu constructor de Loro pide String para fecha, cámbialo a LocalDate en la clase Loro.
                        miInventario.insertarMascota(new Loro(nombre, edad, estado, fecha, "Curvo", true, origen, habla));
                    }
                    System.out.println("¡Mascota añadida!");
                    break;

                case 1: System.out.println(miInventario.mostrarInfoBasicaMascotas()); break;
                case 2:
                    System.out.print("Índice: ");
                    System.out.println(miInventario.mostrarInfoMascota(sc.nextInt()));
                    break;
                case 3: System.out.println(miInventario.mostrarInfoTodasMascotas()); break;
                case 5:
                    System.out.print("Nombre a eliminar: ");
                    String n = sc.nextLine();
                    // Usamos un Gato temporal para buscar el nombre (funciona igual con Perro)
                    if (miInventario.eliminarMascota(new Gato(n, 0, "", LocalDate.now())))
                        System.out.println("Eliminado.");
                    else System.out.println("No encontrado.");
                    break;
                case 6: miInventario.vaciarInventario(); break;
            }
        } while (opcion != 0);
    }
}