
import java.util.ArrayList;
import java.util.List;

public class Gato implements Comparable<Gato> {

    //atributos nombre y edad
    private String nombre;
    private int edad;

    private List<Gato> gatos;

    //constructor con parámetros
    public Gato(String nombre, int edad) throws NombreIncorrectoException, EdadIncorrectaException {
        this.setNombre(nombre);
        this.setEdad(edad);

        this.gatos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) throws NombreIncorrectoException {
        if (nombre.length() < 3) {
            throw new NombreIncorrectoException("El nombre debe tener al menos 3 carácteres");
        }else {
            this.nombre = nombre;
        }
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) throws EdadIncorrectaException {
        if (edad < 0) {
            throw new EdadIncorrectaException("No puede tener menos de 0 años");
        } else {
            this.edad = edad;
        }
    }
    public List<Gato> getGatos() {
        return gatos;
    }

    //metodo imprimir() para mostrar los datos de un gato
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Gato{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Gato o) {
    if(o != null){
        return Integer.compare(this.edad, o.edad);
    }
    return 1;
    }

}



