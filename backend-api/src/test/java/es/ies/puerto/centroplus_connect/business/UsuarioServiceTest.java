package es.ies.puerto.centroplus_connect.business;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import es.ies.puerto.centroplus_connect.adapters.out.persistence.Usuario.IUsuarioPeristenceAdapter;
import es.ies.puerto.centroplus_connect.business.Impl.UsuarioService;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

class UsuarioServiceTest {

    @Mock
    IUsuarioPeristenceAdapter repository;

    UsuarioService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        service = new UsuarioService(repository);
    }

    @Test
    void findAll_devuelveLista() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        List<Usuario> usuarios = service.findAll();
        assertNotNull(usuarios);
    }

    @Test
    void findById_idNuloDevuelveVacio() {
        Optional<Usuario> resultado = service.findById(null);
        assertTrue(resultado.isEmpty());
    }

    @Test
    void findById_idValidoDevuelveUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Jorge Mesa");
        when(repository.findById(1L)).thenReturn(Optional.of(usuario));
        Optional<Usuario> resultado = service.findById(1L);
        assertNotNull(resultado.orElse(null));
    }

    @Test
    void registrarUsuario_nuloLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.registrarUsuario(null);
        });
    }
}