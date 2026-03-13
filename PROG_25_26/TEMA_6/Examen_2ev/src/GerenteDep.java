import java.time.LocalDate;
import java.util.ArrayList;

public class GerenteDep extends Trabajador{


    private Gerencia gerencia;
    private ArrayList<Trabajador> trabajadores;

    public static int contadorTrabajadores = 0;

    public GerenteDep(String nombre, LocalDate fechaNacimiento, String dni, String direccion, int numeroSS, String email, double salario, Departamento departamento, int numTrabajador, Gerencia gerencia, ArrayList<Trabajador> trabajadores) throws NumeroSSIncorrectoException {
        super(nombre, fechaNacimiento, dni, direccion, numeroSS, email, salario, departamento);

        this.gerencia = gerencia;
        this.trabajadores = new ArrayList<>();
    }


    public static int getContadorTrabajadores() {
        return contadorTrabajadores;
    }

    public Gerencia getGerencia() {
        return gerencia;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }



    public void setGerencia(Gerencia gerencia) {
        this.gerencia = gerencia;
    }

    public void setTrabajadores(ArrayList<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    @Override
    public String toString() {
        return super.toString() + " [GerenteDep: " +
        ", gerencia=" + gerencia + '\'' +
        ", trabajadores=" + trabajadores + '\'' +
                ']';
    }

    //METODO PARA MOSTRAR INFO DEPARTAMENTO

    public String mostrarInfoDepartamento() {
        //  email, salario, departamento
        String info = "";
        info += "Nombre: " + getNombre() + "\n";
        info += "FechaNacimiento: " + getFechaNacimiento()+ "\n";
        info += "DNI: " + getDni() + "\n";
        info += "Dirección: " + getDireccion() + "\n";
        info += "NumSS: " + getNumeroSS() + "\n";
        info += "Email: " + getEmail()+ "\n";
        info += "Salario: " + getSalario() + "\n";
        info += "Departamento: " + getDepartamento() + "\n";

        return info;
    }

    // GENERADOR DE CÓDIGO ÚNICO
    private String generarCodigoTrabajador() {
        contadorTrabajadores++; // Suma 1 al contador común
        return String.format("G-%04d", contadorTrabajadores);
    }
}


//ME FALTA EL COSTE SALARIAL DE TODOS LOS EMPLEADOS
