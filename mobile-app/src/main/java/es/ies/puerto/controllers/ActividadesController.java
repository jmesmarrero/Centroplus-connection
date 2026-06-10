package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.repositories.Impl.ActividadRepository;
import es.ies.puerto.Service.Impl.ActividadService;
import es.ies.puerto.Service.Interfaces.IActividadService;

public class ActividadesController {

    @FXML
    private ListView<String> listActividades;

    private final IActividadService service = new ActividadService(new ActividadRepository());

    @FXML
    public void initialize() {
        cargarActividades();
    }

    private void cargarActividades() {
        List<Actividad> actividades = service.findAll();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Actividad a : actividades) {
            items.add(a.getNombre() + " - " + a.getTipoActividad() + " - " + a.getPrecio() + "€");
        }
        listActividades.setItems(items);
    }
}