package az.turing.booking_flight_spring_boot.service.impl;

import az.turing.booking_flight_spring_boot.domain.entity.Passenger;
import az.turing.booking_flight_spring_boot.domain.repository.PassengerRepository;
import az.turing.booking_flight_spring_boot.exception.NotFoundException;
import az.turing.booking_flight_spring_boot.mapper.PassengerMapper;
import az.turing.booking_flight_spring_boot.model.request.PassengerRequest;
import az.turing.booking_flight_spring_boot.model.response.PassengerResponse;
import az.turing.booking_flight_spring_boot.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {

    private final PassengerMapper passengerMapper;
    private final PassengerRepository passengerRepo;
    @Override
    public void savePassenger(PassengerRequest passengerRequest) {
        Passenger passenger=new Passenger();
        passenger.setName(passengerRequest.getName());
        passenger.setSurname(passengerRequest.getSurname());
        passengerRepo.save(passenger);
    }

    @Override
    public void deletePassenger(Long id) {
        if(!passengerRepo.existsById(id)){
            throw new NotFoundException(
                    String.format("Passenger with id %d not found",id));
        }
        passengerRepo.deleteById(id);
    }

    @Override
    public PassengerResponse updatePassenger(Long id, PassengerRequest passengerRequest) {
        Passenger passenger=passengerRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Passenger not found"));
        passenger.setName(passengerRequest.getName());
        passenger.setSurname(passengerRequest.getSurname());
        passengerRepo.save(passenger);
        return passengerMapper.toDto(passenger);
    }

    @Override
    public PassengerResponse getPassengerById(Long id) {
        Passenger passenger=passengerRepo.findById(id)
                .orElseThrow(()->new NotFoundException("Passenger not found"));
        return passengerMapper
                .toDto(passenger);
    }

    @Override
    public List<PassengerResponse> getAllPassengers() {
        List<Passenger> passengers=passengerRepo.findAll();
        return passengerMapper.toListDto(passengers);
    }
}
