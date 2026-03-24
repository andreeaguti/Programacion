package com.decroly;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String opcion = "";


        Connection cn = SqlDataManager.getConnection();

        if (cn != null) {
            System.out.println("¡Conexión establecida con mercaDaw! 🦸‍♂️");
        } else {
            System.out.println("No se pudo conectar. Revisa la consola para ver el error.");
        }

        do{
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            try {
                switch (opcion) {
                    case "1":
                        List<Producto> productos = SQLAccessMercaDaw.getProductos();
                        if (productos.isEmpty()) {
                            System.out.println("La lista de productos está vacía");
                        } else{
                            System.out.println("\n--- LISTA DE PRODUCTOS ---");
                            // Recorrer la lista con un bucle for-each
                            for (Producto p : productos) {
                                System.out.println(p.toString());
                            }
                        }
                        break;
                    case "2":
                        System.out.print("Introduce la referencia del producto (ej: L001): ");
                        String refBuscada = sc.nextLine(); // Leemos lo que escribe el usuario

                        // Llamo al metodo y guardamos el resultado
                        Producto productoEncontrado = SQLAccessMercaDaw.getProductoPorReferencia(refBuscada);

                        if (productoEncontrado != null) {
                            System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                            System.out.println(productoEncontrado.toString()); // Usará tu toString vertical
                        } else {
                            System.out.println("No se ha encontrado ningún producto con la referencia: " + refBuscada);
                        }
                        break;
                    case "3":
                        System.out.print("Introduce el tipo del producto: ");
                        String tipoBuscado = sc.nextLine(); // Leemos lo que escribe el usuario

                        Producto productosEncontrados = SQLAccessMercaDaw.getProductoPorTipo(Integer.parseInt(tipoBuscado));

                        if (productosEncontrados != null) {
                            System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                            System.out.println(productosEncontrados.toString()); // Usará tu toString vertical
                        } else {
                            System.out.println("No se ha encontrado ningún producto con la referencia: " + tipoBuscado);
                        }
                        break;
                    case "4":

                        break;
                }
            }catch(Exception e) {
                e.printStackTrace(); //mostrar las llamadas
            }
        }while(!opcion.equals("9"));

    }
    /*
    "ID: " + p.getId() +
                                        " | Ref: " + p.getReferencia() +
                                        " | Nombre: " + p.getNombre() +
                                        " | Descripción: " + p.getDescripcion() +
                                        " | Precio: " + p.getPrecio() + "€" +
                                        " | IVA: " + p.getIva()*/

    private static void imprimirMenuOpciones() {
        System.out.println("\n--- MENÚ DE MERCADAW ---");
        System.out.println("1. Mostrar todos los Productos en el Inventario");
        System.out.println("2. Buscar producto por referencia");
        System.out.println("3. Buscar productos por tipo");
        System.out.println("4. Buscar producto por cantidad");
        System.out.println("5. Insertar un nuevo producto (no permitir referencias repetidas)");
        System.out.println("6. Eliminar Producto por referencia ");
        System.out.println("7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto)");
        System.out.println("8. Insertar un nuevo tipo de producto ");
        System.out.println("9. Salir ");
        System.out.print("Seleccione una opción: ");
    }
}