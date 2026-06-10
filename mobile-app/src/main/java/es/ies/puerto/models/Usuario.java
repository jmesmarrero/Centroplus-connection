package es.ies.puerto.models;

import java.util.List;
import java.util.Objects;

public class Usuario {

    private Long id;

    private String nombre;
    private String dni;
    private String email;
    private String telefono;
    private TipoUsuario tipoUsuario;
    private List<Reserva> reservas;
    private List<Incidencia> incidencias;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String nombre, String dni, String email, String telefono, TipoUsuario tipoUsuario) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(Long id, String nombre, String dni, String email, String telefono, TipoUsuario tipoUsuario,
            List<Reserva> reservas, List<Incidencia> incidencias) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.reservas = reservas;
        this.incidencias = incidencias;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Incidencia> getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(List<Incidencia> incidencias) {
        this.incidencias = incidencias;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null)
            return false;

        if (this == obj)
            return true;
        if (!(obj instanceof Usuario)) {
            return false;
        }
        Usuario usuario = (Usuario) obj;

        return Objects.equals(id, usuario.id);

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}