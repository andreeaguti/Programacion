import java.time.LocalDate;
import java.io.Serializable;

//CLASE MADRE DE LOS CLIENTES
//Si en tu videoclub no vas a crear objetos "Persona" a secas (solo Clientes o Empleados), podrías poner public abstract class Persona.
//Esto impide que alguien haga new Persona(...) por error.

public class Persona implements Serializable {
//Serializable: Fundamental para que los datos del cliente no se borren al cerrar el programa.

    private static final long serialVersionUID = -8277680958705568161L;

    //ATRIBUTOS
    protected String DNI;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;
//Usamos esta clase para la fecha de nacimiento porque no nos interesa la hora en la que nació el cliente, solo el día.

    //CONSTRUCTOR

    public Persona(String DNI, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }


    //GETTERS


    public String getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    //SETTERS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    //TOSTRING

    @Override
    public String toString() {
        return "Persona{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}//CIERRE CLASE PERSONA