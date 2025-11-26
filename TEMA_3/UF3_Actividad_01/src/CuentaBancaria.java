public class CuentaBancaria {

//ENCAPSULACION DE ATRIBUTOS

    private String IBAN;
    private String titular;
    private double saldo;
    private Movimiento [] movimientos;
    private int contadorMovimientos = 0;

    //CREO CONSTRUCTORES DE LOS ATRIBUTOS
    public CuentaBancaria(String IBAN, String titular) {

        //VALIDACION PARA EL STRING TITULAR
        if (titular == null || titular.length() == 0) {
            System.out.println("El nombre del titular no puede estar vacio");
            this.IBAN = null;
            this.titular = null;
            return;
        }

        this.IBAN = IBAN;
        this.titular = titular;

        this.saldo = 0;
        this.movimientos = new Movimiento[100];
        this.contadorMovimientos = 0;

    }
//GETTERS Y SETTERS
        public String getIBAN () {
            return this.IBAN;
        }
        public String getTitular () {
            return this.titular;
        }
        public double getSaldo() {
            return this.saldo;
    }

//⭕️CREACION DE METODOS ⭕️

//PARA AÑADIR MOVIMIENTOS
        public void anadirMovimientos (Movimiento m){
            if (contadorMovimientos < movimientos.length) {
                movimientos[contadorMovimientos] = m;
                contadorMovimientos++;
            } else {
                System.out.println("Has superado el maximo de movimientos");
            }
        }

//PARA INGRESAR DINERO
        public void ingresar(double cantidad) {
            if (cantidad <= 0) {
                System.out.println("La cantidad a ingresar debe ser mayor a 0");
                return; //Se detiene
            }
            //actualizo el saldo
            this.saldo += cantidad;

            if (saldo < 0) {
                    System.out.println("AVISO: Estas en numeros rojos");
                }
            if (cantidad > 3000) {
                System.out.println("AVISO: Notificar a hacienda del ingreso");
            }

        //Registramos el movimiento
        Movimiento m = new Movimiento("Ingreso", cantidad);
        anadirMovimientos(m);
    }

//PARA REITRAR DINERO
    public void retirar (double cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad a retirar debe ser mayor a 0");
            return;
        }
        double saldoFinal = saldo - cantidad;

        if (saldoFinal < -50) {
            System.out.println("AVISO: saldo por debajo de lo permitido");
            return;
        }
        this.saldo = saldoFinal;

        if (cantidad > 3000) {
            System.out.println("AVISO: notificar a hacienda");
        }
        //Registramos el movimiento
        Movimiento m = new Movimiento("Retirada", cantidad);
        anadirMovimientos(m);
    }

//MOSTRAR DATOS DE LA CUENTA
        public String infoCuenta() {
        String infoCuenta = "";
            infoCuenta += "\n--- DATOS DE LA CUENTA BANCARIA ---";
            infoCuenta += "IBAN: " + IBAN + "\n";
            infoCuenta += "Titular: " + titular + "\n";
            infoCuenta += "Saldo: " + saldo + "€" + "\n";
            return infoCuenta;
        }

//MOSTRAR MOVIMIENTOS

    public void mostrarMovimientos() {
        System.out.println("\n HISTORIAL DE MOVIMIENTOS");

        //si todavia no hay movimientos
        if (contadorMovimientos == 0) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (int i = 0; i < contadorMovimientos; i++) {
            Movimiento m = movimientos[i];
            System.out.println("Movimiento " + (i + 1));
            System.out.print(m.infoMovimiento());
        }
    }

}



