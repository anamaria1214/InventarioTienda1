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

 private Tienda tienda = Tienda.getInstance();

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
 private TableColumn<Cliente, String> columnaId;
 @FXML
 private TableColumn<Cliente, String> columnaNombre;
 @FXML
 private TableColumn<Cliente, String> columnaDireccion;
 @FXML
 private TableView<Cliente> tablaCliente;


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
   columnaId.setCellValueFactory(new PropertyValueFactory<>("numeroIdentificacion"));
   columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
   columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
   listarClientes();

  }

  public void registarCliente(){
   Cliente cliente= new Cliente(campoNombreCliente.getText(),
           Integer.parseInt(campoIdCliente.getText()),campoDireccion.getText());
           tienda.agregarCliente(cliente);


   listarClientes();

  }



 public void actualizarCliente(int numeroIdentificacion){
  Cliente cliente= new Cliente(campoNombreCliente.getText(),
          Integer.parseInt(campoIdCliente.getText()),campoDireccion.getText());
  tienda.actualizarCliente(cliente, numeroIdentificacion);

}

  public void listarClientes(){
   tablaCliente.setItems( FXCollections.observableList(tienda.getClientes().values().stream().toList()));

  }
 public void actualizarCliente(){
  Cliente cliente= new Cliente(campoNombreCliente.getText(),
          Integer.parseInt(campoIdCliente.getText()),campoDireccion.getText());
  tienda.actualizarCliente(cliente);
  listarClientes();
 }
 public void eliminarCliente(){
   tienda.eliminarCliente(Integer.parseInt(campoIdCliente.getText()));
   listarClientes();
   campoIdCliente.setText("");
   campoDireccion.setText("");
   campoNombreCliente.setText("");
 }

}
