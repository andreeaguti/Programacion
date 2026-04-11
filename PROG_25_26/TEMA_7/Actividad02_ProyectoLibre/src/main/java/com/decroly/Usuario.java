package com.decroly;

import com.decroly.excepciones.CineException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {

    @Serial
    private static final long serialVersionUID = 6034740040037360084L;

    private int id;
    private String nombre;
    private String email;

    public Usuario(int id, String nombre, String email) throws CineException {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    //SETTER CON VALIDACION
    public void setNombre(String nombre) throws CineException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new CineException("El nombre del usuario no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setEmail(String email) throws CineException {
        if (email == null) {
            throw new CineException("El email no puede estar vacio.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
