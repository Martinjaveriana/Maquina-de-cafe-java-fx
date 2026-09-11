package org.example.maquinadecafejavafx.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.maquinadecafejavafx.managers.SesionManager;
import org.example.maquinadecafejavafx.managers.SceneManager;
import org.example.maquinadecafejavafx.services.PrecioService;

public class ReciboController implements Initializable {

    /*
     *
     * ATRIBUTOS
     *
     * */

    private final SceneManager sceneManager;
    private final SesionManager sesion;
    private final PrecioService precioService;

    @FXML private Label lblCliente;
    @FXML private Label lblProducto;
    @FXML private Label lblPrecio;
    @FXML private TextField txtValorIngresado;
    @FXML private Label lblMensaje;
    @FXML private Button btnContinuar;

    private boolean pagoRealizado = false;

    public ReciboController(SceneManager sceneManager, SesionManager sesion, PrecioService precioService) {
        this.sceneManager = sceneManager;
        this.sesion = sesion;
        this.precioService = precioService;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sesion.setPrecio(precioService.calcularPrecio(sesion.getTipoDeCafe(), sesion.getTamano()));

        lblCliente.setText(sesion.getNombre() + " " + sesion.getApellido());
        lblProducto.setText(sesion.getTipoDeCafe() + " - " + sesion.getTamano()
                + " - Azúcar: " + sesion.getAzucar());
        lblPrecio.setText("Total a pagar: $" + sesion.getPrecio());
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

        if (valorIngresado < sesion.getPrecio()) {
            mostrarError("El valor ingresado no alcanza. Faltan $"
                    + (sesion.getPrecio() - valorIngresado) + ".");
            return;
        }

        sesion.setValorIngresado(valorIngresado);
        int vueltas = valorIngresado - sesion.getPrecio();

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
        sesion.vaciar();
        sceneManager.showWelcome();
    }

    private void mostrarError(String mensaje) {
        pagoRealizado = false;
        btnContinuar.setDisable(true);
        lblMensaje.setStyle("-fx-text-fill: #b3261e; -fx-font-size: 12px;");
        lblMensaje.setText(mensaje);
    }
}