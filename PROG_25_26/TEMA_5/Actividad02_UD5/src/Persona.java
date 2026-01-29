/*Ejercicio 03: Crea una clase Persona: con los atributos Nombre, DNI, FechaNacimiento (dato tipo
fecha). */

import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    public Persona(String nombre, String dni, LocalDate fechaNacimiento) throws NombreIncorrectoException, DniIncorrectoException{
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) throws NombreIncorrectoException{
        if (nombre == null) {
            throw new NombreIncorrectoException("El nombre no puede ser nulo");
        } else {
            this.nombre = nombre;
        }
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) throws DniIncorrectoException{
        if (dni == null) {
            throw new DniIncorrectoException("El dni no puede ser nulo");
        } else {
            this.dni = dni;
        }
    }
    public String getFechaNacimiento() {
        return fechaNacimiento.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append('}');
        return sb.toString();
    }
}
