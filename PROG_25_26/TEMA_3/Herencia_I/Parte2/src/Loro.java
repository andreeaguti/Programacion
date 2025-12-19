import java.time.LocalDate;

public class Loro extends Aves {

    private String origen;
    private boolean habla;

    public Loro(String nombre, int edad, String estado, LocalDate fechaNacimiento, String pico, boolean vuela, String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }

    //getter y setter
    public String getOrigen() {
        return origen;
    }
    public boolean isHabla() {
        return habla;
    }
    public void setHabla(boolean habla) {
        this.habla = habla;
    }

    @Override
    public String vuela() {
        return "Soy un loro y puedo volar";
    }

    @Override
    public String muestra() {
        return "Hola soy un:" + getClass().getSimpleName() + "y me llamo " + super.nombre;
    }

    @Override
    public String habla() {
        return "Hola soy un: " + getClass().getSimpleName() + " y puedo hablar contigo";
    }
}
// "this" accede a esta clase y "super" accede la clase padre
// getSimpleName(): esto extrae el nombre de esta clase
