package az.turing.booking_flight_spring_boot.mapper;

import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import az.turing.booking_flight_spring_boot.model.response.FlightResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper extends EntityMapper<Flight, FlightResponse> {

    @Override
    Flight toEntity(FlightResponse flightResponse);

    @Override
    FlightResponse toDto(Flight flight);

    @Override
    List<Flight> toListEntity(List<FlightResponse> flightResponse);

    @Override
    List<FlightResponse> toListDto(List<Flight> flight);
}
