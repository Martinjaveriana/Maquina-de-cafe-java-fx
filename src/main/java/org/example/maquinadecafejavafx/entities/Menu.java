package org.example.maquinadecafejavafx.entities;

import java.util.List;

public class Menu {
    private List<Producto> productos;

    public Menu(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int buscarProducto(String nombre, String tamano){
        for( Producto p : productos){
            if (p.getNombre().equals(nombre) && p.getTamano().equals(tamano)){
                return p.getPrecio();
            }
        }
        return 0;
    }
}
