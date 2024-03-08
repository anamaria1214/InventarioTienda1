package inventario.controller;

import inventario.app.Main;
import inventario.model.Producto;
import inventario.model.Tienda;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class CarritoController implements Initializable {
    private Tienda tienda = Tienda.getInstance();

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnComprar;

    @FXML
    private TextField idCliente;

    @FXML
    private TextField idProducto;

    @FXML
    private GridPane productosCarrito;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    /*public void pintarPaquetes(TreeSet<Producto> productos){
        contenedor.getChildren().clear();
        contenedor.setSpacing(0);

        System.out.println(productos);

        for(int i=0;i<productos.size();i++){
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/View/producto.fxml"));
            try {
                AnchorPane paquete = loader.load();
                ProductosController paqueteC = loader.getController();
                paqueteC.setPaquete(paquetes.get(i));
                paqueteC.pintarComponente();
                paqueteC.setIdCliente(sesion.getCliente().getIdCliente());
                contenedor.getChildren().add(paquete);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
}
