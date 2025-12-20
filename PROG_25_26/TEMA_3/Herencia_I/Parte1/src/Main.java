import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventario miInventario = new Inventario("Ejercicio Astros", 10);
        int opcion;

        do {
            System.out.println("\n===== GESTIÓN DE INVENTARIO =====");
            System.out.println("1. Insertar Astro");
            System.out.println("2. Mostrar informacion de un astro concreto");
            System.out.println("3. Mostrar todos los datos de todos");
            System.out.println("0. Salir");
            System.out.print("Elige: ");

            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("\n¿Qué vas a insertar? 1.Planeta | 2.Satelite ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    // Datos comunes para TODOS
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Radio Ecuatorial (km): ");
                    Double radioEcuatorial = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Rotacion sobre su eje (h): ");
                    Double rotacion = sc.nextDouble();
                    System.out.print("Temperatura media: ");
                    Double temperatura = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) { // Planeta
                        System.out.print("Distancia al sol : ");
                        Double distanciaAlSol = sc.nextDouble();
                        System.out.print("Orbita al sol : ");
                        Double orbitaAlSol = sc.nextDouble();
                        System.out.print("¿Tiene satélites? (true/false): ");
                        boolean tieneSatelites = sc.nextBoolean();
                        sc.nextLine();
                        Planetas p = new Planetas(nombre, radioEcuatorial, rotacion, temperatura, distanciaAlSol, orbitaAlSol, tieneSatelites);
                        miInventario.insertarAstro(p);
                    }else if (tipo == 2) {
                        System.out.print("Distancia al planeta : ");
                        Double distanciaAlPlaneta = sc.nextDouble();
                        System.out.print("Orbita al planeta : ");
                        Double orbitaPlanetaria = sc.nextDouble();
                        System.out.print("Planeta al que pertenece ");
                        String planetaPertenece = sc.nextLine();
                        sc.nextLine();
                        Satelites s = new Satelites(nombre, radioEcuatorial, rotacion, temperatura, distanciaAlPlaneta, orbitaPlanetaria, planetaPertenece);
                        miInventario.insertarAstro(s);
                    }
                    System.out.println("Astro añadido");
                    break;
                case 2:
                    System.out.print("Índice: ");
                    System.out.println(miInventario.mostrarInfoAstro(sc.nextInt()));
                    break;
                case 3:
                    System.out.println(miInventario.mostrarInfoTodosAstros());
                    break;
            }
        }while (opcion != 0);
    }
}