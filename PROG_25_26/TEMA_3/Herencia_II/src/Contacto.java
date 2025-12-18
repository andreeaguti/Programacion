public class Contacto {

    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
    public void mostrarContacto()
    {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Telefono: " + this.telefono);
    }
    public String getNombre() {
        return nombre;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
