package inventario.controller;

import inventario.model.Producto;
import inventario.model.Tienda;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InventarioController implements Initializable {

    private Tienda tienda = Tienda.getInstance();

    @FXML
    private TableColumn<?, ?> columnaCantidadProducto;

    @FXML
    private TableColumn<?, ?> columnaIdentificacionProducto;

    @FXML
    private TableColumn<?, ?> columnaNombreProducto;

    @FXML
    private TableColumn<?, ?> columnaPrecioProducto;

    @FXML
    private TableView<Producto> tablaProductos;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnaCantidadProducto.setCellValueFactory(new PropertyValueFactory<>("cantInventario"));
        columnaIdentificacionProducto.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
        columnaNombreProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        columnaPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));

        //tablaProductos.setItems(FXCollections.observableSet(tienda.getProductos()));
    }
}
