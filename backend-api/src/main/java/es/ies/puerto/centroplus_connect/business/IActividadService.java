package es.ies.puerto.centroplus_connect.business;

import java.util.List;
import java.util.Optional;



import es.ies.puerto.centroplus_connect.domain.model.Actividad;

public interface IActividadService {

    Actividad registrarActividad(Actividad actividad);
    Optional<Actividad> findById(Long id);
    List<Actividad> findAll();
    Optional<Actividad> update(Long id, Actividad actividad);
    boolean deleteById(Long id);
    Optional<Actividad> findByNombre(String nombre);

}
