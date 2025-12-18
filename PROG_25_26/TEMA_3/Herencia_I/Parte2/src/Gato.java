public class Gato extends Mascotas {

    private String color;
    private boolean peloLargo;

    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    public String getColor() {
        return color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    @Override
    public String muestra() {
        return "";
    }

    @Override
    public String habla() {
        return "Soy un gato ";
    }

    public void saluda() {
        System.out.println(nombre + " te lame en señal de saludo.");
    }
}