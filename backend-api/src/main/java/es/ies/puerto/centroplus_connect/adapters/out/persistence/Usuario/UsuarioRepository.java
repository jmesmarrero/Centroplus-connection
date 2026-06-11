package es.ies.puerto.centroplus_connect.adapters.out.persistence.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Funcion para buscar Usuario por email
     * @param email parametro de entrada email
     * @return usuario encongtrado por email
     */
    Optional<Usuario> findByEmail(String email);

    
}
