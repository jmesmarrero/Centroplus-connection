package es.ies.puerto.centroplus_connect.adapters.in.controller;

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

import es.ies.puerto.centroplus_connect.adapters.in.api.Actividad.ActividadRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Actividad.ActividadResponse;
import es.ies.puerto.centroplus_connect.adapters.mapper.ActividadMapper;
import es.ies.puerto.centroplus_connect.business.IActividadService;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/actividades")
@Tag(name = "Actividad API")
@CrossOrigin
public class ActividadController {

    private final IActividadService service;
    private final ActividadMapper mapper;

    public ActividadController(IActividadService service, ActividadMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    @Operation(summary = "Get all actividades")
    public List<ActividadResponse> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get actividad by id")
    public ResponseEntity<ActividadResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create actividad")
    public ResponseEntity<ActividadResponse> create(@RequestBody ActividadRequest request) {
        Actividad created = service.registrarActividad(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update actividad (partial)")
    public ResponseEntity<ActividadResponse> update(@PathVariable Long id, @RequestBody ActividadRequest request) {
        // convert request -> domain patch: completed may be null; title/desc may be
        // null
        Actividad patch = new Actividad();
        patch.setNombre(request.getNombre());
        patch.setTipoActividad(request.getTipoActividad());
        patch.setDuracion(request.getDuracion());
        patch.setPrecio(request.getPrecio());
        patch.setPlazasMaximas(request.getPlazasMaximas());
        patch.setPlazasOcupadas(request.getPlazasOcupadas());
        

        return service.update(id, patch)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete actividad")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    @Operation(summary = "Get actividad by nombre")
    public ResponseEntity<ActividadResponse> getByNombre(@PathVariable String nombre) {
        return service.findByNombre(nombre)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
