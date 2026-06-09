package es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia;

import java.time.LocalDate;

import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;

public class IncidenciaRequest {

    private Long idUsuario;
    private String asunto;
    private String descripcion;
    private LocalDate fecha;
    private EstadoIncidencia estado;

    public IncidenciaRequest() {
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
