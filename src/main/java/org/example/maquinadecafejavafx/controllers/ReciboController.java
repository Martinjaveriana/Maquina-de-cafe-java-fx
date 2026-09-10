package org.example.maquinadecafejavafx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.maquinadecafejavafx.managers.ContextManager;
import org.example.maquinadecafejavafx.managers.SceneManager;

public class ReciboController implements Initializable {

    private final SceneManager sceneManager;
    private final ContextManager context;

    @FXML private Label lblCliente;
    @FXML private Label lblProducto;
    @FXML private Label lblPrecio;
    @FXML private TextField txtValorIngresado;
    @FXML private Label lblMensaje;
    @FXML private Button btnContinuar;

    private boolean pagoRealizado = false;

    public ReciboController(SceneManager sceneManager, ContextManager context) {
        this.sceneManager = sceneManager;
        this.context = context;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblCliente.setText(context.getNombre() + " " + context.getApellido());
        lblProducto.setText(context.getTipoDeCafe() + " - " + context.getTamano()
                + " - Azúcar: " + context.getNivelAzucar());
        lblPrecio.setText("Total a pagar: $" + context.getPrecio());
        btnContinuar.setDisable(true);

        // Si el cliente cambia el valor después de haber pagado, se vuelve a
        // exigir pagar antes de dejarlo continuar.
        txtValorIngresado.textProperty().addListener((obs, viejo, nuevo) -> {
            if (pagoRealizado) {
                pagoRealizado = false;
                btnContinuar.setDisable(true);
                lblMensaje.setText("");
            }
        });
    }

    @FXML
    private void pagar() {
        String texto = txtValorIngresado.getText().trim();
        if (texto.isEmpty()) {
            mostrarError("Ingresa el valor con el que vas a pagar.");
            return;
        }

        int valorIngresado;
        try {
            valorIngresado = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            mostrarError("Ingresa solo números.");
            return;
        }

        if (valorIngresado < context.getPrecio()) {
            mostrarError("El valor ingresado no alcanza. Faltan $"
                    + (context.getPrecio() - valorIngresado) + ".");
            return;
        }

        context.setValorIngreado(valorIngresado);
        int vueltas = valorIngresado - context.getPrecio();

        pagoRealizado = true;
        btnContinuar.setDisable(false);
        lblMensaje.setStyle("-fx-text-fill: #2e7d32; -fx-font-size: 12px;");
        lblMensaje.setText(vueltas > 0
                ? "Pago exitoso. Tu cambio es $" + vueltas + "."
                : "Pago exitoso, pagaste con el valor exacto.");
    }

    @FXML
    private void continuar() {
        // TODO: aquí es donde la máquina entregaría el café y las vueltas.
        context.vaciar();
        sceneManager.showWelcome();
    }

    private void mostrarError(String mensaje) {
        pagoRealizado = false;
        btnContinuar.setDisable(true);
        lblMensaje.setStyle("-fx-text-fill: #b3261e; -fx-font-size: 12px;");
        lblMensaje.setText(mensaje);
    }
}