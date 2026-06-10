package es.ies.puerto.Service.Impl;

import java.util.List;

import es.ies.puerto.Service.Interfaces.IUsuarioService;
import es.ies.puerto.models.Usuario;
import es.ies.puerto.repositories.Interface.IUsuarioRepository;
import es.ies.puerto.validators.UsuarioValidator;

public class UsuarioService implements IUsuarioService {

    private final IUsuarioRepository repository;

    public UsuarioService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return false;
        }
        return repository.create(usuario);
    }

    @Override
    public Usuario findById(Long id) {
        if (!UsuarioValidator.idValido(id)) {
            return null;
        }
        return repository.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean update(Usuario usuario) {
        if (!UsuarioValidator.usuarioValido(usuario)) {
            return false;
        }
        if (!UsuarioValidator.idValido(usuario.getId())) {
            return false;
        }
        return repository.update(usuario);
    }

    @Override
    public boolean deleteById(Long id) {
        if (!UsuarioValidator.idValido(id)) {
            return false;
        }
        return repository.deleteById(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        if (!UsuarioValidator.emailValido(email)) {
            return null;
        }
        return repository.findByEmail(email);
    }
}
