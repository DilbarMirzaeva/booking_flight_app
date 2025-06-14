package az.turing.booking_flight_spring_boot.logging;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
public class FlightAOP {

    @Pointcut(value = "execution(* az.turing.booking_flight_spring_boot.service.FlightService.*(..))")
    public void logForFightService() {}

    @Before(value = "logForFightService()")
    public void logBeforeFightService(JoinPoint joinPoint) {
        log.info("Method start successfully: {} ",joinPoint.getSignature().getName());
    }

    @After(value = "logForFightService()")
    public void logAfterFightService(JoinPoint joinPoint) {
        log.info("Method finished successfully: {} ",joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "logForFightService()",returning = "result")
    public void logRunningFlightService(JoinPoint joinPoint,Object result){
        log.info("Method: {} | with result : {}",joinPoint.getSignature().getName(),result);
    }

    @AfterThrowing(value = "logForFightService()",throwing = "ex")
    public void logExceptionFlightService(JoinPoint joinPoint,Exception ex){
        log.error("Method: {} | with exception: {}",joinPoint.getSignature().getName(),ex.getLocalizedMessage());
    }
}
