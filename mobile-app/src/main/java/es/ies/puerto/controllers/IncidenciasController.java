// IncidenciasController.java
package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;

import es.ies.puerto.models.Incidencia;
import es.ies.puerto.repositories.Impl.IncidenciaRepository;
import es.ies.puerto.Service.Interfaces.IIncidenciaService;
import es.ies.puerto.Service.Impl.IncidenciaService;

public class IncidenciasController {

    @FXML
    private ListView<String> listIncidencias;

    private final IIncidenciaService service = new IncidenciaService(new IncidenciaRepository());

    @FXML
    public void initialize() {
        cargarIncidencias();
    }

    private void cargarIncidencias() {
        List<Incidencia> incidencias = service.findAll();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Incidencia i : incidencias) {
            items.add(i.getAsunto() + " - " + i.getEstado() + " - " + i.getFecha());
        }
        listIncidencias.setItems(items);
    }

    @FXML
private void volver() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/es/ies/puerto/main.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) listIncidencias.getScene().getWindow();
        stage.setScene(scene);
    } catch (Exception e) {
        System.err.println("Error volviendo: " + e.getMessage());
    }
}
}
