package org.example.maquinadecafejavafx.controllers;

import javafx.fxml.FXML;
import org.example.maquinadecafejavafx.managers.SceneManager;

public class WelcomeController {

    /*
     *
     * ATRIBUTOS
     *
     * */

    private final SceneManager sceneManager;

    public WelcomeController(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    public void iniciarPedido() {
        sceneManager.showPedido();
    }
}