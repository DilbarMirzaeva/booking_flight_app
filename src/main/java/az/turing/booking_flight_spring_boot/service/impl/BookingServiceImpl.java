package az.turing.booking_flight_spring_boot.service.impl;

import az.turing.booking_flight_spring_boot.domain.entity.Booking;
import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import az.turing.booking_flight_spring_boot.domain.entity.Passenger;
import az.turing.booking_flight_spring_boot.domain.entity.Status;
import az.turing.booking_flight_spring_boot.domain.repository.BookingRepository;
import az.turing.booking_flight_spring_boot.domain.repository.FlightRepository;
import az.turing.booking_flight_spring_boot.domain.repository.PassengerRepository;
import az.turing.booking_flight_spring_boot.exception.AlreadyExistsException;
import az.turing.booking_flight_spring_boot.exception.InsufficientBalanceException;
import az.turing.booking_flight_spring_boot.exception.NotFoundException;
import az.turing.booking_flight_spring_boot.exception.SeatUnavailableException;
import az.turing.booking_flight_spring_boot.mapper.BookingMapper;
import az.turing.booking_flight_spring_boot.model.request.BookingRequest;
import az.turing.booking_flight_spring_boot.model.response.BookingResponse;
import az.turing.booking_flight_spring_boot.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;
    private final FlightRepository flightRepository;
    private final PassengerRepository passengerRepository;

        @Override
        @Transactional
        public BookingResponse saveBooking(BookingRequest bookingRequest) {
            Flight flight= flightRepository.findById(bookingRequest.getFlightId())
                    .orElseThrow(()->new NotFoundException("Flight not found"));

            if(flight.getStatus()==Status.DELETED){
                throw new NotFoundException("Flight has been deleted");
            }

            if(flight.getAvailableSeats()<bookingRequest.getNumberOfSeats()){
                throw new SeatUnavailableException("Flight has not enough seats");
            }

            List<Passenger> passengers= bookingRequest.getPassengers()
                    .stream().map(passenger ->{
                        Passenger passenger1=new Passenger();
                        passenger1.setName(passenger.getName());
                        passenger1.setSurname(passenger.getSurname());
                        passenger1.setBalance(passenger.getBalance());
                        return passenger1;
                    })
                    .toList();

            Long price=flight.getSeatPrice()*bookingRequest.getNumberOfSeats();
            Long pricePerPassenger=price/bookingRequest.getPassengers().size();

            passengers.forEach(p->{
                if(p.getBalance()<pricePerPassenger){
                    throw new InsufficientBalanceException("Passenger: "+p.getName()+" has not enough balance");
                }
            });
            passengers.forEach(p->
                p.setBalance(p.getBalance()-pricePerPassenger));

            Booking booking=new Booking();
            booking.setStatus(Status.BOUGHT);
            booking.setNumberOfSeats(bookingRequest.getNumberOfSeats());
            booking.setPrice(price);
            flight.setAvailableSeats(flight.getAvailableSeats()-bookingRequest.getNumberOfSeats());
            flightRepository.save(flight);
            booking.setFlight(flight);
            booking.setPassengers(passengers);
            passengers.forEach(p -> p.setBooking(booking));

            Booking savedBooking=bookingRepository.save(booking);
            passengerRepository.saveAll(passengers);

            return bookingMapper.toDto(savedBooking);
        }

    @Override
    @Transactional
    public void deleteBooking(Long id) {
        Booking deletedBooking=bookingRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Booking not found"));
        if(deletedBooking.getStatus()==Status.DELETED){
            throw new AlreadyExistsException("Booking has been deleted already");
        }
        deletedBooking.getPassengers()
                .forEach(p->p.setBalance(p.getBalance()+ deletedBooking.getPrice() / deletedBooking.getPassengers().size()));
        deletedBooking.getFlight().setAvailableSeats(deletedBooking.getFlight().getAvailableSeats()+deletedBooking.getNumberOfSeats());
        deletedBooking.setStatus(Status.DELETED);
        bookingRepository.save(deletedBooking);
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