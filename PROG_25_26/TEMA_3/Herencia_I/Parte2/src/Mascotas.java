import java.time.LocalDate;

public abstract class Mascotas {

    protected String nombre;
    protected int edad;
    protected String estado;
    protected LocalDate fechaNacimiento;

    public Mascotas(String nombre, int edad, String estado, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract String muestra(); //porque lo tienen más clases
    public abstract String habla(); //porque lo tienen más clases


    // Métodos
    public String cumpleanos() {
        String mensaje = "No es mi cumple";
        if (this.fechaNacimiento.getDayOfYear() == LocalDate.now().getDayOfYear()) {
            this.edad ++;
            mensaje = "Es mi cumple y cumplo " + this.edad  + "años";
        }
        return mensaje;
    }
    public String morir() {
        return "Siento dejar este mundo sin probar pipas facundo";
    }

    @Override
    public String toString() {
        return "Mascotas{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", estado='" + estado + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
//protected se pone en todas las clases abstratas que vayan a tener hijos
//public abstract String muestra(); //se pone asi, porque lo tienen más clases
// porque aqui no hacemos getter de todos los atributos?
// para que sirve el toString???