public class Main {
    public static void main(String[] args) {

        Inventario inventario = new Inventario();

        Perro perro = new Perro("Max", 5, "Sano", "2020-01-01", "Labrador", false);
        Gato gato = new Gato("Pelusa", 2, "Sano", "2023-05-15", "Blanco", true);
        Loro loro = new Loro("Rocky", 8, "Sano", "2017-08-01", "Gancho", true, "Africano", true);
        Canario canario = new Canario("Tweety", 1, "Sano", "2024-03-10", "Cono", true, "Amarillo", true);

        System.out.println(" INSERTANDO ANIMALES EN EL INVENTARIO ");
        inventario.insertarAnimal(perro);
        inventario.insertarAnimal(gato);
        inventario.insertarAnimal(loro);
        inventario.insertarAnimal(canario);


        System.out.println("\n--- A. LISTA COMPLETA ---");
        inventario.listaAnimales();


        System.out.println("\n--- B. DATOS DEL PERRO ---");
        inventario.mostrarDatosAnimal("Max");


        System.out.println("\n--- C. MOSTRAR TODOS LOS DATOS ---");
        inventario.mostrarTodosLosDatos();


        System.out.println("\n--- D. ELIMINANDO A Pelusa ---");
        inventario.eliminarAnimal("Pelusa");
        inventario.listaAnimales();


        System.out.println("\n VACIANDO INVENTARIO");
        inventario.vaciarInventario();
        inventario.listaAnimales();
    }
}