package inventario.controller;

import inventario.app.Main;
import inventario.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class CarritoController implements Initializable {
    private Tienda tienda = Tienda.getInstance();
    private ArrayList<DetalleVenta> detalles = new ArrayList<>();
    private ArrayList<Producto> carritoCompras= new ArrayList<>();

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnComprar;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField idProducto;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TableColumn<Producto, String> columProducto;
    @FXML
    private TableColumn<Producto, Integer> columnCodProducto;
    @FXML
    private TableColumn<Producto, Double> columnPrecioProducto;
    @FXML
    private TableView<Producto> tablaProductosCarritos;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        columnCodProducto.setCellValueFactory(new PropertyValueFactory<>("codProducto"));
        columProducto.setCellValueFactory(new PropertyValueFactory<>("nombreProducto"));
        columnPrecioProducto.setCellValueFactory(new PropertyValueFactory<>("precio"));


    }
    public void agregarProducto(){
        DetalleVenta detalle = new DetalleVenta();
        if(tienda.verificarProducto(idProducto.getText())){
            Producto producto = tienda.obtenerProducto(idProducto.getText());
            int cantidad = Integer.parseInt(txtCantidad.getText());

            double subTotal = producto.getPrecio()*cantidad;
            tienda.restarInventario(producto,cantidad);

            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setSubTotal(subTotal);
            detalles.add(detalle);

            carritoCompras.add(producto);
            tablaProductosCarritos.setItems( FXCollections.observableList(carritoCompras.stream().toList()));
            //tablaProductosCarritos.getItems().add(producto);
        }
    }

    public void comprarProductos(){
        if(tienda.obtenerCliente(Integer.parseInt(idCliente.getText()))!=null){
            Venta venta= tienda.crearVenta(detalles, Integer.parseInt(idCliente.getText()));
            tienda.agregarVenta(venta);
            JOptionPane.showMessageDialog(null, "El total de su compra es de: "+venta.getPrecioTotal());
            System.out.println(tienda.obtenerCliente(Integer.parseInt(idCliente.getText())));
        }else{
            JOptionPane.showMessageDialog(null,"Cliente no encontrado");
        }

    }


}
