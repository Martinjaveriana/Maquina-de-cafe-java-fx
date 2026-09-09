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

        lblError.setText("");
        // TODO: guardar nombre/apellido/tipoCafe/tamano en el ContextManager
        // y navegar a la pantalla de nivel de azúcar.
        System.out.printf("Pedido: %s %s -> %s (%s)%n",
                nombre, apellido, cafeSeleccionado.getText(), tamanoSeleccionado.getText());
    }

    @FXML
    public void volver() {
        sceneManager.showWelcome();
    }
}