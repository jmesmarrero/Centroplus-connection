package es.ies.puerto.centroplus_connect.business.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad.IActividadPersistenceAdapter;
import es.ies.puerto.centroplus_connect.adapters.out.persistence.Incidencia.IIncidenciaPersistenceAdapter;
import es.ies.puerto.centroplus_connect.business.IIncidenciaService;
import es.ies.puerto.centroplus_connect.business.Validator.IncidenciaValidator;
import es.ies.puerto.centroplus_connect.business.Validator.UsuarioValidator;
import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Service
public class IncidenciaService implements IIncidenciaService {

    private final IIncidenciaPersistenceAdapter repository;

    

    public IncidenciaService(IIncidenciaPersistenceAdapter repository) {
        this.repository = repository;
    }

    @Override
    public Incidencia save(Incidencia incidencia) {
        if (!IncidenciaValidator.incidenciaValida(incidencia)) {
            throw new IllegalArgumentException();
        }
        return repository.save(incidencia);
    }

    @Override
    public Optional<Incidencia> findById(Long id) {
        if (!IncidenciaValidator.esIdValido(id)) {
            return Optional.empty();
        }
        return repository.findById(id);
    }

    @Override
    public List<Incidencia> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Incidencia> update(Long id, Incidencia incidencia) {
        if (!IncidenciaValidator.esIdValido(id)) {
            return Optional.empty();
        }
        if (!IncidenciaValidator.incidenciaValida(incidencia)) {
            return Optional.empty();
        }
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        incidencia.setId(id);
        return Optional.of(repository.save(incidencia));

    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);  
    }

    @Override
    public boolean existsById(Long id) {
        if (!IncidenciaValidator.esIdValido(id)) {
            return false;
        }
        return repository.existsById(id);
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) {
        if (!IncidenciaValidator.esEstadoValido(estado)) {
            return new ArrayList<>();
        }
        return repository.findByEstado(estado);
    }

    @Override
    public List<Incidencia> findByUsuario(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return new ArrayList<>();
        }
        return repository.findByUsuario(usuario);
    }

    @Override
    public List<Incidencia> findByFecha(LocalDate fecha) {
        if (!IncidenciaValidator.esFechaValida(fecha)) {
            return new ArrayList<>();
        }
        return repository.findByFecha(fecha);
    }

    @Override
    public Incidencia cambiarEstado(Long id, EstadoIncidencia estado) {
        if (!IncidenciaValidator.esIdValido(id)) {
            throw new IllegalArgumentException();
        }
        Optional<Incidencia> incidencia = repository.findById(id);
        if (incidencia.isEmpty()) {
            throw new IllegalArgumentException();
        }
        Incidencia IncidenciaCambio = incidencia.get();

        IncidenciaCambio.setEstado(estado);
        return repository.save(IncidenciaCambio);
    


    }


}
