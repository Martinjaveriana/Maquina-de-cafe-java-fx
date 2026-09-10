package org.example.maquinadecafejavafx.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.example.maquinadecafejavafx.managers.SesionManager;
import org.example.maquinadecafejavafx.managers.SceneManager;

public class AzucarController {

    private final SceneManager sceneManager;
    private final SesionManager sesion;

    @FXML
    private RadioButton rbNada;
    @FXML
    private RadioButton rbBajo;
    @FXML
    private RadioButton rbAlto;
    @FXML
    private ToggleGroup grupoAzucar;
    @FXML
    private Label lblError;
    @FXML
    private RadioButton rbMedio;

    public AzucarController(SceneManager sceneManager, SesionManager sesion) {
        this.sceneManager = sceneManager;
        this.sesion = sesion;
    }

    @FXML
    void continuar(ActionEvent event) {
        RadioButton azucarSeleccionado = (RadioButton) grupoAzucar.getSelectedToggle();
        if (azucarSeleccionado != null){
            sesion.setNivelAzucar(azucarSeleccionado.getText());
            sceneManager.showRecibo(); 
        } else{
            lblError.setText("Selecciona un nivel de azucar");
        }
    }

    @FXML
    public void cancelar() {
        sceneManager.showWelcome();
        sesion.vaciar();
    }

}
