package es.ies.puerto.repositories.Interface;

import java.util.List;
import es.ies.puerto.models.Usuario;

public interface IUsuarioRepository {

    /**
     * Funcion para crear usuario
     * @param usuario usuario a crear
     * @return true si se creó correctamente
     */
    boolean create(Usuario usuario);

    /**
     * Funcion para encontrar usuario por id
     * @param id identificador unico
     * @return usuario encontrado
     */
    Usuario findById(Long id);

    /**
     * Funcion para encontrar todos los usuarios
     * @return lista de usuarios
     */
    List<Usuario> findAll();

    /**
     * Funcion para actualizar usuario
     * @param usuario usuario a actualizar
     * @return true si se actualizó correctamente
     */
    boolean update(Usuario usuario);

    /**
     * Funcion para eliminar usuario por id
     * @param id identificador unico
     * @return true si se eliminó correctamente
     */
    boolean deleteById(Long id);

    /**
     * Funcion para buscar usuario por email
     * @param email email del usuario
     * @return usuario encontrado
     */
    Usuario findByEmail(String email);
}