
public class Inventario {

    private Mascotas[] animales;

    private int contadorAnimales = 0; //lo hacemos aqui para hacer un campo privado auxiliar

    public Inventario() {

        final int CAPACIDAD_MAXIMA = 50;
        this.animales = new Mascotas[CAPACIDAD_MAXIMA];
        this.contadorAnimales = 0; //el array vacio de primeras
    }

    public boolean insertarAnimal(Mascotas animal) {
        if (contadorAnimales < animales.length) {
            this.animales[contadorAnimales] = animal; // Inserta en el índice actual
            contadorAnimales++; // Sumamos al contador
            return true;
        } else {
            System.out.println("ERROR: El inventario está lleno. No se puede insertar a " + animal.getNombre());
            return false;
        }
    }

    public Mascotas eliminarAnimal(String nombre) {
        int indiceAEliminar = -1;

        // 1. Buscar el índice del animal
        for (int i = 0; i < contadorAnimales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombre)) {
                indiceAEliminar = i;
                break;
            }
        }

        if (indiceAEliminar != -1) {
            Mascotas animalEliminado = animales[indiceAEliminar];

            for (int i = indiceAEliminar; i < contadorAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            contadorAnimales--;
            return animalEliminado;
        }
        return null;
    }

    public void listaAnimales() {
        if (contadorAnimales == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n--- Lista de Animales (Tipo y Nombre, Total: " + contadorAnimales + ") ---");
        // Iteramos solo sobre los elementos realmente ocupados
        for (int i = 0; i < contadorAnimales; i++) {
            Mascotas animal = animales[i];
            System.out.println("* " + animal.getTipo() + ": " + animal.getNombre());
        }
    }

    public void mostrarDatosAnimal(String nombre) {
        Mascotas animalEncontrado = null;

        for (int i = 0; i < contadorAnimales; i++) {
            if (animales[i].getNombre().equalsIgnoreCase(nombre)) {
                animalEncontrado = animales[i];
                break;
            }
        }

        if (animalEncontrado != null) {
            animalEncontrado.muestra(); // Polimorfismo
        } else {
            System.out.println("Animal '" + nombre + "' no encontrado en el inventario.");
        }
    }

    public void mostrarTodosLosDatos() {
        if (contadorAnimales == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }
        System.out.println("\n--- Datos Completos de Todo el Inventario ---");

        for (int i = 0; i < contadorAnimales; i++) {
            animales[i].muestra(); // Polimorfismo
            System.out.println("------------------------------------------");
        }
    }

    public void vaciarInventario() {
        for (int i = 0; i < contadorAnimales; i++) {
            animales[i] = null;
        }
        this.contadorAnimales = 0;
        System.out.println("El inventario ha sido vaciado completamente.");
    }
}
