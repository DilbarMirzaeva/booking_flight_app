package az.turing.booking_flight_spring_boot.controller;
import az.turing.booking_flight_spring_boot.model.request.BookingRequest;

import az.turing.booking_flight_spring_boot.model.response.BookingResponse;

import az.turing.booking_flight_spring_boot.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/booking")
@RequiredArgsConstructor

public class BookingController {
    private final BookingService bookingService;
    @GetMapping("{id}")
    public ResponseEntity<BookingResponse> getById(@PathVariable Long id){
        return ResponseEntity.ok(bookingService.findBookingById(id));
    }
    @GetMapping({"/all"})
    public ResponseEntity<Iterable<BookingResponse>> getAll(){
        return ResponseEntity.ok(bookingService.findAllBookings());
    }
    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Void> save(@Validated @RequestBody BookingRequest bookingRequest){
        bookingService.saveBooking(bookingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
