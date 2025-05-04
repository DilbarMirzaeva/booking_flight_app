package az.turing.booking_flight_spring_boot.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "flights")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origin",nullable = false)
    private String origin;

    @Column(name = "destination",nullable = false)
    private String destination;
    
    @Column(name="available_seats",nullable = false)
    private Integer availableSeats;

    @Column(name="departure_time",nullable = false)
    private LocalDateTime departureTime;

    @Column(name="arrival_time",nullable = false)
    private LocalDateTime arrivalTime;

    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Booking> bookingList;

}
