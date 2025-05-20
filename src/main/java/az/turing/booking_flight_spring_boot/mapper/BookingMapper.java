package az.turing.booking_flight_spring_boot.mapper;

import az.turing.booking_flight_spring_boot.domain.entity.Booking;

import az.turing.booking_flight_spring_boot.model.response.BookingResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<Booking, BookingResponse> {
    @Override
    Booking toEntity(BookingResponse bookingResponse);
    @Override
    BookingResponse toDto(Booking booking);
    @Override
    List<Booking> toListEntity(List<BookingResponse> bookingResponse);
    @Override
    List<BookingResponse> toListDto(List<Booking> booking);
}
