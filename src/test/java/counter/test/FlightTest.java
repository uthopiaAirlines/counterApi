package counter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        OffsetDateTime now = OffsetDateTime.now();
        Flight flight1 = flight.arrivalTime(now.plusDays(1));
        assertEquals(now.plusDays(1), flight1.getArrivalTime());
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
        OffsetDateTime now = OffsetDateTime.now();
        Flight flight1 = flight.departureTime(now.plusDays(1));
        assertEquals(now.plusDays(1), flight1.getDepartureTime());
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

    @Test
    public void toStringTest() {
        assertEquals(String.class, flight.toString().getClass());
        flight.setAirline(null);
        assertEquals(String.class, flight.toString().getClass());
    }

    @Test
    public void equalsTest() {
        Flight flight1 = new Flight();
        OffsetDateTime now = OffsetDateTime.now();
        flight.setAirline(1);
        flight.setArrivalLocation(1);
        flight.setArrivalTime(now);
        flight.setAvailableSeats(1);
        flight.setDepartureLocation(1);
        flight.setDepartureTime(now.minusDays(3));
        flight.setFlightId(1);
        flight.setPrice(BigDecimal.valueOf(15.99));
        flight1.setAirline(1);
        flight1.setArrivalLocation(1);
        flight1.setArrivalTime(now);
        flight1.setAvailableSeats(1);
        flight1.setDepartureLocation(1);
        flight1.setDepartureTime(now.minusDays(3));
        flight1.setFlightId(1);
        flight1.setPrice(BigDecimal.valueOf(15.99));
        assertTrue(flight.equals(flight1));
        assertTrue(flight.equals(flight.airline(1)));
        flight1.setAirline(10);
        assertFalse(flight.equals(flight1));
        assertFalse(flight.equals(null));
        assertEquals(Integer.class, Integer.valueOf(flight.hashCode()).getClass());
    }

    @Test
    public void constructorTest() {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight(1);
    }
}