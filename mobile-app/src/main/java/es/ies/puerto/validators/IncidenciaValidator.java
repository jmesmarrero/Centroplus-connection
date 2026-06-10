package es.ies.puerto.validators;

import java.time.LocalDate;

import es.ies.puerto.models.*;

public class IncidenciaValidator {

    public static boolean esIdValido(Long id) {
        return id != null && id > 0;
    }

    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.isBlank();
    }

    public static boolean esAsuntoValido(String asunto) {
        return esTextoValido(asunto);
    }

    public static boolean esDescripcionValido(String descripcion) {
        return esTextoValido(descripcion);
    }

    public static boolean esFechaValida(LocalDate fecha) {
        if (fecha == null) {
            return false;
        }
        if (fecha.isAfter(LocalDate.now())) {
            return false;
        }
        return true;
    }

    public static boolean esEstadoValido(EstadoIncidencia estado) {
        if (estado == null) {
            return false;
        }
        return estado == EstadoIncidencia.ABIERTA || estado == EstadoIncidencia.CERRADA
                || estado == EstadoIncidencia.EN_PROCESO;
    }

    public static boolean incidenciaValida(Incidencia incidencia) {
        if (incidencia == null) {
            return false;
        }

        return UsuarioValidator.usuarioValido(incidencia.getUsuario()) && esAsuntoValido(incidencia.getAsunto())
                && esDescripcionValido(incidencia.getDescripcion()) && esFechaValida(incidencia.getFecha());
    }

}
