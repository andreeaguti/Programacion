import java.time.LocalDate;
import java.util.regex.Pattern;

public class Empresa {
    //hago la encapsulacion
    private final String nombre;
    private final String cif;
    private final LocalDate fechaFundacion;
    private final int maximoTrabajadores;

    private Trabajador[] coleccionTrabajadores;
    private int contadorTrabajadores = 0;

    private static final Pattern CIF_PATTERN = Pattern.compile("^[A-Z]\\d{10}$");

    public Empresa(String nombre, String cif, LocalDate fechaFundacion, int maximoTrabajadores) {
        if (!CIF_PATTERN.matcher(cif).matches()) {
            throw new IllegalArgumentException("CIF invalido");
        }
        if (maximoTrabajadores <= 0) {
            throw new IllegalArgumentException("ERROR: El número máximo de trabajadores debe ser positivo.");
        }
        this.nombre = nombre;
        this.cif = cif;
        this.fechaFundacion = fechaFundacion;
        this.maximoTrabajadores = maximoTrabajadores;
        this.coleccionTrabajadores = new Trabajador[maximoTrabajadores];
    }

    //getters
    public String getNombre() {
        return nombre;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public int getMaximoTrabajadores() {
        return maximoTrabajadores;
    }

    public Trabajador[] getColeccionTrabajadores() {
        return this.coleccionTrabajadores;
    }

    public int getContadorTrabajadores() {
        return contadorTrabajadores;
    }

    //METODOS

    //METODO PARA BUSCAR POR DNI
    public Trabajador buscarTrabajadorPorDni(String dni) {
        for (int i = 0; i < this.contadorTrabajadores; i++) {
            Trabajador t = this.coleccionTrabajadores[i];
            if (t.getDni().equals(dni)) {
                return t;
            }
        }
        return null;
    }

    public boolean existeTrabajador (Trabajador trabajador) {
        return buscarTrabajadorPorDni(trabajador.getDni()) != null;
    }

    private void ampliarDimensionTrabajadores(){
        Trabajador[] TrabajaoresRegistradosAux = new Trabajador[this.coleccionTrabajadores.length + 10];
        for(int i = 0; i < this.coleccionTrabajadores.length; i++){
            TrabajaoresRegistradosAux[i] = this.coleccionTrabajadores[i];
        }
        this.coleccionTrabajadores = TrabajaoresRegistradosAux;
    }

    public void registrarTrabajador(Trabajador trabajador) {
        if (this.existeTrabajador(trabajador)) {
            System.out.println("ERROR: El trabajador ya existe");
            return;
        }
        if (this.contadorTrabajadores >= this.maximoTrabajadores) {
            System.out.println("ERROR: Limite de trabajadores registrados");
            return;
        }
        trabajador.setNumSS("SS-" + (1000 + this.contadorTrabajadores));
       this.coleccionTrabajadores[this.contadorTrabajadores++] = trabajador;
        System.out.println("Trabajador " + trabajador.getNombre() + " registrado. SS asignado: " + trabajador.getNumSS());
    }

    public boolean eliminarTrabajadorEmpresa (String dniBaja) {
        //recorro el array buscando el dni
        for (int i = 0; i < this.contadorTrabajadores; i++) {
            Trabajador t = this.coleccionTrabajadores[i];

            if (t.getDni().equals(dniBaja)) {
            t.setNumSS(null);

            for (int j = i; j < this.contadorTrabajadores - 1; j++) {
                this.coleccionTrabajadores[j] = this.coleccionTrabajadores[j + 1];
                this.coleccionTrabajadores[j] = this.coleccionTrabajadores[j + 1];
                }
            this.coleccionTrabajadores[this.contadorTrabajadores - 1] = null;
            this.contadorTrabajadores--;

            System.out.println("Trabajador con DNI: " + dniBaja + " dado de baja. SS borrado.");
            return true;
            }
        }
        System.out.println("ERROR: Trabajador con DNI " + dniBaja + " no encontrado.");
        return false;
    }

    public String mostrarInformacionEmpresa() {
        return "Empresa{" +
                "nombre='" + this.nombre + '\'' +
                ", fechaFundacion=" + this.fechaFundacion + '\'' +
                ", cif='" + this.cif + '\'' +
                ", maximo de trabajadores='" + this.maximoTrabajadores + '\'' +
                '}';
    }

    public String mostrarInformacionTrabajadores() {
        if (this.contadorTrabajadores == 0) {
            return "No hay trabajadores registrados en la empresa.";
        }

        StringBuilder sb = new StringBuilder("--- LISTA DE TRABAJADORES ---\n");
        for (int i = 0; i < this.contadorTrabajadores; i++) {
            // Delegamos la impresión al metodo toString() del objeto Trabajador
            sb.append("  ").append(i + 1).append(". ").append(this.coleccionTrabajadores[i].toString()).append("\n");
        }
        return sb.toString();
    }
}








