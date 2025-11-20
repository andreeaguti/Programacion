
public class CuentaBancaria {

//Creo los contadores que necesito
    private static final double saldoMinimo = -50.0;
    private static final double maximoMovimientos = 100;
    private static final double maximoHacienda = 3000.0;
    private static final int longitudIBAN = 24;

//ARRAY
    private final Movimiento [] movimientos;

//Lo primero hacemos la encapsulación con los atributos
    private final String IBAN;
    private final String titular;
    private double saldo;

    private int numMovimientos;

//Creo constructores con los atributos que se necesitan
public CuentaBancaria (String IBAN, String titular) {
    this.IBAN = IBAN.toUpperCase(); //Para que se traduzca a mayúsculas
    this.titular = titular;
    this.saldo = 0;
    this.movimientos = new Movimiento[maximoMovimientos];
    this.numMovimientos = 0;
}

//Instrucción para que el usuario introduzca un IBAN correcto

public static boolean IbanCorrecto(String IBAN){
    if (IBAN == null || IBAN.length() !=longitudIBAN){
        return false;
        System.out.println("Ingrese un IBAN correcto");
    }













}




















        // --- 4. Validación de IBAN (Método estático, usado por DawBank) ---
        /** Este método se mantiene sin cambios
        public static boolean validarIBAN(String iban) {
            if (iban == null || iban.length() != LONGITUD_IBAN_REQUERIDA) {
                return false;
            }

            String ibanUpperCase = iban.toUpperCase();

            if (!Character.isLetter(ibanUpperCase.charAt(0)) || !Character.isLetter(ibanUpperCase.charAt(1))) {
                return false;
            }

            for (int i = 2; i < LONGITUD_IBAN_REQUERIDA; i++) {
                if (!Character.isDigit(ibanUpperCase.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        // --- Getters y Métodos de Funcionalidad (No cambian: ingreso, retirada, etc.) ---

        // Métodos como getIban(), realizarIngreso(), mostrarMovimientos(), etc.
        // son idénticos a la versión anterior.

        public String getIban() { return iban; }
        public String getTitular() { return titular; }
        public double getSaldo() { return saldo; }

        private void registrarMovimiento(String tipo, double cantidad) {
            if (numMovimientos == MAX_MOVIMIENTOS) {
                for (int i = 0; i < MAX_MOVIMIENTOS - 1; i++) {
                    movimientos[i] = movimientos[i + 1];
                }
                movimientos[MAX_MOVIMIENTOS - 1] = new Movimiento(tipo, cantidad);
            } else {
                movimientos[numMovimientos] = new Movimiento(tipo, cantidad);
                numMovimientos++;
            }
        }

        public boolean realizarIngreso(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("❌ ERROR: La cantidad a ingresar debe ser superior a 0.");
                return false;
            }
            this.saldo += cantidad;
            registrarMovimiento("Ingreso", cantidad);
            System.out.printf("✅ Ingreso realizado. Nuevo saldo: %.2f€%n", this.saldo);
            verificarAvisos(cantidad);
            verificarAvisosSaldo();
            return true;
        }

        public boolean realizarRetirada(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("❌ ERROR: La cantidad a retirar debe ser superior a 0.");
                return false;
            }
            double nuevoSaldo = this.saldo - cantidad;
            if (nuevoSaldo < SALDO_MINIMO) {
                System.out.printf("❌ ERROR: La retirada excede el límite de saldo mínimo (%.2f€).%n", SALDO_MINIMO);
                return false;
            }
            this.saldo = nuevoSaldo;
            registrarMovimiento("Retirada", cantidad);
            System.out.printf("✅ Retirada realizada. Nuevo saldo: %.2f€%n", this.saldo);
            verificarAvisos(cantidad);
            verificarAvisosSaldo();
            return true;
        }

        public void mostrarDatosCuenta() {
            System.out.println("\n--- Datos de la Cuenta ---");
            System.out.println("  IBAN:    " + this.iban);
            System.out.println("  Titular: " + this.titular);
            System.out.printf("  Saldo:   %.2f€%n", this.saldo);
            System.out.println("---------------------------\n");
        }

        private void verificarAvisos(double cantidad) {
            if (cantidad > LIMITE_AVISO_HACIENDA) {
                System.out.println("\n*** ⚠️ AVISO: Notificar a hacienda por movimiento superior a " + LIMITE_AVISO_HACIENDA + "€ ***\n");
            }
        }

        private void verificarAvisosSaldo() {
            if (this.saldo < 0) {
                System.out.println("\n*** ⚠️ AVISO: Saldo negativo (la cuenta está en descubierto) ***\n");
            }
        }
    }











