public abstract class Astros {
    protected String nombre;
    protected double radioEcuatorial;
    protected double rotacionSobreSuEjeMasa;
    protected double temperaturaMediaGravedad;

    public Astros(String nombre, double radioEcuatorial, double rotacionSobreSuEjeMasa, double temperaturaMediaGravedad) {
        this.nombre = nombre;
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreSuEjeMasa = rotacionSobreSuEjeMasa;
        this.temperaturaMediaGravedad = temperaturaMediaGravedad;
    }
    public abstract String muestra(); //lo va a tener en las clases hijas

    @Override
    public String toString() {
        return "Astros{" +
                "nombre='" + nombre + '\'' +
                ", radioEcuatorial=" + radioEcuatorial +
                ", rotacionSobreSuEjeMasa=" + rotacionSobreSuEjeMasa +
                ", temperaturaMediaGravedad=" + temperaturaMediaGravedad +
                '}';
    }
}