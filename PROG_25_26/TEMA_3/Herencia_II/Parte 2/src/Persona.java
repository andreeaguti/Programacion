import java.time.LocalDate;

public class Persona extends Contacto{

    private LocalDate cumpleanos;

    public Persona(String nombre, String telefono,  LocalDate cumpleanos) {
        super(nombre, telefono);
        this.cumpleanos = cumpleanos;
    }
    public LocalDate getCumpleanos() {
        return cumpleanos;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", cumpleanos=" + cumpleanos +
                '}';
    }
}
