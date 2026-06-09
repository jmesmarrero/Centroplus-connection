package es.ies.puerto.centroplus_connect.adapters.mapper;

import org.mapstruct.Mapper;

import es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia.IncidenciaRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Incidencia.IncidenciaResponse;
import es.ies.puerto.centroplus_connect.domain.model.Incidencia;

@Mapper(componentModel = "spring")
public interface IncidenciaMapper {

    Incidencia toDomain(IncidenciaRequest request);
    IncidenciaResponse toResponse(Incidencia incidencia);

}
