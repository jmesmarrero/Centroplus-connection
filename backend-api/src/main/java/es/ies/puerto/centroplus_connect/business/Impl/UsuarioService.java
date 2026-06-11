package es.ies.puerto.centroplus_connect.business.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;
import es.ies.puerto.centroplus_connect.adapters.out.persistence.Usuario.IUsuarioPeristenceAdapter;

import es.ies.puerto.centroplus_connect.business.IUsuarioService;
import es.ies.puerto.centroplus_connect.business.Validator.UsuarioValidator;

@Service
public class UsuarioService implements IUsuarioService {

    private final IUsuarioPeristenceAdapter repository;

    public UsuarioService(IUsuarioPeristenceAdapter repository) {
        this.repository = repository;
    }

    public Usuario registrarUsuario(Usuario usuario) {

        if (!UsuarioValidator.usuarioValido(usuario)) {
        throw new IllegalArgumentException("Usuario a crear no valido");
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

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if (id == null || usuario == null) {
            return Optional.empty();
        }
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        usuario.setId(id);
        return Optional.of(repository.save(usuario));
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        if (!UsuarioValidator.emailValido(email)) {
            throw new IllegalArgumentException("Email no es valido");

        }
        return repository.findByEmail(email);
    }

}
