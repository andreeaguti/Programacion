import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class Alumno implements Serializable {

    //LO HACEMOS CUANDO HEMOS TERMINADO CON EL CÓDIGO!! Lo tienen que tener todas las clases***
    private static final long serialVersionUID = -4873232981990226003L;

    private String nombre;
    private String apellido;
    private int edad;
    private String email;

    private List<Calificacion> calificaciones;

    public Alumno(String nombre, String apellido, int edad, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.calificaciones = new LinkedList<>();
    }

    public void calificar(String asignatura, int nota) {
        this.calificaciones.add(new Calificacion(asignatura, nota));
    }
    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
