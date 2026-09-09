package org.example.maquinadecafejavafx.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.example.maquinadecafejavafx.managers.ContextManager;
import org.example.maquinadecafejavafx.managers.SceneManager;

public class PedidoController {

    private final SceneManager sceneManager;
    private final ContextManager context;

    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private ToggleGroup grupoCafe;
    @FXML private ToggleGroup grupoTamano;
    @FXML private Label lblError;

    public PedidoController(SceneManager sceneManager, ContextManager context) {
        this.sceneManager = sceneManager;
        this.context = context;
    }

    @FXML
    private void continuar() {
        String nombre = txtNombre.getText().trim();
        String apellido = txtApellido.getText().trim();
        RadioButton cafeSeleccionado = (RadioButton) grupoCafe.getSelectedToggle();
        RadioButton tamanoSeleccionado = (RadioButton) grupoTamano.getSelectedToggle();

        /// SE DA UN MENSAJE DE ERROR QUE INDICA EL CAMPO INCOMPLETO
        if (nombre.isEmpty() || apellido.isEmpty()) {
            lblError.setText("Por favor ingresa tu nombre y apellido.");
            return;
        }
        if (cafeSeleccionado == null) {
            lblError.setText("Selecciona un tipo de café.");
            return;
        }
        if (tamanoSeleccionado == null) {
            lblError.setText("Selecciona un tamaño.");
            return;
        }

        //si nada esta vacio se puede seguir a la pantalla de la azucar
        if (cafeSeleccionado.getText() != null && tamanoSeleccionado.getText() != null && !txtNombre.getText().isEmpty() && !txtApellido.getText().isEmpty()){
            sceneManager.showAzucar();
        }

        lblError.setText("");

        //Persiste la informacion
        context.setNombre(nombre);
        context.setApellido(apellido);
        context.setTipoDeCafe(cafeSeleccionado.getText());
        context.setTamano(tamanoSeleccionado.getText());

        System.out.printf("Pedido: %s %s -> %s (%s)%n",
                nombre, apellido, cafeSeleccionado.getText(), tamanoSeleccionado.getText());
    }

    @FXML
    public void volver() {
        sceneManager.showWelcome();
    }
}