// ReservaService.java
package es.ies.puerto.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import es.ies.puerto.Service.Interfaces.IReservaService;
import es.ies.puerto.models.Actividad;
import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Reserva;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.Interface.IActividadRepository;
import es.ies.puerto.repositories.Interface.IReservaRepository;
import es.ies.puerto.validators.ReservaValidator;
import es.ies.puerto.validators.UsuarioValidator;
import es.ies.puerto.validators.ActividadValidator;

public class ReservaService implements IReservaService {

    private final IReservaRepository repository;
    private final IActividadRepository actividadRepository;

    public ReservaService(IReservaRepository repository, IActividadRepository actividadRepository) {
        this.repository = repository;
        this.actividadRepository = actividadRepository;
    }

    @Override
    public boolean create(Reserva reserva) {
        if (!ReservaValidator.reservaValida(reserva)) {
            return false;
        }
        return repository.create(reserva);
    }

    @Override
    public Reserva findById(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Reserva> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Reserva reserva) {
        if (!ReservaValidator.reservaValida(reserva)) {
            return false;
        }
        if (!ReservaValidator.esIdValido(reserva.getId())) {
            return false;
        }
        return repository.update(reserva);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public List<Reserva> findByUsuario(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return new ArrayList<>();
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
    public boolean addReserva(Reserva reserva) {
        if (!ReservaValidator.reservaValida(reserva)) {
            return false;
        }
        Actividad actividad = reserva.getActividad();
        if (actividad.getPlazasOcupadas() >= actividad.getPlazasMaximas()) {
            return false;
        }
        actividad.setPlazasOcupadas(actividad.getPlazasOcupadas() + 1);
        actividadRepository.update(actividad);
        return repository.create(reserva);
    }

    @Override
    public boolean cancelReserva(Long id) {
        if (!ReservaValidator.esIdValido(id)) {
            return false;
        }
        Reserva reserva = repository.findById(id);
        if (reserva == null) {
            return false;
        }
        reserva.setEstado(EstadoReserva.CANCELADA);
        Actividad actividad = reserva.getActividad();
        if (actividad.getPlazasOcupadas() > 0) {
            actividad.setPlazasOcupadas(actividad.getPlazasOcupadas() - 1);
            actividadRepository.update(actividad);
        }
        return repository.update(reserva);
    }
}
