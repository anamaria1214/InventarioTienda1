package inventario.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader( Main.class.getResource("/view/Inicio.fxml") );
        Parent parent = loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Alquila Facil");
        stage.show();

    }

    public static void main(String[] args) {
        launch( Main.class, args );
    }

}
