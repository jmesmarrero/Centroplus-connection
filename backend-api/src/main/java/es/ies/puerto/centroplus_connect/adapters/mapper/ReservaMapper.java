package es.ies.puerto.centroplus_connect.adapters.mapper;

import org.mapstruct.Mapper;

import es.ies.puerto.centroplus_connect.adapters.in.api.Reserva.ReservaRequest;
import es.ies.puerto.centroplus_connect.adapters.in.api.Reserva.ReservaResponse;
import es.ies.puerto.centroplus_connect.domain.model.Reserva;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    Reserva toDomain(ReservaRequest request);
    ReservaResponse toResponse(Reserva reserva);



}
