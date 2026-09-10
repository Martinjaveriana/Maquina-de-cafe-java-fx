package org.example.maquinadecafejavafx.entities;

public class Producto {
    private String nombre;
    private String tamano;
    private int precio;

    public Producto(String nombre, int precio, String tamano) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

}
