package es.ies.puerto.centroplus_connect.adapters.in.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.centroplus_connect.adapters.in.api.Usuario.UsuarioRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Usuario.UsuarioResponse;
import es.ies.puerto.centroplus_connect.adapters.mapper.UsuarioMapper;
import es.ies.puerto.centroplus_connect.business.IUsuarioService;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name = "Usuario API")
@CrossOrigin
public class UsuarioController {

    private final IUsuarioService service;
    private final UsuarioMapper mapper;

    public UsuarioController(IUsuarioService service, UsuarioMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all usuarios")
    public List<UsuarioResponse> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get usuario by id")
    public ResponseEntity<UsuarioResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create usuario")
    public ResponseEntity<UsuarioResponse> create(@RequestBody UsuarioRequest request) {
        Usuario created = service.registrarUsuario(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update usuario (partial)")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody UsuarioRequest request) {
        // convert request -> domain patch: completed may be null; title/desc may be
        // null
        Usuario patch = new Usuario();
        patch.setNombre(request.getNombre());
        patch.setDni(request.getDni());
        patch.setEmail(request.getEmail());
        patch.setTelefono(request.getTelefono());
        patch.setTipoUsuario(request.getTipoUsuario());
        // patch.setCompleted(Boolean.TRUE.equals(request.getCompleted()));

        return service.update(id, patch)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete usuario")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
