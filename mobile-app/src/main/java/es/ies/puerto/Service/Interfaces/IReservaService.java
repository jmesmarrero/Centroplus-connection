package es.ies.puerto.Service.Interfaces;

import java.util.List;
import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.models.Usuario;

public interface IReservaService {

    /**
     * Funcion para crear reserva
     * @param reserva reserva a crear
     * @return true si se creó correctamente
     */
    boolean create(Reserva reserva);

    /**
     * Funcion para encontrar reserva por id
     * @param id identificador unico
     * @return reserva encontrada
     */
    Reserva findById(Long id);

    /**
     * Funcion para encontrar todas las reservas
     * @return lista de reservas
     */
    List<Reserva> findAll();

    /**
     * Funcion para actualizar reserva
     * @param reserva reserva a actualizar
     * @return true si se actualizó correctamente
     */
    boolean update(Reserva reserva);

    /**
     * Funcion para eliminar reserva por id
     * @param id identificador unico
     * @return true si se eliminó correctamente
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar reservas por usuario
     * @param usuario usuario a buscar
     * @return lista de reservas
     */
    List<Reserva> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar reservas por actividad
     * @param actividad actividad a buscar
     * @return lista de reservas
     */
    List<Reserva> findByActividad(Actividad actividad);

    /**
     * Funcion para buscar reservas por estado
     * @param estado estado de la reserva
     * @return lista de reservas
     */
    List<Reserva> findByEstado(EstadoReserva estado);

    /**
     * Funcion para añadir reserva con validaciones
     * @param reserva reserva a añadir
     * @return true si se añadió correctamente
     */
    boolean addReserva(Reserva reserva);

    /**
     * Funcion para cancelar reserva
     * @param id identificador de la reserva
     * @return true si se canceló correctamente
     */
    boolean cancelReserva(Long id);
}
