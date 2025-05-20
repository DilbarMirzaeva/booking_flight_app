package az.turing.booking_flight_spring_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.UUID;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<GlobalResponse> alreadyExistsHandler(AlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                GlobalResponse.builder()
                        .message(e.getMessage())
                        .error(ErrorMessage.ALREADY_EXISTS)
                        .uuid(UUID.randomUUID())
                        .timestamp(LocalDateTime.now())
                        .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GlobalResponse> notFoundHandler(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                GlobalResponse.builder()
                        .message(e.getMessage())
                        .error(ErrorMessage.NOT_FOUND)
                        .uuid(UUID.randomUUID())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<GlobalResponse> insufficientBalanceHandler(InsufficientBalanceException e){
        return ResponseEntity.status(HttpStatus.INSUFFICIENT_STORAGE).body(
                GlobalResponse.builder()
                        .message(e.getMessage())
                        .error(ErrorMessage.INSUFFICIENT_BALANCE)
                        .uuid(UUID.randomUUID())
                        .timestamp(LocalDateTime.now())
                        .build());
    }
}
