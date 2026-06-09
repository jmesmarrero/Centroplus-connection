package es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia;

import java.time.LocalDate;

import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public class IncidenciaResponse {
    private Long id;
    private Usuario usuario;
    private String asunto;
    private String descripcion;
    private LocalDate fecha;
    private EstadoIncidencia estado;

    public IncidenciaResponse(){}

    public IncidenciaResponse(Long id, Usuario usuario, String asunto, String descripcion, LocalDate fecha,
            EstadoIncidencia estado) {
        this.id = id;
        this.usuario = usuario;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoIncidencia getEstado() {
        return estado;
    }

    public void setEstado(EstadoIncidencia estado) {
        this.estado = estado;
    }

    

}
