package az.turing.booking_flight_spring_boot.domain.repository;

import az.turing.booking_flight_spring_boot.domain.entity.Booking;
import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    Booking findBookingsByFlight(Flight flight);
    boolean existsByFlight(Flight flight);
    List<Booking> findAllByFlight(Flight flight);
}
