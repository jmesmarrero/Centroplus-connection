package es.ies.puerto.centroplus_connect.adapters.mapper;

import org.mapstruct.Mapper;

import es.ies.puerto.centroplus_connect.adapters.in.api.Actividad.ActividadRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Actividad.ActividadResponse;
import es.ies.puerto.centroplus_connect.domain.model.Actividad;

@Mapper(componentModel = "spring")
public interface ActividadMapper {
    Actividad toDomain(ActividadRequest request);

    ActividadResponse toResponse(Actividad actividad);

}
