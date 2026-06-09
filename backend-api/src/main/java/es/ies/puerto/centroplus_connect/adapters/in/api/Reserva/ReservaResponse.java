package es.ies.puerto.centroplus_connect.adapters.in.api.Reserva;

import java.time.LocalDate;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public class ReservaResponse {

    private Long id;
    private Usuario usuario;
    private Actividad actividad;
    private LocalDate fecha;
    private EstadoReserva estado;

    public ReservaResponse() {
    }

    public ReservaResponse(Long id, Usuario usuario, Actividad actividad, LocalDate fecha, EstadoReserva estado) {
        this.id = id;
        this.usuario = usuario;
        this.actividad = actividad;
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    

}
