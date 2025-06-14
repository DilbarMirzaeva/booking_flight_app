package az.turing.booking_flight_spring_boot.service;

import az.turing.booking_flight_spring_boot.model.request.PassengerRequest;
import az.turing.booking_flight_spring_boot.model.response.PassengerResponse;

import java.util.List;

public interface PassengerService {
    void savePassenger(PassengerRequest passengerRequest);
    void deletePassenger(Long id);
    PassengerResponse updatePassenger(Long id, PassengerRequest passengerRequest);
    PassengerResponse getPassengerById(Long id);
    List<PassengerResponse> getAllPassengers();
}
