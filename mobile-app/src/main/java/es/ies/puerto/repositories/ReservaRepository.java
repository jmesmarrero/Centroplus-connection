package es.ies.puerto.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.models.Usuario;

public class ReservaRepository extends SQLiteConnectionManager {

    public boolean create(Reserva reserva) {
        String sql = "INSERT INTO reservas (id_usuario, id_actividad, fecha, estado) VALUES (?,?,?,?)";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, reserva.getUsuario().getId());
            sentencia.setLong(2, reserva.getActividad().getId());
            sentencia.setString(3, reserva.getFecha().toString());
            sentencia.setString(4, reserva.getEstado().name());
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se ha podido crear reserva");
            return false;
        }
    }

    public List<Reserva> findAll() {
        String sql = "SELECT * FROM reservas";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            ResultSet resultado = sentencia.executeQuery();
            List<Reserva> reservas = new ArrayList<>();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                Long idUsuario = resultado.getLong("id_usuario");
                Long idActividad = resultado.getLong("id_actividad");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                EstadoReserva estado = EstadoReserva.valueOf(resultado.getString("estado"));

                UsuarioRepository usuarioRepo = new UsuarioRepository();
                ActividadRepository actividadRepo = new ActividadRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);
                Actividad actividad = actividadRepo.findById(idActividad);

                reservas.add(new Reserva(id, usuario, actividad, fecha, estado));
            }
            return reservas;
        } catch (Exception e) {
            System.err.println("no se pueden encontrar reservas");
            return new ArrayList<>();
        }
    }

    public Reserva findById(Long id) {
        String sql = "SELECT * FROM reservas WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                Long idUsuario = resultado.getLong("id_usuario");
                Long idActividad = resultado.getLong("id_actividad");
                LocalDate fecha = LocalDate.parse(resultado.getString("fecha"));
                EstadoReserva estado = EstadoReserva.valueOf(resultado.getString("estado"));

                UsuarioRepository usuarioRepo = new UsuarioRepository();
                ActividadRepository actividadRepo = new ActividadRepository();
                Usuario usuario = usuarioRepo.findById(idUsuario);
                Actividad actividad = actividadRepo.findById(idActividad);

                return new Reserva(id, usuario, actividad, fecha, estado);
            }
        } catch (Exception e) {
            System.err.println("no se pudo encontrar reserva por id: " + id);
        }
        return null;
    }

    public boolean update(Reserva reserva) {
        String sql = "UPDATE reservas SET id_usuario=?, id_actividad=?, fecha=?, estado=? WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, reserva.getUsuario().getId());
            sentencia.setLong(2, reserva.getActividad().getId());
            sentencia.setString(3, reserva.getFecha().toString());
            sentencia.setString(4, reserva.getEstado().name());
            sentencia.setLong(5, reserva.getId());
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se pudo actualizar reserva");
            return false;
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se pudo eliminar reserva con id: " + id);
            return false;
        }
    }
}
