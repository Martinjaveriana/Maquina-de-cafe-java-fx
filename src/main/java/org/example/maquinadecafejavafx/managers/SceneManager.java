package org.example.maquinadecafejavafx.managers;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.maquinadecafejavafx.controllers.AzucarController;
import org.example.maquinadecafejavafx.controllers.PedidoController;
import org.example.maquinadecafejavafx.controllers.WelcomeController;

public class SceneManager {

    private final Stage stage;
    private final ContextManager context;

    public SceneManager(Stage stage, ContextManager context) {
        this.stage = stage;
        this.context = context;
    }

    /* MUESTRA LA PANTALLA DE INICIO */
    public void showWelcome() {
        WelcomeController welcomeController = new WelcomeController(this);
        loadScene("/org/example/maquinadecafejavafx/welcome-view.fxml", welcomeController);
        stage.setTitle("Máquina de café");
    }

    /* MUESTRA EL FORMULARIO DE PEDIDO */
    public void showPedido() {
        PedidoController pedidoController = new PedidoController(this, context);
        loadScene("/org/example/maquinadecafejavafx/pedido-view.fxml", pedidoController);
        stage.setTitle("Máquina de café - Nuevo pedido");
    }

    /*MUESTRA LA PANTALLA EN DONDE SE SELECCIONA EL NIVEL DE AZUCAR*/
    public void showAzucar(){
        AzucarController azucarController = new AzucarController(this, context);
        loadScene("/org/example/maquinadecafejavafx/azucar-view.fxml", azucarController);
    }

    private void loadScene(String fxml, Object controller) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            loader.setController(controller);
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar la vista: " + fxml, e);
        }
    }
}