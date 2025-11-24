import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {

//Creo los contadores que necesito
    private static final double saldoMinimo = -50.0;
    private static final int maximoMovimientos = 100;
    private static final double maximoHacienda = 3000.0;
    private static final int longitudIBAN = 24;

//ARRAY
    private final Movimiento [] movimientos;

//Lo primero hacemos la encapsulación con los atributos
    private String IBAN;
    private String titular;
    private double saldo;
    private int numMovimientos;
    private boolean CuentaValida; //Para comprobar que la cuenta es correcta

//Creo constructores con los atributos que se necesitan
public CuentaBancaria (String IBAN, String titular) {
    this.saldo = 0;
    this.movimientos = new Movimiento[maximoMovimientos];
    this.numMovimientos = 0;
    this.CuentaValida = false;

    //DECLARO COMO NULL A TITULAR E IBAN
    this.IBAN = null;
    this.titular = null;

//VALIDACION PARA EL STRING TITULAR
    if (titular == null || titular.length() == 0) {
        System.out.println("El nombre del titular no puede estar vacio");
    return;
    }

//SI LOS DATOS ESTAN CORRECTOS:
    this.CuentaValida = true;
    this.titular = titular;
    this.IBAN = IBAN.toUpperCase();
    System.out.println("Cuenta creada correctamente");
}

//Getters y setters
    public boolean getcuentaValida () {
        return CuentaValida;
    }
    public String getIBAN() {
        return IBAN;
    }
    public String getTitular() {
        return titular;
    }
    public double getSaldo() {
        return saldo;
    }

public void mostrarDatosCuenta() {
    if(!CuentaValida){
        System.out.println("La cuenta no es válida");
        return;
    }
    System.out.println("\n--- DATOS DE LA CUENTA BANCARIA ---");
    System.out.println("IBAN: " + IBAN);
    System.out.println("Titular: " + titular);
    System.out.println("Saldo: " + saldo + "€");
    }

    //PARA INGRESAR
    public boolean ingresar (double cantidad){
    if(!this.CuentaValida){
        System.out.println("ERROR: La cuenta no es válida.");
        return false;
    }
    if (cantidad <= 0) {
        System.out.println("ERROR: No puedes ingresar una cantidad menor o igual a 0");
        return false;
    }
    this.saldo += cantidad;
    //Registro el movimiento de ingreso
        if (numMovimientos < maximoMovimientos) {
        Movimiento m = new Movimiento("Ingreso", cantidad);
        this.movimientos[numMovimientos] = m;
        numMovimientos++;
        }else{
            System.out.println("Has superado el máximo de movimientos");
        }

//CREO LOS AVISOS
    if (cantidad > maximoHacienda){
        System.out.println("AVISO NOTIFICAR A HACIENDA; has ingresado mas de " + maximoHacienda + "€");
    }
    if (this.saldo < 0){
        System.out.println("AVISO SALDO NEGATIVO; saldo actual de "+ this.saldo + "€");
}
    System.out.println("Ingreso realizado con exito");
    return true;
    }

    //PARA REITRAR

    public boolean retirar (double cantidad){

    //COMPRUEBO EL SALDO
    if(!this.CuentaValida){
       System.out.println("Error: La cuenta no es valida");
       return false;
    }
    if(cantidad <= 0){
       System.out.println("La cantidad a retirar debe ser mayor a 0");
       return false;
    }

    double nuevoSaldo = this.saldo - cantidad;


    if (nuevoSaldo < saldoMinimo){
        System.out.println("ERROR: Supera el saldo maximo en negativo ");
        return false;
    }
    this.saldo = nuevoSaldo;

    //REGISTRO DE SALDOS
    if (numMovimientos < maximoMovimientos){
        Movimiento m = new Movimiento("Retirada", cantidad);
        this.movimientos[numMovimientos] = m;
        this.numMovimientos++;
    }else {
        System.out.println("Has superado el maximo de movimientos");
        }

    //AVISOS

    if (this.saldo < 0){
        System.out.println("AVISO: SALGO NEGATIVO");
    }

    if (cantidad > maximoHacienda){
        System.out.println("AVISO: notificar a hacienda");
    }

    System.out.println("Retirada realizada con exito ✅");
    return true;
    }

public void mostrarMovimientos(){
    if(!CuentaValida){
        System.out.println("Error: La cuenta no es valida");
        return;
    }
    if(numMovimientos == 0){
        System.out.println("No hay movimientos en la cuenta");
        return;
    }

    System.out.println("\n*** HISTORIAL DE MOVIMIENTOS ***");
    System.out.println("-------------------------------------------------");
    System.out.println("| ID   | Fecha      | Tipo     | Cantidad (€)   |");
    System.out.println("-------------------------------------------------");

    for (int i = 0; i < numMovimientos; i++) {
        Movimiento m = movimientos[i];
        System.out.println(m.getID() + m.getFecha() + m.getTipo() + m.getCantidad());
    }
    System.out.println("-------------------------------------------------");

    }
}
