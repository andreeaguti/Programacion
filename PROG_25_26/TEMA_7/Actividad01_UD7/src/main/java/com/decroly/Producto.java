package com.decroly;

public class Producto {
    private int id;
    private String referencia;
    private String nombre;
    private String descripcion;
    private int idTipo; // Referencia al ID de la tabla de tipos
    private int cantidad;
    private double precio;
    private int descuento;
    private int iva;
    private boolean aplicarDto;

    // Constructor completo
    public Producto(int id, String referencia, String nombre, String descripcion,
                    int idTipo, int cantidad, double precio, int descuento,
                    int iva, boolean aplicarDto) {
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTipo = idTipo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.iva = iva;
        this.aplicarDto = aplicarDto;
    }

    // Getters y Setters

    public int getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDescuento() {
        return descuento;
    }

    public int getIva() {
        return iva;
    }

    public boolean isAplicarDto() {
        return aplicarDto;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public void setAplicarDto(boolean aplicarDto) {
        this.aplicarDto = aplicarDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("\n--- FICHA DE PRODUCTO ---\n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Referencia: '").append(referencia).append("'\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Descripción: ").append(descripcion).append("\n");
        sb.append("ID Tipo: ").append(idTipo).append("\n");
        sb.append("Cantidad: ").append(cantidad).append("\n");
        sb.append("Precio: ").append(precio).append(" €\n");
        sb.append("Descuento: ").append(descuento).append(" %\n");
        sb.append("IVA: ").append(iva).append(" %\n");
        // Un toque extra: que ponga Sí/No en lugar de true/false
        sb.append("¿Aplica Dto?: ").append(aplicarDto ? "Sí" : "No").append("\n");
        sb.append("-------------------------");
        return sb.toString();
    }
}
