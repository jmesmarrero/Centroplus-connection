package es.ies.puerto.centroplus_connect.adapters.out.persistence.Incidencia;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public interface IIncidenciaPersistenceAdapter {

    /**
     * Funcion para crear incidencia
     * @param incidencia incidencia a crear
     * @return incidencia creada
     */
    Incidencia save(Incidencia incidencia);

    /**
     * Funcion para encontrar incidencia por id
     * @param id identificsdor unoco de la clase
     * @return incidencia por ese id
     */
    Optional<Incidencia> findById(Long id);

    /**
     * Funcion para encontrar todas las incidencias
     * @return todas las incidencias
     */
    List<Incidencia> findAll();

    /**
     * Fucnion para actualizar la incidencia 
     * @param id identificador unico de la clase
     * @param incidencia incidencia a actualizar
     * @return incidencia actualizada
     */
    Optional<Incidencia> update(Long id, Incidencia incidencia);

    /**
     * Funcion para borrar incidencia
     * @param id identificador unico de la clase
     */
    void deleteById(Long id);

    /**
     * Funcion para ver si existe o no ese id
     * @param id identificasdor unico de la clase
     * @return true si existe and false lo contrario
     */
    boolean existsById(Long id);

    /**
     * Funcion para buscar incidencia por estado
     * @param estado estado dado por la clase "ABIERA", "CERRADA", "EN PROCESO"
     * @return lista de incidencias por estado
     */
    List<Incidencia> findByEstado(EstadoIncidencia estado);

    /**
     * Funcion para buscar Incidencia por usuario
     * @param usuario usuario dado para buscar incidencia
     * @return listado de incidencias por usuario
     */
    List<Incidencia> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar por fecha de incidencia
     * @param fecha fecha dada para buscar en LocalDate
     * @return listado de incidencias por fecha
     */
    List<Incidencia> findByFecha(LocalDate fecha);

}
