package az.turing.booking_flight_spring_boot.service;
import az.turing.booking_flight_spring_boot.domain.entity.Booking;
import az.turing.booking_flight_spring_boot.model.request.BookingRequest;
import az.turing.booking_flight_spring_boot.model.response.BookingResponse;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface BookingService {
     void saveBooking(BookingRequest bookingRequestt);
     void deleteBooking(Long id);
     List<BookingResponse> findAllBookings();
     BookingResponse findBookingById(Long id);

}