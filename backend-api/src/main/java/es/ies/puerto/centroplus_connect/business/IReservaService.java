package es.ies.puerto.centroplus_connect.business;

import java.util.List;
import java.util.Optional;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public interface IReservaService {

    /**
     * Funcion para crear reserva
     * 
     * @param reserva reserva a crear
     * @return crea reserva nueva
     */
    Reserva save(Reserva reserva);

    /**
     * Funcion para encontrar reserva por id
     * 
     * @param id identificador unico apra encontrar reserva
     * @return reserva encontrada por su id
     */
    Optional<Reserva> findById(Long id);

    /**
     * Funcion para encontrar todas las reservas
     * 
     * @return todas las actividades
     */
    List<Reserva> findAll();

    /**
     * Funcion para actualizar reserva
     * 
     * @param reserva reserva a actualizar
     * @return reserva actualizada
     */
    Optional<Reserva> update(Long id, Reserva reserva);

    /**
     * Funcion para eliminar reserva por id
     * 
     * @param id parametro identificador unico
     */
    void deleteById(Long id);

    /**
     * Fucnion para saber si exisye el usuario
     * 
     * @param id identificador unico de la clase
     * @return true si existe usuario por id or false en caso contrario
     */
    boolean existsById(Long id);

    /**
     * Funcion para encontrar lista de usuarios
     * @param usuario usuarios a buscar
     * @return lista de usuaruis
     */
    List<Reserva> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar reservas por actividad
     * @param actividad actividad a buscar
     * @return lista de reservas por actividad
     */
    List<Reserva> findByActividad(Actividad actividad);

    /**
     * Funcion oara buscar reservas por Estado
     * @param estado estado a buscar
     * @return lista de las reservas por Estado
     */
    List<Reserva> findByEstado(EstadoReserva estado);

    /**
     * Funcion para anadir una reserva
     * @param reserva reserva dada para anadir
     * @return reserva anadida
     */
    Reserva addReserva(Reserva reserva);
    /**
     * Funcion para cancelar una reserva de sus plaza
     * @param id identificador unico
     * @return reserva candelaa de la actividad
     */
    Reserva cancelReserva(Long id);

}
