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

import es.ies.puerto.centroplus_connect.adapters.in.api.Reserva.ReservaRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Reserva.ReservaResponse;
import es.ies.puerto.centroplus_connect.adapters.mapper.ReservaMapper;
import es.ies.puerto.centroplus_connect.business.IActividadService;
import es.ies.puerto.centroplus_connect.business.IReservaService;
import es.ies.puerto.centroplus_connect.business.IUsuarioService;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/reservas")
@Tag(name = "Reserva Api")
@CrossOrigin
public class ReservaController {

    private final IReservaService service;
    private final ReservaMapper mapper;
    private final IUsuarioService usuarioService;
    private final IActividadService actividadService;

    public ReservaController(IReservaService service, ReservaMapper mapper, IUsuarioService usuarioService,
            IActividadService actividadService) {
        this.service = service;
        this.mapper = mapper;
        this.usuarioService = usuarioService;
        this.actividadService = actividadService;
    }

    @GetMapping
    @Operation(summary = "Get all reservas")
    public List<ReservaResponse> getAll() {
        return service.findAll().stream().map(mapper::toResponse).toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get reserva by id")
    public ResponseEntity<ReservaResponse> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(mapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PostMapping
    @Operation(summary = "Create reserva")
    public ResponseEntity<ReservaResponse> create(@RequestBody ReservaRequest request) {
        Usuario usuario = usuarioService.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Actividad actividad = actividadService.findById(request.getIdActividad())
                .orElseThrow(() -> new IllegalArgumentException("Actividad no encontrada"));

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setActividad(actividad);
        reserva.setFecha(request.getFecha());
        reserva.setEstado(request.getEstado());

        Reserva created = service.addReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(created));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update reserva (partial)")
    public ResponseEntity<ReservaResponse> update(@PathVariable Long id, @RequestBody ReservaRequest request) {
        // convert request -> domain patch: completed may be null; title/desc may be
        // null
        Usuario usuario = usuarioService.findById(request.getIdUsuario())
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        Actividad actividad = actividadService.findById(request.getIdActividad())
                .orElseThrow(() -> new IllegalArgumentException("Actividad no encontrada"));

        Reserva reserva = new Reserva();
        reserva.setUsuario(usuario);
        reserva.setActividad(actividad);
        reserva.setFecha(request.getFecha());
        reserva.setEstado(request.getEstado());
        return service.update(id, reserva)
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

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Get reserva by usuario")
    public List<ReservaResponse> getByUsuario(@PathVariable Long idUsuario) {
        Usuario usuario = usuarioService.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        return service.findByUsuario(usuario).stream()
                .map(mapper::toResponse).toList();

    }

    @GetMapping("/actividad/{idActividad}")
    @Operation(summary = "Get reserva by actividad")
    public List<ReservaResponse> getByActividad(@PathVariable Long idActividad) {
        Actividad actividad = actividadService.findById(idActividad)
                .orElseThrow(() -> new IllegalArgumentException("Actividad no encontrado"));
        return service.findByActividad(actividad).stream()
                .map(mapper::toResponse).toList();

    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Get reservas by estado")
    public List<ReservaResponse> getByEstado(@PathVariable EstadoReserva estado) {
        return service.findByEstado(estado).stream()
                .map(mapper::toResponse)
                .toList();
    }

    @PatchMapping("/cancel/{id}")
    @Operation(summary = "Cancel reserva")
    public ResponseEntity<ReservaResponse> cancelReserva(@PathVariable Long id) {
        Reserva cancelled = service.cancelReserva(id);
        return ResponseEntity.ok(mapper.toResponse(cancelled));
    }
}
