import java.util.Objects;

public class Persona {

    private String dni;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //Si es imposible que una persona no tenga telefono o email
    public Persona(String dni, String nombre, String apellido, String telefono, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    //Se usa para dar flexibilidad. estoy creando una persona y no me se el telefono o el email
    // me permite crear la persona sin que el programa me dé un error por falta de datos.
    public Persona(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = "";
        this.email = "";
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona{");
        sb.append("dni ='").append(dni).append('\'');
        sb.append(", nombre ='").append(nombre).append('\'');
        sb.append(", apellido ='").append(apellido).append('\'');
        sb.append(", telefono ='").append(telefono).append('\'');
        sb.append(", email ='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) { //El metodo es accesible desde cualquier sitio y solo puede devolver true o false siempre se pone (object o)
        if (o == null || getClass() != o.getClass()) return false;
        //(o == null) si el otro objeto no existe o..
        //getClass() != o.getClass()) si el otro objeto no es de la clase persona
        //return false; devuelve false
        Persona persona = (Persona) o;
        //Como ya sabemos que no es nulo y que es una Persona, le decimos a Java: "Trata a este objeto o como una Persona para que pueda leer sus atributos".
        return Objects.equals(dni, persona.dni) && Objects.equals(nombre, persona.nombre) && Objects.equals(apellido, persona.apellido);

    }

    @Override
    public int hashCode() { //cualquiera puede ver la huella de la persona, el hashcode va a ser un entero
        //el hashcode es un metodo que devuelve un número entero (int) que representa de forma rápida a un objeto en la memoria del ordenador
        return Objects.hash(dni, nombre, apellido);
    }
}
