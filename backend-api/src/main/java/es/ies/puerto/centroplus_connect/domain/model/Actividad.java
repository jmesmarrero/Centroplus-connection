package es.ies.puerto.centroplus_connect.domain.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actividades")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_actividad")
    private TipoActividad tipoActividad;

    private Integer duracion;
    private Double precio;
    @Column(name = "plazas_maximas")
    private Integer plazasMaximas;
    @Column(name = "plazas_ocupadas")
    private Integer plazasOcupadas;

    @JsonIgnore
    @OneToMany(mappedBy = "actividad", fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Actividad() {
    }

    public Actividad(Long id) {
        this.id = id;
    }

    public Actividad(Long id, String nombre, TipoActividad tipoActividad, Integer duracion, Double precio,
            Integer plazasMaximas, Integer plazasOcupadas, List<Reserva> reservas) {
        this.id = id;
        this.nombre = nombre;
        this.tipoActividad = tipoActividad;
        this.duracion = duracion;
        this.precio = precio;
        this.plazasMaximas = plazasMaximas;
        this.plazasOcupadas = plazasOcupadas;
        this.reservas = reservas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public void setTipoActividad(TipoActividad tipoActividad) {
        this.tipoActividad = tipoActividad;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPlazasMaximas() {
        return plazasMaximas;
    }

    public void setPlazasMaximas(Integer plazasMaximas) {
        this.plazasMaximas = plazasMaximas;
    }

    public Integer getPlazasOcupadas() {
        return plazasOcupadas;
    }

    public void setPlazasOcupadas(Integer plazasOcupadas) {
        this.plazasOcupadas = plazasOcupadas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Actividad [id=" + id + ", nombre=" + nombre + ", tipoActividad=" + tipoActividad + ", duracion="
                + duracion + ", precio=" + precio + ", plazasMaximas=" + plazasMaximas + ", plazasOcupadas="
                + plazasOcupadas + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (this == obj)
            return true;
        if (!(obj instanceof Actividad)) {
            return false;
        }
        Actividad actividad = (Actividad) obj;

        return Objects.equals(id, actividad.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
