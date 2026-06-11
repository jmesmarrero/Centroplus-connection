package es.ies.puerto.centroplus_connect.adapters.in.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia.IncidenciaRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia.IncidenciaResponse;
import es.ies.puerto.centroplus_connect.adapters.mapper.IncidenciaMapper;
import es.ies.puerto.centroplus_connect.business.IIncidenciaService;
import es.ies.puerto.centroplus_connect.business.IUsuarioService;
import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/incidencias")
@Tag(name = "Incidencia API")
@CrossOrigin
public class IncidenciaController {

    private final IIncidenciaService service;
    private final IncidenciaMapper mapper;
    private final IUsuarioService usuarioService;

    public IncidenciaController(IIncidenciaService service, IncidenciaMapper mapper, IUsuarioService usuarioService) {
        this.service = service;
        this.mapper = mapper;
        this.usuarioService = usuarioService;
    }

    @GetMapping
    @Operation(summary = "Get all incidencias")
    public List<IncidenciaResponse> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get incidencia by id")
    public ResponseEntity<IncidenciaResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @Operation(summary = "Create inciedncia")
    public ResponseEntity<IncidenciaResponse> create(@RequestBody IncidenciaRequest request) {
        Usuario usuario = usuarioService.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Incidencia incidencia = new Incidencia();
        incidencia.setUsuario(usuario);
        incidencia.setAsunto(request.getAsunto());
        incidencia.setDescripcion(request.getDescripcion());
        incidencia.setFecha(request.getFecha());
        incidencia.setEstado(request.getEstado());

        Incidencia created = service.save(incidencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));

    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update Incidencia (partial)")
    public ResponseEntity<IncidenciaResponse> update(@PathVariable Long id, @RequestBody IncidenciaRequest request) {
       
        Usuario usuario = usuarioService.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Incidencia incidencia = new Incidencia();
        incidencia.setUsuario(usuario);
        incidencia.setAsunto(request.getAsunto());
        incidencia.setDescripcion(request.getDescripcion());
        incidencia.setFecha(request.getFecha());
        incidencia.setEstado(request.getEstado());
        return service.update(id, incidencia)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete incidencia")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Get incidencia by usuario")
    public List<IncidenciaResponse> getByUsuario(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return service.findByUsuario(usuario).stream()
                .map(mapper::toResponse).toList();

    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Get incidencia by estado")
    public List<IncidenciaResponse> getByEstado(@PathVariable EstadoIncidencia estado) {

        return service.findByEstado(estado).stream()
                .map(mapper::toResponse).toList();

    }

    @GetMapping("/fecha/{fecha}")
    @Operation(summary = "Get incidencia by fecha")
    public List<IncidenciaResponse> getByFecha(@PathVariable LocalDate fecha) {

        return service.findByFecha(fecha).stream()
                .map(mapper::toResponse).toList();

    }

    @PatchMapping("/{id}/estado/{estado}")
    @Operation(summary = "Change estado incidencia")
    public ResponseEntity<IncidenciaResponse> cambiarEstado(@PathVariable Long id,
            @PathVariable EstadoIncidencia estado) {
        Incidencia incidencia = service.cambiarEstado(id, estado);
        return ResponseEntity.ok(mapper.toResponse(incidencia));
    }

}
