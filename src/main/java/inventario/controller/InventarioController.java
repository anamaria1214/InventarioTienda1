package inventario.controller;

import inventario.model.Producto;
import inventario.model.Tienda;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarioController implements Initializable {

    private Tienda tienda = Tienda.getInstance();


    @FXML
    private TextField texto;

    @FXML
    private TableColumn<Producto, Integer> columnaCantidadProducto;

    @FXML
    private TableColumn<Producto, String> columnaIdentificacionProducto;

    @FXML
    private TableColumn<Producto, String> columnaNombreProducto;

    @FXML
    private TableColumn<Producto, Double> columnaPrecioProducto;

    @FXML
    private TableView<Producto> tablaProductos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnaCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("cantInventario"));
        columnaIdentificacionProducto.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
        columnaNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        columnaPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaProductos.setItems( FXCollections.observableList(tienda.getProductos().stream().toList()) );


    }
}
