package es.ies.puerto.centroplus_connect.adapters.out.persistence.Reserva;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Component
public class ReservaPersistenceAdapter implements IReservaPersistenceAdapter{
    private final ReservaRepository jpaRepo;

    
    public ReservaPersistenceAdapter(ReservaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Reserva save(Reserva reserva) {
        return jpaRepo.save(reserva);
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Reserva> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Reserva> update(Long id, Reserva reserva) {
        if (!jpaRepo.existsById(id)) {
            return Optional.empty();
        }
        reserva.setId(id);
        return Optional.of(jpaRepo.save(reserva));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepo.existsById(id);
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        return jpaRepo.findByUsuario(usuario);
    }

    @Override
    public List<Reserva> findByActividad(Actividad actividad) {
        return jpaRepo.findByActividad(actividad);
    }

    @Override
    public List<Reserva> findByEstado(EstadoReserva estado) {
        return jpaRepo.findByEstado(estado);
    }

}
