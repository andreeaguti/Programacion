public class Empresa extends Contacto {
    private String web;

    public Empresa(String nombre, String telefono, String web) {
        super(nombre, telefono);
        this.web = web;
    }

    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", web='" + web + '\'' +
                '}';
    }
}
