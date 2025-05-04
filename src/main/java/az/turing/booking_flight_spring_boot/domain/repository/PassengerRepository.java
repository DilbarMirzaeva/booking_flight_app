package az.turing.booking_flight_spring_boot.domain.repository;

import az.turing.booking_flight_spring_boot.domain.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger,Long> {
}
