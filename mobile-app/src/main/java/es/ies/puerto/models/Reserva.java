package es.ies.puerto.models;

import java.time.LocalDate;
import java.util.Objects;

public class Reserva {

    private Long id;
    private Usuario usuario;
    private Actividad actividad;
    private LocalDate fecha;
    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(Long id, Usuario usuario, Actividad actividad, LocalDate fecha, EstadoReserva estado) {
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

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", actividad=" + actividad + ", fecha=" + fecha
                + ", estado=" + estado + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Reserva)) {
            return false;
        }
        Reserva reserva = (Reserva) obj;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}