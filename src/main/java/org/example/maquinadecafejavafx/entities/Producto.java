package org.example.maquinadecafejavafx.entities;

public class Producto {

    /*
     *
     * ATRIBUTOS
     *
     * */

    private String nombre;
    private String tamano;
    private String nivelAzucar;
    private int precio;

    public Producto(String nombre, int precio, String tamano, String nivelAzucar) {
        this.nombre = nombre;
        this.precio = precio;
        this.tamano = tamano;
        this.nivelAzucar = nivelAzucar;
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

    public String getNivelAzucar() {
        return nivelAzucar;
    }

    public void setNivelAzucar(String nivelAzucar) {
        this.nivelAzucar = nivelAzucar;
    }
}
