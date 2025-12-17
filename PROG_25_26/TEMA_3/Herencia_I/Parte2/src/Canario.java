public class Canario extends Ave {
    protected String color;
    protected boolean canta;

    public Canario(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }

    @Override
    public void muestra() { // [cite: 83]
        System.out.println("--- Canario: " + nombre + " ---");
        System.out.println("Color: " + color + ", Canta: " + (canta ? "Sí" : "No"));
        System.out.println("Pico: " + pico + ", Vuela: " + vuela + ", Edad: " + edad);
    }

    @Override
    public void habla() {
        if (canta) {
            System.out.println(nombre + " está cantando una cancion.");
        } else {
            System.out.println(nombre + " emite un ruido suave.");
        }
    }
}
