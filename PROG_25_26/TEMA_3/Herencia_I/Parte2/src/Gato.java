public class Gato extends Mascotas {

    protected String color;
    protected boolean peloLargo;

    public Gato(String nombre, int edad, String estado, String fechaNacimiento, String color, boolean peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }

    @Override
    public void muestra() {
        System.out.println("--- Gato: " + nombre + " ---");
        System.out.println("Color: " + color + ", Pelo Largo: " + (peloLargo ? "Sí" : "No"));
        System.out.println("Edad: " + edad + " años, Estado: " + estado);
    }

    @Override
    public void habla() {
        System.out.println(nombre + " dice: Miau");
    }

    public void saluda() {
        System.out.println(nombre + " te lame en señal de saludo.");
    }
}