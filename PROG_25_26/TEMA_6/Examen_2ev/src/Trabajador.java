import java.time.LocalDate;

public abstract class Trabajador extends Persona {

    protected int numeroSS; // (10 dígitos numéricos)
    protected String email; //Email de la empresa (comprobación opcional)
    protected double salario;
    protected Departamento departamento; // (informática, gestión, marketing, dirección)

    public Trabajador(String nombre, LocalDate fechaNacimiento, String dni, String direccion, int numeroSS, String email, double salario, Departamento departamento) throws NumeroSSIncorrectoException {
        super(nombre, fechaNacimiento, dni, direccion);
        this.numeroSS = numeroSS;
        this.email = email;
        this.salario = salario;
        this.departamento = departamento;
    }

    //GETTER
    public int getNumeroSS() {
        return numeroSS;
    }

    public String getEmail() {
        return email;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public double getSalario() {
        return salario;
    }

    //SETTER

    public void setNumeroSS(int numeroSS) throws NumeroSSIncorrectoException {
        if (numeroSS < 0 || numeroSS > 10) {
            throw new NumeroSSIncorrectoException("Tiene que tener 10 dígitos");
        }else {
            this.numeroSS = numeroSS;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    //TOSTRING

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Trabajador{");
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", dni='").append(dni).append('\'');
        sb.append(", direccion='").append(direccion).append('\'');
        sb.append("numeroSS='").append(numeroSS).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", salario=").append(salario);
        sb.append(", departamento=").append(departamento);

        sb.append('}');
        return sb.toString();
    }
}
