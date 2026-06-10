// IncidenciasController.java
package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
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
}
