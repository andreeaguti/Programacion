public class Astros {
    private double masaCuerpo;
    private double diametroMedio;
    private double periodoRotacion;
    private double periodoTraslacion;
    private double distanciaMedia;

    public Astros(double masaCuerpo, double diametroMedio, double periodoRotacion, double periodoTraslacion, double distanciaMedia) {
        this.masaCuerpo = masaCuerpo;
        this.diametroMedio = diametroMedio;
        this.periodoRotacion = periodoRotacion;
        this.periodoTraslacion = periodoTraslacion;
        this.distanciaMedia = distanciaMedia;
    }
    public void mostrarAstros()
    {
        System.out.println("Masa Cuerpo: " + this.masaCuerpo);
        System.out.println("Diametro Medio: " + this.diametroMedio);
        System.out.println("Periodo Rotacion: " + this.periodoRotacion);
        System.out.println("Periodo Traslacion: " + this.periodoTraslacion);
        System.out.println("Distancia Media: " + this.distanciaMedia);
    }
    public double getMasaCuerpo() {
        return masaCuerpo;
    }
    public void setMasaCuerpo(double masaCuerpo) {
        this.masaCuerpo = masaCuerpo;
    }
    public double getDiametroMedio() {
        return diametroMedio;
    }
    public void setDiametroMedio(double diametroMedio) {
        this.diametroMedio = diametroMedio;
    }
    public double getPeriodoRotacion() {
        return periodoRotacion;
    }
    public void setPeriodoRotacion(double periodoRotacion) {
        this.periodoRotacion = periodoRotacion;
    }
    public double getPeriodoTraslacion() {
        return periodoTraslacion;
    }
    public void setPeriodoTraslacion(double periodoTraslacion) {
        this.periodoTraslacion = periodoTraslacion;
    }
    public double getDistanciaMedia() {
        return distanciaMedia;
    }
    public void setDistanciaMedia(double distanciaMedia) {
        this.distanciaMedia = distanciaMedia;
    }

    public String mostrarInfoAstros(){
        return "Astros{" +
                "MasaCuerpo='" + this.masaCuerpo + '\'' +
                ", DiametroMedio='" + this.diametroMedio + '\'' +
                ", PeriodoRotacion='" + this.periodoRotacion + '\'' +
                ", PeriodoTraslacion='" + this.periodoTraslacion + '\'' +
                ", DistanciaMedia='" + this.distanciaMedia + '\'' +
                '}';
    }
}
