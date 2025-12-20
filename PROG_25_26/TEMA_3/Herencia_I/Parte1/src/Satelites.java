public class Satelites extends Astros {

    private double distanciaAlPlaneta;
    private double orbitaPlanetaria;
    private String planetaPertenece;

    public Satelites(String nombre, double radioEcuatorial, double rotacionSobreSuEjeMasa, double temperaturaMediaGravedad, double distanciaAlPlaneta, double orbitaPlanetaria, String planetaPertenece) {
        super(nombre, radioEcuatorial, rotacionSobreSuEjeMasa, temperaturaMediaGravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPertenece = planetaPertenece;
    }

    public double getDistanciaAlPlaneta() {
        return distanciaAlPlaneta;
    }

    public double getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public String getPlanetaPertenece() {
        return planetaPertenece;
    }

    @Override
    public String muestra() {
        return "Satélite: " + this.getClass().getSimpleName() +
                " Orbita alrededor de: " + this.planetaPertenece +
                " Distancia al planeta: " + this.distanciaAlPlaneta + " km.";
    }

    @Override
    public String toString() {
        return "Satelites{" +
                "nombre='" + nombre + '\'' +
                ", radioEcuatorial=" + radioEcuatorial +
                ", rotacionSobreSuEjeMasa=" + rotacionSobreSuEjeMasa +
                ", temperaturaMediaGravedad=" + temperaturaMediaGravedad +
                ", distanciaAlPlaneta=" + distanciaAlPlaneta +
                ", orbitaPlanetaria=" + orbitaPlanetaria +
                ", planetaPertenece='" + planetaPertenece + '\'' +
                '}';
    }
}
