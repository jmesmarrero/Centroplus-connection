package es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;

@Component
public class ActividadPersistenceAdapter implements IActividadPersistenceAdapter {

    private final ActividadRepository jpaRepo;

    public ActividadPersistenceAdapter(ActividadRepository jpaRepo){
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Actividad save(Actividad actividad) {
        return jpaRepo.save(actividad);
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Actividad> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Actividad> update(Long id, Actividad actividad) {
        if (!jpaRepo.existsById(id)) {
            return Optional.empty();
            
        }
        actividad.setId(id);
        return Optional.of(jpaRepo.save(actividad));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public Optional<Actividad> findByNombre (String nombre) {
        return jpaRepo.findByNombre(nombre);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepo.existsById(id);
    }

}
