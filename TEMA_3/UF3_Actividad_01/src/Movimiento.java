import java.time.LocalDate; //sin hora
import java.time.format.DateTimeFormatter;

public class Movimiento {

//Lo primero hacemos la encapsulación
    private final int ID;
    private final String fecha;
    private final String tipo; //Ingreso o retirada
    private final double cantidad; //crear un array

//Creo un contador para el ID del movimmiento y para asignar fecha
   private static int contadorMovimientos = 0;
   private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

//Creo constructores con los atributos que se necesitan, ID y fecha se generan automáticamente
    public Movimiento (String tipo, double cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;

        this.fecha = LocalDate.now().format(dtf);
        this.ID = contadorMovimientos++; //Para que no empieze en cero
    }

//Defino los getter y setter de los anteriores atributos
    public int getID(){
        return ID;
    }
    public String getFecha(){
        return this.fecha;
    }
    public String getTipo(){
        return this.tipo;
    }
    public double getCantidad(){
        return this.cantidad;
    }

//Para mostrar toda la información anterior

    public String infoMovimiento(){
        String infoMovimiento = "";
        infoMovimiento = "ID: " + this.ID + "\n";
        infoMovimiento += "Fecha: " + this.fecha + "\n";
        infoMovimiento += "Tipo: " + this.tipo + "\n";
        infoMovimiento += "Cantidad: " + this.cantidad + "\n";

    return infoMovimiento;
    }
}