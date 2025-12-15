public class Satelites extends Astros {

    private double distanciaPlaneta;
    private double orbitaPlaneta;
    private String planetaPertenece;

    public Satelites(double masaCuerpo, double diametroMedio, double periodoRotacion, double periodoTraslacion, double distanciaMedia, double distanciaPlaneta, double orbitaPlaneta, String planetaPertenece)
    {
        super (masaCuerpo, diametroMedio, periodoRotacion, periodoTraslacion, distanciaMedia);

        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlaneta = orbitaPlaneta;
        this.planetaPertenece = planetaPertenece;
    }
public void mostrarAstros()
    {
        super.mostrarAstros();
            System.out.println("Planeta Pertenece: " + planetaPertenece);
            System.out.println("Distancia Planeta: " + distanciaPlaneta);
            System.out.println("Orbita Planeta: " + orbitaPlaneta);
    }
    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }
    public void setDistanciaPlaneta(double distanciaPlaneta) {
        this.distanciaPlaneta = distanciaPlaneta;
    }
    public double getOrbitaPlaneta() {
        return orbitaPlaneta;
    }
    public void setOrbitaPlaneta(double orbitaPlaneta) {
        this.orbitaPlaneta = orbitaPlaneta;
    }
    public String getPlanetaPertenece() {
        return planetaPertenece;
    }
    public void setPlanetaPertenece(String planetaPertenece) {
        this.planetaPertenece = planetaPertenece;
    }
}
