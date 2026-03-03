import java.time.LocalDate;
import java.time.LocalDateTime;

public class Videojuego extends Articulo{

    private GeneroVideojuego genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Videojuego(String codigo, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja, GeneroVideojuego genero, LocalDateTime fechaAlquiler, boolean isAlquilada) {
        super(codigo, titulo, fechaRegistro, fechaBaja);
        this.genero = genero;
        this.fechaAlquiler = fechaAlquiler;
        this.isAlquilada = isAlquilada;
    }

    public GeneroVideojuego getGenero() {
        return genero;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public void setAlquilada(boolean alquilada) {
        isAlquilada = alquilada;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Videojuego{");
        sb.append("genero=").append(genero);
        sb.append(", fechaAlquiler=").append(fechaAlquiler);
        sb.append(", isAlquilada=").append(isAlquilada);
        sb.append('}');
        return sb.toString();
    }
}
