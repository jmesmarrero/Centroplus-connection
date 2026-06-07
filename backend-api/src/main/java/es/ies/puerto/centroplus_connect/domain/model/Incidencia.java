package es.ies.puerto.centroplus_connect.domain.model;

import java.time.LocalDate;
import java.util.Objects;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidencias")
public class Incidencia {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String asunto;

    private String descripcion;

    private LocalDate fecha;

    @Enumerated(EnumType.STRING)
    private EstadoIncidencia estado;

    public Incidencia() {
    }

    public Incidencia(Long id) {
        this.id = id;
    }

    public Incidencia(Long id, Usuario usuario, String asunto, String descripcion, LocalDate fecha, EstadoIncidencia estado) {
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

    @Override
    public String toString() {
        return "Incidencia [id=" + id + ", usuario=" + usuario + ", asunto=" + asunto + ", descripcion=" + descripcion
                + ", fecha=" + fecha + ", estado=" + estado + "]";
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
        if (!(obj instanceof Incidencia))
            return false;
        Incidencia otra = (Incidencia) obj;
        return Objects.equals(id, otra.id);
    }

    

}
