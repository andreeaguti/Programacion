
import java.util.Objects;

public class Coche implements Comparable<Coche> {

    private String color;
    private String marca;

    public Coche(String color, String marca) {
        this.color = color;
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void  setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Coche{");
        sb.append("color='").append(color).append('\'');
        sb.append(", marca='").append(marca).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Objects.equals(color, coche.color) && Objects.equals(marca, coche.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, marca);
    }


    @Override
    public int compareTo(Coche o) {
        if (o != null) {
            return this.marca.compareTo(o.marca);
        }
        return 1;
    }
}