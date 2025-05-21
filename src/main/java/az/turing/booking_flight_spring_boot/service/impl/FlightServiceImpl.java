package az.turing.booking_flight_spring_boot.service.impl;

import az.turing.booking_flight_spring_boot.domain.entity.Flight;
import az.turing.booking_flight_spring_boot.domain.entity.Status;
import az.turing.booking_flight_spring_boot.domain.repository.FlightRepository;
import az.turing.booking_flight_spring_boot.exception.AlreadyExistsException;
import az.turing.booking_flight_spring_boot.exception.NotFoundException;
import az.turing.booking_flight_spring_boot.mapper.FlightMapper;
import az.turing.booking_flight_spring_boot.model.request.FlightRequest;
import az.turing.booking_flight_spring_boot.model.response.FlightResponse;
import az.turing.booking_flight_spring_boot.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepo;
    private final FlightMapper flightMapper;

    @Override
    public void saveFlight(FlightRequest flightRequest) {
        if (flightRepo.existsByOriginAndDestinationAndDepartureTime(flightRequest.getOrigin(),flightRequest.getDestination(),flightRequest.getDepartureTime())){
            throw new AlreadyExistsException("Flight already exists");
        }
        Flight flight=new Flight();
        flight.setOrigin(flightRequest.getOrigin());
        flight.setArrivalTime(flightRequest.getArrivalTime());
        flight.setDestination(flightRequest.getDestination());
        flight.setAvailableSeats(flightRequest.getAvailableSeats());
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setSeatPrice(flightRequest.getSeatPrice());
        flight.setStatus(Status.ACTIVE);
        flightRepo.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        Flight flight=flightRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Flight not found with id: "+id));
        if(flight.getStatus()==Status.DELETED){
            throw new AlreadyExistsException("Flight has been deleted already");
        }
        flight.setStatus(Status.DELETED);
        flightRepo.save(flight);
    }

    @Override
    public FlightResponse updateFlight(Long id,FlightRequest flightRequest) {
        Flight flight=flightRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Flight not found with id:"+ id));
        if(flight.getStatus()==Status.DELETED){
            throw new AlreadyExistsException("Flight has been deleted already");
        }
        flight.setOrigin(flightRequest.getOrigin());
        flight.setDestination(flightRequest.getDestination());
        flight.setAvailableSeats(flightRequest.getAvailableSeats());
        flight.setArrivalTime(flightRequest.getArrivalTime());
        flight.setDepartureTime(flightRequest.getDepartureTime());
        flight.setSeatPrice(flightRequest.getSeatPrice());
        flightRepo.save(flight);
        return flightMapper.toDto(flight);
    }

    @Override
    public FlightResponse getFlightById(Long id) {
        Flight flight=flightRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Flight not found with id: "+id));
        return flightMapper.toDto(flight);
    }

    @Override
    public List<FlightResponse> getAllFlights() {
        List<Flight> flights=flightRepo.findAll();
        return flightMapper.toListDto(flights);
    }

}
