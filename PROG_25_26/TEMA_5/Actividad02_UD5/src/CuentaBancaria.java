import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class CuentaBancaria {
    private String IBAN;
    private double saldo;

    //Debe de tener un atributo/propiedad de tipo cliente.
    private Cliente cliente;

    //Los movimientos deberán almacenarse en una colección en lugar de en un array. (LINKEDHASHSET)
    private Set<Movimiento> movimientos;
    //en los corchetes pueden ir String, Integer, Double o clases

    public CuentaBancaria(String IBAN, Cliente cliente) throws IbanIncorrectoException{
        this.setIBAN(IBAN);
        this.saldo = 0.0;
        this.cliente = cliente;
        this.movimientos = new LinkedHashSet<>();
    }

    //GETTER
    public String getIBAN() {
        return this.IBAN;
    }

    public double getSaldo() {
        return this.saldo;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    public Set<Movimiento> getMovimientos() {
        return movimientos;
    }

    //SETTER
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setIBAN(String IBAN) throws IbanIncorrectoException{
        if(IBAN.length()<23){
            throw new IbanIncorrectoException("El IBAN debe tener 23 carácteres");
        }else {
            this.IBAN = IBAN;
        }
    }

    public void setMovimientos(Set<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }

    public void ingresar(double valor) throws CuentaException, AvisarHaciendaException {
        if (valor <= 0) {
            throw new CuentaException("Saldo negativo");
        }

        this.saldo += valor;
        this.generarMovimiento(Tipo.INGRESO, valor);

        if(valor >= 3000) {
            throw new AvisarHaciendaException("Saldo igual o superior a 3000, se avisará a Hacienda");
        }
    }

    public void retirar(double valor) throws CuentaException, AvisarHaciendaException {
        double valorAbsoluto = Math.abs(valor);
        if ((this.saldo - valorAbsoluto) <= -50) {
            throw new CuentaException("Saldo insuficiente");
        }
        //generar movimiento
        this.saldo -= valorAbsoluto;
        this.generarMovimiento(Tipo.RETIRADA, valorAbsoluto);
        if(valor >= 3000) {
            throw new AvisarHaciendaException("Saldo igual o superior a 3000, se avisará a Hacienda");
        }
    }

    public void generarMovimiento(Tipo tipo, double cantidad) {
        this.movimientos.add(new Movimiento(tipo, cantidad));
    }

    public String infoCuentaBancaria() {
        String info = "";
        info += "Cliente: " + this.cliente + "\n";
        info += "IBAN: " + this.IBAN + "\n";
        info += "Saldo: " + this.saldo + "\n";
        return info;
    }

    /*Metodo para mostrar información*/
    public String infoMovimientos() throws NoHayMovimientosException{
        if (movimientos.isEmpty()) {
            throw new NoHayMovimientosException("No se encontro el movimiento");
        }
        StringBuilder info = new StringBuilder("--- Listado de Movimientos ---\n");
        for (Movimiento movimiento : movimientos) {

            info.append(movimiento).append("\n");
        }
        return info.toString();
    }
    }
