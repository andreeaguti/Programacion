package com.decroly;

import com.decroly.excepciones.CineException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Pelicula implements Serializable {

    @Serial
    private static final long serialVersionUID = -3289559316984388622L;

    private int id;
    private String titulo;
    private String genero;
    private int duracion;

    public Pelicula(int id, String titulo, int duracion, String genero) {
        this.id = id;
        setTitulo(titulo);
        setDuracion(duracion);
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()){
            throw new CineException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(int duracion) throws CineException {
        if (duracion <= 0 ) {
            throw new CineException("La duracion de la pelicula debe ser mayor a 0 minutos");
        }
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pelicula{");
        sb.append("id=").append(id);
        sb.append(", titulo='").append(titulo).append('\'');
        sb.append(", genero='").append(genero).append('\'');
        sb.append(", duracion=").append(duracion);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id == pelicula.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
