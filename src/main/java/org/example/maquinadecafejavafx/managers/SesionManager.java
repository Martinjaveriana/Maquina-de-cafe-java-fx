package org.example.maquinadecafejavafx.managers;

public class SesionManager {
    private String nombre;
    private String apellido;
    private String tipoDeCafe;
    private String nivelAzucar;
    private String tamano;
    private int precio;
    private int valorIngreado;

    public SesionManager() {
        this.nombre = null;
        this.apellido = null;
        this.tipoDeCafe = null;
        this.nivelAzucar = null;
        this.tamano = null;
        this.precio = 0;
        this.valorIngreado = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDeCafe() {
        return tipoDeCafe;
    }

    public void setTipoDeCafe(String tipoDeCafe) {
        this.tipoDeCafe = tipoDeCafe;
    }

    public String getNivelAzucar() {
        return nivelAzucar;
    }

    public void setNivelAzucar(String nivelAzucar) {
        this.nivelAzucar = nivelAzucar;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getValorIngreado() {
        return valorIngreado;
    }

    public void setValorIngreado(int valorIngreado) {
        this.valorIngreado = valorIngreado;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void vaciar(){
        this.nombre = null;
        this.apellido = null;
        this.tipoDeCafe = null;
        this.nivelAzucar = null;
        this.tamano = null;
        this.precio = 0;
        this.valorIngreado = 0;
    }
}
