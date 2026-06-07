package es.ies.puerto.centroplus_connect.business;

import java.util.List;
import java.util.Optional;



import es.ies.puerto.centroplus_connect.domain.model.Usuario;

public interface IUsuarioService {

    Usuario registrarUsuario(Usuario usuario);
    Optional<Usuario> findById(Long id);
    List<Usuario>findAll();
    Optional<Usuario> update(Long id, Usuario usuario);
    void deleteById(Long id);
}
