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
                            System.out.println(productoEncontrado.toString()); // Usará tu toString
                        } else {
                            System.out.println("No se ha encontrado ningún producto con la referencia: " + refBuscada);
                        }
                        break;

                    case "3":
                        System.out.print("Introduce el tipo del producto: ");
                        int tipoBuscado = sc.nextInt(); // Leemos lo que escribe el usuario

                        Producto productosEncontrados = SQLAccessMercaDaw.getProductoPorTipo(tipoBuscado);

                        if (productosEncontrados != null) {
                            System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                            System.out.println(productosEncontrados.toString()); // Usará tu toString
                        } else {
                            System.out.println("No se ha encontrado ningún producto de tipo: " + tipoBuscado);
                        }
                        break;

                    case "4":
                        System.out.print("Introduce la cantidad del producto: ");
                        String cantidadBuscada = sc.nextLine(); // Leemos lo que escribe el usuario

                        Producto productosEncontrados2 = SQLAccessMercaDaw.getProductoPorCantidad(Integer.parseInt(cantidadBuscada)); // lo pasamos a numero

                        if (productosEncontrados2 != null) {
                            System.out.println("\n--- PRODUCTO ENCONTRADO ---");
                            System.out.println(productosEncontrados2.toString()); // Usará tu toString
                        } else {
                            System.out.println("No se ha encontrado ningún producto con la cantidad de : " + cantidadBuscada);
                        }
                        break;

                    case "5":
                        System.out.println("\n--- INSERTAR NUEVO PRODUCTO ---");

                        // 1. Pedir los datos al usuario
                        System.out.print("Referencia (ej: L005): ");
                        String ref = sc.nextLine();

                        // Validar si la referencia ya existe
                        if (SQLAccessMercaDaw.getProductoPorReferencia(ref) != null) {
                            System.out.println("Error: La referencia ya existe en el sistema.");
                            break;
                        }

                        System.out.print("Nombre: ");
                        String nom = sc.nextLine();

                        System.out.print("Descripción: ");
                        String desc = sc.nextLine();

                        System.out.print("ID Tipo (1-Lácteos, 2-Carnicería, 3-Bebidas, etc.): ");
                        int idTipo = Integer.parseInt(sc.nextLine());

                        System.out.print("Cantidad: ");
                        int cant = Integer.parseInt(sc.nextLine());

                        System.out.print("Precio: ");
                        double prec = Double.parseDouble(sc.nextLine());

                        System.out.print("Descuento (%): ");
                        int dto = Integer.parseInt(sc.nextLine());

                        System.out.print("IVA (%): ");
                        int iva = Integer.parseInt(sc.nextLine());

                        System.out.print("¿Aplicar descuento? (true/false): ");
                        boolean aplicar = Boolean.parseBoolean(sc.nextLine());

                        // 2. Crear el objeto Producto
                        // El ID se pone en 0 o -1 porque la base de datos lo genera solo (Auto-increment)
                        Producto nuevoProducto = new Producto(0, ref, nom, desc, idTipo, cant, prec, dto, iva, aplicar);

                        // 3. Llamar al metodo de eliminar
                        int resultado = SQLAccessMercaDaw.insertProductos(nuevoProducto);

                        // 4. Comprobar si funcionó
                        if (resultado > 0) {
                            System.out.println("¡Producto insertado!");
                        } else {
                            System.out.println("No se pudo insertar el producto.");
                        }
                        break;

                    case "6":
                        System.out.println("\n--- ELIMINAR UN PRODUCTO ---");

                        // 1. Pedir los datos al usuario
                        System.out.print("Referencia del producto que desea eliminar (ej: L005): ");
                        String referencia = sc.nextLine();

                            int resultado2 = SQLAccessMercaDaw.deleteProductoByRef(referencia);

                            if (resultado2 >= 0) {
                                System.out.println("¡Producto eliminado!");
                            } else {
                                System.out.println("No se pudo eliminar el producto.");
                            }
                        break;
                    case "7":

                        System.out.println("\n--- ACTUALIZAR UN PRODUCTO ---");

                        // 1. Pedir los datos al usuario
                        System.out.print("Referencia del producto que desea actualizar (ej: L005): ");
                        String ref2 = sc.nextLine();

                        Producto productoExistente = SQLAccessMercaDaw.getProductoPorReferencia(ref2);
                        // Validar si la referencia ya existe
                        if (productoExistente == null) {
                            System.out.println("❌ Error: La referencia no existe en el sistema.");
                            break;
                        }
                        //descripción, cantidad, precio, descuento, AplicarDto
                        System.out.print("Descripción: ");
                        String descripcion = sc.nextLine();

                        System.out.print("Cantidad: ");
                        int cantidad = Integer.parseInt(sc.nextLine());

                        System.out.print("Precio: ");
                        double precio = Double.parseDouble(sc.nextLine());

                        System.out.print("Descuento (%): ");
                        int descuento = Integer.parseInt(sc.nextLine());

                        System.out.print("¿Aplicar descuento? (true/false): ");
                        boolean aplicarDto = Boolean.parseBoolean(sc.nextLine());

                        Producto miProductoEditado = new Producto(
                                productoExistente.getId(),
                                ref2,
                                productoExistente.getNombre(),
                                descripcion,
                                productoExistente.getIdTipo(),
                                cantidad,
                                precio,
                                descuento,
                                productoExistente.getIva(),
                                aplicarDto
                        );

                        int actualizar = SQLAccessMercaDaw.updateProducto(miProductoEditado);

                        if (actualizar > 0) {
                            System.out.println("¡Producto actualizado!");
                        } else {
                            System.out.println("No se pudo actualizar el producto.");
                        }
                        break;

                    case "8":
                        System.out.println("\n--- INSERTAR NUEVO TIPO DE PRODUCTO ---");

                        // 1. Pedir los datos al usuario

                        System.out.print("Nombre: ");
                        String nombreTipo = sc.nextLine();

                        // 2. Crear el objeto TipoProducto
                        // El ID se pone en 0 o -1 porque la base de datos lo genera solo (Auto-increment)
                        TipoProducto nuevoTipo = new TipoProducto(0, nombreTipo);

                        // 3. Llamar al metodo de eliminar
                        int resultado5 = SQLAccessMercaDaw.insertTipoProducto(nuevoTipo);

                        // 4. Comprobar si funcionó
                        if (resultado5 > 0) {
                            System.out.println("¡Tipo de producto añadido!");
                        } else {
                            System.out.println("No se pudo añadir el tipo de producto.");
                        }
                        break;
                    case "9":
                        System.out.println("Cerrando Inventario.");
                        break;
                }
            }catch(Exception e) {
                e.printStackTrace(); //mostrar las llamadas
            }
        }while(!opcion.equals("9"));

    }

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