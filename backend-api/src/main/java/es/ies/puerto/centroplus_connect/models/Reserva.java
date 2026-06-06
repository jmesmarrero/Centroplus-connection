package es.ies.puerto.centroplus_connect.models;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.FetchType;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    // TODO: descomentar cuando Jorge cree Actividad.java
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_actividad")
    // private Actividad actividad;

    private String fecha;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    public Reserva() {
    }

    public Reserva(Long id) {
        this.id = id;
    }

    public Reserva(Long id, Usuario usuario, String fecha, EstadoReserva estado) {
        this.id = id;
        this.usuario = usuario;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Reserva))
            return false;
        Reserva otra = (Reserva) obj;
        return Objects.equals(id, otra.id);

    }

    @Override
    public String toString() {
        return "Reserva [id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", estado=" + estado + "]";
    }

}