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

public class ActividadesController {

    @FXML
    private ListView<String> listActividades;

    private static final String API_URL = "http://localhost:8080/api/v1/actividades";

    @FXML
    public void initialize() {
        cargarActividades();
    }

    private void cargarActividades() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actividades = mapper.readTree(response.body());
            
            ObservableList<String> items = FXCollections.observableArrayList();
            for (JsonNode actividad : actividades) {
                String item = actividad.get("nombre").asText() + 
                             " - " + actividad.get("tipoActividad").asText() +
                             " - " + actividad.get("precio").asText() + "€";
                items.add(item);
            }
            listActividades.setItems(items);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
