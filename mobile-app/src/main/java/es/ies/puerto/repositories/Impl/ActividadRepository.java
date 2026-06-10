package es.ies.puerto.repositories.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.TipoActividad;
import es.ies.puerto.repositories.SQLiteConnectionManager;
import es.ies.puerto.repositories.Interface.IActividadRepository;

public class ActividadRepository extends SQLiteConnectionManager implements IActividadRepository {

    public boolean create(Actividad actividad) {
        String sql = "INSERT INTO actividades (nombre, tipo_actividad, duracion, precio, plazas_maximas, plazas_ocupadas) VALUES (?,?,?,?,?,?)";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad().name());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPrecio());
            sentencia.setInt(5, actividad.getPlazasMaximas());
            sentencia.setInt(6, actividad.getPlazasOcupadas());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se ha podido crear actividad");
            return false;
        }
    }

    public Actividad findById(Long id) {
        String sql = "SELECT * FROM actividades WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            ResultSet resultado = sentencia.executeQuery();
            if (resultado.next()) {
                String nombre = resultado.getString("nombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                return new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas, plazasOcupadas);
            }

        } catch (Exception e) {
            System.err.println("no se pudo encontrar por id: " + id);
        }
        return null;
    }

    public List<Actividad> findAll() {
        String sql = "SELECT * FROM actividades";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            ResultSet resultado = sentencia.executeQuery();
            List<Actividad> actividades = new ArrayList<>();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                TipoActividad tipoActividad = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                actividades
                        .add(new Actividad(id, nombre, tipoActividad, duracion, precio, plazasMaximas, plazasOcupadas));
            }
            return actividades;

        } catch (Exception e) {
            System.err.println("no se pueden encontrar actividades");
            return new ArrayList<>();
        }
    }

    public boolean update(Actividad actividad) {
        String sql = "UPDATE actividades SET nombre=?, tipo_actividad=?, duracion=?, precio=?, plazas_maximas=?, plazas_ocupadas=? WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, actividad.getNombre());
            sentencia.setString(2, actividad.getTipoActividad().name());
            sentencia.setInt(3, actividad.getDuracion());
            sentencia.setDouble(4, actividad.getPrecio());
            sentencia.setInt(5, actividad.getPlazasMaximas());
            sentencia.setInt(6, actividad.getPlazasOcupadas());
            sentencia.setLong(7, actividad.getId());

            return sentencia.executeUpdate() > 0;

        } catch (Exception e) {
            System.err.println("no se pudo actualizar actividad");
            return false;
        }
    }

    public boolean deleteById(Long id) {
        String sql = "DELETE FROM actividades WHERE id = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setLong(1, id);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("no se pudo eliminar actividad con id: " + id);
            return false;
        }
    }

    public List<Actividad> findByTipo(TipoActividad tipo) {
        String sql = "SELECT * FROM actividades WHERE tipo_actividad = ?";
        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {
            sentencia.setString(1, tipo.name());
            List<Actividad> actividades = new ArrayList<>();
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                actividades.add(new Actividad(id, nombre, tipo, duracion, precio, plazasMaximas, plazasOcupadas));
            }
            return actividades;

        } catch (Exception e) {
            System.err.println("no se encontraron actividades por tipo: " + tipo);
            return new ArrayList<>();
        }
    }

    public List<Actividad> findConPlazasDisponibles() {
        String sql = "SELECT * FROM actividades WHERE plazas_ocupadas < plazas_maximas";
        List<Actividad> actividades = new ArrayList<>();

        try (Connection connection = SQLiteConnectionManager.getConnection();
                PreparedStatement sentencia = connection.prepareStatement(sql)) {

            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                Long id = resultado.getLong("id");
                String nombre = resultado.getString("nombre");
                TipoActividad tipo = TipoActividad.valueOf(resultado.getString("tipo_actividad"));
                Integer duracion = resultado.getInt("duracion");
                Double precio = resultado.getDouble("precio");
                Integer plazasMaximas = resultado.getInt("plazas_maximas");
                Integer plazasOcupadas = resultado.getInt("plazas_ocupadas");

                actividades.add(new Actividad(id, nombre, tipo, duracion, precio, plazasMaximas, plazasOcupadas));
            }
            return actividades;

        } catch (Exception e) {
            System.err.println("no se encontraron actividades con plazas");
            return new ArrayList<>();
        }
    }
}