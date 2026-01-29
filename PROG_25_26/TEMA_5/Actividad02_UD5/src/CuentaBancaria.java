import java.util.LinkedHashSet;
import java.util.Set;

public class CuentaBancaria {
    private String IBAN;
    private String titular;
    private double saldo;

    //VOY A UTILIZAR LINKEDHASHSET
    private Set<Movimiento> movimientos;
    //en los corchetes pueden ir String, Integer, Double o clases


    public CuentaBancaria(String IBAN, String titular) {
        this.IBAN = IBAN;
        this.titular = titular;

        this.movimientos = new LinkedHashSet<>();
        this.saldo = 0.0;

    }

    public String getIBAN() {
        return this.IBAN;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Set<Movimiento> getMovimientos() {
        return movimientos;
    }

    public boolean ingresar(double valor) {
        boolean retorno = false;
        double valorAbsoluto = Math.abs(valor);
        this.saldo += valorAbsoluto;
        retorno = true;
        //generar movimiento
        this.generarMovimiento(Tipo.INGRESO, valorAbsoluto);
        return retorno;
    }

    public boolean retirar(double valor) {
        boolean retorno = false;
        double valorAbsoluto = Math.abs(valor);
        if ((this.saldo - valorAbsoluto) >= -50) {
            this.saldo -= valorAbsoluto;
            this.generarMovimiento(Tipo.RETIRADA, valorAbsoluto);
            retorno = true;
        }
        return retorno;
    }


    public void generarMovimiento(Tipo tipo, double cantidad) {
        this.movimientos.add(new Movimiento(tipo, cantidad));
    }

    public String infoCuentaBancaria() {
        String info = "";
        info += "Titular: " + this.titular + "\n";
        info += "IBAN: " + this.IBAN + "\n";
        info += "Saldo: " + this.saldo + "\n";
        return info;

    }

    /*Metodo para mostrar información*/
    public String infoMovimientos() {
        if (movimientos.isEmpty()) {
            return "No hay movimientos";
        }

        StringBuilder info = new StringBuilder("--- Listado de Movimientos ---\n");
        for (Movimiento movimiento : movimientos) {
            // Asumiendo que Movimiento tiene un buen toString()
            info.append(movimiento).append("\n");
        }
        return info.toString();
    }
    }
