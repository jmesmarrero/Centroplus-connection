package es.ies.puerto.centroplus_connect.adapters.out.persistence.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Repository
public interface IUsuarioPeristenceAdapter {
  /**
     * Funcion para crear un usuario
     * @param usuario usuario a crear
     * @return True si se ha creado al usuario correctamente o false lo contrario
     */
    Usuario save(Usuario usuario);

    /**
     * Funcion para buscar usuario por id
     * @param id identificador unico de la clase
     * @return usuario con ese id
     */
    Optional<Usuario> findById(Long id);

    /**
     * Funcion para encontrarlos a todos
     * @return todos los usuarios
     */
    List<Usuario> findAll();

    /**
     * Funcion para actualizar usuario
     * @param usuario usuario a actualizar
     * @param id identificador unico de la clase
     * @return true si se ha actualizado correctamente o false lo contrario
     */
    Optional<Usuario> update(Long id, Usuario usuario);

    /**
     * Funcion para borrar usuario por su id
     * @param id identificador unico de la clase
     * 
     */
    void deleteById(Long id);

    /**
     * Funcion para buscar usuario por su email
     * @param email parametro para buscar al usuario por el email
     * @return usuario encontrado por su email
     */
    Optional<Usuario> findByEmail(String email);
    /**
     * Fucnion para saber si exisye el usuario
     * @param id identificador unico de la clase
     * @return true si existe usuario por id or false en caso contrario
     */
    boolean existsById(Long id);
}
