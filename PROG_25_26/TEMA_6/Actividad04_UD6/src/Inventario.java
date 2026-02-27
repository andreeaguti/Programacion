import java.io.*;
import java.util.Scanner;
import java.util.*;


public class Inventario {

    private static ArrayList<Producto> listaProductos = new ArrayList<>();

    private static final String PATH = ".\\src\\resources\\";

    public static void main(String[] args) {

        cargarDesdeDAT("almacen.dat");
        cargarDesdeCSV("productos.csv");

        Scanner sc = new Scanner(System.in);
        String opcion = "";

        do {
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        mostrarProductos();
                        break;
                    case "2":
                        eliminarProducto();
                        break;
                    case "3":
                        guardarEnFichero();
                        break;
                    case "4":
                        crearProducto();
                        break;
                }
            }catch(Exception e) {
                e.printStackTrace(); //mostrar las llamadas
            }
        }while (!opcion.equals("3"));
    }

    private static void cargarDesdeDAT(String filename) {
        File f = new File(PATH + filename);
        if (!f.exists())
            return;

        boolean eof = false;
        try (DataInputStream lector = new DataInputStream(new FileInputStream(f))) {
            while (!eof) {
                try {
                    String ref = lector.readUTF();
                    String desc = lector.readUTF();
                    String tipo = lector.readUTF();
                    int cant = lector.readInt();
                    double precio = lector.readDouble();
                    int dto = lector.readInt();
                    int iva = lector.readInt();
                    boolean aplica = lector.readBoolean();

                    listaProductos.add(new Producto(ref, desc, tipo, cant, precio, dto, iva, aplica));
                } catch (EOFException e) {
                    eof = true;
                }
            }
            System.out.println("Carga de binario finalizada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void cargarDesdeCSV(String filename) {

        try (FileReader file = new FileReader(PATH + filename);
             BufferedReader bufferedReader = new BufferedReader(file)) {

            String linea = "";

            while (linea != null) {
                linea = bufferedReader.readLine();

                if (linea != null) {
                    // Comprobamos que la línea no esté vacía
                    if (!linea.trim().equals("")) {
                        String[] datosLinea = linea.split(",");

                        // Extraemos y limpiamos (trim) cada campo según el orden de Producto
                        String referencia = datosLinea[0].trim();
                        String descripcion = datosLinea[1].trim();
                        String tipo = datosLinea[2].trim();

                        // Conversiones de tipos necesarias
                        int cantidad = Integer.parseInt(datosLinea[3].trim());
                        double precio = Double.parseDouble(datosLinea[4].trim());
                        int descuento = Integer.parseInt(datosLinea[5].trim());
                        int iva = Integer.parseInt(datosLinea[6].trim());
                        boolean aplicarDto = Boolean.parseBoolean(datosLinea[7].trim());

                        // Creamos el objeto y lo añadimos a la lista de la clase
                        Producto p = new Producto(referencia, descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);
                        listaProductos.add(p);
                    }
                }
            }
        } catch (IOException e) {
            // Según las instrucciones del ejercicio: mensaje breve y printStackTrace
            System.out.println("Error al leer el archivo CSV: " + filename);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Error: Formato de número no válido en el archivo CSV.");
            e.printStackTrace();
        }
    }

    //METODO PARA MOSTRAR LOS PRODUCTOS
    public static void mostrarProductos(){
        if(listaProductos.isEmpty()){
            System.out.println("No hay productos");
        }else{
            for(Producto producto : listaProductos){
                System.out.println(producto.toString());
            }
        }
    }

    //METODO PARA ELIMINAR PRODUCTO POR REFERENCIA
    private static void eliminarProducto() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la referencia del producto que desea eliminar: ");
        String referencia = sc.nextLine();

        Producto pAux= null;
        for(Producto productoAux : listaProductos){
            if(productoAux.getReferencia().equals(referencia)){
                pAux = productoAux;
                break;
            }
        }if(pAux != null){
            listaProductos.remove(pAux);
            System.out.println("Producto eliminado correctamente.");
        }else {
            throw new Exception("No existe el producto con el referencia: " + referencia);
        }
    }

    private static void crearProducto() throws Exception {
        Scanner sc = new Scanner(System.in);


            System.out.println("Introduzca la referencia del producto: ");
            String referencia = sc.nextLine();

            for (Producto producto : listaProductos) {
                if (producto.getReferencia().equalsIgnoreCase(referencia)) {
                    throw new Exception("Error: Ya existe un producto con esa referencia.");
                }
            }

            System.out.println("Introduzca la descripcion del producto: ");
            String descripcion = sc.nextLine();
            System.out.println("Introduce a el tipo de libro: ");
            String tipo = sc.nextLine();

            System.out.println("Introduce la cantidad de producto: ");
            int cantidad = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce el precio del producto: ");
            double precio = Double.parseDouble(sc.nextLine());
            System.out.println("Introduce el descuento del producto: ");
            int descuento = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce el iva del producto: ");
            int iva = Integer.parseInt(sc.nextLine());
            System.out.println("Introduce si tiene desceunto el producto: ");
            boolean aplicarDto = Boolean.parseBoolean(sc.nextLine());

            Producto nuevo = new Producto(referencia,descripcion, tipo, cantidad, precio, descuento, iva, aplicarDto);

            listaProductos.add(nuevo);

            System.out.println("Producto guardado correctamente en la biblioteca");

    }

    private static void guardarEnFichero() {
        final String filename = "inventario.dat";

        File doc = new File(PATH);
        if (!doc.exists()) doc.mkdirs();

        try (DataOutputStream escritor = new DataOutputStream(new FileOutputStream(PATH + filename))) {
            for (Producto p : listaProductos) {
                escritor.writeUTF(p.getReferencia());
                escritor.writeUTF(p.getDescripcion());
                escritor.writeUTF(p.getTipo());
                escritor.writeInt(p.getCantidad());
                escritor.writeDouble(p.getPrecio());
                escritor.writeInt(p.getDescuento());
                escritor.writeInt(p.getIva());
                escritor.writeBoolean(p.isAplicarDto());
            }
            System.out.println("Datos guardados correctamente en el fichero binario.");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DEL PROGRAMA ---");
        System.out.println("1. Mostrar Productos en el Inventario");
        System.out.println("2. Eliminar Producto por referencia");
        System.out.println("3. Guardar y Salir (inventario.dat)");
        System.out.println("4. Registrar producto en el inventario");
        System.out.print("Seleccione una opción: ");
    }
}