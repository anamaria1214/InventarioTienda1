package inventario.controller;

import inventario.model.Cliente;
import inventario.model.Tienda;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class CrudClienteController implements Initializable {

 @FXML
 private TextField campoIdCliente;
 @FXML
 private TextField campoNombreCliente;
 @FXML
 private TextField campoDireccion;
 @FXML
 private Button btnAgregar;
 @FXML
 private Button btnActualizar;
 @FXML
 private Button btnEliminar;
 @FXML
 private TableColumn columnaId;
 @FXML
 private TableColumn columnaNombre;
 @FXML
 private TableColumn columnaDireccion;
 @FXML
 private TableView tablaCliente;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
   columnaId.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
   columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
   columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));

   tablaCliente.setItems( FXCollections.observableHashMap( Tienda.getClientes() ) );

  }

  public void registarCliente(){
   Cliente cliente= new Cliente(campoNombreCliente.getText(),
           Integer.parseInt(campoIdCliente.getText()),campoDireccion.getText());
  }
}
