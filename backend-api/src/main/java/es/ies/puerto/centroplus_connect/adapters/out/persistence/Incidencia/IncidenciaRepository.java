package es.ies.puerto.centroplus_connect.adapters.out.persistence.Incidencia;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {

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
