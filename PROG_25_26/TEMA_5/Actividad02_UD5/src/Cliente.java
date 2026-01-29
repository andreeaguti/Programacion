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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("telefono='").append(telefono).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


