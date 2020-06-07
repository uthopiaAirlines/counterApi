package counter.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import counter.Swagger2SpringBoot;
import counter.model.Booking;
import counter.model.Flight;

@SpringBootTest(classes = Swagger2SpringBoot.class)
public class BookingTest {

    Booking booking = new Booking();

    @BeforeEach
    void setBooking() {
        booking.setBookingAgent("fa956c43-f7c6-4da0-ba96-3860d0e4ddf9");
        booking.setBookingId(1);
        booking.setFlight(new Flight(1));
        booking.setNumberOfTickets(1);
        booking.setPatron("466f0f8b-02a3-4b03-8bdd-e82529800ba8");
        booking.setTicketPrice(BigDecimal.valueOf(15.99));
    }

    @Test
    void bookingAgentTest() {
        Booking booking2 = booking.bookingAgent("466f0f8b-02a3-4b03-8bdd-e82529800ba8");
        assertEquals("466f0f8b-02a3-4b03-8bdd-e82529800ba8", booking2.getBookingAgent());
    }

    @Test
    void bookingIdTest() {
        Booking booking2 = booking.bookingId(2);
        assertEquals(Integer.valueOf(2), booking2.getBookingId());
    }

    @Test
    void flightTest() {
        Booking booking2 = booking.flight(new Flight(2));
        assertEquals(Integer.valueOf(2), booking2.getFlight().getFlightId());   
    }

    @Test
    void numberOfTicketsTest() {
        Booking booking2 = booking.numberOfTickets(2);
        assertEquals(Integer.valueOf(2), booking2.getNumberOfTickets());
    }

    @Test
    void patronTest() {
        Booking booking2 = booking.patron("fa956c43-f7c6-4da0-ba96-3860d0e4ddf9");
        assertEquals("fa956c43-f7c6-4da0-ba96-3860d0e4ddf9", booking2.getPatron());
    }

    @Test
    void ticketPriceTest() {
        Booking booking2 = booking.ticketPrice(BigDecimal.valueOf(17.99));
        assertEquals(BigDecimal.valueOf(17.99), booking2.getTicketPrice());
    }

    @Test
    public void toStringTest() {
        assertEquals(String.class, booking.toString().getClass());
        booking.setBookingAgent(null);
        assertEquals(String.class, booking.toString().getClass());
    }

    @Test
    void equalsTest() {
        Booking booking1 = new Booking();
        booking1.setBookingAgent("fa956c43-f7c6-4da0-ba96-3860d0e4ddf9");
        booking1.setBookingId(1);
        booking1.setFlight(new Flight(1));
        booking1.setNumberOfTickets(1);
        booking1.setPatron("466f0f8b-02a3-4b03-8bdd-e82529800ba8");
        booking1.setTicketPrice(BigDecimal.valueOf(15.99));
        assertTrue(booking.equals(booking1));
        assertTrue(booking.equals(booking.bookingId(1)));
        booking1.setBookingId(10);
        assertFalse(booking.equals(booking1));
        assertFalse(booking.equals(null));
        assertEquals(Integer.class, Integer.valueOf(booking.hashCode()).getClass());
    }
}