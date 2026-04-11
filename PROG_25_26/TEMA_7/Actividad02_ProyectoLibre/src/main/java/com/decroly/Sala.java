package com.decroly;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Sala implements Serializable {

    @Serial
    private static final long serialVersionUID = -384823999332703385L;

    private int numero;
    private int filas;
    private int columnas;


    public Sala(int numero, int filas, int columnas) {
        this.numero = numero;
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getNumero() {
        return numero;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sala{");
        sb.append("numero=").append(numero);
        sb.append(", filas=").append(filas);
        sb.append(", columnas=").append(columnas);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sala sala = (Sala) o;
        return numero == sala.numero;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numero);
    }
}
