package es.ies.puerto.centroplus_connect.business.Impl;

import java.util.List;
import java.util.Optional;

import es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad.ActividadRepository;
import es.ies.puerto.centroplus_connect.business.IActividadService;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;

public class ActividadService implements IActividadService {

    private final ActividadRepository repository;
    

    public ActividadService(ActividadRepository repository) {
        this.repository = repository;
    }

    @Override
    public Actividad registrarActividad(Actividad actividad) {
        if (actividad == null) {
            return null;
        }
        if (actividad.getId() == null) {
            return null;
        }
        if (repository.existsById(actividad.getId())) {
            throw new IllegalArgumentException();
        }
        return repository.save(actividad);
    }

    @Override
    public Optional<Actividad> findById(Long id) {
        if (id == null) {
            
            return Optional.empty();
        }
        return repository.findById(id);
    }

    @Override
    public List<Actividad> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Actividad> update(Long id, Actividad actividad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
