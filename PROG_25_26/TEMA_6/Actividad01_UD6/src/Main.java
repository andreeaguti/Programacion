import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileWriter;

public class Main {

    private static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {

        final String path = ".\\resources\\";
        String fileName = "Almacen.dat";
        boolean fileMode = true;

        FileWriter file = null;
        try{
            file = new FileWriter(path+fileName, fileMode);
        }catch (IOException e){
            System.out.println("Error al abrir el archivo");
            return;
        }

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            abrirFicehero();

            switch (opcion) {
                case "1":
                    crearProducto();
                    break;
                case "2":
                    mostrarProductos();
                    break;
                case "3":
                    eliminarProductos();
                    break;
                case "4":

            }
        }while (!opcion.equals("5"));

    }
    //METODO PARA ABRIR FICHERO
    public static void abrirFicehero() {
        final String path = ".\\src\\resources\\";
        String fileName = "Almacen.dat";

        try(FileReader file = new FileReader(path+fileName);
            BufferedReader bufferedReader = new BufferedReader(file);){
            String linea = "";
            while(linea != null){
                linea = bufferedReader.readLine();
                if(linea != null){
                    if(!linea.equals("")){
                        System.out.println(linea);
                    }

                }
            }

        } catch (IOException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }

    //METODO PARA CREAR PRODUCTO
    public static void crearProducto() {
        Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el código del producto: ");
            String codigo = sc.nextLine();
            System.out.println("Introduce el nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce la cantidad del producto: ");
            int cantidad = sc.nextInt();
            System.out.println("Introduce el precio del producto: ");
            double precio = sc.nextDouble();

            Producto nuevo = new Producto(codigo, nombre, cantidad, precio);
            productos.add(nuevo);
    }

    //METODO PARA MOSTRAR PRODUCTOS
    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No existen productos");
        }else{
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    //METODO PARA ELIMINAR PRODUCTOS POR CÓDIGO
    public static void eliminarProductos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el codigo del producto que desea eliminar: ");
        String cod = sc.nextLine();

        Producto pAux=null;
        for (Producto producto : productos) {
            if (producto.getCodigo().equals(cod)) {
                pAux = producto;
                break;
            }
        }
        if (pAux != null) {
            productos.remove(pAux);
            System.out.println(cod + " eliminado");
        }else {
            System.out.println("Producto no encontrado");
        }
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DE OPERACIONES ---");
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar productos existentes");
        System.out.println("3. Eliminar producto por código");
        System.out.println("4. Guardar productos en el fichero");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }


}