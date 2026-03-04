import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Persona {

    private String numSocio;
    private LocalDate fechaBaja;
    private List<Articulo> articulosAlquilados;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento, String numSocio, LocalDate fechaBaja) throws DniIncorrectoException {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numSocio = numSocio;
        this.fechaBaja = fechaBaja;
        this.articulosAlquilados = new ArrayList<>();
    }

    public String getNumSocio() {
        return numSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public List<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }

    public void setArticulosAlquilados(List<Articulo> articulosAlquilados) {
        this.articulosAlquilados = articulosAlquilados;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("dni='").append(this.getDni()).append('\'');
        sb.append(", nombre='").append(this.getNombre()).append('\'');
        sb.append(", direccion='").append(this.getDireccion()).append('\'');
        sb.append(", fechaNacimiento=").append(this.getFechaNacimientoFormato()).append('\'');
        sb.append("numSocio='").append(numSocio).append('\'');
        sb.append(", fechaBaja=").append(fechaBaja);
        sb.append(", articulosAlquilados=").append(articulosAlquilados);
        sb.append('}');
        return sb.toString();
    }

    //metodo para mostrar los articulos alquilados
    public void mostrarArticulosAlquilados(){
        if(articulosAlquilados.size() <= 0){
            System.out.println("Lista de articulos vacia");
        }else {
            for (Articulo art : articulosAlquilados){
                System.out.println(articulosAlquilados.toString());
            }
        }
    }

}
