
public class Planeta extends Astros {

    private double distanciaSol;
    private double orbitaSol;
    private boolean tieneSatelites;

    public Planeta(double masaCuerpo, double diametroMedio, double periodoRotacion, double periodoTraslacion, double distanciaMedia, double distanciaSol, double orbitaSol, boolean tieneSatelites)
    {
        super (masaCuerpo, diametroMedio, periodoRotacion, periodoTraslacion, distanciaMedia);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneSatelites = tieneSatelites;
    }
    public void mostrarAstros()
    {
        super.mostrarAstros();
        System.out.println("Distancia Sol: " + this.distanciaSol);
        System.out.println("Orbita Sol: " + this.orbitaSol);
        System.out.println("Tiene Satelites: " + this.tieneSatelites);
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }
    public double getOrbitaSol() {
        return orbitaSol;
    }
    public boolean isTieneSatelites() {
        return tieneSatelites;
    }
    public void setDistanciaSol(double distanciaSol) {
        this.distanciaSol = distanciaSol;
    }
    public void setOrbitaSol(double orbitaSol) {
        this.orbitaSol = orbitaSol;
    }
    public void setTieneSatelites(boolean tieneSatelites) {
        this.tieneSatelites = tieneSatelites;
    }
}
