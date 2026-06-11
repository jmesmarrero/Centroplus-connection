package es.ies.puerto.centroplus_connect.domain.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "reservas")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuario;

    @JoinColumn(name = "id_actividad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Actividad actividad;
    
    @Column(name = "fecha", columnDefinition = "TEXT")
    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
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