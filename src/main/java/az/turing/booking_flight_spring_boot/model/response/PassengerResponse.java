package az.turing.booking_flight_spring_boot.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponse {
    private Long id;
    private String name;
    private String surname;
    private Long balance;
}
