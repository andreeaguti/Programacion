package com.decroly;

import com.decroly.excepciones.CineException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionCine implements Serializable {


    @Serial
    private static final long serialVersionUID = -4791327150223613864L;

    //ATRIBUTOS (Colecciones)
    private List<Pelicula> listaPeliculas;
    private List<Sesion> listaSesiones;
    private List<Usuario> listaUsuarios;
    private List<Entrada> registroVentas; //Para guardar las entradas vendidas

    //CONSTRUCTOR
    public GestionCine() throws CineException {
        this.listaPeliculas = new ArrayList<>();
        this.listaSesiones = new ArrayList<>();
        this.listaUsuarios = new ArrayList<>();
        this.registroVentas = new ArrayList<>();
    }

    //GETTERS
    public List<Pelicula> getListaPeliculas() {
        return listaPeliculas;
    }

    public List<Sesion> getListaSesiones() {
        return listaSesiones;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public List<Entrada> getRegistroVentas() {
        return registroVentas;
    }


    //METODOS
    public void anadirPelicula(Pelicula p) {
        listaPeliculas.add(p);
    }

    public void anadirSesion(Sesion s) {
        listaSesiones.add(s);
    }

    public void anadirUsuario(Usuario u) {
        listaUsuarios.add(u);
    }


    public void venderEntrada(Entrada e) throws CineException {
        if(e == null) {
            throw new CineException("La entrada no puede ser nula");
        } if (e.getPrecioBase() <= 0){
            throw new CineException("La entrada no puede valer menos de 0");
        }
        registroVentas.add(e);
        System.out.println("Venta registrada: " + e.calcularPrecioFinal() + "€");
    }

    public void mostrarCartelera() {
        System.out.println("\n--- CARTELERA ---");
        if (listaSesiones.isEmpty()) {
            System.out.println("No hay sesiones programadas actualmente.");
        } else {
            for (Sesion s : listaSesiones) {
                System.out.println(s.toString());
            }
        }
    }

    public void mostrarVentas() {
        System.out.println("\nREGISTRO DE VENTAS REALIZADAS");
        if (registroVentas.isEmpty()) {
            System.out.println("Todavía no se ha vendido ninguna entrada.");
        } else {
            double totalVentas = 0;
            for (Entrada e : registroVentas) {
                System.out.println(e.toString() + " | Precio: " + e.calcularPrecioFinal() + "€");
                totalVentas += e.calcularPrecioFinal();
            }
            System.out.println("-------------------------------------");
            System.out.println("RECAUDACIÓN TOTAL: " + totalVentas + "€");
        }
    }

    public Pelicula buscarPeliculaPorNombre(String nombre) {
        for (Pelicula p : listaPeliculas) {
            if (p.getTitulo().equalsIgnoreCase(nombre.trim())) {
                return p;
            }
        }
        return null;
    }

    public Sesion buscarSesionPorId(int id) {
        for (Sesion s : listaSesiones) {
            if (s.getId() == id) return s;
        }
        return null;
    }


    //METODO PARA GUARDAR DATOS EN FICHERO BINARIO
    public void guardarDatos(String archivo) throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(this); // "this" es el propio objeto GestionCine
        }
    }

    //METODO PARA CARGAR DATOS EN FICHERO BINARIO
    public static GestionCine cargarDatos(String archivo) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (GestionCine) ois.readObject();
        }
    }

}
