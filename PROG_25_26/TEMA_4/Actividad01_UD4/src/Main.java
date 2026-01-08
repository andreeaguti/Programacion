import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
//EJERCICIO 1: Crea 5 instancias de la Clase Producto.
        Producto p1 = new Producto("Movil", 50);
        Producto p2 = new Producto("Ordenador", 30);
        Producto p3 = new Producto("Teclados", 70);
        Producto p4 = new Producto("Television", 73);
        Producto p5 = new Producto("Secador", 90);

//EJERCICIO 2: Crea un ArrayList.
        ArrayList<Producto> productos = new ArrayList<>();

//EJERCICIO 3: Añade las 5 instancias de Producto al ArrayList.
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

//EJERCICIO 4:Visualiza el contenido de ArrayList utilizando Iterator.
        Iterator<Producto> itera = productos.iterator();
        Producto cadaProducto;
        while (itera.hasNext()) {
            cadaProducto = itera.next();
            System.out.println(cadaProducto.toString());
        }

//EJERCICIO 5: Elimina dos elementos del ArrayList.
        //1- Elimina el elemento que ocupa la posición especificada en el argumento y retorna el elemento
        //borrado.
        // METODO: Object remove(int pos)
        Producto p = productos.remove(1);
        System.out.println("Se ha eliminado el producto: " + p.getNombre());

        //2-Este metodo busca un objeto específico dentro de la lista. Para que funcione correctamente con objetos
        // propios (como Producto), tu clase debería tener implementado el metodo .equals()
        // METODO: boolean remove (Object o)
        boolean eliminado = productos.remove(p5);
        if (eliminado) {
            System.out.println("Se ha eliminado el producto: " + eliminado);
        }

//EJERCICIO 6:Inserta un nuevo objeto producto en medio de la lista.
        productos.add(2, new Producto("Planchas", 92));
        System.out.println("Recorriendo de nuevo todos los elementos");
        for (int i=0; i<productos.size(); i++) {
            System.out.println(productos.get(i).toString());
        }

//EJERCICIO 7: Visualiza de nuevo el contenido de ArrayList utilizando Iterator.
        Iterator<Producto> itera1 = productos.iterator();
        Producto cadaProducto2;
        while (itera1.hasNext()) {
            cadaProducto2 = itera1.next();
            System.out.println(cadaProducto2.toString());
        }

//EJERCICIO 9: Elimina todos los valores del ArrayList.
        System.out.println("Productos antes de clear: " + productos.size());

        productos.clear();

        System.out.println("Productos después de clear: " + productos.size());

    }
}


//8. Ordena la lista por el nombre del producto (hay que usar el método sort y el
//compateTo)