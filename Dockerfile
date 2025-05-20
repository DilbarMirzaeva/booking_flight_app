FROM eclipse-temurin:17-jre-alpine

COPY build/libs/booking_flight_spring_boot-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8082

ENTRYPOINT ["java","-jar","/app/app.jar"]