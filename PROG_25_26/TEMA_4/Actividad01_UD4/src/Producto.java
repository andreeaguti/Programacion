import java.util.Objects;

public class Producto {

    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String verTipo() {
        if (this.cantidad > 50) {
            return "Producto demandado";
        } else {
            return "Producto Estándar";
        }
    }
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return cantidad == producto.cantidad && Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cantidad);
    }
}
