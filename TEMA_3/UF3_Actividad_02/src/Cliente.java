import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cliente {

    //HACEMOS LA ENCAPSULACION

    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula [] peliculasAlquiladas;

    //CREAMOS LOS CONSTRUCTORES
    public Cliente (String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento){
        this.setdni(dni);
        this.nombre = nombre;
        this.setnumSocio(numSocio);
        this.direccion = direccion;
        this.setfechaNacimiento(fechaNacimiento);
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Pelicula[10];
    }
    //DEFINO GETTERS
    public String getDni() {
        return dni;
    }
    public String getNombre() {
        return nombre;
    }
    public String getNumSocio() {
        return numSocio;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    //DEFINO SETTERS
    public void setdni(String dni) {
        this.dni = dni;
    }
    public void setnumSocio(String numSocio) {
        this.numSocio = numSocio;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setfechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

//METODO PARA MOSTRAR INFORMACIÓN DEL CLIENTE
public String mostrarInfoCliente(){
    String mostrarInfoCliente = "";
    mostrarInfoCliente = "DNI: " + this.getDni() + "\n";
    mostrarInfoCliente = "Nombre: " + this.getNombre() + "\n";
    mostrarInfoCliente = "Numero de socio: " + this.getNumSocio() + "\n";
    mostrarInfoCliente = "Dirección: " + this.getDireccion() + "\n";
    mostrarInfoCliente = "Fecha de nacimiento: " + this.getFechaNacimiento() + "\n";
    mostrarInfoCliente = "Fecha de baja: " + this.getFechaBaja() + "\n";
    return mostrarInfoCliente;
}
//METODO PARA MOSTRAR ULTIMAS PELICULAS ALQUILADAS



























}
