package az.turing.booking_flight_spring_boot.service;

import az.turing.booking_flight_spring_boot.model.request.FlightRequest;
import az.turing.booking_flight_spring_boot.model.response.FlightResponse;

import java.util.List;

public interface FlightService {
    void saveFlight(FlightRequest flightRequest);
    void deleteFlight(Long id);
    FlightResponse updateFlight(Long id,FlightRequest flightRequest);
    FlightResponse getFlightById(Long id);
    List<FlightResponse> getAllFlights();
}
