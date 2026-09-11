package org.example.maquinadecafejavafx.services;

import org.example.maquinadecafejavafx.entities.Menu;
import org.example.maquinadecafejavafx.repositories.PrecioRepository;

public class PrecioService {

    /*
     *
     * ATRIBUTOS
     *
     * */

    private final PrecioRepository precioRepository;

    public PrecioService(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    public int calcularPrecio(String producto, String tamano) {
        Menu menu = precioRepository.obtenerMenu();
        int precio = menu.buscarProducto(producto, tamano);

        if (precio == 0) {
            throw new IllegalArgumentException(
                    "No hay precio registrado para \"" + producto + "\" (" + tamano + ").");
        }

        return precio;
    }
}