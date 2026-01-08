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
        /* Triangulo t = trians.remove(2);
        System.out.println("Se ha eliminado el triángulo: " + t.verTipo()); */





    }
}
/*A continuación, en el programa principal haz lo siguiente:
1. Crea 5 instancias de la Clase Producto.
2. Crea un ArrayList.
3. Añade las 5 instancias de Producto al ArrayList.
4. Visualiza el contenido de ArrayList utilizando Iterator.
5. Elimina dos elementos del ArrayList.
6. Inserta un nuevo objeto producto en medio de la lista.
7. Visualiza de nuevo el contenido de ArrayList utilizando Iterator.
8. Ordena la lista por el nombre del producto (hay que usar el método sort y el
compateTo)
9. Elimina todos los valores del ArrayList. */