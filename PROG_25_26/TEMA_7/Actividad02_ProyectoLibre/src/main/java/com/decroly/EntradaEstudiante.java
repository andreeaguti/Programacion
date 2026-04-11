package com.decroly;

public class EntradaEstudiante extends Entrada {

    public EntradaEstudiante(int id, int idSesion, int fila, int columna, double precioBase) {
        super(id, idSesion, fila, columna, precioBase);
    }

    @Override
    public double calcularPrecioFinal() {
        return this.precioBase * 0.8;
    }
}
