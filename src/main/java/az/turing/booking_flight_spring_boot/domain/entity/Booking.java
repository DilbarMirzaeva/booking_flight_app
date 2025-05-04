package az.turing.booking_flight_spring_boot.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Flight flight;
    @OneToMany
    private List<Passenger> passengers;
}
