package es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long>{

    Optional<Actividad> findByNombre(String nombre);

    
}