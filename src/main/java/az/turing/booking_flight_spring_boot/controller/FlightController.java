package az.turing.booking_flight_spring_boot.controller;

import az.turing.booking_flight_spring_boot.model.request.FlightRequest;
import az.turing.booking_flight_spring_boot.model.response.FlightResponse;
import az.turing.booking_flight_spring_boot.service.impl.FlightServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flight")
@Validated
@RequiredArgsConstructor
public class FlightController {

    private final FlightServiceImpl flightService;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody FlightRequest flightRequest) {
        flightService.saveFlight(flightRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<FlightResponse> update(@RequestParam Long id,@RequestBody FlightRequest flightRequest) {
        return ResponseEntity.ok(flightService.updateFlight(id, flightRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.getFlightById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FlightResponse>> getAll() {
        return ResponseEntity.ok(flightService.getAllFlights());
    }


}
