package es.ies.puerto.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.util.List;

import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.Impl.UsuarioRepository;
import es.ies.puerto.Service.Interfaces.IUsuarioService;
import es.ies.puerto.Service.Impl.UsuarioService;

public class UsuariosController {

    @FXML
    private ListView<String> listUsuarios;

    private final IUsuarioService service = new UsuarioService(new UsuarioRepository());

    @FXML
    public void initialize() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = service.findAll();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Usuario u : usuarios) {
            items.add(u.getNombre() + " - " + u.getEmail() + " - " + u.getTipoUsuario());
        }
        listUsuarios.setItems(items);
    }
}