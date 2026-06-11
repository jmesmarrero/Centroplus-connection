package es.ies.puerto.centroplus_connect.business.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad.IActividadPersistenceAdapter;
import es.ies.puerto.centroplus_connect.business.IActividadService;
import es.ies.puerto.centroplus_connect.business.Validator.ActividadValidator;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;

@Service
public class ActividadService implements IActividadService {

    private final IActividadPersistenceAdapter repository;

    public ActividadService(IActividadPersistenceAdapter repository) {
        this.repository = repository;
    }

    @Override
    public Actividad registrarActividad(Actividad actividad) {
        if (actividad == null) {
            return null;
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
        return repository.findAll();
    }

    @Override
    public Optional<Actividad> update(Long id, Actividad actividad) {
        if (id == null) {

            return Optional.empty();
        }
        if (!ActividadValidator.actividadValida(actividad)) {
            return Optional.empty();
        }
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        actividad.setId(id);
        return Optional.of(repository.save(actividad));
    }

    @Override
    public boolean deleteById(Long id) {

        if (!ActividadValidator.idValido(id)) {
            return false;
        }
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<Actividad> findByNombre(String nombre) {
        if (!ActividadValidator.nombreValido(nombre)) {
            return Optional.empty();
        }
        return repository.findByNombre(nombre);
    }

}
