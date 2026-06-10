// IncidenciaService.java
package es.ies.puerto.Service.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.Service.Interfaces.IIncidenciaService;
import es.ies.puerto.models.EstadoIncidencia;
import es.ies.puerto.models.Incidencia;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.Interface.IIncidenciaRepository;
import es.ies.puerto.validators.IncidenciaValidator;
import es.ies.puerto.validators.UsuarioValidator;

public class IncidenciaService implements IIncidenciaService {

    private final IIncidenciaRepository repository;

    public IncidenciaService(IIncidenciaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Incidencia incidencia) {
        if (!IncidenciaValidator.incidenciaValida(incidencia)) {
            return false;
        }
        return repository.create(incidencia);
    }

    @Override
    public Incidencia findById(Long id) {
        if (!IncidenciaValidator.esIdValido(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Incidencia> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Incidencia incidencia) {
        if (!IncidenciaValidator.incidenciaValida(incidencia)) {
            return false;
        }
        if (!IncidenciaValidator.esIdValido(incidencia.getId())) {
            return false;
        }
        return repository.update(incidencia);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!IncidenciaValidator.esIdValido(id)) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public List<Incidencia> findByUsuario(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return new ArrayList<>();
        }
        return repository.findByUsuario(usuario);
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) {
        if (!IncidenciaValidator.esEstadoValido(estado)) {
            return new ArrayList<>();
        }
        return repository.findByEstado(estado);
    }

    @Override
    public List<Incidencia> findByFecha(LocalDate fecha) {
        if (!IncidenciaValidator.esFechaValida(fecha)) {
            return new ArrayList<>();
        }
        return repository.findByFecha(fecha);
    }

    @Override
    public boolean cambiarEstado(Long id, EstadoIncidencia estado) {
        if (!IncidenciaValidator.esIdValido(id) || !IncidenciaValidator.esEstadoValido(estado)) {
            return false;
        }
        Incidencia incidencia = repository.findById(id);
        if (incidencia == null) {
            return false;
        }
        incidencia.setEstado(estado);
        return repository.update(incidencia);
    }
}