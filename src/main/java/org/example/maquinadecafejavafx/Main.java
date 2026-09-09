package org.example.maquinadecafejavafx;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.maquinadecafejavafx.managers.ContextManager;
import org.example.maquinadecafejavafx.managers.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage stagePrincipal) {
        ContextManager contextManager = new ContextManager();
        SceneManager sceneManager = new SceneManager(stagePrincipal, contextManager);
        sceneManager.showWelcome();
    }

    public static void main(String[] args) {
        launch(args);
    }
}