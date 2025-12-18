import java.time.LocalDate;

public abstract class Mascotas {


        protected String nombre;
        protected int edad;
        protected String estado;
        protected LocalDate fechaNacimiento;

    public abstract String muestra(); //porque lo tienen más clases
    public abstract String habla(); //porque lo tienen más clases

    // Métodos
    public String cumpleanos() {
           String mensaje = "No es mi cumple";
        }

        public void morir() {
            this.estado = "Fallecido";
            System.out.println(nombre + " ha muerto.");
        }

//protected se pone en todas las clases abstratas que vayan a tener hijos
//public abstract String muestra(); //porque lo tienen más clases