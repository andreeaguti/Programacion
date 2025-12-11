import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Trabajador {
    //Hago la encapsulacion

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final Pattern DNI_PATTERN = Pattern.compile("^\\d{8}[A-Z]$");
    private static final Pattern NUMSS_PATTERN = Pattern.compile("^\\d{10}$");

    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numSS; //10 digitos

    //creamos constructores
    public Trabajador(String nombre, LocalDate fechanacimiento, String dni, String direccion, String numSS) {
        //sin estas validaciones si el usuario ingresa el dni o numSS mal lo creara igualmente
        if (!DNI_PATTERN.matcher(dni).matches()) {
            throw new IllegalArgumentException("DNI invalido");
        }
        if (!NUMSS_PATTERN.matcher(numSS).matches()) {
            throw new IllegalArgumentException("numSS invalido");
        }
        this.nombre = nombre;
        this.fechaNacimiento = fechanacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.numSS = numSS;
    }
    //getters
    public String getNombre() {
        return nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public String getDni() {
        return dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getNumSS() {
        return numSS;
    }

    //setters
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setNumSS(String numSS) {
        this.numSS = numSS;
    }

    //METODOS

    public String mostrarInfoTrabajador() {
        return "Trabajador{" +
                "nombre='" + this.nombre + '\'' +
                ", fechaNacimiento=" + this.fechaNacimiento.format(formatter) +
                ", dni='" + this.dni + '\'' +
                ", direccion='" + this.direccion + '\'' +
                ", numSS=" + this.numSS + '\'' +
                '}';
    }
    //me pone en el enunciado "o modificar el toString"
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trabajador{");
        sb.append("nombre='").append(this.nombre).append('\'');
        sb.append(", fechaNacimiento=").append(this.fechaNacimiento.format(formatter));
        sb.append(", dni='").append(this.dni).append('\'');
        sb.append(", direccion='").append(this.direccion).append('\'');
        sb.append(", numSS='").append(this.numSS).append('\'');
        return sb.toString();
    }
}

