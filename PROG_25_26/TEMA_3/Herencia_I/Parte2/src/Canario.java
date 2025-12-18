import java.time.LocalDate;

public class Canario extends Aves {

    private String color;
    private boolean canta;

    public Canario(String nombre, int edad, String estado, LocalDate fechaNacimiento, String pico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public boolean isCanta() {
        return canta;
    }
    public void setCanta(boolean canta) {
        this.canta = canta;
    }

    @Override
    public String vuela() {
        return "Soy un canario y puedo volar";
    }

    @Override
    public String muestra() {
        return "Hola soy un: " + getClass().getSimpleName() + "y me llamo " + super.nombre;
    }

    @Override
    public String habla() {
        return "Hola soy un: " + getClass().getSimpleName() + " y puedo hablar contigo";
    }

}
