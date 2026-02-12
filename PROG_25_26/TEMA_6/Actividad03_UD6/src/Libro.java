import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Libro implements Serializable {


    @Serial
    private static final long serialVersionUID = 5976617470545454419L;

    private String isbn;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    private List<String> autores;

    public Libro(String isbn, String titulo, String autor, LocalDate fechaPublicacion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.autores = new LinkedList<>();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public List<String> getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Libro{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", fechaPublicacion=").append(fechaPublicacion);
        sb.append(", autores=").append(autores);
        sb.append('}');
        return sb.toString();
    }
}
