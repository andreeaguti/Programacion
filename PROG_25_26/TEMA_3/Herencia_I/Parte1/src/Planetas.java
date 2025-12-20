public class Planetas extends Astros {

    private double distanciaAlSol;
    private double orbitaAlSol;
    private boolean tieneSatelites;

    public Planetas(String nombre, double radioEcuatorial, double rotacionSobreSuEjeMasa, double temperaturaMediaGravedad, double distanciaAlSol, double orbitaAlSol, boolean tieneSatelites) {
        super(nombre, radioEcuatorial, rotacionSobreSuEjeMasa, temperaturaMediaGravedad);
        this.distanciaAlSol = distanciaAlSol;
        this.orbitaAlSol = orbitaAlSol;
        this.tieneSatelites = tieneSatelites;
    }

    //getters
    public double getDistanciaAlSol() {
        return distanciaAlSol;
    }
    public double getOrbitaAlSol() {
        return orbitaAlSol;
    }
    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    @Override
    public String muestra() {
        return "Estas en la sección: " + this.getClass().getSimpleName() + " | Distancia al Sol: " + this.distanciaAlSol + " millones de km." ;
    }

    @Override
    public String toString() {
        return "Planetas{" +
                "distanciaAlSol=" + distanciaAlSol +
                ", orbitaAlSol=" + orbitaAlSol +
                ", tieneSatelites=" + tieneSatelites +
                ", nombre='" + nombre + '\'' +
                ", radioEcuatorial=" + radioEcuatorial +
                ", rotacionSobreSuEjeMasa=" + rotacionSobreSuEjeMasa +
                ", temperaturaMediaGravedad=" + temperaturaMediaGravedad +
                '}';
    }
}
