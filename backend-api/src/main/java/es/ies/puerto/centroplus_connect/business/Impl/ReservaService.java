package es.ies.puerto.centroplus_connect.business.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.adapters.out.persistence.Actividad.IActividadPersistenceAdapter;
import es.ies.puerto.centroplus_connect.adapters.out.persistence.Reserva.IReservaPersistenceAdapter;
import es.ies.puerto.centroplus_connect.business.IReservaService;
import es.ies.puerto.centroplus_connect.business.Validator.ActividadValidator;
import es.ies.puerto.centroplus_connect.business.Validator.ReservaValidator;
import es.ies.puerto.centroplus_connect.business.Validator.UsuarioValidator;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Service
public class ReservaService implements IReservaService {

    private final IReservaPersistenceAdapter repository;
    private final IActividadPersistenceAdapter repoActividad;

    public ReservaService(IReservaPersistenceAdapter repository, IActividadPersistenceAdapter repoActividad) {
        this.repository = repository;
        this.repoActividad = repoActividad;
    }

    @Override
    public Reserva save(Reserva reserva) {
        if (!ReservaValidator.reservaValida(reserva)) {
            throw new IllegalArgumentException("no se ha podido crear");
        }
        return repository.save(reserva);
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            return Optional.empty();
        }
        return repository.findById(id);
    }

    @Override
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Reserva> update(Long id, Reserva reserva) {
        if (!ReservaValidator.esIdValido(id) || !ReservaValidator.reservaValida(reserva)) {
            return Optional.empty();
        }
        if (!existsById(id)) {
            return Optional.empty();
        }
        reserva.setId(id);
        return Optional.of(repository.save(reserva));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            return false;
        }
        return repository.existsById(id);
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            throw new IllegalArgumentException("no se puede encontrar usuario");

        }
        return repository.findByUsuario(usuario);
    }

    @Override
    public List<Reserva> findByActividad(Actividad actividad) {
        if (!ActividadValidator.actividadValida(actividad)) {
            return new ArrayList<>();
        }
        return repository.findByActividad(actividad);
    }

    @Override
    public List<Reserva> findByEstado(EstadoReserva estado) {
        if (!ReservaValidator.esEstadoValido(estado)) {
            return new ArrayList<>();
        }
        return repository.findByEstado(estado);
    }

    @Override
    public Reserva addReserva(Reserva reserva) {
        if (!ReservaValidator.reservaValida(reserva)) {
            throw new IllegalArgumentException();
        }
        
        if (reserva.getActividad().getPlazasOcupadas() >= reserva.getActividad().getPlazasMaximas()) {
            throw new IllegalArgumentException();
        }
        Actividad actividad = reserva.getActividad();
        actividad.setPlazasOcupadas(actividad.getPlazasOcupadas() + 1);
        repoActividad.save(actividad);
        
        return repository.save(reserva);
    }

    @Override
    public Reserva cancelReserva(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            throw new IllegalArgumentException();
        }
        Optional<Reserva> reserva = repository.findById(id);
        if (reserva.isEmpty()) {
            throw new IllegalArgumentException("no se ha podido encontrar opr id");
        }
        Reserva reservaCancelar = reserva.get();

        reservaCancelar.setEstado(EstadoReserva.CANCELADA);

        Actividad actividad = reservaCancelar.getActividad();
        actividad.setPlazasOcupadas(actividad.getPlazasOcupadas() -1);
        repoActividad.save(actividad);

        return repository.save(reservaCancelar);
    }

}
