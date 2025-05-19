package az.turing.booking_flight_spring_boot.exception;

public class IsufficientBalanceException extends RuntimeException {
    public IsufficientBalanceException(String message) {
        super(message);
    }
}
