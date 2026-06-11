package es.ies.puerto.centroplus_connect.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.ies.puerto.centroplus_connect.business.Validator.UsuarioValidator;
import es.ies.puerto.centroplus_connect.domain.model.TipoUsuario;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public class UsuarioValidatorTest {

    @Test
    void dniValidoCorrectoEIncorrecto() {
        assertTrue(UsuarioValidator.dniValido("12345678Z"));
        assertFalse(UsuarioValidator.dniValido("1234Z"));
        assertFalse(UsuarioValidator.dniValido(null));
    }

    @Test
    void emailValidoCorrectoEIncorrecto() {
        assertTrue(UsuarioValidator.emailValido("jorge@centroplus.es"));
        assertFalse(UsuarioValidator.emailValido("jorge@@mal"));
        assertFalse(UsuarioValidator.emailValido(""));
    }

    @Test
    void usuarioValidUsuarioCompletoEsValido() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Jorge Mesa");
        usuario.setDni("12345678Z");
        usuario.setEmail("jorge@centroplus.es");
        usuario.setTipoUsuario(TipoUsuario.ALUMNO);

        assertTrue(UsuarioValidator.usuarioValido(usuario));
    }

    @Test
    void usuarioValidUsuarioNuloNoEsValido() {
        assertFalse(UsuarioValidator.usuarioValido(null));
    }

}
