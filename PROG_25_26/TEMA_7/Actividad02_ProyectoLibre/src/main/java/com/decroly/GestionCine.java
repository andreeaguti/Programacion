package com.decroly;

import com.decroly.excepciones.CineException;

import java.util.List;

public class GestionCine {

    //ATRIBUTOS (Colecciones)
    private List<Pelicula> listaPeliculas;
    private List<Sesion> listaSesiones;
    private List<Usuario> listaUsuarios;
    private List<Entrada> registroVentas; //Para guardar las entradas vendidas

    //CONSTRUCTOR
    public GestionCine(List<Pelicula> listaPeliculas, List<Sesion> listaSesiones, List<Usuario> listaUsuarios, List<Entrada> registroVentas) throws CineException {
        this.listaPeliculas = listaPeliculas;
        this.listaSesiones = listaSesiones;
        this.listaUsuarios = listaUsuarios;
        this.registroVentas = registroVentas;
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
            throw new IllegalArgumentException("La entrada no puede ser nula");
        } if (e.getPrecioBase() <= 0){
            throw new IllegalArgumentException("La entrada no puede valer menos de 0");
        }
        registroVentas.add(e);
        System.out.println("Venta registrada: " + e.calcularPrecioFinal() + "€");
    }

    public void mostrarCartelera() {
        System.out.println("\n--- CARTELERA ---");
        for (Sesion s : listaSesiones) {
            System.out.println(s.toString());
        }
    }



}
