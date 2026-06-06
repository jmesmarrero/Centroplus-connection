package es.ies.puerto.centroplus_connect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.models.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long>{

    
}