package az.turing.booking_flight_spring_boot.controller;

import az.turing.booking_flight_spring_boot.model.request.PassengerRequest;
import az.turing.booking_flight_spring_boot.model.response.PassengerResponse;
import az.turing.booking_flight_spring_boot.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/passenger")
public class PassengerController {
    private final PassengerService passengerService;

    @PostMapping
    public ResponseEntity<Void> create(@Validated @RequestBody PassengerRequest passengerRequest) {
        passengerService.savePassenger(passengerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<PassengerResponse> update(@RequestParam Long id,@RequestBody PassengerRequest passengerRequest){
        return ResponseEntity.ok(passengerService.updatePassenger(id,passengerRequest));
    }

    @GetMapping("{id}")
    public ResponseEntity<PassengerResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(passengerService.getPassengerById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PassengerResponse>> getAll() {
        return ResponseEntity.ok(passengerService.getAllPassengers());
    }
}
