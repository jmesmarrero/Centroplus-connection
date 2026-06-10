package es.ies.puerto.models;

import java.time.LocalDate;
import java.util.Objects;

public class Incidencia {

    private Long id;
    private Usuario usuario;
    private String asunto;
    private String descripcion;
    private LocalDate fecha;
    private EstadoIncidencia estado;

    public Incidencia() {
    }

    public Incidencia(Long id) {
        this.id = id;
    }

    public Incidencia(Long id, Usuario usuario, String asunto, String descripcion, LocalDate fecha,
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

    

    @Override
    public String toString() {
        return "Incidencia [id=" + id + ", usuario=" + usuario + ", asunto=" + asunto + ", descripcion=" + descripcion
                + ", fecha=" + fecha + ", estado=" + estado + "]";
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

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}