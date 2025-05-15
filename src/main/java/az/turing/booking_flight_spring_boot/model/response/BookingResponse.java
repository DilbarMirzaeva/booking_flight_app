package az.turing.booking_flight_spring_boot.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
        private Long bookingId;
        private Long flightId;
        private List<PassengerResponse> passengers;
        private Long price;
        private Long numberofSeats;
}
