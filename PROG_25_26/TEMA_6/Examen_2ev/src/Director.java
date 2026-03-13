import java.security.PublicKey;
import java.time.LocalDate;

public class Director extends Trabajador {

    private int numTelefono;
    private boolean isCoche;


    public Director(String nombre, LocalDate fechaNacimiento, String dni, String direccion, int numeroSS, String email, double salario, Departamento departamento, int numTelefono, boolean isCoche) throws NumeroSSIncorrectoException {
        super(nombre, fechaNacimiento, dni, direccion, numeroSS, email, salario, departamento);
        this.numTelefono = numTelefono;
        this.isCoche = false;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public boolean isCoche() {
        return isCoche;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }

    public void setCoche(boolean coche) {
        isCoche = coche;
    }

    @Override
    public String toString() {
        return super.toString() + "Director" +
                "NumeroTelefono=" + numTelefono +
                ", isCoche=" + isCoche +
                '}';
    }

    //METODO PARA MOSTRAR INFO
    public String mostrarInfoDirector() {
        String info = "";
        info += "Nombre: " + this.nombre;
        info += "Fecha de nacimiento: " + this.fechaNacimiento;
        info += "Dni: " + this.dni;
        info += "Direccion: " + this.direccion;
        info += "Numero SS: " + this.numeroSS;
        info += "Email: " + this.email;
        info += "Salario: " + this.salario;
        info += "Departamento: " + this.departamento;
        return info;
    }
}

