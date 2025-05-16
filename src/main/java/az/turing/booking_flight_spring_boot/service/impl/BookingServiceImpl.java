package az.turing.booking_flight_spring_boot.service.impl;

import az.turing.booking_flight_spring_boot.domain.entity.Booking;
import az.turing.booking_flight_spring_boot.domain.repository.BookingRepository;
import az.turing.booking_flight_spring_boot.exception.NotFoundException;
import az.turing.booking_flight_spring_boot.mapper.BookingMapper;
import az.turing.booking_flight_spring_boot.model.request.BookingRequest;
import az.turing.booking_flight_spring_boot.model.response.BookingResponse;
import az.turing.booking_flight_spring_boot.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    @Override
    public void saveBooking(BookingRequest bookingRequest) {


    }
    @Override
    public void deleteBooking(Long id) {
        if(!bookingRepository.existsById(id)) {
            throw new NotFoundException("Booking has not found");
        }
        bookingRepository.deleteById(id);
    }

    @Override
    public List<BookingResponse> findAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookingMapper.toListDto(bookings);
    }

    @Override
    public BookingResponse findBookingById(Long id) {
        Booking booking=bookingRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Booking has not found"));
        return bookingMapper.toDto(booking);
    }


}