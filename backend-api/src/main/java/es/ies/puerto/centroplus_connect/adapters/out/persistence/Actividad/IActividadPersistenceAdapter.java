package es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad;

import java.util.List;
import java.util.Optional;


import es.ies.puerto.centroplus_connect.domain.model.Actividad;


public interface IActividadPersistenceAdapter {

    /**
     * Funcion para crear actividad
     * 
     * @param actividad actividad a crear
     * @return crea actividad nueva
     */
    Actividad save(Actividad actividad);

    /**
     * Funcion para encontrar actividad por id
     * 
     * @param id identificador unico apra encontrar actividad
     * @return actividad encontrada por su id
     */
    Optional<Actividad> findById(Long id);

    /**
     * Funcion para encontrar todas las actividades
     * 
     * @return todas las actividades
     */
    List<Actividad> findAll();

    /**
     * Funcion para actualizar actividad
     * 
     * @param actividad actividad a actualizar
     * @return Actividad actualizada
     */
    Optional<Actividad> update(Long id, Actividad actividad);

    /**
     * Funcion para eliminar actividad por id
     * 
     * @param id parametro identificador unico
     */
    void deleteById(Long id);

    /**
     * Funcion para buscar actividad por nombre
     * 
     * @param nombre parametro String para buscar actividad
     * @return actividad con ese nombre
     */
    Optional<Actividad> findByNombre(String nombre);

    /**
     * Fucnion para saber si exisye el usuario
     * 
     * @param id identificador unico de la clase
     * @return true si existe usuario por id or false en caso contrario
     */
    boolean existsById(Long id);

}
