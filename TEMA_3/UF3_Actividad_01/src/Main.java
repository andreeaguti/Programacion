import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = null;
        boolean datosValidos = false;

        // VALIDACIÓN DE LA CUENTA

        String ibanValido = MiUtils.comprobarPatronRepetidamente("[a-zA-Z]{2}[0-9]{22}", "Introduzca un IBAN");

        // 2. VALIDACIÓN DEL TITULAR
        while (!datosValidos) {

            System.out.print("Introduzca el nombre del titular: ");
            String titular = sc.nextLine();

            if (titular != null && !titular.trim().isEmpty()) {
        // Creo la cuenta del IBAN
            cuenta = new CuentaBancaria(ibanValido, titular);

                if (cuenta.getIBAN() != null) {
                    datosValidos = true;
                    System.out.println("Cuenta de: " + cuenta.getTitular() + " creada.");
                } else {
                    System.out.println(" Titular inválido");
                }
            } else {
                System.out.println(" Nombre del titular no puede estar vacío. Inténtelo de nuevo.");
            }
        }

        // CREO EL MENU PRINCIPAL
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println(cuenta.infoCuenta());
                    break;
                case 2: // IBAN
                    System.out.println("IBAN: " + cuenta.getIBAN());
                    break;
                case 3: // Titular
                    System.out.println("TITULAR: " + cuenta.getTitular());
                    break;
                case 4: // Saldo
                    System.out.println("SALDO: " + cuenta.getSaldo() + "€");
                    break;
                case 5: // Ingreso
                    realizarIngreso(sc, cuenta);
                    break;
                case 6: // Retirada
                    realizarRetirada(sc, cuenta);
                    break;
                case 7: // Movimientos
                    cuenta.mostrarMovimientos();
                    break;
                case 0:
                    System.out.println("\n Cerrando el programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("        MENÚ PRINCIPAL        ");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // ATENCIÓN: Estos métodos utilizan lectura directa que requiere entrada numérica.
    private static void realizarIngreso(Scanner scanner, CuentaBancaria cuenta) {
        System.out.print("Introduzca la cantidad a ingresar: ");
        double cantidad = Double.parseDouble(scanner.nextLine());
        cuenta.ingresar(cantidad);
    }

    private static void realizarRetirada(Scanner scanner, CuentaBancaria cuenta) {
        System.out.print("Introduzca la cantidad a retirar: ");
        double cantidad = Double.parseDouble(scanner.nextLine());
        cuenta.retirar(cantidad);
    }
}