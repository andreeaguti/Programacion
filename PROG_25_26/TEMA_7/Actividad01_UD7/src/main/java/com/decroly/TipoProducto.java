package com.decroly;

public class TipoProducto {
    private int id_tipo;
    private String nombre_tipo;


    public TipoProducto(int id_tipo, String nombre_tipo) {
        this.id_tipo = id_tipo;
        this.nombre_tipo = nombre_tipo;
    }


    public int getId_tipo() {
        return id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoProducto{");
        sb.append("id_tipo=").append(id_tipo);
        sb.append(", nombre_tipo=").append(nombre_tipo);
        sb.append('}');
        return sb.toString();
    }
}
