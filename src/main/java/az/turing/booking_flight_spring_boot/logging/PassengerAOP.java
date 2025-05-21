package az.turing.booking_flight_spring_boot.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class PassengerAOP {

    @Pointcut(value = "execution(* az.turing.booking_flight_spring_boot.service.PassengerService.*(..))")
    public void logForPassenger(){}

    @Before(value = "logForPassenger()")
    public void logBeforePassenger(JoinPoint joinPoint){
        log.info("Method start successfully: {} ",joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logForPassenger()",returning = "result")
    public void logRunningPassenger(JoinPoint joinPoint,Object result){
        log.info("Method: {} | with result : {}",joinPoint.getSignature().getName(),result);
    }

    @After(value = "logForPassenger()")
    public void logAfterPassenger(JoinPoint joinPoint){
        log.info("Method finished successfully: {} ",joinPoint.getSignature().getName());
    }

    @AfterThrowing(value = "logForPassenger()",throwing = "ex")
    public void logExceptionPassenger(JoinPoint joinPoint,Exception ex){
        log.error("Method: {} | with exception: {}",joinPoint.getSignature().getName(),ex.getLocalizedMessage());
    }
}
