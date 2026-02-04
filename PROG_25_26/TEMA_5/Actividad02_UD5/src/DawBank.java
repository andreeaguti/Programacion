import java.time.LocalDate;
import java.util.Scanner;

public class DawBank {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        CuentaBancaria miCuenta = null;

        try {
            System.out.println(" DAWBANK ");
            System.out.print("Introduzca nombre del titular: ");
            String nombre = sc.nextLine();

            System.out.print("Introduzca DNI: ");
            String dni = sc.nextLine();

            System.out.print("Introduzca teléfono: ");
            String telefono = sc.nextLine();

            // He puesto datos de ejemplo para fecha, email y dirección, puedes pedirlos por Scanner si prefieres
            Cliente cliente = new Cliente(nombre, dni, LocalDate.of(1990, 1, 1), telefono, "andrea@gmail.es", "Calle San Fernando");

            System.out.print("Introduzca el IBAN: ");
            String IBAN = sc.nextLine();

            miCuenta = new CuentaBancaria(IBAN, cliente);

            System.out.println("\nCuenta creada con éxito.\n");

        } catch (Exception e) {
            System.out.println("Error al crear la cuenta: " + e.getMessage());
            return;
        }

        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(miCuenta.infoCuentaBancaria());
                    break;
                case "2":
                    System.out.println("El IBAN es: " + miCuenta.getIBAN());
                    break;
                case "3":
                    System.out.println("El Titular es: " + miCuenta.getCliente());
                    break;
                case "4":
                    System.out.println("El saldo actual es: " + miCuenta.getSaldo() + "€");
                    break;
                case "5":
                    realizarIngreso(miCuenta);
                    break;
                case "6":
                    realizarRetirada(miCuenta);
                    break;
                case "7":
                    try {
                        System.out.println(miCuenta.infoMovimientos());
                    } catch (NoHayMovimientosException e) {
                        System.out.println("Aviso: " + e.getMessage());
                    }
                    break;
                case "8":
                    System.out.println("Cerrando DawBank.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("8"));
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DE OPERACIONES ---");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Metodo para ingresos
    private static void realizarIngreso(CuentaBancaria cuenta) {
        try {
            System.out.print("Cantidad a ingresar: ");
            double cantidad = Double.parseDouble(sc.nextLine());
            cuenta.ingresar(cantidad);
            System.out.println("Ingreso realizado.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número válido.");
        } catch (AvisarHaciendaException e) {
            System.out.println("NOTIFICACIÓN: " + e.getMessage());
        } catch (CuentaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Metodo para retiradas
    private static void realizarRetirada(CuentaBancaria cuenta) {
        try {
            System.out.print("Cantidad a retirar: ");
            double cantidad = Double.parseDouble(sc.nextLine());
            cuenta.retirar(cantidad);
            System.out.println("Retirada realizada.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe introducir un número válido.");
        } catch (AvisarHaciendaException e) {
            System.out.println("NOTIFICACIÓN: " + e.getMessage());
        } catch (CuentaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}