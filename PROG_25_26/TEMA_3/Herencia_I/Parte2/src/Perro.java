import java.time.LocalDate;

public class Perro extends Mascotas {

    private String raza;
    private boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fechaNacimiento, String raza,
                 boolean pulgas) {
        super (nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }



    @Override
    public String muestra() {
        return "";
    }

    @Override
    public String habla() {
        return "";
    }
}
    //super siempre indica que va a acceder a cosas de la clase padre




