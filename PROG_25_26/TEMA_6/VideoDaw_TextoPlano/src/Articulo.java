import java.time.LocalDate; // Para fechas simples (año, mes, día) como el registro o la baja.
import java.io.Serializable; // Interfaz para permitir que el objeto se guarde en archivos.
import java.time.LocalDateTime; // Para fechas con hora exacta (importante para las 48h de alquiler).

public class Articulo implements Serializable {

    //implements Serializable: Esto es vital. Indica que los objetos de esta clase se pueden convertir en un flujo de
    // bytes para guardarlos en un archivo (como pide el ejercicio al final).

    private static final long serialVersionUID = -1050932028895202237L;
//Es como el "DNI" de la versión de la clase. Sirve para que, al leer un archivo guardado, Java sepa que la clase no ha cambiado y es compatible.

    //ATRIBUTOS
    //Se usa protected en lugar de private para que las clases hijas (Pelicula y Videojuego) puedan acceder directamente a estos datos
    protected String cod;
    protected String titulo;
    protected LocalDate fechaRegistro;
    protected LocalDate fechaBaja;
    protected boolean isAlquilado;
    protected LocalDateTime fechaAlquiler;


    //CONSTRUCTOR

    public Articulo(String cod, String titulo) {
        this.cod = cod;
        this.titulo = titulo;

        this.fechaRegistro = LocalDate.now(); // Asigna automáticamente la fecha del sistema al crear el objeto.
        this.fechaBaja = null; // Un artículo nuevo no nace "de baja", por eso es null.
        this.isAlquilado = false;// Por defecto, empieza disponible.
        this.fechaAlquiler = null;// No hay fecha de alquiler porque aún no se ha alquilado.
    }

    //GETTERS

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
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


    //SETTERS para poder modificar los valores de los atributos

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public boolean isAlquilado() {
        return isAlquilado;
    }
    public void setAlquilado(boolean alquilado) {
        isAlquilado = alquilado;
    }
    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;

    }


    //TO STRING
    //Sirve para que, si hago un System.out.println(miArticulo), se vea un texto legible con los datos y no un código raro.
    @Override
    public String toString() {
        return "Articulo{" +
                "cod='" + cod + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", fechaBaja=" + fechaBaja +
                '}';
    }
}