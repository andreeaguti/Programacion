public class Gato {
    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws Exception {
        this.nombre = nombre;
        if (edad < 0) {
            throw new Exception("No puede tener menos de 0 años");
        } else {
            this.edad = edad;
        }
    }
}
