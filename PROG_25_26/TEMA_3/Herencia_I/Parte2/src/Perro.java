import java.time.LocalDate;

public class Perro extends Mascotas {

    private String raza;
    private boolean pulgas;

    public Perro(String nombre, int edad, String estado, LocalDate fechaNacimiento, String raza, boolean pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    // getter y setter
    public String getRaza() {
        return raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }
    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String muestra() {
        return "Hola, soy un " + this.getClass().getSimpleName() + "y me llamo" + super.nombre;
    }

    @Override
    public String habla() {
        return "Hola soy un " + this.getClass().getSimpleName() + "y hago guau guau";
    }

}

// "this" accede a esta clase y "super" accede la clase padre
// getSimpleName(): esto extrae el nombre de esta clase



