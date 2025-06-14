package az.turing.booking_flight_spring_boot.mapper;

import az.turing.booking_flight_spring_boot.domain.entity.Passenger;
import az.turing.booking_flight_spring_boot.model.response.PassengerResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassengerMapper extends EntityMapper<Passenger, PassengerResponse> {
    @Override
    Passenger toEntity(PassengerResponse passengerResponse);

    @Override
    PassengerResponse toDto(Passenger passenger);

    @Override
    List<Passenger> toListEntity(List<PassengerResponse> passengerResponse);

    @Override
    List<PassengerResponse> toListDto(List<Passenger> passenger);
}
