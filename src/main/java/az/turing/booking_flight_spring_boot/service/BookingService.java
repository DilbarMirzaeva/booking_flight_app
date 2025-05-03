package az.turing.booking_flight_spring_boot.service;

import az.turing.booking_flight_spring_boot.domain.entity.Booking;
import az.turing.booking_flight_spring_boot.domain.repository.BookingRepository;
import az.turing.booking_flight_spring_boot.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepo;

    public void saveBooking(Booking booking){
        bookingRepo.save(booking);
    }
    public void deleteBooking(Booking booking){
        bookingRepo.delete(booking);
    }
    public List<Booking> findAllBookings(){
        return bookingRepo.findAll();
    }




}