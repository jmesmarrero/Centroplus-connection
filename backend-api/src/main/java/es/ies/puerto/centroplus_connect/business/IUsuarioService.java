package es.ies.puerto.centroplus_connect.business;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Service
public interface IUsuarioService {
    /**
     * Funcion para registrar usuario
     * @param usuario usuario a registrar
     * @return usuario registrado
     */
    Usuario registrarUsuario(Usuario usuario);
    /**
     * Funcion para encontrar usuario por id
     * @param id parametro identificador unico de la clase
     * @return usuario encontrado por id
     */
    Optional<Usuario> findById(Long id);
    /**
     * Fucnion para encontrar a todos los usuarios
     * @return todos los usuarios
     */
    List<Usuario>findAll();
    /**
     * Funcion para actualizar usuario
     * @param id parametro unico de la clase
     * @param usuario usuario a actualizar
     * @return usuario actualizado
     */
    Optional<Usuario> update(Long id, Usuario usuario);
    /**
     * Funcion para eliminar usuario por id
     * @param id identificador unico del usuario
     */
    void deleteById(Long id);
    /**
     * Funcion para buscar usuario por email
     * @param email parametro dado por usuario
     * @return usuario encontrado por email
     */
    Optional<Usuario> findByEmail(String email);
}
