// IIncidenciaService.java
package es.ies.puerto.Service.Interfaces;

import java.time.LocalDate;
import java.util.List;
import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.models.Usuario;

public interface IIncidenciaService {

    /**
     * Funcion para crear incidencia
     * @param incidencia incidencia a crear
     * @return true si se creó correctamente
     */
    boolean create(Incidencia incidencia);

    /**
     * Funcion para encontrar incidencia por id
     * @param id identificador unico
     * @return incidencia encontrada
     */
    Incidencia findById(Long id);

    /**
     * Funcion para encontrar todas las incidencias
     * @return lista de incidencias
     */
    List<Incidencia> findAll();

    /**
     * Funcion para actualizar incidencia
     * @param incidencia incidencia a actualizar
     * @return true si se actualizó correctamente
     */
    boolean update(Incidencia incidencia);

    /**
     * Funcion para eliminar incidencia por id
     * @param id identificador unico
     * @return true si se eliminó correctamente
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar incidencias por usuario
     * @param usuario usuario a buscar
     * @return lista de incidencias
     */
    List<Incidencia> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar incidencias por estado
     * @param estado estado de la incidencia
     * @return lista de incidencias
     */
    List<Incidencia> findByEstado(EstadoIncidencia estado);

    /**
     * Funcion para buscar incidencias por fecha
     * @param fecha fecha de la incidencia
     * @return lista de incidencias
     */
    List<Incidencia> findByFecha(LocalDate fecha);

    /**
     * Funcion para cambiar estado de incidencia
     * @param id identificador unico
     * @param estado nuevo estado
     * @return true si se cambió correctamente
     */
    boolean cambiarEstado(Long id, EstadoIncidencia estado);
}