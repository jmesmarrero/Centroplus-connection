package es.ies.puerto.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController {

    @FXML
    private void irAUsuarios() {
        navegarA("/es/ies/puerto/usuarios.fxml");
    }

    @FXML
    private void irAReservas() {
        navegarA("/es/ies/puerto/reservas.fxml");
    }

    @FXML
    private void irAActividades() {
        navegarA("/es/ies/puerto/actividades.fxml");
    }

    @FXML
    private void irAIncidencias() {
        navegarA("/es/ies/puerto/incidencias.fxml");
    }

    private void navegarA(String ruta) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ruta));
            Scene scene = new Scene(loader.load());
            Stage stage = (Stage) Window.getWindows().get(0);
            stage.setScene(scene);
        } catch (Exception e) {
            System.err.println("Error navegando: " + e.getMessage());
        }
    }
}
