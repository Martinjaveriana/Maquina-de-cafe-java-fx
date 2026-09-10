package org.example.maquinadecafejavafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.maquinadecafejavafx.managers.ContextManager;
import org.example.maquinadecafejavafx.managers.SesionManager;
import org.example.maquinadecafejavafx.managers.SceneManager;
import org.example.maquinadecafejavafx.repositories.PrecioRepository;
import org.example.maquinadecafejavafx.services.PrecioService;

public class Main extends Application {

    @Override
    public void start(Stage stagePrincipal) {

        PrecioRepository precioRepository = new PrecioRepository();

        PrecioService precioService = new PrecioService(precioRepository);

        SesionManager sesionManager = new SesionManager();
        ContextManager contextManager = new ContextManager(precioRepository, precioService);
        SceneManager sceneManager = new SceneManager(stagePrincipal, sesionManager, contextManager);
        sceneManager.showWelcome();
    }

    public static void main(String[] args) {
        //Inicia el motor grafico de java fx
        launch(args);
    }
}