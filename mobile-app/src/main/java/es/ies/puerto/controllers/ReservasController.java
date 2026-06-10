package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReservasController {

    @FXML
    private ListView<String> listReservas;

    private static final String API_URL = "http://localhost:8080/api/v1/reservas";

    @FXML
    public void initialize() {
        cargarReservas();
    }

    private void cargarReservas() {
        try {
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response =cliente.send(request, HttpResponse.BodyHandlers.ofString());
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode reservas = mapper.readTree(response.body());

            ObservableList<String> items = FXCollections.observableArrayList();
            for (JsonNode reserva : reservas) {
                String item = reserva.get("id").asText() +
                " - " + reserva.get("fecha").asText() +
                " - " + reserva.get("estado").asText();
                items.add(item);
            }
            listReservas.setItems(items);
        
        
        } catch (Exception e) {
            System.err.println("Error: "+ e.getMessage());
        }
    }



    
}
