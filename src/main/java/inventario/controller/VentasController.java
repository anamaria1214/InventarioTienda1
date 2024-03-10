package inventario.controller;

import inventario.model.Tienda;
import inventario.model.Venta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class VentasController implements Initializable {

    private Tienda tienda = Tienda.getInstance();
    @FXML
    private TableColumn<Venta, Integer> ColumnCliente;

    @FXML
    private TableColumn<Venta, Double> ColumnPrecioTotal;

    @FXML
    private TableColumn<Venta, Integer> columnCodigo;

    @FXML
    private TableColumn<Venta, String> columnFecha;

    @FXML
    private TableView<Venta> tablaVentas;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ColumnCliente.setCellValueFactory(new PropertyValueFactory<>("idCliente"));
        ColumnPrecioTotal.setCellValueFactory(new PropertyValueFactory<>("PrecioTotal"));
        columnCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoventa"));
        columnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        tablaVentas.setItems( FXCollections.observableList(tienda.getVentas().stream().toList()) );

    }
}
