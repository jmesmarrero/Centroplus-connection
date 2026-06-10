package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.List;

import es.ies.puerto.models.Reserva;
import es.ies.puerto.repositories.Impl.ActividadRepository;
import es.ies.puerto.repositories.Impl.ReservaRepository;
import es.ies.puerto.Service.Interfaces.IReservaService;
import es.ies.puerto.Service.Impl.ReservaService;

public class ReservasController {

    @FXML
    private ListView<String> listReservas;

    private final IReservaService service = new ReservaService(new ReservaRepository(), new ActividadRepository());

    @FXML
    public void initialize() {
        cargarReservas();
    }

    private void cargarReservas() {
        List<Reserva> reservas = service.findAll();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Reserva r : reservas) {
            items.add(r.getId() + " - " + r.getUsuario().getNombre() + 
                     " - " + r.getActividad().getNombre() + 
                     " - " + r.getEstado());
        }
        listReservas.setItems(items);
    }
}
