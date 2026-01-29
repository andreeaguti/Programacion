/*Ejercicio 5:Modifica la clase Movimiento() para que use tipo de dato con fecha y hora. Modifica el
metodo toString() para que muestre toda la información del movimiento y elimina el
metodo mostrarInfoMovimiento(). */

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private int id;
    private LocalDateTime fecha;
    private Tipo tipo;
    private double cantidad;

    private static int contadorMovimiento = 0;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    public Movimiento() {}

    public Movimiento(Tipo tipo, double cantidad) {
        this.id = contadorMovimiento;
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.cantidad = cantidad;

        contadorMovimiento++;
    }

    public int getId() {
        return this.id;
    }

    public LocalDateTime getFecha() {
        return this.fecha;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movimiento{");
        sb.append("id=").append(id);
        sb.append(", fecha='").append(fecha).append('\'');
        sb.append(", tipo=").append(tipo);
        sb.append(", cantidad=").append(cantidad);
        sb.append(", dtf=").append(dtf);
        sb.append('}');
        return sb.toString();
    }
}
