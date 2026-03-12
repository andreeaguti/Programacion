import java.io.Serial;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

public class Pelicula extends Articulo implements Serializable {
    //extends Articulo: Indica que Pelicula hereda de Articulo.
    //implements Serializable: Al igual que la madre, permite guardar películas en archivos.

    @Serial
    private static final long serialVersionUID = -5452698551965501642L;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    //Sirve para definir cómo quieres que se vean las fechas. Si no lo usas, Java las saca en un formato feo por defecto.

    // ATRIBUTOS
//Pelicula utiliza los atributos de su madre, pero que has añadido isAlquilada para ser más específico con el lenguaje
// (femenino para película). No obstante, técnicamente podrías usar solo los de la madre para ahorrar memoria.
    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    //CONTADOR

    public static int contadorPelicula = 0;
//static: Esto es fundamental. Significa que la variable pertenece a la clase, no a cada película individual. Es una "memoria común". Si creas 5 películas, el contador llega a 5 para todas.

    //CONSTRUCTOR

    public Pelicula(String cod, String titulo, Genero genero) {
        super(cod, titulo); // Pasamos el código y el título de la clase MADRE
        this.genero = genero;
        this.isAlquilado = false; // Usa el nombre que pusimos en Articulo
        this.fechaAlquiler = null;
    }



    //GETTERS


    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public Genero getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public static int getContadorPelicula() {
        return contadorPelicula;
    }

    //SETTERS


    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    // GENERADOR DE CÓDIGO ÚNICO
    private String generarCodigoPelicula() {
        contadorPelicula++; // Suma 1 al contador común
        return String.format("P-%04d", contadorPelicula);// Devuelve "P-" seguido de 4 cifras (ej: P-0001)
    }

    //TO STRING

//METODOS DE INFORMACION
    @Override
    public String toString() {
        return super.toString() + "Pelicula" +
                "dtf=" + dtf +
                ", genero=" + genero +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilada=" + isAlquilada +
                '}';
    }

    //METODO MOSTRAR INFO
    //Para qué sirve: Está pensado para la interfaz. Si tu programa tiene un menú y el usuario quiere ver los datos de una película,
    // no querrá ver Pelicula{cod='P-001', titulo='Matrix'...}. Querrá algo limpio.
    //Cuando el enunciado dice "Un metodo para ver sus películas registradas", llamarás a este metodo para que la lista
    // en pantalla quede ordenada y bonita.
    public String mostrarInfoPelicula() {
        String info = "";
        info += "Cod: " + getCod() + "\n";
        info += "Titulo: " + getTitulo() + "\n";
        info += "Genero: " + getGenero() + "\n";
        info += "Fecha Registro: " + getFechaRegistro() + "\n";
        info += "Fecha Baja: " + getFechaBaja() + "\n";
        info += "Fecha Alquiler: " + getFechaAlquiler() + "\n";
        info += "¿Alquilada?: " + isAlquilada + "\n"; //COMO ES BOOLEANO SE USA ISALQUILADA EN LUGAR DE GET
        return info;
    }
    //El toString es para cumplir con la herencia de Java y facilitar el debug, mientras que mostrarInfo es un método de negocio para presentar la información al usuario de forma clara
}