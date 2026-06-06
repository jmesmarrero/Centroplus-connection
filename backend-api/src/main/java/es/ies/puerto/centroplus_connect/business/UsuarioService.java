package es.ies.puerto.centroplus_connect.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;
import es.ies.puerto.centroplus_connect.adapters.out.persistence.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario registrarUsuario(Usuario usuario) {

        if (repository.existsById(usuario.getId())) {
            throw new IllegalArgumentException("usuario ya creado");
        }
        if (usuario.getDni() == null) {
            throw new IllegalArgumentException("dni no puede ser nulo");
        }
        return repository.save(usuario);

    }

    public Optional<Usuario> findById(Long id) {
        if (id == null) {
            return null;

        }

        return repository.findById(id);
    }

    public List<Usuario> findAll() {
        return repository.findAll();
    }

    

    public void deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

        } else {

            throw new IllegalArgumentException("no se ha podido borrar usuario con id: " + id);
        }
    }

}
