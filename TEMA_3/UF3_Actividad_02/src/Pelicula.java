import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //HACEMOS LA ENCAPSULACION

    private String codigo;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    //CREAMOS LOS CONSTRUCTORES
public Pelicula (String codigo, String titulo, Genero genero){//solo lo que el usuario va a tener que introducir
    this.titulo = titulo;
    this.genero = genero;
    this.setCodigo(codigo); //cuando cree el setter me saldra bien

    this.fechaRegistro = LocalDate.now();
    this.fechaBaja = null;
    this.fechaAlquiler = null;
    this.isAlquilada = false;
}

    //DEFINO GETTERS
public String getCodigo() {
    return codigo;
}
public String getTitulo() {
    return titulo;
}
public Genero getGenero() {
    return genero;
}
public LocalDate getFechaRegistro() {
    return fechaRegistro;
}
public LocalDate getFechaBaja() {
    return fechaBaja;
}
public LocalDateTime getFechaAlquiler() {
    return fechaAlquiler;
}
public boolean isAlquilada() {
    return isAlquilada;
}
    //DEFINO SETTERS
public void setCodigo(String codigo) {
    this.codigo = codigo;
}
public void setTitulo(String titulo) {
    this.titulo = titulo;
}
public void setGenero(Genero genero) {
    this.genero = genero;
}
public void setFechaBaja(LocalDate fechaBaja) {
    this.fechaBaja = fechaBaja;
}
public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
    this.fechaAlquiler = fechaAlquiler;
}
public void setAlquilada(boolean isAlquilada) {
    this.isAlquilada = isAlquilada;
}

    //AHORA CREO UN METODO PARA MOSTRAR TODA LA INFORMACIÓN DE ESA PELICULA

public String mostrarInfoPelicula(){
    String mostrarInfoPelicula = "";
    mostrarInfoPelicula = "Codigo: " + this.getCodigo() + "\n";
    mostrarInfoPelicula = "Titulo: " + this.getTitulo() + "\n";
    mostrarInfoPelicula = "Genero: " + this.getGenero() + "\n";
    mostrarInfoPelicula = "Fecha Registro: " + this.getFechaRegistro() + "\n";
    mostrarInfoPelicula = "Fecha Baja: " + this.getFechaBaja() + "\n";
    mostrarInfoPelicula = "Fecha Alquiler: " + this.getFechaAlquiler() + "\n";
    mostrarInfoPelicula = "Alquilada: " + this.isAlquilada() + "\n";
    return mostrarInfoPelicula;
}

}
