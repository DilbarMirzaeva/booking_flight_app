package az.turing.booking_flight_spring_boot.domain.repository;

import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
}
