public abstract class Mascotas {

        protected String nombre;
        protected int edad;
        protected String estado;
        protected String fechaNacimiento;

        public Mascotas(String nombre, int edad, String estado, String fechaNacimiento) {
            this.nombre = nombre;
            this.edad = edad;
            this.estado = estado;
            this.fechaNacimiento = fechaNacimiento;
        }

        public abstract void muestra();
        public abstract void habla();

        // Métodos
        public void cumpleanos() {
            this.edad++;
            System.out.println (nombre + " ahora tiene " + edad + " años.");
        }

        public void morir() {
            this.estado = "Fallecido";
            System.out.println(nombre + " ha muerto.");
        }

        public String getNombre() {
            return nombre;
        }
        public String getTipo() {
            return this.getClass().getSimpleName();
        }
    }

