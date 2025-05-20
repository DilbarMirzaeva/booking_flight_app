package az.turing.booking_flight_spring_boot.model.request;

import az.turing.booking_flight_spring_boot.domain.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingRequest {
    private Long flightId;
    private List<PassengerRequest> passengers;
    private Integer numberOfSeats;
}
