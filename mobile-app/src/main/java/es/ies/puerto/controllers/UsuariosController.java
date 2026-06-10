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

public class UsuariosController {

    @FXML
    private ListView<String> listUsuarios;

    private static final String API_URL = "http://localhost:8080/api/v1/usuarios";

    @FXML
    public void initialize() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode usuarios = mapper.readTree(response.body());
            
            ObservableList<String> items = FXCollections.observableArrayList();
            for (JsonNode usuario : usuarios) {
                String item = usuario.get("nombre").asText() + 
                             " - " + usuario.get("email").asText() +
                             " - " + usuario.get("tipoUsuario").asText();
                items.add(item);
            }
            listUsuarios.setItems(items);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
