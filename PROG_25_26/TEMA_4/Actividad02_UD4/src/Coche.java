import java.util.Objects;

public class Coche {

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

    @Override
    public String toString() {
        return "Coche{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return Objects.equals(marca, coche.marca) &&
                Objects.equals(color, coche.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, marca);
    }
}

