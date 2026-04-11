package com.decroly;

import java.io.Serial;
import java.io.Serializable;

public abstract class Entrada implements Serializable {
    /** PORQUE LO HE HECHO SERIALIZABLE? Y PORQUE NO EN TEXTO PLANO?
     * Si vendes 10 entradas y cierras el programa, los datos desaparecen.
     Al ser Serializable, podemos guardar la "partida" en un archivo y recuperarla al día siguiente.
     * Uso texto plano para los tickets de los clientes porque deben ser legibles por humanos, pero uso serialización
     * para la base de datos interna de ventas.
     * */

    @Serial
    private static final long serialVersionUID = -3363652341803407965L;
    //ATRIBUTOS
    protected int id;
    protected int idSesion;
    protected int fila;
    protected int columna;
    protected double precioBase;

    //CONSTRUCTOR
    public Entrada(int id, int idSesion, int fila, int columna, double precioBase) {
        this.id = id;
        this.idSesion = idSesion;
        this.fila = fila;
        this.columna = columna;
        this.precioBase = precioBase;
    }

    public abstract double calcularPrecioFinal(); //Obliga a sus Clases hijas a implementar su precio

    //GETTERS
    public int getId() {
        return id;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    //SETTERS
    public void setId(int id) {
        this.id = id;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Entrada{");
        sb.append("id=").append(id);
        sb.append(", idSesion=").append(idSesion);
        sb.append(", fila=").append(fila);
        sb.append(", columna=").append(columna);
        sb.append(", precioBase=").append(precioBase);
        sb.append('}');
        return sb.toString();
    }
}
