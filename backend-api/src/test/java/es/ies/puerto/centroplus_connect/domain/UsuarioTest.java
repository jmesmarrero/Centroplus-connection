package es.ies.puerto.centroplus_connect.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import es.ies.puerto.centroplus_connect.domain.model.TipoUsuario;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

class UsuarioTest {

    @Test
    void constructorVacioCreaUsuarioSinDatos() {
        Usuario usuario = new Usuario();
        assertNotNull(usuario);
        assertNull(usuario.getNombre());
    }

    @Test
    void constructorCreaUsuarioConDatos() {
        Usuario usuario = new Usuario(1L, "Jorge Mesa", "12345678Z", 
                "jorge@centroplus.es", "666999666", TipoUsuario.ALUMNO);
        assertEquals(1L, usuario.getId());
        assertEquals("Jorge Mesa", usuario.getNombre());
        assertEquals("12345678Z", usuario.getDni());
        assertEquals(TipoUsuario.ALUMNO, usuario.getTipoUsuario());
    }

    @Test
    void setterNombreActualizaNombre() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Ana Perez");
        assertEquals("Ana Perez", usuario.getNombre());
    }

    @Test
    void setterEmailActualizaEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("ana@centroplus.es");
        assertEquals("ana@centroplus.es", usuario.getEmail());
    }
}