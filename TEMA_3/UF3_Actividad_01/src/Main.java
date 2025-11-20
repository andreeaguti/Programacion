import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    //Creo variable para la cuenta bancaria
    private static CuentaBancaria cuenta = null;

    public static void main(String[] args) {
        int opcion = -1;

        System.out.println("→ BIENVENIDO A DAWBANK ←");

        if (crearCuenta()) {
            mostrarMenu();
    }
        sc.close();
}
private static boolean crearCuenta() {

while (true) {
    System.out.print("Ingrese el IBAN de la cuenta (2 letras y 22 numeros): \n");
    String IBAN = sc.nextLine();

    System.out.println("Ingrese el nombre del titular");
    String titular = sc.nextLine();

    cuenta = new CuentaBancaria(IBAN, titular);

    if (cuenta.getcuentaValida()) {
    System.out.println( "\n CUENTA CREADA ");
    cuenta.mostrarDatosCuenta();
    return true;
    } else {
        System.out.println("Los datos son incorrectos");
    }
  }
}
private static void mostrarMenu() {
        String opcion = "8";
do {
    System.out.println("Selecciona una opcion");
    System.out.println("1. Datos de la cuenta ");
    System.out.println("2. Mostrar IBAN");
    System.out.println("3. Mostrar titular");
    System.out.println("4. Mostrar Saldo");
    System.out.println("5. Realizar un ingreso");
    System.out.println("6. Realizar una retirada");
    System.out.println("7. Mostar historial de movimientos");
    System.out.println("8. Salir");
    opcion = sc.nextLine();

    switch (opcion) {
        case "1":
            cuenta.mostrarDatosCuenta();
            break;
        case "2":
            System.out.println("IBAN" + cuenta.getIBAN());
            break;
        case "3":
            System.out.println("Titular" + cuenta.getTitular());
            break;
        case "4":
            System.out.println("Saldo" + cuenta.getSaldo());
            break;
        case "5":
            realizarIngreso();
            break;
        case "6":
            realizarRetirada();
            break;
        case "7":
            cuenta.infoMovimientos();
            break;
        case "8":
            System.out.println("Cerrando programa...");
        default:
            System.out.println("Por favor ingrese una opcion valida");
        }
    }while  (!opcion.equals ("8"));
}

    }