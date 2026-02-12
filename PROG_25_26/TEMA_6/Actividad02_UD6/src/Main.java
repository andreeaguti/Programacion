import java.io.*;
import java.util.Scanner;
import java.util.*;

public class Main {

    private static LinkedList<Producto> productos = new LinkedList<>();
    private static final String PATH = "Almacen.dat";

    public static void main(String[] args) {

        abrirFichero();
        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();

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
                    guardarEnFichero();
                    break;
                case "5":
                    System.out.println("Cerrando programa...");
            }
        }while (!opcion.equals("5"));
    }

    //METODO PARA ABRIR FICHERO
    public static void abrirFichero() {
        FileInputStream fichero;
        DataInputStream lector;

        try{
            fichero = new FileInputStream("Almacen.dat");
            lector = new DataInputStream(fichero);
        }catch (IOException e){
            System.out.println("Error al abrir fichero");
            System.out.println(e.getMessage());
            return;
        }
        boolean eof = false;
        while (!eof) {
            try{
                String codigo = lector.readUTF();
                String nombre = lector.readUTF();
                int can = lector.readInt();
                double pre = lector.readDouble();
                Producto p = new Producto(codigo, nombre, can, pre);
                productos.add(p); //LOS AÑADO AL LINKEDlIST
                System.out.println(p);
            } catch (EOFException e) {
                eof = true;
            }catch (IOException e2){
                System.out.println("Error al leer fichero");
                System.out.println(e2.getMessage());
                break;
            }
        }
        try{
            lector.close();
            fichero.close();
        }catch (IOException e){
            System.out.println("Error al cerrar el fichero");
            System.out.println(e.getMessage());
        }
    }

    //METODO PARA GUARDAR
    public static void guardarEnFichero() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(PATH))) {
            for (Producto p : productos) {
                dos.writeUTF(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeInt(p.getCantidad());
                dos.writeDouble(p.getPrecio());
            }
            System.out.println("Datos guardados en Almacen.dat");
        } catch (IOException e) {
            System.out.println("Error al guardar en el fichero: " + e.getMessage());
        }
    }
    //METODO PARA CREAR PRODUCTO
    public static void crearProducto() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Introduce el código del producto: ");
            String codigo = sc.nextLine();
            System.out.println("Introduce el nombre del producto: ");
            String nombre = sc.nextLine();
            System.out.println("Introduce la cantidad del producto: ");
            int cantidad = sc.nextInt();
            System.out.println("Introduce el precio del producto: ");
            double precio = sc.nextDouble();
            sc.nextLine();

            Producto nuevo = new Producto(codigo, nombre, cantidad, precio);
            productos.add(nuevo);

        }catch (InputMismatchException e){
            System.out.println("Error: "+e.getMessage());
        }
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