import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula extends Articulo{

    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    private static int contadorPeliculas = 0;

    public Pelicula(String codigo, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, Genero genero, LocalDateTime fechaAlquiler, boolean isAlquilada) {
        super(codigo, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
        contadorPeliculas++;
    }
//getter
    public Genero getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    //setter
    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String fechaFormateada = (fechaAlquiler != null) ? fechaAlquiler.format(dtf) : "No alquilada";
        final StringBuilder sb = new StringBuilder("Pelicula{");
        sb.append("genero=").append(genero);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", IsAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }
}
