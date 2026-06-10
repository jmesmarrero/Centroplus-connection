package es.ies.puerto.Service.validators;

import java.time.LocalDate;

import es.ies.puerto.models.EstadoReserva;
import es.ies.puerto.models.Reserva;

public class ReservaValidator {

    public static boolean esIdValido(Long id) {

        return id != null && id > 0;
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.isBlank();
    }

    public static boolean esEstadoValido(EstadoReserva estado) {

        if (estado == null) {
            return false;
        }
        return estado == EstadoReserva.ACTIVA || estado == EstadoReserva.CANCELADA;

    }

    public static boolean esFechaValida(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }
        return fecha.isAfter(LocalDate.now());
    }

    public static boolean reservaValida(Reserva reserva) {
        if (reserva == null) {
            return false;
        }
        return UsuarioValidator.usuarioValido(reserva.getUsuario())
                && ActividadValidator.actividadValida(reserva.getActividad()) && esFechaValida(reserva.getFecha())
                && esEstadoValido(reserva.getEstado());
    }

}
