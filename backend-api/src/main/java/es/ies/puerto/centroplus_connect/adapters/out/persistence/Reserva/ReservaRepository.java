package es.ies.puerto.centroplus_connect.adapters.out.persistence.Reserva;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.ies.puerto.centroplus_connect.domain.model.Actividad;
import es.ies.puerto.centroplus_connect.domain.model.EstadoReserva;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

   /**
     * Funcion para encontrar lista de usuarios
     * @param usuario usuarios a buscar
     * @return lista de usuaruis
     */
    List<Reserva> findByUsuario(Usuario usuario);

    /**
     * Funcion para buscar reservas por actividad
     * @param actividad actividad a buscar
     * @return lista de reservas por actividad
     */
    List<Reserva> findByActividad(Actividad actividad);

    /**
     * Funcion oara buscar reservas por Estado
     * @param estado estado a buscar
     * @return lista de las reservas por Estado
     */
    List<Reserva> findByEstado(EstadoReserva estado);

}
