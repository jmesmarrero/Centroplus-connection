package es.ies.puerto.centroplus_connect.adapters.out.persistence.Usuario;

import java.util.List;
import java.util.Optional;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.stereotype.Component;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Component
public class UsuarioPersitenceAdapter implements IUsuarioPeristenceAdapter {

    private final UsuarioRepository jpaRepo;

    public UsuarioPersitenceAdapter(UsuarioRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Usuario save(Usuario usuario) {
        return jpaRepo.save(usuario);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepo.findById(id);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepo.findAll();
    }

    @Override
    public Optional<Usuario> update(Long id, Usuario usuario) {
        if (!jpaRepo.existsById(id)) {
            return Optional.empty();

        }
        usuario.setId(id);
        return Optional.of(jpaRepo.save(usuario));
    }

    @Override
    public void deleteById(Long id) {
        jpaRepo.deleteById(id);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return jpaRepo.findByEmail(email);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepo.existsById(id);
    }

}
