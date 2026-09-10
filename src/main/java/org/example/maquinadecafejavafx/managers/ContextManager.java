package org.example.maquinadecafejavafx.managers;

import org.example.maquinadecafejavafx.repositories.PrecioRepository;
import org.example.maquinadecafejavafx.services.PrecioService;

public class ContextManager {
    private PrecioRepository precioRepository;
    private PrecioService precioService;

    public ContextManager(PrecioRepository precioRepository, PrecioService precioService) {
        this.precioRepository = precioRepository;
        this.precioService = precioService;
    }

    public PrecioRepository getPrecioRepository() {
        return precioRepository;
    }

    public void setPrecioRepository(PrecioRepository precioRepository) {
        this.precioRepository = precioRepository;
    }

    public PrecioService getPrecioService() {
        return precioService;
    }

    public void setPrecioService(PrecioService precioService) {
        this.precioService = precioService;
    }
}
