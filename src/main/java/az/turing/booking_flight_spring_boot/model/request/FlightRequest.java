package az.turing.booking_flight_spring_boot.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightRequest {
    private String origin;
    private String destination;
    private Integer availableSeats;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
}
