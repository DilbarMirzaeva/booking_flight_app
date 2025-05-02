package az.turing.booking_flight_spring_boot.exception;

public class SeatUnavailableException extends RuntimeException {
  public SeatUnavailableException(String message) {
    super(message);
  }
}
