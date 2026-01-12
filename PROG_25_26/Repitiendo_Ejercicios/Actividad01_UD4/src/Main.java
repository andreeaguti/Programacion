import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Main {
    public static void main(String[] args) {

    //EJERCICIO 1: Crea 5 instancias de la Clase Producto.
        Producto p1 = new Producto("Ordenador", 15);
        Producto p2 = new Producto("Movil", 55);
        Producto p3 = new Producto("Tablet", 68);
        Producto p4 = new Producto("TV", 91);
        Producto p5 = new Producto("Cargadores", 76);


    //EJERCICIO 2: Crea un ArrayList.
        ArrayList<Producto> productos = new ArrayList<Producto>();

    //EJERCICIO 3: Añade las 5 instancias de Producto al ArrayList.
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

    //EJERCICIO 4: Visualiza el contenido de ArrayList utilizando Iterator.
        Iterator<Producto> iterator = productos.iterator();
        Producto cadaProducto;
        while (iterator.hasNext()) {
            cadaProducto = iterator.next();
            System.out.println(cadaProducto.toString());
        }

    //EJERCICIO 5: Elimina dos elementos del ArrayList.

        boolean resultado = productos.remove(p2);
        productos.remove(1);

        //Ejemplo para eliminar un objeto buscado
        Producto aux = null;
        for(Producto producto: productos){
            if(producto.getNombre().equalsIgnoreCase("TV")){
                aux = producto;
                break;
            }
        }

        if(aux != null){
            productos.remove(aux);
        }

    //EJERCICIO 6: Inserta un nuevo objeto producto en medio de la lista.
        Producto p6 = new Producto("Nuevo pataIphone", 13);
        productos.add(productos.size() / 2, p6);

        System.out.println("\nEjercicio 6");
        for(Producto producto: productos){
            System.out.println(producto);
        }

    //EJERCICIO 7: Visualiza de nuevo el contenido de ArrayList utilizando Iterator.
        System.out.println("\nEjercicio 7");
        Iterator<Producto> itera = productos.iterator();
        Producto cadaProducto2;
        while (itera.hasNext()) {
            cadaProducto2 = itera.next();
            System.out.println(cadaProducto2.toString());
        }

    //EJERCICIO 8: Ordena la lista por el nombre del producto (hay que usar el método sort y el
    //compateTo)
        System.out.println("\nEjercicio 8");

        Collections.sort(productos);

        for(Producto p: productos){
            System.out.println(p);
        }

    //EJERCICIO 09: Elimina todos los valores del ArrayList.
        productos.clear();

















    }
}