package az.turing.booking_flight_spring_boot.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerRequest {
    private String name;
    private String surname;
    private Long balance;
}
