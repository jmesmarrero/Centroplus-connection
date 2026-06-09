package es.ies.puerto.centroplus_connect.adapters.mapper;

import org.mapstruct.Mapper;

import es.ies.puerto.centroplus_connect.adapters.in.api.Usuario.UsuarioRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Usuario.UsuarioResponse;
import es.ies.puerto.centroplus_connect.domain.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toDomain(UsuarioRequest request);

    UsuarioResponse toResponse(Usuario usuario);
}
