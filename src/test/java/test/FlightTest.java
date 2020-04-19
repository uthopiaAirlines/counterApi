package test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import counter.Swagger2SpringBoot;
import counter.model.Flight;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class FlightTest {

    Flight flight = new Flight();

    @BeforeEach
    void setFlight() {
        flight.setAirline(1);
        flight.setArrivalLocation(1);
        flight.setArrivalTime(OffsetDateTime.now());
        flight.setAvailableSeats(1);
        flight.setDepartureLocation(1);
        flight.setDepartureTime(OffsetDateTime.now().minusDays(3));
        flight.setFlightId(1);
        flight.setPrice(BigDecimal.valueOf(15.99));
    }

    @Test
    public void airlineTest() {
        Flight flight1 = flight.airline(2);
        assertEquals(Integer.valueOf(2), flight1.getAirline());
    }

    @Test
    public void arrivalLocationTest() {
        Flight flight1 = flight.arrivalLocation(2);
        assertEquals(Integer.valueOf(2), flight1.getArrivalLocation());
    }

    @Test
    public void arrivalTimeTest() {
        Flight flight1 = flight.arrivalTime(OffsetDateTime.now().plusDays(1));
        assertEquals(OffsetDateTime.now().plusDays(1), flight1.getArrivalTime());
    }

    @Test
    public void availableSeatsTest() {
        Flight flight1 = flight.availableSeats(2);
        assertEquals(Integer.valueOf(2), flight1.getAvailableSeats());
    }

    @Test
    public void departureLocationTest() {
        Flight flight1 = flight.departureLocation(2);
        assertEquals(Integer.valueOf(2), flight1.getDepartureLocation());
    }

    @Test
    public void departureTimeTest() {
        Flight flight1 = flight.departureTime(OffsetDateTime.now().plusDays(1));
        assertEquals(OffsetDateTime.now().plusDays(1), flight1.getDepartureTime());
    }

    @Test
    public void flightIdTest() {
        Flight flight1 = flight.flightId(2);
        assertEquals(Integer.valueOf(2), flight1.getFlightId());
    }
    
    @Test
    public void priceTest() {
        Flight flight1 = flight.price(BigDecimal.valueOf(17.99));
        assertEquals(BigDecimal.valueOf(17.99), flight1.getPrice());
    }

    // private void blah() {
    //     flight.airline(airline);
    //     flight.arrivalLocation(arrivalLocation);
    //     flight.arrivalTime(arrivalTime);
    //     flight.availableSeats(availableSeats);
    //     flight.departureLocation(departureLocation);
    //     flight.departureTime(departureTime);
    //     flight.flightId(flightId);
    //     flight.getAirline();
    //     flight.getArrivalLocation();
    //     flight.getArrivalTime();
    //     flight.getAvailableSeats();
    //     flight.getDepartureLocation();
    //     flight.getDepartureTime();
    //     flight.getFlightId();
    //     flight.getPrice();
    //     flight.price(price);
    //     flight.setAirline(airline);
    //     flight.setArrivalLocation(arrivalLocation);
    //     flight.setArrivalTime(arrivalTime);
    //     flight.setAvailableSeats(availableSeats);
    //     flight.setDepartureLocation(departureLocation);
    //     flight.setDepartureTime(departureTime);
    //     flight.setPrice(price);
    // }
}