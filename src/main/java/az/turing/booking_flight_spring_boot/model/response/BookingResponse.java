package az.turing.booking_flight_spring_boot.model.response;


import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import az.turing.booking_flight_spring_boot.domain.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
        private Long id;
        private Long price;
        private Integer numberOfSeats;
        private FlightResponse flight;
        private Status status;
        private List<PassengerResponse> passengers;
}
