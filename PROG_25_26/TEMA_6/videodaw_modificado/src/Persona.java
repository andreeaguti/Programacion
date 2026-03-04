import java.time.LocalDate;

public class Persona {
//dni, nombre, direccion, fecha nacimiento

    private String dni;
    private String nombre;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) throws DniIncorrectoException{
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setDni(String dni) throws DniIncorrectoException{
        if(this.dni==null){
            throw new DniIncorrectoException("El dni no puede ser nulo");
        }else {
            this.dni = dni;
        }
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if(getFechaNacimiento() < 18){}
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("dni='").append(dni).append('\'');
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
}
