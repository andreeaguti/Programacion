public class Loro extends Ave {
    protected String origen;
    protected boolean habla;

    public Loro(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela, String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }

    @Override
    public void muestra() {
        System.out.println("Loro: " + nombre);
        System.out.println("Origen: " + origen + ", Puede Hablar ");
        System.out.println("Pico: " + pico + ", Vuela: " + vuela + ", Edad: " + edad);
    }

    @Override
    public void habla() {
        if (habla) {
            System.out.println(nombre + " dice: ¡Hola!");
        } else {
            System.out.println(nombre + " hace ruido.");
        }
    }
}
