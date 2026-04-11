package com.decroly;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Sesion implements Serializable {

    @Serial
    private static final long serialVersionUID = 2277560305016674678L;
    private int id;
    private Pelicula pelicula;
    private Sala sala;
    private String hora;

    public Sesion(int id, Pelicula pelicula, Sala sala, String hora) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public String getHora() {
        return hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sesion{");
        sb.append("id=").append(id);
        sb.append(", pelicula=").append(pelicula);
        sb.append(", sala=").append(sala);
        sb.append(", hora='").append(hora).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sesion sesion = (Sesion) o;
        return id == sesion.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
