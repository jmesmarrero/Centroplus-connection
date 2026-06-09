package es.ies.puerto.centroplus_connect.adapters.in.api.Reserva;

import java.time.LocalDate;

import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;

public class ReservaRequest {
    private Long idUsuario;
    private Long idActividad;
    private LocalDate fecha;
    private EstadoReserva estado;

    public ReservaRequest(){}

    

    public Long getIdUsuario() {
        return idUsuario;
    }



    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }



    public Long getIdActividad() {
        return idActividad;
    }



    public void setIdActividad(Long idActividad) {
        this.idActividad = idActividad;
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
