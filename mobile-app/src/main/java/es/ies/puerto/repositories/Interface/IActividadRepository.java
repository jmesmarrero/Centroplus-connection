package es.ies.puerto.repositories.Interface;

import java.util.List;
import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.TipoActividad;

public interface IActividadRepository {

    /**
     * Funcion para crear actividad
     * @param actividad actividad a crear
     * @return true si se creó correctamente
     */
    boolean create(Actividad actividad);

    /**
     * Funcion para encontrar actividad por id
     * @param id identificador unico
     * @return actividad encontrada
     */
    Actividad findById(Long id);

    /**
     * Funcion para encontrar todas las actividades
     * @return lista de actividades
     */
    List<Actividad> findAll();

    /**
     * Funcion para actualizar actividad
     * @param actividad actividad a actualizar
     * @return true si se actualizó correctamente
     */
    boolean update(Actividad actividad);

    /**
     * Funcion para eliminar actividad por id
     * @param id identificador unico
     * @return true si se eliminó correctamente
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar actividades por tipo
     * @param tipo tipo de actividad
     * @return lista de actividades por tipo
     */
    List<Actividad> findByTipo(TipoActividad tipo);

    /**
     * Funcion para buscar actividades con plazas disponibles
     * @return lista de actividades con plazas
     */
    List<Actividad> findConPlazasDisponibles();
}