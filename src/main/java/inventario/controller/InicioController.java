package inventario.controller;

import inventario.model.Tienda;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import inventario.app.Main;

import java.io.IOException;

public class InicioController {

    private Tienda tienda = Tienda.getInstance();
    
    @FXML
    private Button btnClientes;

    @FXML
    private Button btnProductos;

    @FXML
    private Button btnVentas;
    @FXML
    private BorderPane centerPane;


    public void abrirVentanaCliente() {
        cambiarVentana("crudCliente");
    }
    public void abrirVentanaInventario() {
        cambiarVentana("inventario");
    }
    public void abrirVentanaVentas() {
        cambiarVentana("ventas");
    }

    private void cambiarVentana(String fxmlname) {
        try {
            Node nodo = Main.loadFXML(fxmlname);
            setCenter(nodo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("exports")
    public void setCenter(Node node) {
        centerPane.setCenter(node);
    }
}
