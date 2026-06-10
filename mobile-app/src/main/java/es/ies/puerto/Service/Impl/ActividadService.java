package es.ies.puerto.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.Service.Interfaces.IActividadService;
import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.TipoActividad;
import es.ies.puerto.repositories.Interface.IActividadRepository;
import es.ies.puerto.validators.ActividadValidator;

public class ActividadService implements IActividadService {

    private final IActividadRepository repository;

    public ActividadService(IActividadRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Actividad actividad) {
        if (!ActividadValidator.actividadValida(actividad)) {
            return false;
        }
        return repository.create(actividad);
    }

    @Override
    public Actividad findById(Long id) {
        if (!ActividadValidator.idValido(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Actividad> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Actividad actividad) {
        if (!ActividadValidator.actividadValida(actividad)) {
            return false;
        }
        if (!ActividadValidator.idValido(actividad.getId())) {
            return false;
        }
        return repository.update(actividad);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!ActividadValidator.idValido(id)) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public List<Actividad> findByTipo(TipoActividad tipo) {
        if (!ActividadValidator.esTipoActividad(tipo)) {
            return new ArrayList<>();
        }
        return repository.findByTipo(tipo);
    }

    @Override
    public List<Actividad> findConPlazasDisponibles() {
        return repository.findConPlazasDisponibles();
    }
}