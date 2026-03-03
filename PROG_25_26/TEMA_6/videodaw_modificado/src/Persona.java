import java.time.LocalDate;

public class Persona {
//dni, nombre, direccion, fecha nacimiento

    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }


}
