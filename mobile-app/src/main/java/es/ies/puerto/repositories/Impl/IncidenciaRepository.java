package es.ies.puerto.repositories.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.SQLiteConnectionManager;
import es.ies.puerto.repositories.Interface.IIncidenciaRepository;

public class IncidenciaRepository extends SQLiteConnectionManager implements IIncidenciaRepository {

    public boolean create(Incidencia incidencia) {
        String sql = "INSERT INTO incidencias (id_usuario, asunto, descripcion, fecha, estado) VALUES (?,?,?,?,?)";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, incidencia.getUsuario().getId());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha().toString());
            sentencia.setString(5, incidencia.getEstado().name());
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se ha podido crear incidencia");
            return false;
        }
    }

    public Incidencia findById(Long id) {
        String sql = "SELECT * FROM incidencias WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Long idUsuario = resultado.getLong("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                EstadoIncidencia estado = EstadoIncidencia.valueOf(resultado.getString("estado"));

                UsuarioRepository usuarioRepo = new UsuarioRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);

                return new Incidencia(id, usuario, asunto, descripcion, fecha, estado);
            }
        } catch (Exception e) {
            System.err.println("no se pudo encontrar incidencia por id: " + id);
        }
        return null;
    }

    public List<Incidencia> findAll() {
        String sql = "SELECT * FROM incidencias";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            ResultSet resultado = sentencia.executeQuery();
            List<Incidencia> incidencias = new ArrayList<>();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                Long idUsuario = resultado.getLong("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                EstadoIncidencia estado = EstadoIncidencia.valueOf(resultado.getString("estado"));

                UsuarioRepository usuarioRepo = new UsuarioRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);

                incidencias.add(new Incidencia(id, usuario, asunto, descripcion, fecha, estado));
            }
            return incidencias;
        } catch (Exception e) {
            System.err.println("no se pueden encontrar incidencias");
            return new ArrayList<>();
        }
    }

    public boolean update(Incidencia incidencia) {
        String sql = "UPDATE incidencias SET id_usuario=?, asunto=?, descripcion=?, fecha=?, estado=? WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, incidencia.getUsuario().getId());
            sentencia.setString(2, incidencia.getAsunto());
            sentencia.setString(3, incidencia.getDescripcion());
            sentencia.setString(4, incidencia.getFecha().toString());
            sentencia.setString(5, incidencia.getEstado().name());
            sentencia.setLong(6, incidencia.getId());
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se pudo actualizar incidencia");
            return false;
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM incidencias WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se pudo eliminar incidencia con id: " + id);
            return false;
        }
    }

    @Override
    public List<Incidencia> findByUsuario(Usuario usuario) {
        List<Incidencia> incidencias = new ArrayList<>();

        String sql = "SELECT * FROM incidencias WHERE id_usuario = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, usuario.getId());
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                EstadoIncidencia estado = EstadoIncidencia.valueOf(resultado.getString("estado"));
                incidencias.add(new Incidencia(id, usuario, asunto, descripcion, fecha, estado));
            }
            return incidencias;
        } catch (Exception e) {
            System.err.println("no se encontraron incidencias por usuario");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) {

        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencias WHERE estado = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, estado.name());
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                Long idUsuario = resultado.getLong("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                UsuarioRepository usuarioRepo = new UsuarioRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);
                incidencias.add(new Incidencia(id, usuario, asunto, descripcion, fecha, estado));
            }
            return incidencias;
        } catch (Exception e) {
            System.err.println("no se encontraron incidencias por estado");
            return new ArrayList<>();
        }
    }

    @Override
    public List<Incidencia> findByFecha(LocalDate fecha) {

        List<Incidencia> incidencias = new ArrayList<>();
        String sql = "SELECT * FROM incidencias WHERE fecha = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, fecha.toString());
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Long id = resultado.getLong("id");
                Long idUsuario = resultado.getLong("id_usuario");
                String asunto = resultado.getString("asunto");
                String descripcion = resultado.getString("descripcion");
                EstadoIncidencia estado = EstadoIncidencia.valueOf(resultado.getString("estado"));
                UsuarioRepository usuarioRepo = new UsuarioRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);
                incidencias.add(new Incidencia(id, usuario, asunto, descripcion, fecha, estado));
            }
            return incidencias;
        } catch (Exception e) {
            System.err.println("no se encontraron incidencias por fecha");
            return new ArrayList<>();
        }
    }
}
