import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Articulo implements Serializable {

    //ME FALTA PONER QUE EL CODIGO SEA P-0001

    private String codigo;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;

    public Articulo(String codigo, String titulo, LocalDate fechaRegistro, LocalDate fechaBaja) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now(); //fecha actual
        this.fechaBaja = null;
    }

    //GETTER
    public String getCodigo() {
        return codigo;
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

    //METODO TOSTRING PARA MOSTRAR LOS DATOS DE UN PRODUCTO

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Articulo{");
        sb.append("codigo='").append(codigo).append('\'');
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", fechaRegistro='").append(fechaRegistro).append('\'');
        sb.append(", fechaBaja='").append(fechaBaja).append('\'');
        sb.append('}');
        return sb.toString();
    }

    //tengo que hacer el codigo unico:
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return Objects.equals(codigo, articulo.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}

