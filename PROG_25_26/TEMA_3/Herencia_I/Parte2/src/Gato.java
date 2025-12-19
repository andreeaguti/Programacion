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
        final StringBuilder sb = new StringBuilder("Gato{");
        sb.append("color='").append(color).append('\'');
        sb.append(", peloLargo=").append(peloLargo);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", estado='").append(estado).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
}
// "this" busca en la clase y "super" busca en la clase padre
// getSimpleName(): esto extrae el nombre de esta clase