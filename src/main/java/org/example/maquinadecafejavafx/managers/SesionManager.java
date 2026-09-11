package org.example.maquinadecafejavafx.managers;

import org.example.maquinadecafejavafx.entities.Producto;
import org.example.maquinadecafejavafx.entities.Usuario;

public class SesionManager {

    /*
    *
    * ATRIBUTOS
    *
    * */

    private Usuario usuario;
    private Producto producto;
    private int valorIngresado;

    public SesionManager() {
        this.usuario = null;
        this.producto = null;
        this.valorIngresado = 0;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getValorIngresado() {
        return valorIngresado;
    }

    public void setValorIngresado(int valorIngresado) {
        this.valorIngresado = valorIngresado;
    }

    public String getAzucar() {
        return this.getProducto().getNivelAzucar();
    }

    public void setAzucar(String azucar) {
        this.getProducto().setNivelAzucar(azucar);
    }

    public int getPrecio() {
        return this.getProducto().getPrecio();
    }

    public void setPrecio(int precio) {
        this.getProducto().setPrecio(precio);
    }

    public String getTipoDeCafe() {
        return this.getProducto().getNombre();
    }

    public void setTipoDeCafe(String tipoCafe) {
        this.getProducto().setNombre(tipoCafe);
    }

    public String getTamano() {
        return this.getProducto().getTamano();
    }

    public void setTamano(String tamano) {
        this.getProducto().setTamano(tamano);
    }

    public String getNombre() {
        return this.getUsuario().getNombre();
    }

    public void setNombre(String nombre) {
        this.getUsuario().setNombre(nombre);
    }

    public String getApellido() {
        return this.getUsuario().getApellido();
    }

    public void setApellido(String apellido) {
        this.getUsuario().setApellido(apellido);
    }



    public void vaciar(){
        this.usuario = null;
        this.producto = null;
        this.valorIngresado = 0;
    }
}
