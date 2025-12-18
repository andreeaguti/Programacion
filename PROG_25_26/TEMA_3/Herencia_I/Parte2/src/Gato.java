import java.time.LocalDate;

public class Gato extends Mascotas {

    private String color;
    private boolean peloLargo;


    public Gato(String nombre, int edad, String estado, LocalDate fechaNacimiento) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    //getter
    public String getColor() {
        return color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }


    @Override
    public String muestra() {
        return "Hola, soy un " + this.getClass().getSimpleName() + " y me llamo "+ super.nombre;
    }

    @Override
    public String habla() {
        return "Soy un" + this.getClass().getSimpleName() + " y hago miau miau";
    }

    @Override
    public String toString() {
        return "Gato{" +
                "color='" + color + '\'' +
                ", peloLargo=" + peloLargo +
                '}';
    } // no me deja coger los atributos de mascota

}
// "this" busca en la clase y "super" busca en la clase padre
// getSimpleName(): esto extrae el nombre de esta clase