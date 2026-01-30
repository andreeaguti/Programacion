import java.util.Scanner;

public class DawBank {
    public static void main(String[] args) {
        Scanner sc;

        String opcion = "";

        do{
            sc = new Scanner(System.in);

            imprimirMenuOpciones();
            opcion = sc.nextLine();

            CuentaBancaria miCuenta = null;

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
                    System.out.println("El saldo es: " + miCuenta.getSaldo());
                    break;

                case "5":
                    ingresar(miCuenta);
                    break;

                case "6":
                    retirar(miCuenta);
                    break;

                case "7":
                    System.out.println(miCuenta.infoMovimientos());
                    break;

                case "8":
                    System.out.println("Gracias por elegir DawBANk, hasta la proxima.");
                    break;

                default:
                    System.out.println("Por favor, escoja la opcion correcta (1-8) ejem ejem ejem tonto");
            }

        }while(!opcion.equals("8"));

    }

    private static void imprimirMenuOpciones() {
        System.out.println("Escoja la opcion que desee");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
    }
}