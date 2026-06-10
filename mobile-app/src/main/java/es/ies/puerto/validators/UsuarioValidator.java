package es.ies.puerto.validators;

import es.ies.puerto.models.TipoUsuario;
import es.ies.puerto.models.Usuario;

public class UsuarioValidator {

    public static boolean idValido(Long id) {

        return id != null;
    }

    public static boolean nombreValido(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return false;
        }
        nombre = nombre.trim();
        return nombre.matches("^[A-ZÑÁÉÍÓÚ][a-zñáéíóú]{2,} ([A-ZÑÁÉÍÓÚ][a-zñáéíóú]{2,})?$");
    }

    public static boolean dniValido(String dni) {
        if (dni == null || dni.isBlank()) {
            return false;
        }
        dni = dni.trim();

        return dni.matches("^[0-9]{8}[A-Z]$");
    }

    public static boolean emailValido(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }
        email = email.trim();

        return email.matches("^[a-z.+_-]+@[a-z.+_-]+\\.[a-z]{2,}$");
    }

    public static boolean esTipoUsuario(TipoUsuario tipoUsuario) {
        if (tipoUsuario == null) {
            return false;
        }
        return tipoUsuario == TipoUsuario.ALUMNO || tipoUsuario == TipoUsuario.SOCIO
                || tipoUsuario == TipoUsuario.AMBOS;
    }

    public static boolean usuarioValido(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        return nombreValido(usuario.getNombre()) &&
                emailValido(usuario.getEmail()) &&
                dniValido(usuario.getDni()) &&
                esTipoUsuario(usuario.getTipoUsuario());
    }

}
