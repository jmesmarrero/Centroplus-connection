package es.ies.puerto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static final String RUTA = "/es/ies/puerto/main.fxml";

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(RUTA));
        Scene scene = new Scene(loader.load());
        stage.setTitle("CentroPlus Connect");
        stage.setWidth(390);
        stage.setHeight(760);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
