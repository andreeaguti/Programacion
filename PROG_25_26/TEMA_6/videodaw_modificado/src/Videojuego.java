import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Esta clase es la "gemela" de Pelicula, pero con los matices propios de los videojuegos

public class Videojuego extends Articulo implements Serializable{
//extends Articulo: Al igual que la película, hereda toodo lo de articulo.
//Serializable: Necesario para guardar el estado de los videojuegos en el disco duro.

    @Serial
    private static final long serialVersionUID = -7404079771132447219L;


    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    // ATRIBUTOS

    private GeneroVideojuego generoVideojuego; // Enum propio de videojuegos
    private PLATAFORMAVJ plataformavj;// Otro Enum para la consola/PC
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilado;

    //CONTADOR

    public static int contadorVideoJuegos = 0;
//Sirve para llevar la cuenta de cuántos juegos hemos creado sin que se reinicie el contador cada vez.

    //CONSTRUCTOR

    public Videojuego(String cod, String titulo, GeneroVideojuego genero, PLATAFORMAVJ plataforma) {
        super(cod, titulo); // LLAMADA OBLIGATORIA a la madre (Articulo)
        this.generoVideojuego = genero;
        this.plataformavj = plataforma;
        this.isAlquilado = false;
        this.fechaAlquiler = null;
    }



    //GETTERS

    public DateTimeFormatter getDtf() {
        return dtf;
    }

    public GeneroVideojuego getGeneroVideojuego() {
        return generoVideojuego;
    }
    public PLATAFORMAVJ getPlataformavj() {
        return plataformavj;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilado() {
        return isAlquilado;
    }

    public static int getContadorVideoJuegos() {
        return contadorVideoJuegos;
    }


    //SETTERS


    public void setGeneroVideojuego(GeneroVideojuego generoVideojuego) {
        this.generoVideojuego = generoVideojuego;
    }

    public void setPlataformavj(PLATAFORMAVJ plataformavj) {
        this.plataformavj = plataformavj;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilado = alquilada;
    }


    //TO STRING

    @Override
    public String toString() {
        return super.toString() + "VideoJuegos" +
                "dtf=" + dtf +
                ", genero=" + generoVideojuego +
                ", plataforma=" + plataformavj +
                ", fechaAlquiler=" + fechaAlquiler +
                ", isAlquilado=" + isAlquilado +
                '}';
    }

    //METODO MOSTRAR INFO
    //Es el que usarás en el menú de GestionVideoDaw para que se vea bonito.

    public String mostrarInfoVideoJuego() {
        String info = "";
        info += "Cod: " + getCod() + "\n";
        info += "Titulo: " + getTitulo() + "\n";
        info += "Genero: " + getGeneroVideojuego()+ "\n";
        info += "Plataforma: " + getPlataformavj() + "\n";
        info += "Fecha Registro: " + getFechaRegistro() + "\n";
        info += "Fecha Baja: " + getFechaBaja() + "\n";
        info += "Fecha Alquiler: " + getFechaAlquiler() + "\n";
        info += "¿Alquilado?: " + isAlquilado() + "\n"; //COMO ES BOOLEANO SE USA ISALQUILADA EN LUGAR DE GET
        return info;
    }


}