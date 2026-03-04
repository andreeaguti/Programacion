/* Ejercicio 4: Crear una clase Cliente que herede de Persona y tenga los atributos/propiedades nº
teléfono, email, dirección. Modificar el metodo toString() para mostrar la información
correctamente. */
import java.time.LocalDate;

public class Cliente extends Persona{

    private String telefono;
    private String email;
    private String direccion;

    public Cliente(String nombre, String dni, LocalDate fechaNacimiento, String telefono, String email, String direccion) throws NombreIncorrectoException, DniIncorrectoException{

        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nombre='").append(this.getNombre()).append('\'');
        sb.append(", dni='").append(this.getDni()).append('\'');
        sb.append(", fecha nacimiento='").append(this.getFechaNacimiento()).append('\'');
        sb.append("telefono='").append(telefono).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


