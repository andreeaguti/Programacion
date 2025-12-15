
    public abstract class Ave extends Mascotas {

        protected String pico;
        protected boolean vuela;

        public Ave(String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela) {
            super(nombre, edad, estado, fechaNacimiento);
            this.pico = pico;
            this.vuela = vuela;
        }

        public void volar() {
            if (vuela) {
                System.out.println(nombre + " está volando.");
            } else {
                System.out.println(nombre + " no puede volar.");
            }
        }
    }
