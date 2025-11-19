

public class CuentaBancaria {

//Creo los contadores que necesito
    private static final double saldoMinimo = -50.0;
    private static final double maximoMovimientos = 100;
    private static final double maximoHacienda = 0.0;

//ARRAY
    private Movimiento [] movimientos;

//Lo primero hacemos la encapsulación
    private final String IBAN;
    private final String titular;
    private double saldo;

    private int numMovimientos;

//Creo constructores con los atributos que se necesitan
public CuentaBancaria(String IBAN, String titular, double saldo, int movimientos) {
    this.IBAN = IBAN;
    this.titular = titular;
    this.saldo = saldo;
    this.movimientos = new Movimiento;
    }




















/**
package dawbank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

    public class CuentaBancaria {

        // --- 1. CONSTANTES (Valores fijos para todas las cuentas) ---
        private static final double SALDO_MINIMO = -50.0;
        private static final double LIMITE_NOTIFICACION_HACIENDA = 3000.0;
        private static final int MAX_MOVIMIENTOS = 100;

        // --- 2. ATRIBUTOS ---
        private final String iban;     // Inmutable, requerido en el constructor
        private final String titular;  // Inmutable, requerido en el constructor
        private double saldo;          // Dinero en euros
        private Movimiento[] movimientos; // Array para el histórico
        private int numMovimientos;    // Contador de movimientos realizados

        // --- 3. CONSTRUCTOR ---

        /**
         * Constructor que inicializa la cuenta.
         * @param iban El IBAN a validar.
         * @param titular El nombre del titular (no puede ser nulo/vacío).
         * @throws IllegalArgumentException Si la validación falla.
         */
        public CuentaBancaria(String iban, String titular) throws IllegalArgumentException {
            // Debes implementar:
            // 1. Validar el IBAN usando el método validarIBAN(). Si falla, lanzar excepción.
            // 2. Validar que el titular no esté vacío. Si falla, lanzar excepción.
            // 3. Asignar this.iban y this.titular.
            // 4. Inicializar this.saldo = 0.0;
            // 5. Inicializar this.movimientos = new Movimiento[MAX_MOVIMIENTOS];
            // 6. Inicializar this.numMovimientos = 0;
        }

        // --- 4. LÓGICA DE VALIDACIÓN ---

        /**
         * Valida el formato del IBAN: 2 letras + 22 números.
         * @param iban El IBAN a comprobar.
         * @return true si es válido, false en caso contrario.
         */
        private boolean validarIBAN(String iban) {
            // Debes implementar la lógica de validación usando Expresiones Regulares
            // Pista: ^[A-Z]{2}[0-9]{22}$

            return false; // Cambia este valor al implementar la lógica
        }

        // --- 5. LÓGICA DE OPERACIONES ---

        /**
         * Registra un movimiento en el array histórico.
         * Debe verificar si MAX_MOVIMIENTOS se ha excedido.
         * @param movimiento El objeto Movimiento a guardar.
         */
        private void registrarMovimiento(Movimiento movimiento) {
            // Implementar la lógica para añadir el movimiento al array
            // y gestionar el contador numMovimientos.
        }

        /**
         * Realiza un ingreso en la cuenta.
         * @param cantidad Cantidad a ingresar.
         * @return true si el ingreso es válido y se realiza.
         */
        public boolean ingresar(double cantidad) {
            // 1. Validar que la cantidad sea > 0.
            // 2. Actualizar el saldo.
            // 3. Registrar el movimiento usando new Movimiento("Ingreso", cantidad).
            // 4. Mostrar AVISO: Notificar a hacienda si cantidad > LIMITE_NOTIFICACION_HACIENDA.
            // 5. Mostrar AVISO: Saldo negativo si el nuevo saldo es < 0.
            return false; // Cambia este valor al implementar la lógica
        }

        /**
         * Realiza una retirada de la cuenta.
         * @param cantidad Cantidad a retirar.
         * @return true si la retirada es válida y se realiza.
         */
        public boolean retirar(double cantidad) {
            // 1. Validar que la cantidad sea > 0.
            // 2. Calcular el saldo futuro.
            // 3. Validar que el saldo futuro no sea inferior a SALDO_MINIMO (-50€).
            // 4. Actualizar el saldo.
            // 5. Registrar el movimiento usando new Movimiento("Retirada", cantidad).
            // 6. Mostrar AVISO: Notificar a hacienda si cantidad > LIMITE_NOTIFICACION_HACIENDA.
            // 7. Mostrar AVISO: Saldo negativo si el nuevo saldo es < 0.
            return false; // Cambia este valor al implementar la lógica
        }

        // --- 6. MÉTODOS DE CONSULTA (Getters) ---

        public String getIban() {
            return this.iban;
        }

        public String getTitular() {
            return this.titular;
        }

        public double getSaldo() {
            return this.saldo;
        }

        /**
         * Muestra todos los datos de la cuenta.
         */
        public void mostrarDatosCuenta() {
            System.out.println("   IBAN: " + this.iban);
            System.out.println("   Titular: " + this.titular);
            System.out.println("   Saldo: " + String.format("%.2f", this.saldo) + " €");
        }

        /**
         * Muestra el histórico de movimientos.
         */
        public void mostrarMovimientos() {
            // Debes iterar desde i=0 hasta numMovimientos
            // y llamar al método de mostrar de cada objeto Movimiento.
        }
    }














}
