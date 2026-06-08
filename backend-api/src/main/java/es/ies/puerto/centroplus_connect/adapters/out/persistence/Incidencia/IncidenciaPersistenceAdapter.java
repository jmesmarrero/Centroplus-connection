package es.ies.puerto.centroplus_connect.adapters.out.persistence.Incidencia;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import es.ies.puerto.centroplus_connect.domain.model.EstadoIncidencia;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Component
public class IncidenciaPersistenceAdapter implements IIncidenciaPersistenceAdapter {

    private final IncidenciaRepository jpaRepo;

    public IncidenciaPersistenceAdapter(IncidenciaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Incidencia save(Incidencia incidencia) {
        return jpaRepo.save(incidencia);
    }

    @Override
    public Optional<Incidencia> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Incidencia> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Incidencia> update(Long id, Incidencia incidencia) {
        if (!jpaRepo.existsById(id)) {
            return Optional.empty();
        }
        incidencia.setId(id);
        return Optional.of(jpaRepo.save(incidencia));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public List<Incidencia> findByEstado(EstadoIncidencia estado) {
        return jpaRepo.findByEstado(estado);
    }

    @Override
    public List<Incidencia> findByUsuario(Usuario usuario) {
        return jpaRepo.findByUsuario(usuario);
    }

    @Override
    public List<Incidencia> findByFecha(LocalDate fecha) {
        return jpaRepo.findByFecha(fecha);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepo.existsById(id);
    }

}
