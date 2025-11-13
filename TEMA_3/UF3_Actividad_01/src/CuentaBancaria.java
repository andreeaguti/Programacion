public class CuentaBancaria {

//Lo primero hacemos la encapsulación
    private String IBAN;
    private String titular;
    private double saldo;
    private int movimientos; //crear un array

//Creo constructores con los atributos que se necesitan
public CuentaBancaria(String IBAN, String titular, double saldo, int movimientos) {
    this.IBAN = IBAN;
    this.titular = titular;
    this.saldo = saldo;
    this.movimientos =new movimientos;
    }

//Defino los getter y setter de los anteriores atributos

public String getIBAN() {
    return this.IBAN;
}
public String getTitular() {
    return this.titular;
}
public void setSaldo(double saldo) {
    this.saldo = saldo;
}



















}
