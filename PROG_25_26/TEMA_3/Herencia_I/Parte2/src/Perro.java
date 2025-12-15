public class Perro extends Mascotas {
        protected String raza;
        protected boolean pulgas;

        public Perro(String nombre, int edad, String estado, String fechaNacimiento, String raza, boolean pulgas) {
            super(nombre, edad, estado, fechaNacimiento);
            this.raza = raza;
            this.pulgas = pulgas;
        }

        @Override
        public void muestra() {
            System.out.println("--- Perro: " + nombre + " ---");
            System.out.println("Raza: " + raza + ", Edad: " + edad + " años");
            System.out.println("Estado: " + estado + ", Pulgas: " + (pulgas ? "Sí" : "No"));
        }

        @Override
        public void habla() { // [cite: 71]
            System.out.println(nombre + " dice: ¡Guau! ¡Guau!");
        }
    }




